package org.mo.content.service.mobile.logic.truetimedata;

import com.cyou.gccloud.data.data.FDataLogicTruetimeUnit;
import com.cyou.gccloud.define.enums.core.EGcLink;
import java.util.Iterator;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.logic.data.system.FGcSessionInfo;
import org.mo.cloud.logic.data.system.IGcSessionConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.mobile.logic.truetimedata.ITrueTimeDataConsole;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>实时数据服务。</T>
//============================================================
public class FTrueTimeDataService
      extends FObject
      implements
         ITrueTimeDataService
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FTrueTimeDataService.class);

   // 实时数据逻辑控制台
   @ALink
   protected ITrueTimeDataConsole _trueTimeDataConsole;

   // protected String _newsServiceHost = "http://eai.ezubo.com:8089/";
   // 配置文件注入属性
   @AProperty
   protected String _trueTimeDataHost;

   // Storage服务器
   @ALink
   protected IGcStorageConsole _storageConsole;

   // GcSession会话控制台
   @ALink
   protected IGcSessionConsole _sessionConsole;

   // ============================================================
   // <T>默认逻辑。</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // ============================================================
   @Override
   public EResult process(IWebContext context,
                          IWebInput input,
                          IWebOutput output){
      _logger.debug(this, "process", "process begin. ");
      return EResult.Success;
   }

   // ============================================================
   // <T>根据guid获取实时数据相关信息。</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // ============================================================
   @Override
   public EResult query(IWebContext context,
                        IWebInput input,
                        IWebOutput output,
                        ILogicContext logicContext){
      _logger.debug(this, "query", "query begin. ");
      // 获得guid参数
      String guid = input.config().findNode("guid").text();
      FDataLogicTruetimeUnit newsUnit = _trueTimeDataConsole.getNewsByGuid(guid, logicContext);
      if(newsUnit != null){
         FXmlNode news_info = output.config().createNode("news_info");
         String guidStr = newsUnit.guid();
         String newsLabel = newsUnit.label();
         String newsContent = newsUnit.content();
         String newsUpdate = newsUnit.updateDate() + "";
         if(guidStr != null && (!"".equals(guidStr))){
            news_info.createNode("guid").setText(guidStr);
         }else{
            news_info.createNode("guid").setText("0");
         }
         if(newsLabel != null && (!"".equals(newsLabel))){
            news_info.createNode("label").setText(newsLabel);
         }else{
            news_info.createNode("label").setText("0");
         }
         if(newsContent != null && (!"".equals(newsContent))){
            news_info.createNode("content").setText(newsContent);
         }else{
            news_info.createNode("content").setText("0");
         }
         if(newsUpdate != null && (!"".equals(newsUpdate))){
            news_info.createNode("update_date").setText(newsUpdate);
         }else{
            news_info.createNode("update_date").setText("0");
         }
         return EResult.Success;
      }
      return EResult.Failure;
   }

   // ============================================================
   // <T>分页获取实时数据相关信息。</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // ============================================================
   @Override
   public EResult select(IWebContext context,
                         IWebInput input,
                         IWebOutput output,
                         ILogicContext logicContext){
      _logger.debug(this, "FNewsService_select", "FNewsService_select begin. ");

      // FXmlNode inputNode = input.config();
      // + );
      int pageNum = 0, pageSize = 10;
      String pageSizeStr = input.config().findNode("pagesize").text();
      String pageNumStr = input.config().findNode("pagenumber").text();
      if(pageSizeStr != null && (!"".equals(pageSizeStr))){
         pageSize = Integer.parseInt(pageSizeStr);
      }
      if(pageNumStr != null && (!"".equals(pageNumStr))){
         pageNum = Integer.parseInt(pageNumStr);
      }
      FLogicDataset<FDataLogicTruetimeUnit> newsUnits = _trueTimeDataConsole.select(pageNum, pageSize, logicContext);
      output.config().createNode("page_number").setText(pageNumStr);
      if(newsUnits != null && newsUnits.count() > 0){
         FXmlNode list = output.config().createNode("truetime_list");
         for(Iterator<FDataLogicTruetimeUnit> iterator = newsUnits.iterator(); iterator.hasNext();){
            FDataLogicTruetimeUnit newsUnit = iterator.next();
            FXmlNode xruntime = list.createNode("truetime_info");
            // xruntime.createNode("ouid").setText(newsUnit.ouid());
            String guidStr = newsUnit.guid();
            if(guidStr != null && (!"".equals(guidStr))){
               xruntime.createNode("guid").setText(guidStr);
               if(newsUnit.linkCd() == EGcLink.Content){
                  xruntime.createNode("info_url").setText(_trueTimeDataHost + "mobile/logic/truetimedata/TrueTimeData.wa?do=getContent&guid=" + newsUnit.guid());
               }
            }else{
               xruntime.createNode("guid").setText("0");
            }

            // 如果是外链实时数据
            if(newsUnit.linkCd() == EGcLink.Link){
               String newsLinkUrl = newsUnit.linkUrl();
               if(newsLinkUrl != null && (!"".equals(newsLinkUrl))){
                  xruntime.createNode("info_url").setText(newsUnit.linkUrl());
               }else{
                  xruntime.createNode("info_url").setText("0");
               }
            }
            String newsLabel = newsUnit.label();
            if(newsLabel != null && (!"".equals(newsLabel))){
               xruntime.createNode("label").setText(newsLabel);
            }else{
               xruntime.createNode("label").setText("0");
            }
            String newsDescription = newsUnit.description();
            if(newsDescription != null && (!"".equals(newsDescription))){
               xruntime.createNode("info_description").setText(newsDescription);
            }else{
               xruntime.createNode("info_description").setText("0");
            }
            if(newsUnit.iconUrl() != null && (!"".equals(newsUnit.iconUrl()))){
               String makeUrl = _storageConsole.makeUrl(newsUnit.iconUrl());
               xruntime.createNode("icon_url").setText(makeUrl);
            }else{
               xruntime.createNode("icon_url").setText("0");
            }
            String updateDate = newsUnit.recordDate().format("yyyy/mm/dd");
            if(updateDate != null && (!"".equals(updateDate))){
               xruntime.createNode("publish_date").setText(updateDate);
            }else{
               xruntime.createNode("publish_date").setText("0");
            }
            int viewCount = newsUnit.viewCount();
            xruntime.createNode("read_count").setText(viewCount + "");
         }

      }
      return EResult.Success;
   }

   // ============================================================
   // <T>标记实时数据已读</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // ============================================================
   @Override
   public EResult markRead(IWebContext context,
                           IWebInput input,
                           IWebOutput output,
                           ILogicContext logicContext,
                           IWebSession sessionContext){
      String sessionCode = context.head("mo-session-id");
      String guid = context.parameter("truetime_id");
      if(RString.isNotEmpty(sessionCode)){
         FGcSessionInfo sessionInfo = _sessionConsole.findBySessionCode(logicContext, sessionCode);
         long userId = sessionInfo.userId();
         int isSuccess = _trueTimeDataConsole.markRead(guid, userId, logicContext, sessionContext);
         if(isSuccess == -1){
            return EResult.Failure;
         }else{
            output.config().createNode("read_count").setText(isSuccess + "");
         }
      }
      return EResult.Success;
   }
}
