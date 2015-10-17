package org.mo.content.core.manage.product.common;

import com.cyou.gccloud.data.data.FDataCommonAreaUnit;
import java.util.Map;
import org.mo.core.aop.face.ASourceMachine;
//============================================================
//<P>区域信息</P>
//@class FDataAreaInfo
//@version 1.0.0
//============================================================
@ASourceMachine
public class FDataAreaInfo
      extends 
         FDataCommonAreaUnit
{
   // 存储国家名称
   private String _countryLabel;

   //存储区域名称
   private String _areaLabel;

   //存储省会名称
   private String _provinceLabel;

   public String areaLabel(){
      return _areaLabel;
   }

   public void setAreaLabel(String _areaLabel){
      this._areaLabel = _areaLabel;
   }

   public String provinceLabel(){
      return _provinceLabel;
   }

   public void setProvinceLabel(String _provinceLabel){
      this._provinceLabel = _provinceLabel;
   }

   public String countryLabel(){
      return _countryLabel;
   }

   public void setCountryLabel(String _countryLabel){
      this._countryLabel = _countryLabel;
   }

   //============================================================
   // <T>保存对照表。</T>
   // @param map 对照表
   //============================================================
   @Override
   public void saveMap(Map<String, String> map){
      super.saveMap(map);
      map.put("countryLabel", _countryLabel);
      map.put("areaLabel", _areaLabel);
      map.put("provinceLabel", _provinceLabel);
   }
}
