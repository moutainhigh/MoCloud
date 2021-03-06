package org.mo.com.lang;

import org.mo.com.lang.generic.MInts;

//============================================================
// <T>整数集合。</T>
//============================================================
public class FInts
      extends MInts
{
   //============================================================
   // <T>构造整数集合。</T>
   //============================================================
   public FInts(){
   }

   //============================================================
   // <T>构造整数集合。</T>
   //
   // @param capacity 容量
   //============================================================
   public FInts(int capacity){
      super(capacity);
   }

   //============================================================
   // <T>构造整数类型集合。</T>
   //
   // @param data 数据集合
   //============================================================
   public FInts(int[] data){
      append(data);
   }
}
