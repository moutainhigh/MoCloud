package org.mo.content.core.resource.bitmap;

import org.mo.cloud.logic.resource.bitmap.IGcResBitmapImageConsole;
import org.mo.com.lang.EResult;
import org.mo.com.xml.FXmlNode;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>内容纹理控制台接口。</T>
//============================================================
public interface IC2dBitmapImageConsole
      extends
         IGcResBitmapImageConsole
{
   //============================================================
   // <T>获取数据处理。</T>
   //
   // @param context 逻辑环境
   // @param xoutput 输出内容
   // @param serach 搜索内容
   // @param pageSize 页面大小
   // @param page 页面编号
   // @return 处理结果
   //============================================================
   EResult fetch(ILogicContext context,
                 FXmlNode xoutput,
                 String serach,
                 int pageSize,
                 int page);
}
