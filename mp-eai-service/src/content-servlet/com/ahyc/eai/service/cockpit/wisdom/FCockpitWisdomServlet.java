package com.ahyc.eai.service.cockpit.wisdom;

import com.ahyc.eai.service.common.FAbstractStatisticsServlet;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.mo.com.encoding.RMd5;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>智慧柯南接口.</T>
//============================================================
public class FCockpitWisdomServlet
      extends FAbstractStatisticsServlet
      implements
         ICockpitWisdomServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FCockpitWisdomServlet.class);

   // 资源访问接口
   //   private static IResource _resource = RResource.find(FCockpitWarningServlet.class);

   //============================================================
   // <T>智慧柯南列表</T>
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public EResult fetch(IWebContext context,
                        ILogicContext logicContext,
                        IWebServletRequest request,
                        IWebServletResponse response){
      _logger.debug(this, "fetch", "the method named fetch from FCockpitTrendServlet is beginning... ");
      //检查参数
      if(!checkParameters(context, request, response)){
         return EResult.Failure;
      }
      //............................................................
      // 获得当前时间
      TDateTime currentDate = RDateTime.currentDateTime();
      //............................................................
      // 从缓冲中查找数据
      String cacheCode = "dynamic|" + currentDate.format("YYYYMMDDHH24MI");
      FByteStream cacheStream = findCacheStream(cacheCode);
      if(cacheStream != null){
         return sendStream(context, request, response, cacheStream);
      }
      //............................................................
      int uid = 3;
      String pwd = "d1e5ab7f41f7d25ce64" + uid + "e2036af314e26";
      String token = RMd5.encode(pwd).toLowerCase();
      CloseableHttpClient httpclient = HttpClients.createDefault();
      String url = "http://project.eai.ezubo.com/Api/get_projects?uid=+" + uid + "&token=" + token;
      HttpGet get = new HttpGet(url);
      try{
         CloseableHttpResponse responseResult = httpclient.execute(get);
         HttpEntity entity = responseResult.getEntity();
         if(entity != null){
            String responseContent = EntityUtils.toString(entity);
            String result = new String(responseContent.getBytes("utf-8"));
            //            System.out.println(result);
         }
      }catch(ClientProtocolException e){
         e.printStackTrace();
      }catch(ParseException e){
         e.printStackTrace();
      }catch(UnsupportedEncodingException e){
         e.printStackTrace();
      }catch(IOException e){
         e.printStackTrace();
      }
      // 设置输出流
      FByteStream stream = createStream(context);
      FByteStream dataStream = createStream(context);
      //写入数据
      stream.write(dataStream.memory(), 0, dataStream.position());
      int count = 5;
      stream.writeInt32(5);
      //............................................................
      // 保存数据到缓冲中
      updateCacheStream(cacheCode, stream);
      //............................................................
      // 发送数据
      int dataLength = stream.length();
      _logger.debug(this, "process", "Send data notice dynamic. (count={1}, data_length={2})", count, dataLength);
      return sendStream(context, request, response, stream);
   }
}
