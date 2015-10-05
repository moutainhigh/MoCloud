package org.mo.content.service.info.logic.version;

import com.cyou.gccloud.data.data.FDataSystemVersionResourceUnit;
import com.cyou.gccloud.data.data.FDataSystemVersionUnit;
import java.util.HashMap;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.logic.version.IVersionConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.core.session.IWebSessionConsole;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>版本更新服务。</T>
//============================================================
public class FVersionService
      extends FObject
      implements
         IVersionService
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FVersionService.class);

   //版本更新逻辑控制台
   @ALink
   protected IVersionConsole _versionConsole;

   //会话控制台
   @ALink
   protected IWebSessionConsole _sessionConsole;

   //============================================================
   // <T>默认逻辑。</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   @Override
   public EResult process(IWebContext context,
                          IWebInput input,
                          IWebOutput output){
      _logger.debug(this, "process", "process begin. ");
      return EResult.Success;
   }

   //============================================================
   // @连接服务器查看版本是否有更新
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   //============================================================
   @Override
   public EResult connect(IWebContext context,
                          IWebSession sessionContext,
                          IWebInput input,
                          IWebOutput output,
                          ILogicContext logicContext){
      // 获得应用程序id和与之对应的版本编号
      FXmlNode inputNode = input.config();
      FXmlNode inputApplicationNode = inputNode.findNode("ApplicationId");
      FXmlNode inputVersionNode = inputNode.findNode("VersionCode");
      String applicationStr = inputApplicationNode.text();
      String versionStr = inputVersionNode.text();
      // 会话管理
      //      FWebSession session = (FWebSession)sessionContext;
      //      System.out.println("*******************" + sessionContext.getClass().getName());
      //输出信息
      HashMap<String, Object> hashMap = _versionConsole.connect(context, versionStr, applicationStr, logicContext, sessionContext);
      FDataSystemVersionUnit lastVersionUnit = (FDataSystemVersionUnit)hashMap.get("lastVersion");
      FDataSystemVersionResourceUnit lastVersionResourceUnit = (FDataSystemVersionResourceUnit)hashMap.get("lastVersionResource");
      FXmlNode sessionNode = output.config().createNode("Session");
      sessionNode.set("code", "待定sessionid");
      FXmlNode outputVersionNode = output.config().createNode("VersionCode");
      if(lastVersionUnit != null){
         outputVersionNode.set("code", lastVersionUnit.code());
         outputVersionNode.set("upgrade_cd", lastVersionUnit.forceCd());
      }
      if(lastVersionResourceUnit != null){
         outputVersionNode.set("upgrade_url", lastVersionResourceUnit.downloadUrl());
      }
      FXmlNode outputApplicationNode = output.config().createNode("Application");
      outputApplicationNode.set("Application_Id", applicationStr);
      return EResult.Success;
   }

   //============================================================
   // @断开与服务器的连接
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext 会话session上下文
   //============================================================
   @Override
   public EResult disconnect(IWebContext context,
                             IWebSession sessionContext,
                             IWebInput input,
                             IWebOutput output,
                             ILogicContext logicContext){
      //获取会话id
      FXmlNode inputNode = input.config();
      FXmlNode inputSessionCodeNode = inputNode.findNode("SessionCode");
      String sessionCodeNodeStr = inputSessionCodeNode.text();
      _versionConsole.disconnect(context, sessionCodeNodeStr, logicContext, sessionContext, _sessionConsole);
      return EResult.Success;
   }
}
