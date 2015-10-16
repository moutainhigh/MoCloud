package org.mo.content.face.mobile.logic.truetimedata;

import org.mo.content.face.base.FBasePage;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>客户信息接口。</P>
//@interface ICustomerAction
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================
public interface ITrueTimeDataAction
{
   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   //============================================================
   String construct(IWebContext context,
                    ILogicContext logicContext,
                    @AContainer(name = "page") FTrueTimeDataPage Page,
                    @AContainer(name = "basePage") FBasePage page);

   //============================================================
   // <T>查询</T>
   // @计算器
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   String getInfo(IWebContext context,
                  ILogicContext logicContext,
                  @AContainer(name = "page") FTrueTimeDataPage Page,
                  @AContainer(name = "basePage") FBasePage basePage);

   //============================================================
   // <T>增加之前</T>
   // @内容
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   public String getContent(IWebContext context,
                            ILogicContext logicContext,
                            @AContainer(name = "page") FTrueTimeDataPage page,
                            @AContainer(name = "basePage") FBasePage basePage);

   //============================================================
   // <T>销售工具中集团简介模板</T>
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   public String getGroupInfo(IWebContext context,
                              ILogicContext logicContext,
                              @AContainer(name = "page") FTrueTimeDataPage page,
                              @AContainer(name = "basePage") FBasePage basePage);
}
