package org.mo.content.core.product.financial.news;

import java.util.Map;

import com.cyou.gccloud.data.data.FDataLogicNewsUnit;

public class FDataNewsInfo 
      extends FDataLogicNewsUnit {
   //状态字符串
   private String _statusCdStr;
   //显示字符串
   private String _displayCdStr;
   
   private String _imageName;

   public String getStatusCdStr() {
      return _statusCdStr;
   }
   public void setStatusCdStr(String _statusCdStr) {
      this._statusCdStr=_statusCdStr;
   }
   public String getImageName() {
      return _imageName;
   }
   public void setImageName(String _imageName) {
      this._imageName=_imageName;
   }
   public String getDisplayCdStr() {
      return _displayCdStr;
   }
   public void setDisplayCdStr(String _displayCdStr) {
      this._displayCdStr = _displayCdStr;
   }
   
   //============================================================
   // <T>保存对照表。</T>
   // @param map 对照表
   //============================================================
   @Override
   public void saveMap(Map<String, String> map){
      super.saveMap(map);
      map.put("statusCdStr", _statusCdStr);
      map.put("displayCdStr", _displayCdStr);
      map.put("imageName", _imageName);
   }
}