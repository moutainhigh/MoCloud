package org.mo.web.core.service.servlet;

import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mo.com.lang.EResult;
import org.mo.com.lang.IStringPair;
import org.mo.com.lang.RString;
import org.mo.com.lang.cultrue.FCulture;
import org.mo.com.lang.cultrue.RCulture;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.message.EMessageLevel;
import org.mo.com.text.RDatabaseFormat;
import org.mo.com.xml.FXmlDocument;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.RAop;
import org.mo.core.bind.IBindConsole;
import org.mo.web.core.service.IServiceConsole;
import org.mo.web.core.service.common.EWebServiceFormat;
import org.mo.web.core.service.common.RWebService;
import org.mo.web.core.session.IWebSession;
import org.mo.web.core.session.IWebSessionConsole;
import org.mo.web.protocol.common.IWebContentType;
import org.mo.web.protocol.common.IWebHeaderType;
import org.mo.web.protocol.common.IWebServlet;
import org.mo.web.protocol.context.FWebContext;
import org.mo.web.protocol.context.FWebXmlInput;
import org.mo.web.protocol.context.FWebXmlOutput;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>页面处理模块。</T>
// <P>1. 初始化数据，创建全局应用管理对象。</P>
// <P>2. 根据页面请求，执行相应业务处理。</P>
//============================================================
public abstract class FAbstractServiceServlet
      extends HttpServlet
      implements
         IWebServlet
{
   // 序列化标识
   private static final long serialVersionUID = 1L;

   // 日志输出接口
   private static ILogger _logger = RLogger.find(FAbstractServiceServlet.class);

   // 服务控制台接口
   protected IServiceConsole _serviceConsole;

   // 绑定控制台接口
   protected IBindConsole _bindConsole;

   // 会话控制台接口
   protected IWebSessionConsole _sessionConsole;

   // 会话允许
   protected boolean _sessionVaild;

   //============================================================
   // <T>初始化网络应用程序。</T>
   //
   // @param config 页面设置对象
   //============================================================
   @Override
   public void init(ServletConfig config) throws ServletException{
      super.init(config);
      try{
         _bindConsole = RAop.find(IBindConsole.class);
         _sessionConsole = RAop.find(IWebSessionConsole.class);
         _serviceConsole = RAop.find(IServiceConsole.class);
         _sessionVaild = _sessionConsole.isValid();
         initialize(config);
      }catch(Exception e){
         _logger.error(this, "init", e);
      }
   }

   //============================================================
   // <T>响应网页的Get访问请求。</T>
   //
   // @param request 页面请求对象
   // @param response 页面响应对象
   //============================================================
   @Override
   protected void doGet(HttpServletRequest request,
                        HttpServletResponse response) throws ServletException, IOException{
      process(IWebServlet.METHOD_GET, request, response);
   }

   //============================================================
   // <T>响应网页的Post访问请求。</T>
   //
   // @param request 页面请求对象
   // @param response 页面响应对象
   //============================================================
   @Override
   protected void doPost(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException{
      process(IWebServlet.METHOD_POST, request, response);
   }

   //============================================================
   // <T>网页请求逻辑对象执行开始。</T>
   //
   // @param httpRequest 页面请求对象
   // @param httpResponse 页面响应对象
   //============================================================
   public void process(String type,
                       HttpServletRequest httpRequest,
                       HttpServletResponse httpResponse){
      long startTime = System.currentTimeMillis();
      String uri = null;
      FWebContext context = null;
      IWebSession session = null;
      FCulture culture = null;
      FXmlDocument inputDoc = null;
      FXmlDocument outputDoc = null;
      int formatCd = EWebServiceFormat.Xml;
      try{
         String language = "cn";
         String encoding = "utf-8";
         // 建立会话
         if(_sessionVaild){
            session = _sessionConsole.build(httpRequest.getSession().getId());
            session.referIncrease();
            // 设置语言编码
            culture = session.culture();
            language = culture.countryLanguage();
            encoding = culture.countryEncoding();
            RCulture.link(culture);
         }
         if(_logger.debugAble()){
            _logger.debug(this, "process", "Do{1} - [{2}] (lang={3}, charset={4})", type, httpRequest.getRequestURI(), language, encoding);
         }
         // 设置语言编码
         String serviceEncoding = _serviceConsole.encoding();
         httpRequest.setCharacterEncoding(serviceEncoding);
         httpResponse.setCharacterEncoding(serviceEncoding);
         // 获取传入内容
         inputDoc = new FXmlDocument();
         inputDoc.setOptionAttributeCareCase(false);
         int contentLength = httpRequest.getContentLength();
         if(contentLength > 0){
            // 按照XML解析
            inputDoc.loadStream(httpRequest.getInputStream());
            if(_logger.debugAble()){
               _logger.debugFull(this, "process", "Build input xml.\n{1}", inputDoc.xml());
            }
         }
         // 建立网络线程信息
         context = new FWebContext(session, httpRequest, httpResponse);
         String format = context.parameter(RWebService.PtyFormatCd);
         formatCd = EWebServiceFormat.parse(format);
         if(_logger.debugAble()){
            _logger.debug(this, "process", "Build context: {1}", context.dump());
         }
         _bindConsole.bind(IWebContext.class, context);
         if(session != null){
            _bindConsole.bind(IWebSession.class, session);
         }
         // 设置输出信息
         if(formatCd == EWebServiceFormat.Json){
            httpResponse.setContentType(IWebContentType.JSON);
         }else{
            httpResponse.setContentType(IWebContentType.XML);
         }
         httpResponse.setHeader(IWebHeaderType.PRAGMA, IWebHeaderType.NO_CACHE);
         httpResponse.setHeader(IWebHeaderType.CACHE_CONTROL, IWebHeaderType.NO_CACHE);
         httpResponse.setDateHeader(IWebHeaderType.EXPIRES, 1);
         // 设置输出内容
         outputDoc = new FXmlDocument();
         outputDoc.setOptionAttributeCareCase(false);
         outputDoc.setOptionAttributeReturn(false);
         // 查找服务类型
         uri = context.requestUri();
         if(uri.endsWith(".ws")){
            uri = uri.substring(0, uri.length() - 3);
            int find = uri.lastIndexOf('/');
            if(find != -1){
               uri = uri.substring(find + 1);
            }
            // 设置URL参数到输入节点内
            FXmlNode inputNode = inputDoc.root();
            for(IStringPair pair : context.parameters()){
               String paramName = RDatabaseFormat.toJavaClassName(pair.name());
               String paramValue = pair.value();
               if(inputNode.findNode("paramName") == null){
                  inputNode.createNode(paramName, paramValue);
               }
            }
            // 执行逻辑过程
            FWebXmlInput input = new FWebXmlInput(inputNode);
            FXmlNode outputNode = outputDoc.root();
            outputNode.setName("Service");
            // 设置函数
            String action = context.parameter("action");
            if(RString.isEmpty(action)){
               action = input.get("action");
            }
            if(RString.isEmpty(action)){
               action = "process";
            }
            outputNode.set("method", action + "@" + uri);
            // 设置输出
            FWebXmlOutput output = new FWebXmlOutput(outputNode);
            Object resultCd = _serviceConsole.execute(uri, context, input, output);
            if(resultCd != null){
               outputNode.set(RWebService.PtyResultCd, resultCd.toString().toLowerCase());
            }else{
               outputNode.set(RWebService.PtyResultCd, EResult.Failure.toString().toLowerCase());
            }
            EMessageLevel levelCd = context.messages().calculateMaxLevel();
            if((levelCd != EMessageLevel.Debug) && (levelCd != EMessageLevel.Success)){
               outputNode.set(RWebService.PtyMessageCd, levelCd.toString().toLowerCase());
            }
         }
      }catch(Exception e){
         _logger.error(this, "process", e);
      }finally{
         // 清空关联信息
         _bindConsole.clear();
         // 释放线程绑定对象
         if(culture != null){
            RCulture.unlink(culture);
         }
         // 释放会话引用
         if(session != null){
            session.referDecrease();
         }
         if(outputDoc != null){
            try{
               // 输出服务结果
               if(_logger.debugAble()){
                  _logger.debugFull(this, "process", "Build output xml.\n{1}", outputDoc.xml());
               }
               // 转换格式
               OutputStream outputStream = httpResponse.getOutputStream();
               if(formatCd == EWebServiceFormat.Json){
                  byte[] jsonData = RWebService.xml2json(outputDoc);
                  outputStream.write(jsonData);
               }else{
                  // 输出XML格式格式
                  outputDoc.saveStream(outputStream);
               }
            }catch(Exception e){
               _logger.error(this, "process", e);
            }
         }
         long endTime = System.currentTimeMillis();
         if(_logger.debugAble()){
            _logger.debug(this, "process", endTime - startTime, "Do{1} for {2}", type, uri);
         }
      }
   }
}
