package org.mo.content.face.solution.person;

import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.core.face.AWebLogin;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>用户空间逻辑接口。</T>
//
// @author maocy
// @version 150413
//============================================================
@AWebLogin
public interface IUserAction
{
   //============================================================
   // <T>用户信息显示处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param sessionInfo 会话信息
   // @param page 容器
   // @return 页面
   //============================================================
   String construct(IWebContext context,
                    ILogicContext logicContext,
                    FGcSessionInfo sessionInfo,
                    @AContainer(name = "page") FUserPage page);

   //============================================================
   // <T>用户信息更新处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param sessionInfo 会话信息
   // @param page 容器
   // @return 页面
   //============================================================
   String update(IWebContext context,
                 ILogicContext logicContext,
                 FGcSessionInfo sessionInfo,
                 @AContainer(name = "page") FUserPage page);
}
