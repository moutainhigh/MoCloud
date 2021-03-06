package org.mo.content.face.manage.logger.user;

import org.mo.content.face.base.FBasePage;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>人员账号逻辑接口。</T>
//
// @author sunhr
// @version 150328
//============================================================
public interface IAccessAction
{

   //============================================================
   // <T></T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   String construct(IWebContext context,
                    ILogicContext logicContext,
                    @AContainer(name = "basePage") FBasePage basePage);

   //============================================================
   // <T></T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   String select(IWebContext context,
                 ILogicContext logicContext,
                 @AContainer(name = "accessPage") FAccessPage accessPage,
                 @AContainer(name = "basePage") FBasePage basePage);

}
