package org.mo.eai.resource.history;

import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObject;

//============================================================
// <T>历史城市数据。</T>
//============================================================
public class FHistoryProvinceData
      extends FObject
      implements
         Comparable<FHistoryProvinceData>
{
   // 代码
   protected int _code;

   // 日投资额
   protected float _investmentDay;

   // 总投资额
   protected float _investmentTotal;

   //============================================================
   // <T>构造历史城市数据。</T>
   //============================================================
   public FHistoryProvinceData(){
   }

   //============================================================
   // <T>获得代码。</T>
   //
   // @return 代码
   //============================================================
   public int code(){
      return _code;
   }

   //============================================================
   // <T>设置代码。</T>
   //
   // @param code 代码
   //============================================================
   public void setCode(int code){
      _code = code;
   }

   //============================================================
   // <T>获得日投资额。</T>
   //
   // @return 日投资额
   //============================================================
   public float investmentDay(){
      return _investmentDay;
   }

   //============================================================
   // <T>设置日投资额。</T>
   //
   // @param investmentDay 日投资额
   //============================================================
   public void setInvestmentDay(float investmentDay){
      _investmentDay = investmentDay;
   }

   //============================================================
   // <T>获得总投资额。</T>
   //
   // @return 总投资额
   //============================================================
   public float investmentTotal(){
      return _investmentTotal;
   }

   //============================================================
   // <T>设置总投资额。</T>
   //
   // @param investmentTotal 总投资额
   //============================================================
   public void setInvestmentTotal(float investmentTotal){
      _investmentTotal = investmentTotal;
   }

   //============================================================
   // <T>比较对象。</T>
   //
   // @method
   //============================================================
   @Override
   public int compareTo(FHistoryProvinceData item){
      return (int)(item._investmentTotal - _investmentTotal);
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      output.writeUint16(_code);
      output.writeFloat(_investmentDay);
      output.writeFloat(_investmentTotal);
   }
}
