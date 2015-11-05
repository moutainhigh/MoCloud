package org.mo.content.face.manage.product.system.version;

import com.cyou.gccloud.data.data.FDataSystemVersionUnit;
import com.cyou.gccloud.define.enums.core.EGcResourceStatus;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.product.system.application.IApplicationConsole;
import org.mo.content.core.manage.product.system.version.FDataVersionInfo;
import org.mo.content.core.manage.product.system.version.IVersionConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

public class FVersionAction 
      implements 
         IVersionAction 
{

   //日志输出接口
   private static ILogger _logger = RLogger.find(FVersionAction.class);

   //版本控制端
   @ALink
   private IVersionConsole _versionConsole;

   //应用控制端
   @ALink
   private IApplicationConsole _applicationConsole;

   // ============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   // ============================================================
   @Override
   public String construct(IWebContext context, 
                           ILogicContext logicContext, 
                           FBasePage page) {
      _logger.debug(this, "Construct", "Construct begin. (userId={1})", page.userId());
      if (!page.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/product/system/version/VersionList";
   }

   // ============================================================
   // <T>查询</T>
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String select(IWebContext context, 
                        ILogicContext logicContext, 
                        FVersionPage page, 
                        FBasePage basePage) {
      _logger.debug(this, "Select", "Select begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      if (null != context.parameter("page")) {
         String num = context.parameter("page");
         page.setPageCurrent(Integer.parseInt(num));
      } else {
         page.setPageCurrent(0);
      }
      FDataSystemVersionUnit unit = new FDataSystemVersionUnit();
      unit.setLabel(context.parameter("label"));
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if (null != StrPageSize) {
         pageSize = Integer.parseInt(StrPageSize);
      }
      FLogicDataset<FDataVersionInfo> unitList = _versionConsole.select(logicContext, unit, page.pageCurrent() - 1, pageSize);
      _logger.debug(this, "Select", "Select finish. (unitListCount={1})", unitList.count());
      basePage.setJson(unitList.toJsonListString());
      return "/manage/common/ajax";
   }

   // ============================================================
   // <T>增加之前</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String insertBefore(IWebContext context, 
                              ILogicContext logicContext, 
                              FVersionPage page, 
                              FBasePage basePage) {
      _logger.debug(this, "InsertBefore", "InsertBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/product/system/version/InsertVersion";
   }

   // ============================================================
   // <T>增加</T>
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String insert(IWebContext context, 
                        ILogicContext logicContext, 
                        FVersionPage page, 
                        FBasePage basePage) {
      _logger.debug(this, "Insert", "InsertBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }

      FDataSystemVersionUnit unit = _versionConsole.doPrepare(logicContext);

      Float number = context.parameterAsFloat("number");
      if (number <= 0f) {
         page.setResult("版本号只支持数字和英文小数点!");
         return "/manage/product/system/version/InsertVersion";
      }

      setLogicVersion(context, logicContext, unit);
      if (_versionConsole.isExsitsAppIdandNumber(logicContext, unit.applicationId(), unit.number())) {
         page.setResult("版本号重复!");
         return "/manage/product/system/version/InsertVersion";
      }

      EResult result = _versionConsole.doInsert(logicContext, unit);
      if (!result.equals(EResult.Success)) {
         page.setResult("增加失败");
         return "/manage/product/system/version/InsertVersion";
      }
      _logger.debug(this, "Insert", "Insert finish. (RESULT={S})", "SUCCESS");
      return "/manage/product/system/version/VersionList";
   }

   // ============================================================
   // <T>更新之前</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String updateBefore(IWebContext context, 
                              ILogicContext logicContext, 
                              FVersionPage page, 
                              FBasePage basePage) {
      _logger.debug(this, "updateBefore", "updateBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataSystemVersionUnit unit = _versionConsole.find(logicContext, id);
      page.setUnit(unit);
      page.setResult("");
      _logger.debug(this, "ouid", "updateBefore finish. (Result={1})", "SUCCESS");
      return "/manage/product/system/version/UpdateVersion";
   }

   // ============================================================
   // <T>是否编辑</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String isUpdate(IWebContext context, 
                              ILogicContext logicContext, 
                              FVersionPage Page, 
                              FBasePage basePage){
      _logger.debug(this, "deleteBefore", "deleteBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataSystemVersionUnit unit = _versionConsole.find(logicContext, id);
      if(RString.equals(unit.statusCd(),EGcResourceStatus.Publish)){
         basePage.setJson("noUpdate");
      }else{
         basePage.setJson("yesUpdate");
      }
      return "/manage/common/ajax";
   }
   // ============================================================
   // <T>更新</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String update(IWebContext context, 
                        ILogicContext logicContext, 
                        FVersionPage page, 
                        FBasePage basePage) {
      _logger.debug(this, "Update", "Update Begin.(id={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      FDataSystemVersionUnit unit = _versionConsole.find(logicContext, Long.parseLong(context.parameter("ouid")));
      Float number = context.parameterAsFloat("number");
      if (number <= 0f) {
         basePage.setJson("nonumber");
         return "/manage/common/ajax";
      }
      setLogicVersion(context, logicContext, unit);
      if (_versionConsole.isExsitsAppIdandNumberandOuid(logicContext, unit.applicationId(), unit.ouid(), unit.number())) {
         basePage.setJson("overwrite");
         return "/manage/common/ajax";
      }
      _versionConsole.doUpdate(logicContext, unit);
      basePage.setJson("success");
      _logger.debug(this, "Update", "Update finish.(RESULT={1})", "SUCCESS");
      return "/manage/common/ajax";
   }

   // ============================================================
   // <T>删除之前</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String deleteBefore(IWebContext context, 
                              ILogicContext logicContext, 
                              FVersionPage Page, 
                              FBasePage basePage){
      _logger.debug(this, "deleteBefore", "deleteBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataSystemVersionUnit unit = _versionConsole.find(logicContext, id);
      if(RString.equals(unit.statusCd(),2)){
         basePage.setJson("noDel");
      }else{
         basePage.setJson("yesDel");
      }
      return "/manage/common/ajax";
   }
   // ============================================================
   // <T>删除</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String delete(IWebContext context, 
                        ILogicContext logicContext, 
                        FVersionPage Page, 
                        FBasePage basePage) {
      _logger.debug(this, "Delete", "Delete begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataSystemVersionUnit unit = _versionConsole.find(logicContext, id);
      if (unit == null) {
         throw new FFatalError("id not exists.");
      }
      EResult result = _versionConsole.doDelete(logicContext, unit);
      if (!result.equals(EResult.Success)) {
         throw new FFatalError("Delete failure.");
      } else {
         return "/manage/product/system/version/VersionList";
      }
   }

   // ============================================================
   // <T>抽取数据库字段赋值的公共方法</T>
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return void
   // ============================================================
   public void setLogicVersion(IWebContext context, 
                               ILogicContext logicContext, 
                               FDataSystemVersionUnit unit) {
      unit.setCreateUserId(context.parameterAsLong("adminId"));
      unit.setLabel(context.parameter("label"));
      unit.setCode(context.parameter("code"));
      String note = context.parameter("note");
      note = note.replaceAll("<br>", "\r\n");
      unit.setNote(note);
      unit.setNumber(context.parameterAsFloat("number"));
      unit.setForceCd(context.parameterAsInteger("forceCd"));
      // 默认为申请
      unit.setStatusCd(EGcResourceStatus.Apply);
      unit.setApplicationId(context.parameterAsLong("applicationId"));
      unit.setDownloadUrl(context.parameter("downloadUrl")==null?"":context.parameter("downloadUrl").trim());
      String beginDateStr = context.parameter("beginDate");
      TDateTime beginDate = new TDateTime();
      beginDate.parse(beginDateStr, "YYYY-MM-DD");
      unit.setBeginDate(beginDate);
      String endDateStr = context.parameter("endDate");
      TDateTime endDate = new TDateTime();
      endDate.parse(endDateStr, "YYYY-MM-DD");
      unit.setEndDate(endDate);
   }
}
