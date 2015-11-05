package com.ahyc.eai.service.financial.marketer;

import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>理财师信息处理接口。</T>
//============================================================
public interface IStatisticsCustomerServlet
{
   //============================================================
   // <T>获得实时动态数据。</T>
   //
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param request 请求
   // @param response 应答
   //============================================================
   EResult dynamic(IWebContext context,
                   ILogicContext logicContext,
                   IWebServletRequest request,
                   IWebServletResponse response);

   //============================================================
   // <T>获得投资产品数据。</T>
   //
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param request 请求
   // @param response 应答
   //============================================================
   EResult tender(IWebContext context,
                  ILogicContext logicContext,
                  IWebServletRequest request,
                  IWebServletResponse response);

   //============================================================
   // <T>获得实时趋势数据。</T>
   //
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param request 请求
   // @param response 应答
   //============================================================
   EResult trend(IWebContext context,
                 ILogicContext logicContext,
                 IWebServletRequest request,
                 IWebServletResponse response);
}
