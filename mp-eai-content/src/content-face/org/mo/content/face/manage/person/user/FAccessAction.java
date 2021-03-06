package org.mo.content.face.manage.person.user;

import com.cyou.gccloud.data.data.FDataPersonAccessAuthorityUnit;
import org.mo.com.lang.EResult;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.person.user.IAccessConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.content.face.manage.home.FFrameAction;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.eai.logic.data.person.user.IDataPersonAccessAuthorityConsole;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>人员账号逻辑。</T>
//
// @author sunhr
// @version 150328
//============================================================
public class FAccessAction
      implements
         IAccessAction
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FFrameAction.class);

   //用户控制台
   @ALink
   protected IAccessConsole _accessConsole;

   //用户权限控制台
   @ALink
   protected IDataPersonAccessAuthorityConsole _authorityConsole;

   //============================================================
   // <T>用户</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   @Override
   public String construct(IWebContext context,
                           ILogicContext logicContext,
                           FAccessPage page){
      //      System.out.println("------------eai----------------construct");
      //      FLogicDataset<FDataPersonAccessAuthorityUnit> unitlist = _accessConsole.select(logicContext);
      //      page.setUnitList(unitlist);
      return "/manage/manage/person/user/AccessList";
   }

   @Override
   public String select(IWebContext context,
                        ILogicContext logicContext,
                        FAccessPage page,
                        FBasePage basePage){
      _logger.debug(this, "LoginUser", "LoginUser begin. (page={1})", context.parameter("page"));
      if(null != context.parameter("page")){
         String num = context.parameter("page");
         page.setPageCurrent(Integer.parseInt(num));
      }else{
         page.setPageCurrent(0);
      }
      FLogicDataset<FDataPersonAccessAuthorityUnit> unitlist = _accessConsole.select(logicContext, page.pageCurrent() - 1);
      basePage.setJson(unitlist.toJsonListString());
      return "/manage/common/ajax";
   }

   @Override
   public String delete(IWebContext context,
                        ILogicContext logicContext,
                        FAccessPage page){
      long id = context.parameterAsLong("id");
      FDataPersonAccessAuthorityUnit unit = new FDataPersonAccessAuthorityUnit();
      unit.setOuid(id);
      _accessConsole.doDelete(logicContext, unit);
      page.setResult("/manage/person/user/Access.wa");
      return "/manage/manage/person/user/Success";
   }

   @Override
   public String insert(IWebContext context,
                        ILogicContext logicContext,
                        FAccessPage page){
      String host = context.parameter("host_address").replaceAll(" ", "");
      String passport = context.parameter("passport").replaceAll(" ", "");
      if(!host.isEmpty()){
         EResult hostExist = _accessConsole.hostExists(logicContext, host);
         if(hostExist == EResult.Success){
            page.setResult("此IP[" + host + "]已在白名单中，请勿重复操作！");
            return "/manage/manage/person/user/Failure";
         }
      }
      if(!passport.isEmpty()){
         EResult passportExist = _accessConsole.passportExists(logicContext, passport);
         if(passportExist == EResult.Success){
            page.setResult("此帐号[" + passport + "]已在白名单中，请勿重复操作！");
            return "/manage/manage/person/user/Failure";
         }
      }
      FDataPersonAccessAuthorityUnit unit = new FDataPersonAccessAuthorityUnit();
      unit.setHostAddress(host);
      unit.setLabel(context.parameter("label"));
      unit.setPassport(passport);
      unit.setPassword(context.parameter("password"));
      unit.setAccessCd(context.parameterAsInteger("access_cd"));
      unit.setTypeCd(context.parameterAsInteger("type_cd"));
      //时间处理
      String beginDateStr = context.parameter("begin_date");
      TDateTime beginDate = new TDateTime();
      beginDate.parse(beginDateStr, "YYYY-MM-DD HH24:MI");
      unit.setBeginDate(beginDate);
      //结束时间
      String endDateStr = context.parameter("end_date");
      TDateTime endDate = new TDateTime();
      endDate.parse(endDateStr, "YYYY-MM-DD HH24:MI");
      unit.setEndDate(endDate);
      //.....................................
      unit.setNote(context.parameter("note"));
      _accessConsole.doInsert(logicContext, unit);
      page.setResult("/manage/person/user/Access.wa");
      return "/manage/manage/person/user/Success";
   }

   @Override
   public String updateBefore(IWebContext context,
                              ILogicContext logicContext,
                              FAccessPage page){
      long id = context.parameterAsLong("id");
      FDataPersonAccessAuthorityUnit unit = _accessConsole.find(logicContext, id);
      page.setUnit(unit);
      return "/manage/manage/person/user/UpdateUser";
   }

   @Override
   public String update(IWebContext context,
                        ILogicContext logicContext,
                        FAccessPage page){
      String host = context.parameter("host_address").replaceAll(" ", "");
      String passport = context.parameter("passport").replaceAll(" ", "");
      long id = context.parameterAsLong("id");
      FDataPersonAccessAuthorityUnit unit = _accessConsole.find(logicContext, id);
      unit.setHostAddress(host);
      if(!host.isEmpty()){
         if(unit.isHostAddressChanged()){
            EResult hostExist = _accessConsole.hostExists(logicContext, host);
            if(hostExist == EResult.Success){
               page.setResult("此IP[" + host + "]已在白名单中，请勿重复操作！");
               return "/manage/manage/person/user/Failure";
            }
         }
      }
      unit.setPassport(passport);
      if(!passport.isEmpty()){
         if(unit.isPassportChanged()){
            EResult passportExist = _accessConsole.passportExists(logicContext, passport);
            if(passportExist == EResult.Success){
               page.setResult("此帐号[" + passport + "]已在白名单中，请勿重复操作！");
               return "/manage/manage/person/user/Failure";
            }
         }
      }
      unit.setLabel(context.parameter("label"));
      unit.setPassword(context.parameter("password"));
      unit.setAccessCd(context.parameterAsInteger("access_cd"));
      unit.setTypeCd(context.parameterAsInteger("type_cd"));
      //时间处理
      String beginDateStr = context.parameter("begin_date");
      TDateTime beginDate = new TDateTime(beginDateStr);
      beginDate.parse(beginDateStr, "YYYY-MM-DD HH24:MI");
      unit.setBeginDate(beginDate);
      //结束时间
      String endDateStr = context.parameter("end_date");
      TDateTime endDate = new TDateTime(endDateStr);
      endDate.parse(endDateStr, "YYYY-MM-DD HH24:MI");
      unit.setEndDate(endDate);
      //.....................................
      unit.setNote(context.parameter("note"));
      _accessConsole.doUpdate(logicContext, unit);
      page.setResult("/manage/person/user/Access.wa");
      return "/manage/manage/person/user/Success";
   }

}
