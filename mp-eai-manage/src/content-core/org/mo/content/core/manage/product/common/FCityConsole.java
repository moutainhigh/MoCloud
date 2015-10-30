package org.mo.content.core.manage.product.common;

import com.cyou.gccloud.data.data.FDataCommonAreaUnit;
import com.cyou.gccloud.data.data.FDataCommonCityLogic;
import com.cyou.gccloud.data.data.FDataCommonCityUnit;
import com.cyou.gccloud.data.data.FDataCommonCountryUnit;
import com.cyou.gccloud.data.data.FDataCommonProvinceUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RString;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>城市信息控制台</P>
//@class FCityConsole
//@version 1.0.0
//============================================================

public class FCityConsole 
      extends 
         FAbstractLogicUnitConsole<FDataCommonCityLogic, FDataCommonCityUnit>
      implements 
         ICityConsole 
{
   // 国家控制台
   @ALink
   protected ICountryConsole _countryConsole;

   // 省会控制台
   @ALink
   protected IProvinceConsole _provinceConsole;

   // 区域控制台
   @ALink
   protected IAreaConsole _areaConsole;

   // ============================================================
   // <T>构造城市控制台。</T>
   // ============================================================
   public FCityConsole() {
      super(FDataCommonCityLogic.class, FDataCommonCityUnit.class);
   }

   // ============================================================
   // <T>根据区号获取对象</T>
   // @param logicContext 链接对象
   // @param code 区号
   // @return 数据对象
   // ============================================================
   @Override
   public FDataCommonCityUnit findByCitycode(ILogicContext context, 
                                             String code) {
      FSql where = new FSql();
      if (code != null) {
         where.append(FDataCommonCityLogic.CITY_CODE);
         where.append(" = ");
         where.append(" {code}");
         where.bind("code", RString.parse(code));
      }
      FDataCommonCityLogic logic = context.findLogic(FDataCommonCityLogic.class);
      FDataCommonCityUnit city = logic.search(where);
      return city;
   }

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   // @param logicContext 链接对象
   // @param unit 查询条件
   // @param pageNum 页码
   // @param pageSize 每页显示的行数
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataCityInfo> select(ILogicContext logicContext, 
                                              FDataCommonCityUnit unit, 
                                              int pageNum, 
                                              int pageSize) {
      if (pageNum < 0) {
         pageNum = 0;
      }
      FSql where = new FSql();
      if (!RString.isEmpty(unit.label())) {
         where.append(FDataCommonCityLogic.LABEL);
         where.append(" like ");
         where.append(" '%{label}%'");
         where.bind("label", unit.label());
      }
      String orderBy = String.format("%s %s", FDataCommonCityLogic.DISPLAY_ORDER, "DESC");
      FDataCommonCityLogic logic = logicContext.findLogic(FDataCommonCityLogic.class);
      FLogicDataset<FDataCityInfo> userInfoList = logic.fetchClass(FDataCityInfo.class, null, where.toString(), orderBy, pageSize, pageNum);
      for (FDataCityInfo  tempUnit : userInfoList) {
         FDataCommonCountryUnit unit2 = _countryConsole.find(logicContext, tempUnit.countryId());
         if (unit2 != null) {
            String _countryLabel = unit2.name();
            tempUnit.setCountryLabel(_countryLabel);
         }
         FDataCommonAreaUnit unit3 = _areaConsole.find(logicContext, tempUnit.areaId());
         if (unit3 != null) {
            String _areaLabel = unit3.label();
            tempUnit.setAreaLabel(_areaLabel);
         }
         FDataCommonProvinceUnit unit4 = _provinceConsole.find(logicContext, tempUnit.provinceId());
         if (unit4 != null) {
            String _provinceLabel = unit4.label();
            tempUnit.setProvinceLabel(_provinceLabel);
         }
      }
      return userInfoList;
   }

   // ============================================================
   // <T>根据label,countryId,areaId,provinceId,判断数据存在重复</T>
   // @param logicContext 链接对象
   // @param label 市区标签
   // @param countryId 国家id
   // @param areaId 区域id
   // @param provinceId 身份id
   // @return 数据集合
   // ============================================================
   @Override
   public boolean isExsitsByLabelandId(ILogicContext logicContext, 
                                       String label, 
                                       Long countryId, 
                                       Long areaId, 
                                       Long provinceId) {
      FSql whereSql = new FSql();
      if (!RString.isEmpty(label) && !RString.isEmpty(areaId + "") && !RString.isEmpty(countryId + "") && !RString.isEmpty(provinceId + "")) {
         whereSql.append(FDataCommonCityLogic.LABEL);
         whereSql.append(" = ");
         whereSql.append(" '{label}' ");
         whereSql.bind("label", label);
         whereSql.append(" and ");
         whereSql.append(FDataCommonCityLogic.COUNTRY_ID);
         whereSql.append(" = ");
         whereSql.append(" {countryId}");
         whereSql.bind("countryId", RString.parse(countryId));
         whereSql.append(" and ");
         whereSql.append(FDataCommonCityLogic.AREA_ID);
         whereSql.append(" = ");
         whereSql.append(" {areaId}");
         whereSql.bind("areaId", RString.parse(areaId));
         whereSql.append(" and ");
         whereSql.append(FDataCommonCityLogic.PROVINCE_ID);
         whereSql.append(" = ");
         whereSql.append(" {provinceId}");
         whereSql.bind("provinceId", RString.parse(provinceId));
         FDataCommonCityLogic logic = logicContext.findLogic(FDataCommonCityLogic.class);
         FLogicDataset<FDataCommonCityUnit> areaList = logic.fetch(whereSql.toString());
         if (areaList.count() > 0) {
            return true;
         }
      }
      return false;
   }
   
   // ============================================================
   // <T>根据label,countryId,areaId,provinceId,ouid判断数据存在重复</T>
   // @param logicContext 链接对象
   // @param label 市区标签
   // @param countryId 国家id
   // @param areaId 区域id
   // @param provinceId 身份id
   // @param ouid
   // @return 数据集合
   // ============================================================
   @Override
   public boolean isExsitsByLabelandIdandOuid(ILogicContext logicContext, 
                                              String label, 
                                              Long countryId, 
                                              Long areaId, 
                                              Long provinceId,
                                              Long ouid) {
      FSql whereSql = new FSql();
      if (!RString.isEmpty(label) && !RString.isEmpty(areaId + "") && !RString.isEmpty(countryId + "") && !RString.isEmpty(provinceId + "")) {
         whereSql.append(FDataCommonCityLogic.LABEL);
         whereSql.append(" = ");
         whereSql.append(" '{label}' ");
         whereSql.bind("label", label);
         whereSql.append(" and ");
         whereSql.append(FDataCommonCityLogic.COUNTRY_ID);
         whereSql.append(" = ");
         whereSql.append(" {countryId}");
         whereSql.bind("countryId", RString.parse(countryId));
         whereSql.append(" and ");
         whereSql.append(FDataCommonCityLogic.AREA_ID);
         whereSql.append(" = ");
         whereSql.append(" {areaId}");
         whereSql.bind("areaId", RString.parse(areaId));
         whereSql.append(" and ");
         whereSql.append(FDataCommonCityLogic.PROVINCE_ID);
         whereSql.append(" = ");
         whereSql.append(" {provinceId}");
         whereSql.bind("provinceId", RString.parse(provinceId));
         FDataCommonCityLogic logic = logicContext.findLogic(FDataCommonCityLogic.class);
         FLogicDataset<FDataCommonCityUnit> areaList = logic.fetch(whereSql.toString());
         for(FDataCommonCityUnit unit : areaList){
            if(!RString.equals(ouid, unit.ouid())){
               return true;
            }
         }
      }
      return false;
   }
   
   // ============================================================
   // <T>根据省份id获取对象列表</T>
   // @param logicContext 链接对象
   // @param provinceId 身份id
   // @return 数据对象
   // ============================================================
   @Override
   public FLogicDataset<FDataCommonCityUnit> selectAll(ILogicContext logicContext, 
                                                       Long provinceId) {
      FSql whereSql = new FSql();
      if (!RString.isEmpty(provinceId + "") && provinceId > 0) {
         whereSql.append(FDataCommonCityLogic.PROVINCE_ID);
         whereSql.append(" = ");
         whereSql.append(" {provinceId}");
         whereSql.bind("provinceId", RString.parse(provinceId));
         FDataCommonCityLogic logic = logicContext.findLogic(FDataCommonCityLogic.class);
         return logic.fetch(whereSql.toString());
      }
      FDataCommonCityLogic logic = logicContext.findLogic(FDataCommonCityLogic.class);
      return logic.fetchAll();
   }
   // ============================================================
   // <T>根据省份id获取对象列表</T>
   // @param logicContext 链接对象
   // @param provinceId 身份id
   // @return 数据对象
   // ============================================================
   @Override
   public FLogicDataset<FDataCommonCityUnit> selectAllByProvinceId(ILogicContext logicContext, 
                                                                   Long provinceId) {
      FSql whereSql = new FSql();
      if (!RString.isEmpty(provinceId + "") && provinceId > 0) {
         whereSql.append(FDataCommonCityLogic.PROVINCE_ID);
         whereSql.append(" = ");
         whereSql.append(" {provinceId}");
         whereSql.bind("provinceId", RString.parse(provinceId));
         FDataCommonCityLogic logic = logicContext.findLogic(FDataCommonCityLogic.class);
         return logic.fetch(whereSql.toString());
      }
      return null;
   }
   // ============================================================
   // <T>根据区域id获取对象列表</T>
   // @param logicContext 链接对象
   // @param areaId 区域id
   // @return 数据对象
   // ============================================================
   @Override
   public FLogicDataset<FDataCommonCityUnit> selectAllByAreaId(ILogicContext logicContext, 
                                                               Long areaId) {
      FSql whereSql = new FSql();
      if (!RString.isEmpty(areaId + "") && areaId > 0) {
         whereSql.append(FDataCommonCityLogic.AREA_ID);
         whereSql.append(" = ");
         whereSql.append(" {areaId}");
         whereSql.bind("areaId", RString.parse(areaId));
         FDataCommonCityLogic logic = logicContext.findLogic(FDataCommonCityLogic.class);
         return logic.fetch(whereSql.toString());
      }
      return null;
   }
}
