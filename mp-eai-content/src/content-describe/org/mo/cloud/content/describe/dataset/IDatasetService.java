package org.mo.cloud.content.describe.dataset;

import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>内容表单服务接口。</T>
//============================================================
public interface IDatasetService
{
   //============================================================
   // <T>从配置文件中加载树目录节点。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   void list(IWebContext context,
             IWebInput input,
             IWebOutput output);

   //============================================================
   // <T>查询配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   void query(IWebContext context,
              IWebInput input,
              IWebOutput output);

   //============================================================
   // <T>新建配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   void insert(IWebContext context,
               IWebInput input,
               IWebOutput output);

   //============================================================
   // <T>更新配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   void update(IWebContext context,
               IWebInput input,
               IWebOutput output);

   //============================================================
   // <T>删除配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   void delete(IWebContext context,
               IWebInput input,
               IWebOutput output);
}
