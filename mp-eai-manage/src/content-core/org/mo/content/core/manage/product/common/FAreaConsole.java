package org.mo.content.core.manage.product.common;

import com.cyou.gccloud.data.data.FDataCommonAreaLogic;
import com.cyou.gccloud.data.data.FDataCommonAreaUnit;
import com.cyou.gccloud.data.data.FDataCommonCountryUnit;
import java.util.Iterator;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RString;
import org.mo.core.aop.face.ALink;
//============================================================
//<P>区域信息操作接口</P>
//
//@class FAreaConsole
//@author Sunhr
//@Date 2015.09.13  
//@version 1.0.0
//============================================================
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>区域信息控制台</P>
//@class FAreaConsole
//@author AnjoyTian
//@Date 2015.09.21 
//@version 1.0.0
//============================================================

public class FAreaConsole
      extends FAbstractLogicUnitConsole<FDataCommonAreaLogic, FDataCommonAreaUnit>
      implements
         IAreaConsole
         
{
    //国家控制台
    @ALink
    protected ICountryConsole _countryConsole;

   //============================================================
   // <T>构造区域控制台。</T>
   //============================================================
   public FAreaConsole(){
      super(FDataCommonAreaLogic.class, FDataCommonAreaUnit.class);
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
   public FLogicDataset<FDataAreaInfo> select(ILogicContext logicContext,
                                              FDataCommonAreaUnit unit,
                                              int pageNum,
                                              int pageSize){
      if(pageNum < 0){
         pageNum = 0;
      }
      FSql where = new FSql();
      if(!RString.isEmpty(unit.label())){
         where.append(FDataCommonAreaLogic.LABEL);
         where.append(" LIKE '%");
         where.append(unit.label() + "%'");
      }
      //      String orderBy = String.format("%s %s", FDataCommonAreaLogic.LABEL, "ASC");
      FDataCommonAreaLogic logic = logicContext.findLogic(FDataCommonAreaLogic.class);
      FLogicDataset<FDataAreaInfo> userInfoList = logic.fetchClass(FDataAreaInfo.class, null, where.toString(), null, pageSize, pageNum);
      for(Iterator<FDataAreaInfo> iterator = userInfoList.iterator(); iterator.hasNext();){
          FDataAreaInfo tempUnit = iterator.next();
          //         String _areaLabel = "";
          FDataCommonCountryUnit unit2 = _countryConsole.find(logicContext, tempUnit.countryId());
          if(unit2 != null){
             String _countryLabel = unit2.name();
             tempUnit.setCountryLabel(_countryLabel);
          }
       }
      return userInfoList;
   }

   // ============================================================
   // <T>根据标签获取对象</T>
   // @param logicContext 链接对象
   // @param label 标签
   // @return 数据对象
   // ============================================================
   @Override
   public FDataCommonAreaUnit findByLable(ILogicContext logicContext,
                                          String label){
      FSql whereSql = new FSql();
      if(!RString.isEmpty(label)){
         whereSql.append(FDataCommonAreaLogic.LABEL);
         whereSql.append(" like '%");
         whereSql.append("{label}");
         whereSql.bind("label", label);
         whereSql.append("%'");
      }
      FDataCommonAreaLogic logic = logicContext.findLogic(FDataCommonAreaLogic.class);
      FLogicDataset<FDataCommonAreaUnit> roleList = logic.fetch(whereSql.toString());
      return roleList.first();
   }
}