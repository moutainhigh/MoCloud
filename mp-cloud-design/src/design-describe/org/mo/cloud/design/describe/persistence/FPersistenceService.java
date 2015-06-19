package org.mo.cloud.design.describe.persistence;

import org.mo.cloud.content.design.configuration.FContentObject;
import org.mo.cloud.content.design.persistence.EPersistenceMode;
import org.mo.cloud.content.design.persistence.FPersistence;
import org.mo.cloud.content.design.persistence.IPersistenceConsole;
import org.mo.cloud.content.design.persistence.common.XPersistence;
import org.mo.com.lang.EResult;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.face.ALink;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>持久描述服务。</T>
//============================================================
public class FPersistenceService
      implements
         IPersistenceService
{
   // 存储名称
   protected String _storageName = "cloud";

   // 内容持久化控制台接口
   @ALink
   protected IPersistenceConsole _persistenceConsole;

   //============================================================
   // <T>构造内容表单服务。</T>
   //============================================================
   public FPersistenceService(){
   }

   //============================================================
   // <T>从配置文件中加载树目录节点。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult list(IWebContext context,
                       IWebInput input,
                       IWebOutput output){
      XPersistence[] xtrees = _persistenceConsole.list(_storageName);
      FXmlNode xconfig = output.config();
      for(XPersistence xtree : xtrees){
         FXmlNode xnode = xconfig.createNode("TreeNode");
         xnode.set("name", xtree.getName());
      }
      return EResult.Success;
   }

   //============================================================
   // <T>查询配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult query(IWebContext context,
                        IWebInput input,
                        IWebOutput output){
      String code = context.parameter("code");
      // 查找目录定义
      XPersistence xtree = _persistenceConsole.find(_storageName, code, EPersistenceMode.Config);
      if(xtree == null){
         return EResult.Failure;
      }
      // 转换数据
      FXmlNode xconfig = output.config().createNode();
      FPersistence persistence = _persistenceConsole.findPersistence(_storageName, "design.tree");
      FContentObject content = persistence.convertConfig(xtree);
      // 存储输出
      content.saveConfig(xconfig);
      return EResult.Success;
   }

   //============================================================
   // <T>新建配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult insert(IWebContext context,
                         IWebInput input,
                         IWebOutput output){
      return EResult.Success;
   }

   //============================================================
   // <T>更新配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult update(IWebContext context,
                         IWebInput input,
                         IWebOutput output){
      return EResult.Success;
   }

   //============================================================
   // <T>删除配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult delete(IWebContext context,
                         IWebInput input,
                         IWebOutput output){
      return EResult.Success;
   }
}
