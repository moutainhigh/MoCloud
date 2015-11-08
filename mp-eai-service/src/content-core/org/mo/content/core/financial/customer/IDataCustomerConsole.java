package org.mo.content.core.financial.customer;

import com.cyou.gccloud.data.data.FDataFinancialCustomerUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>客户投资控制台接口。</T>
//============================================================
public interface IDataCustomerConsole
      extends
         IAbstractLogicUnitConsole<FDataFinancialCustomerUnit>
{
   // ============================================================
   // <T>获取理财师客户对产品的投资额</T>
   //
   // @param logicContext 链接对象
   // @param marketerId 日期
   // @return 数据对象
   // ============================================================
   FLogicDataset<FDataCustomerProductInfo> fetchProductInvestmentByMarketerId(ILogicContext logicContext,
                                                                              long marketerId);

   // ============================================================
   // <T>获取理财师的客户</T>
   //
   // @param logicContext 链接对象
   // @param marketerId 日期
   // @return 数据对象
   // ============================================================
   FLogicDataset<FDataCustomerInfo> fetchByMarketerId(ILogicContext logicContext,
                                                      long marketerId);

}