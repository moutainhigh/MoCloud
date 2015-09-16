package org.mo.content.service.face.mobile;

import org.mo.com.lang.EResult;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>手机操作接口。</T>
//============================================================
public interface IMobileService
{
   //============================================================
   // <T>根据手机号获取相关信息。</T>
   //
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   EResult mobileInfo(IWebContext context,
                      IWebInput input,
                      IWebOutput output);

}
