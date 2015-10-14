package org.mo.content.face.manage.product.business;

import com.cyou.gccloud.data.data.FDataLogicSalestoolsUnit;
import com.cyou.gccloud.define.enums.common.EGcDisplay;
import com.cyou.gccloud.define.enums.core.EGcLink;
import com.cyou.gccloud.define.enums.core.EGcResourceStatus;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.product.business.FDataSalestoolsInfo;
import org.mo.content.core.manage.product.business.ISalestoolsConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.upload.IWebUploadConsole;
import org.mo.web.protocol.common.FWebUploadFile;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>销售工具控制器</P>
//@class FSalestoolsAction
//============================================================
public class FSalestoolsAction implements ISalestoolsAction {

   // 日志输出接口
   private static ILogger _logger = RLogger.find(FSalestoolsAction.class);

   // 销售工具控制台
   @ALink
   protected ISalestoolsConsole _salestoolsConsole;

   @ALink
   protected IWebUploadConsole _webUploadConsole;

   // ============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   // ============================================================
   @Override
   public String construct(IWebContext context, ILogicContext logicContext, FBasePage basePage) {
      _logger.debug(this, "Construct", "Construct begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/product/business/SalestoolsList";
   }

   // ============================================================
   // <T>查询</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String select(IWebContext context, ILogicContext logicContext, FSalestoolsPage page, FBasePage basePage) {
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
      FDataLogicSalestoolsUnit unit = new FDataLogicSalestoolsUnit();
      unit.setLabel(context.parameter("label"));
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if (null != StrPageSize) {
         pageSize = Integer.parseInt(StrPageSize);
      }
      FLogicDataset<FDataSalestoolsInfo> unitList = _salestoolsConsole.select(logicContext, unit, page.pageCurrent() - 1, pageSize);
      basePage.setJson(unitList.toJsonListString());
      _logger.debug(this, "Select", "Select finish. (unitListCount={1})", unitList.count());
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
   public String insertBefore(IWebContext context, ILogicContext logicContext, FSalestoolsPage page, FBasePage basePage) {
      _logger.debug(this, "InsertBefore", "InsertBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      page.setResult("");
      return "/manage/product/business/InsertSalestools";
   }

   // ============================================================
   // <T>增加</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String insert(IWebContext context, ILogicContext logicContext, FSalestoolsPage page, FBasePage basePage) {
      _logger.debug(this, "Insert", "InsertBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      FDataLogicSalestoolsUnit unit = _salestoolsConsole.doPrepare(logicContext);
      FWebUploadFile file = context.files().first();
      if (null != file) {
         Integer len = file.length() / 1024;
         if (len > 20) {
            page.setResult("请上传小于20k的图片!");
            return "/manage/product/business/news/InsertNews";
         }
         String type = file.contentType();
         if (!type.contains("image")) {
            page.setResult("请上传图片!");
            return "/manage/product/business/news/InsertNews";
         }
      }
      setLogicNews(context, logicContext, unit, "0");
      EResult result = _salestoolsConsole.doInsert(logicContext, unit);
      if (!result.equals(EResult.Success)) {
         page.setResult("增加失败");
         return "/manage/product/business/InsertNews";
      }
      _logger.debug(this, "Insert", "Insert finish. (RESULT={S})", "SUCCESS");
      return "/manage/product/business/SalestoolsList";
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
   public String updateBefore(IWebContext context, ILogicContext logicContext, FSalestoolsPage page, FBasePage basePage) {
      _logger.debug(this, "updateBefore", "updateBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataLogicSalestoolsUnit unit = _salestoolsConsole.find(logicContext, id);
      FDataSalestoolsInfo info = new FDataSalestoolsInfo();
      info.setOuid(unit.ouid());
      info.setContent(unit.content());
      info.setDescription(unit.description());
      info.setKeywords(unit.keywords());
      info.setDisplayCdStr(EGcDisplay.formatLabel(unit.displayCd()));
      info.setLinkCdStr(EGcLink.formatLabel(unit.linkCd()));
      info.setLinkUrl(unit.linkUrl());
      info.setLabel(unit.label());
      info.setDisplayOrder(unit.displayOrder());
      if (!RString.isEmpty(unit.iconUrl())) {
         info.setIconUrl(unit.iconUrl());
         int na = unit.iconUrl().indexOf("salestoolsImages");
         info.setImageName("/manage/images/salestoolsImages/" + unit.iconUrl().substring(na + 17, unit.iconUrl().length()));
      }
      page.setUnit(info);
      page.setResult("");
      _logger.debug(this, "ouid", "updateBefore begin. (Result={1})", "SUCCESS");
      return "/manage/product/business/UpdateSalestools";
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
   public String update(IWebContext context, ILogicContext logicContext, FSalestoolsPage page, FBasePage basePage) {
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      _logger.debug(this, "Update", "Update Begin.(id={1})", basePage.userId());
      FDataLogicSalestoolsUnit unit = _salestoolsConsole.find(logicContext, Long.parseLong(context.parameter("ouid")));
      FWebUploadFile file = context.files().first();
      if (null != file) {
         Integer len = file.length() / 1024;
         if (len > 20) {
            page.setResult("请上传小于20k的图片!");
            return "/manage/product/business/news/UpdateNews";
         }
         String type = file.contentType();
         if (!type.contains("image")) {
            page.setResult("请上传图片!");
            return "/manage/product/business/news/UpdateNews";
         }
      }
      setLogicNews(context, logicContext, unit, "1");
      _salestoolsConsole.doUpdate(logicContext, unit);
      _logger.debug(this, "Update", "Update finish.(RESULT={1})", "SUCCESS");
      return "/manage/product/business/SalestoolsList";
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
   public String delete(IWebContext context, ILogicContext logicContext, FSalestoolsPage Page, FBasePage basePage) {
      _logger.debug(this, "Delete", "Delete begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataLogicSalestoolsUnit unit = _salestoolsConsole.find(logicContext, id);
      if (unit == null) {
         throw new FFatalError("id not exists.");
      }
      EResult result = _salestoolsConsole.doDelete(logicContext, unit);
      if (!result.equals(EResult.Success)) {
         throw new FFatalError("Delete failure.");
      } else {
         return "/manage/product/business/SalestoolsList";
      }
   }

   // ============================================================
   // <T>抽取数据库字段赋值的公共方法</T>
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   public void setLogicNews(IWebContext context, ILogicContext logicContext, FDataLogicSalestoolsUnit unit, String flag) {
      unit.setCreateUserId(context.parameterAsLong("adminId"));
      unit.setContent(context.parameter("content"));
      unit.setDescription(context.parameter("description"));
      unit.setKeywords(context.parameter("keywords"));
      unit.setDisplayOrder(context.parameterAsInteger("displayOrder"));
      String scd = context.parameter("displayCdStr");
      if (!RString.isEmpty(scd) && scd.length() < 2) {
         unit.setDisplayCd(context.parameterAsInteger("displayCdStr"));
      } else if (!RString.isEmpty(scd) && scd.length() > 1) {
         if (RString.equals(EGcDisplay.DisableLabel, scd)) {
            unit.setDisplayCd(EGcDisplay.Disable);
         }
         if (RString.equals(EGcDisplay.EnabledLabel, scd)) {
            unit.setDisplayCd(EGcDisplay.Enabled);
         }
      }
      unit.setStatusCd(EGcResourceStatus.Apply);
      String lcs = context.parameter("linkCdStr");
      if (!RString.isEmpty(lcs) && lcs.length() < 2) {
         unit.setLinkCd(context.parameterAsInteger("linkCdStr"));
      } else if (!RString.isEmpty(lcs) && lcs.length() > 1) {
         if (RString.equals(EGcLink.UnknownLabel, lcs)) {
            unit.setLinkCd(EGcLink.Unknown);
         }
         if (RString.equals(EGcLink.ContentLabel, lcs)) {
            unit.setLinkCd(EGcLink.Content);
         }
         if (RString.equals(EGcLink.LinkLabel, lcs)) {
            unit.setLinkCd(EGcLink.Link);
         }
      }
      unit.setLabel(context.parameter("label"));
      unit.setLinkUrl(context.parameter("linkUrl"));
      FWebUploadFile file = context.files().first();
      if (null == file) {
         String oiconUr = context.parameter("oiconUr");
         if (!RString.isEmpty(oiconUr)) {
            unit.setIconUrl(oiconUr);
         } else {
            unit.setIconUrl(context.parameter("iconUrl"));
         }
      } else {
         _salestoolsConsole.saveImage(file, unit, flag);
      }
   }
}
