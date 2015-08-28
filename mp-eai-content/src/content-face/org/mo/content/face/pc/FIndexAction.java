package org.mo.content.face.pc;

import com.cyou.gccloud.data.cache.FCacheSystemValidationUnit;
import com.cyou.gccloud.data.data.FDataControlModuleUnit;
import com.cyou.gccloud.data.data.FDataControlRoleModuleUnit;
import com.cyou.gccloud.data.data.FDataControlRoleUnit;
import com.cyou.gccloud.data.data.FDataPersonUserEntryUnit;
import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import com.cyou.gccloud.data.logger.FLoggerPersonUserModuleUnit;
import com.cyou.gccloud.define.enums.core.EGcAuthorityAccess;
import com.cyou.gccloud.define.enums.core.EGcAuthorityResult;
import com.cyou.gccloud.define.enums.core.EGcPersonUserFrom;
import com.cyou.gccloud.define.enums.core.EGcPersonUserStatus;
import com.cyou.gccloud.define.enums.core.EGcValidationValidate;
import com.jianzhou.sdk.BusinessService;
import org.mo.cloud.core.web.FGcWebSession;
import org.mo.com.lang.EResult;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.RRandom;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.cache.system.IValidationConsole;
import org.mo.content.core.common.EChartPage;
import org.mo.content.core.manage.logger.user.ILoggerModuleConsole;
import org.mo.content.core.manage.person.module.IModuleConsole;
import org.mo.content.core.manage.person.role.IRoleConsole;
import org.mo.content.core.manage.person.role.IRoleModuleConsole;
import org.mo.content.core.manage.person.user.IEntryConsole;
import org.mo.content.core.manage.person.user.IUserConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.eai.logic.data.person.user.FDataPersonAccessAuthority;
import org.mo.eai.logic.data.person.user.IDataPersonAccessAuthorityConsole;
import org.mo.eai.logic.financial.FFinancialMarketerInfo;
import org.mo.eai.logic.financial.IFinancialMarketerConsole;
import org.mo.eai.logic.logger.person.user.FLoggerPersonUserAccess;
import org.mo.eai.logic.logger.person.user.ILoggerPersonUserAccessConsole;
import org.mo.eai.logic.service.info.ILogicServiceInfoConsole;
import org.mo.web.core.action.common.FWebCookie;
import org.mo.web.core.session.IWebSession;
import org.mo.web.core.session.IWebSessionConsole;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <P>首页。</P>
//
// @author maocy
// @version 150427
//============================================================
public class FIndexAction
      implements
         IIndexAction
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FIndexAction.class);

   @ALink
   protected IWebSessionConsole _sessionConsole;

   @ALink
   protected IDataPersonAccessAuthorityConsole _personAccessAuthorityConsole;

   @ALink
   protected ILoggerPersonUserAccessConsole _loggerPersonUserAccessConsole;

   @ALink
   protected ILogicServiceInfoConsole _loggerServiceInfoConsole;

   @ALink
   protected IUserConsole _userConsole;

   @ALink
   protected IRoleConsole _roleConsole;

   //模块控制台
   @ALink
   protected IModuleConsole _moduleConsole;

   //角色模块控制台
   @ALink
   protected IRoleModuleConsole _roleModuleConsole;

   @ALink
   protected IEntryConsole _entryConsole;

   //短信校验控制台
   @ALink
   protected IValidationConsole _validationConsole;

   //理财师控制台
   @ALink
   protected IFinancialMarketerConsole _marketerConsole;

   @ALink
   protected ILoggerModuleConsole _loggerModuleConsole;

   //OA角色
   protected final String role_oa = "eai.oa";

   //理财师角色
   protected final String role_marketer = "eai.marketer";

   protected final String module_code_customer = "eai.marketer.customer";

   protected final String module_code_marketer = "eai.marketer.marketer";

   protected final String module_code_department = "eai.department.marketer";

   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @Override
   public String construct(IWebContext context,
                           ILogicContext logicContext,
                           FIndexPage page){
      // 清空参数
      page.setPassport(null);
      page.setPassword(null);
      page.setMessage(null);
      page.setUserType(null);
      // 获得参数
      String hostAddress = context.head("x-real-ip");
      if(RString.isEmpty(hostAddress)){
         hostAddress = context.head("x-forwarded-for");
         if(RString.isEmpty(hostAddress)){
            hostAddress = context.remoteAddress();
         }
      }
      page.setHost(hostAddress);
      // 登录处理
      FDataPersonAccessAuthority authority = _personAccessAuthorityConsole.findByHostAddress(logicContext, hostAddress);
      if(authority != null){
         int accessCd = authority.accessCd();
         if(accessCd == EGcAuthorityAccess.Allow){
            // 增加日志
            FLoggerPersonUserAccess logger = _loggerPersonUserAccessConsole.doPrepare(logicContext);
            logger.setHostAddress(hostAddress);
            logger.setLogicMessage("主机地址为白名单。");
            _loggerPersonUserAccessConsole.doInsert(logicContext, logger);
            //插入用户，权限绑定
            String passport = "white-host:" + hostAddress;
            page.setUserType("host");
            synchronizeData(logicContext, page, passport, EGcPersonUserFrom.EaiHost);
            // 设置服务主机
            return "Main";
         }
      }
      // 非法设置
      return "Login";
   }

   //============================================================
   // <T>登录逻辑处理。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @Override
   public String login(IWebContext context,
                       IWebSession sessionContext,
                       ILogicContext logicContext,
                       FIndexPage page){
      // 获得参数
      String passport = RString.trimRight(page.passport());
      String password = page.password();
      String hostAddress = context.head("x-real-ip");
      String cookie = context.parameter("saveCookie");
      if(RString.isEmpty(hostAddress)){
         hostAddress = context.head("x-forwarded-for");
         if(RString.isEmpty(hostAddress)){
            hostAddress = context.remoteAddress();
         }
      }
      // 登录处理
      String message = null;
      String logggerMessage = null;
      int resultCd = _personAccessAuthorityConsole.doLogin(logicContext, hostAddress, passport, password);
      switch(resultCd){
         case EGcAuthorityResult.Success:
            passport = "white-user:" + passport;
            synchronizeData(logicContext, page, passport, EGcPersonUserFrom.EaiHost);
            logggerMessage = "登录成功。";
            break;
         case EGcAuthorityResult.PassportInvalid:
            logggerMessage = "账号不存在。";
            message = "用户名或密码错误。";
            break;
         case EGcAuthorityResult.PasswordInvalid:
            logggerMessage = "密码错误。";
            message = "用户名或密码错误。";
            break;
         case EGcAuthorityResult.DateInvalid:
            message = "时间已失效。";
            break;
         case EGcAuthorityResult.OaSuccess:
            passport = "oa:" + passport;
            synchronizeData(logicContext, page, passport, EGcPersonUserFrom.EaiOa);
            logggerMessage = "OA登录成功。";
            break;
         case EGcAuthorityResult.OaPasswordInvald:
            logggerMessage = "OA用户或密码错误。";
            message = "用户名或密码错误。";
            break;
         case EGcAuthorityResult.OaHostInvalid:
            logggerMessage = "OA主机非法。";
            message = "用户名或密码错误。";
            break;
         case EGcAuthorityResult.PassportIllegal:
            logggerMessage = "用户名非法特殊字符。";
            message = "用户名非法或含有特殊字符。";
            break;
         case EGcAuthorityResult.PasswordIllegal:
            logggerMessage = "密码非法特殊字符。";
            message = "密码非法或含有特殊字符。";
            break;
      }
      // 获得用户信息
      long userId = 0;
      if((resultCd == EGcAuthorityResult.Success) || (resultCd == EGcAuthorityResult.OaSuccess)){
         FDataPersonUserUnit userUnit = _userConsole.findByPassport(logicContext, passport);
         userId = userUnit.ouid();
         // 打开会话
         FGcWebSession session = (FGcWebSession)sessionContext;
         session.setUserId(userId);
         _sessionConsole.open(session);
      }
      // 增加日志
      FLoggerPersonUserAccess logger = _loggerPersonUserAccessConsole.doPrepare(logicContext);
      logger.setUserId(userId);
      logger.setHostAddress(hostAddress);
      logger.setLogicMessage(logggerMessage);
      logger.setPassport(RString.left(passport, 40));
      logger.setPassword(RString.left(password, 40));
      logger.setBrowserUri(context.requestUrl());
      logger.setPageInfo(context.parameters().dump());
      _loggerPersonUserAccessConsole.doInsert(logicContext, logger);
      // 画面跳转
      if((resultCd == EGcAuthorityResult.Success) || (resultCd == EGcAuthorityResult.OaSuccess)){
         FDataPersonUserUnit user = _userConsole.findByPassport(logicContext, passport);
         if(user != null){
            page.setId(user.guid());
            //获取角色 验证此用户是否绑定e租宝
            FDataControlRoleUnit role = _roleConsole.findByCode(logicContext, role_oa);
            if(user.roleId() == role.ouid()){
               page.setIsOa(true);
            }
         }
         passport = passport.substring(passport.indexOf(":") + 1, passport.length());
         page.setIsLogin(true);
         page.setPassport(passport);
         if(cookie != null){
            context.outputCookies().push(new FWebCookie("passport", passport));
         }else{
            context.outputCookies().push(new FWebCookie("passport", null, 0));
         }
         return "Main";
      }else{
         page.setMessage(message);
         return "Login";
      }
   }

   //============================================================
   // <T>表格逻辑处理。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @Override
   public String chart(IWebContext context,
                       ILogicContext logicContext,
                       FIndexPage page){
      String code = context.parameter("code");
      String guid = context.parameter("id");
      if(RString.isEmpty(guid)){
         return "Login";
      }
      page.setServiceLogic(_loggerServiceInfoConsole.serviceLogic());
      page.setSceneCode(code);
      //保存日志
      FDataPersonUserUnit user = _userConsole.findByGuid(logicContext, guid);
      if(user != null){
         FLoggerPersonUserModuleUnit module = _loggerModuleConsole.doPrepare(logicContext);
         module.setUserId(user.ouid());
         module.setPassport(user.passport());
         module.setBrowserUri(context.requestUrl());
         module.setPageInfo(context.parameters().dump());
         module.setModuleAction("view");
         module.setModuleResult("Success");
         if(code.equals("ChartMarketerCustomer")){
            module.setModuleCode(module_code_customer);
         }else if(code.equals("ChartMarketerMarketer")){
            module.setModuleCode(module_code_marketer);
         }else if(code.equals("ChartDepartmentMarketer")){
            module.setModuleCode(module_code_department);
         }
         _loggerModuleConsole.doInsert(logicContext, module);
      }
      return EChartPage.Scene;
   }

   @Override
   public String loginOut(IWebContext context,
                          ILogicContext logicContext,
                          FIndexPage page){
      // 清空参数
      page.setId(null);
      page.setHost(null);
      page.setServiceLogic(null);
      page.setSceneCode(null);
      page.setPassport(null);
      page.setPassword(null);
      page.setUserType(null);
      page.setMessage(null);
      page.setMenuString(null);
      return "Login";
   }

   //============================================================
   // <T>主页面。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @Override
   public String main(IWebContext context,
                      ILogicContext logicContext,
                      FIndexPage page){
      String id = context.parameter("id");
      FDataPersonUserUnit user = _userConsole.findByGuid(logicContext, id);
      if(user == null){
         return "Login";
      }
      page.setId(id);
      //获取角色 验证此用户是否绑定e租宝
      FDataControlRoleUnit role = _roleConsole.findByCode(logicContext, role_oa);
      if(user.roleId() == role.ouid()){
         page.setIsOa(true);
      }
      String passport = user.passport();
      page.setPassport(passport.substring(passport.indexOf(":") + 1, passport.length()));
      page.setIsLogin(false);
      tackAuthority(logicContext, page, user.roleId());
      return "Main";
   }

   //============================================================
   // <T>发送验证码。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @Override
   public String sendValidate(IWebContext context,
                              ILogicContext logicContext,
                              FIndexPage page){
      page.setMessage(null);
      TDateTime nowTime = new TDateTime(RDateTime.currentDateTime());
      String passport = context.parameter("passport");
      _logger.debug(this, "SendValidate", "SendValidate begin. (passport={1})", passport);
      //根据帐号查找用户及手机号
      if(RString.isEmpty(passport)){
         page.setMessage("E租宝帐号不能为空");
         return "ajax";
      }

      FFinancialMarketerInfo marketer = _marketerConsole.findInfo(logicContext, passport);
      if(marketer == null){
         page.setMessage("E租宝账号无理财师权限！");
         return "ajax";
      }
      _logger.debug(this, "SendValidate", "SendValidate get marketer. (marketerPassport={1})", marketer.passport());
      //获取手机号码 －〉 发送验证码
      String mobile = marketer.phone();
      String random = null;
      //验证5分钟前有没有发过验证码，发过再次发送此验证码
      FCacheSystemValidationUnit validate = _validationConsole.findByTime(logicContext, nowTime);
      if(validate != null){
         random = validate.checkCode();
         _logger.debug(this, "SendValidate", "SendValidate get 5Minute ago data. (checkCode={1})", validate.checkCode());
         EResult result = _validationConsole.deleteByCode(logicContext, random);
         _logger.debug(this, "SendValidate", "SendValidate delete 5Minute ago same code. (result={1})", result);
      }else{
         random = RRandom.getNumberRandom(4);
      }
      int result = sendMessage(random, mobile);
      if(result < 0){
         page.setMessage("验证码发送失败");
         return "ajax";
      }
      //保存数据库
      FCacheSystemValidationUnit unit = _validationConsole.doPrepare(logicContext);
      unit.setPassport(passport);
      unit.setCheckCode(random);
      unit.setValidateCd(EGcValidationValidate.EaiMarketer);
      _validationConsole.doInsert(logicContext, unit);
      page.setMessage("1");
      return "ajax";
   }

   //============================================================
   // <T>账号绑定之前处理。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @Override
   public String bind(IWebContext context,
                      ILogicContext logicContext,
                      FIndexPage page){
      page.setMessage(null);
      String id = context.parameter("id");
      if(RString.isEmpty(id)){
         return "Login";
      }
      _logger.debug(this, "Bind", "Bind begin. (guid={1})", id);
      FDataPersonUserUnit user = _userConsole.findByGuid(logicContext, id);
      if(user == null){
         page.setIsLogin(false);
         return "Main";
      }
      String passport = user.passport();
      page.setPassport(passport.substring(passport.indexOf(":") + 1, passport.length()));
      page.setId(id);
      tackAuthority(logicContext, page, user.roleId());
      return "Binding";
   }

   //============================================================
   // <T>账号绑定。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @Override
   public String bindOnAccount(IWebContext context,
                               ILogicContext logicContext,
                               FIndexPage page){
      page.setMessage(null);
      String epassport = context.parameter("ePassport");
      String validate = context.parameter("validate");
      String id = context.parameter("id");
      _logger.debug(this, "BindOnAccount", "BindOnAccount begin. (passport={1},validate={2},guid={3})", epassport, validate, id);
      if(RString.isEmpty(id)){
         return "Login";
      }
      if(RString.isEmpty(epassport) || RString.isEmpty(validate)){
         page.setMessage("账号或验证码不能为空");
         return "Binding";
      }
      //获取用户
      FDataPersonUserUnit user = _userConsole.findByGuid(logicContext, id);
      if(user != null){
         String passport = user.passport();
         passport = passport.substring(passport.indexOf(":") + 1, passport.length());
         page.setPassport(passport);
      }
      FCacheSystemValidationUnit unit = _validationConsole.findByPassport(logicContext, epassport);
      //时间验证
      if(unit == null){
         page.setMessage("验证码错误");
         return "Binding";
      }
      //检测时间超时
      TDateTime nowTime = new TDateTime(RDateTime.currentDateTime());
      TDateTime serviceTime = new TDateTime(unit.createDate());
      serviceTime.addMinute(5);
      if(serviceTime.isBefore(nowTime)){
         page.setMessage("验证码错误time");
         return "Binding";
      }

      String checkCode = unit.checkCode();
      if(!checkCode.equals(validate)){
         page.setMessage("验证码错误code");
         return "Binding";
      }

      //获取角色
      FDataControlRoleUnit role = _roleConsole.findByCode(logicContext, role_marketer);
      if(user != null){
         user.setRoleId(role.ouid());
         _userConsole.doUpdate(logicContext, user);
         page.setIsOa(false);
      }

      page.setId(id);
      page.setIsLogin(false);
      tackAuthority(logicContext, page, user.roleId());
      return "Main";
   }

   //============================================================
   // <T>发送短信</T>
   //
   // @param logicContext 逻辑环境
   // @param mobile 手机号
   //============================================================
   private int sendMessage(String random,
                           String mobile){
      _logger.debug(this, "SendValidate", "sendMessage begin. (random={1},mobile={2})", random, mobile);
      BusinessService bs = new BusinessService();
      bs.setWebService("http://www.jianzhou.sh.cn/JianzhouSMSWSServer/services/BusinessService");
      String text = "您正在使用[全球实时数据中心系统]进行账户绑定，验证码" + random + ",千万不要告诉别人哟。【钰诚办公平台】";
      int result = bs.sendBatchMessage("sdk_yucheng", "1qazxsw2", mobile, text);
      _logger.debug(this, "SendValidate", "sendMessage finish. (text={1},result={2})", text, result);
      return result;
   }

   //============================================================
   // <T>登录成功后，用户信息同步。</T>
   //
   // @param logicContext 逻辑环境
   // @param passport 账户
   //============================================================
   private void synchronizeData(ILogicContext logicContext,
                                FIndexPage page,
                                String passport,
                                int from){
      FDataPersonUserUnit user = _userConsole.findByPassport(logicContext, passport);
      if(user == null){
         //获取角色
         FDataControlRoleUnit role = _roleConsole.findByCode(logicContext, role_oa);
         if(role != null){
            //同步OA用户
            FDataPersonUserUnit unit = new FDataPersonUserUnit();
            unit.setPassport(passport);
            unit.setRoleId(role.ouid());
            unit.setOvld(true);
            _userConsole.doInsert(logicContext, unit);
            page.setIsOa(true);
            //同步用户状态
            FDataPersonUserEntryUnit entryUnit = new FDataPersonUserEntryUnit();
            entryUnit.setOvld(true);
            entryUnit.setUserId(unit.ouid());
            entryUnit.setStatusCd(EGcPersonUserStatus.Normal);
            entryUnit.setFromCd(from);
            _entryConsole.doInsert(logicContext, entryUnit);
            tackAuthority(logicContext, page, unit.roleId());
         }
      }else{
         tackAuthority(logicContext, page, user.roleId());
      }
   }

   //============================================================
   // <T>获取管理权限。</T>
   //
   // @param logicContext 环境
   // @param page 容器
   // @param roleid 角色编号
   //============================================================
   private void tackAuthority(ILogicContext logicContext,
                              FIndexPage page,
                              long roleid){
      StringBuffer menuStrings = new StringBuffer();
      long roleId = roleid;
      if(roleId != 0){
         FLogicDataset<FDataControlRoleModuleUnit> roelModuleInfoList = _roleModuleConsole.selectDataByRoleIdAndModuleId(logicContext, roleId, 0);
         for(FDataControlRoleModuleUnit role : roelModuleInfoList){
            FDataControlModuleUnit module = _moduleConsole.find(logicContext, role.moduleId());
            if(module != null){
               menuStrings.append(module.code()).append("|");
            }
         }
         page.setMenuString(menuStrings.deleteCharAt(menuStrings.length() - 1).toString());
      }else{
         page.setMenuString(null);
      }
   }

}
