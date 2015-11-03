package com.ahyc.eai.service.cockpit.trend;

import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>理财师信息处理接口。</T>
//============================================================
public interface ICockpitTrendServlet
{

   //============================================================
   // <T>阈值预警列表</T>
   //
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param request 请求
   // @param response 应答
   //============================================================
   EResult fetch(IWebContext context,
                 ILogicContext logicContext,
                 IWebServletRequest request,
                 IWebServletResponse response);
}
