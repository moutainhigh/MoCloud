package org.mo.content.core.manage.product.examine.business.notice;

import com.cyou.gccloud.data.data.FDataLogicNoticeUnit;

import java.util.Map;
//============================================================
//<T>新闻信息</T>
//============================================================
public class FDataNoticeInfo 
      extends 
         FDataLogicNoticeUnit 
{
   // 状态字符串
   private String _statusCdStr;
   // 外链状态字符串
   private String _linkCdStr;
   // 显示字符串
   private String _displayCdStr;
   
   public String getLinkCdStr() {
      return _linkCdStr;
   }

   public void setLinkCdStr(String _linkCdStr) {
      this._linkCdStr = _linkCdStr;
   }

   public String getStatusCdStr() {
      return _statusCdStr;
   }

   public void setStatusCdStr(String _statusCdStr) {
      this._statusCdStr = _statusCdStr;
   }

   public String getDisplayCdStr() {
      return _displayCdStr;
   }

   public void setDisplayCdStr(String _displayCdStr) {
      this._displayCdStr = _displayCdStr;
   }

   // ============================================================
   // <T>保存对照表。</T>
   // @param map 对照表
   // ============================================================
   @Override
   public void saveMap(Map<String, String> map) {
      super.saveMap(map);
      map.put("statusCdStr", _statusCdStr);
      map.put("linkCdStr", _linkCdStr);
      map.put("displayCdStr", _displayCdStr);
   }
}