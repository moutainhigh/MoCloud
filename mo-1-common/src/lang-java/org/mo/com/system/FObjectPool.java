package org.mo.com.system;

import org.mo.com.lang.FList;
import org.mo.com.lang.FObject;

//============================================================
// <T>对象缓冲池。</T>
//============================================================
public class FObjectPool<T>
      extends FObject
{
   // 收集次数
   protected long _allocTotal;

   // 释放次数
   protected long _freeTotal;

   // 自由对象集合
   protected FList<T> _items = new FList<T>();

   //============================================================
   // <T>构造对象缓冲池。</T>
   //============================================================
   public FObjectPool(){
   }

   //============================================================
   // <T>获得收集次数。</T>
   //
   // @return 收集次数
   //============================================================
   public long allocTotal(){
      return _allocTotal;
   }

   //============================================================
   // <T>获得释放次数。</T>
   //
   // @return 释放次数
   //============================================================
   public long freeTotal(){
      return _freeTotal;
   }

   //============================================================
   // <T>收集一个空闲对象。</T>
   //
   // @param item 对象
   //============================================================
   public synchronized T alloc(){
      T value = null;
      if(!_items.isEmpty()){
         value = _items.pop();
      }
      _allocTotal++;
      return value;
   }

   //============================================================
   // <T>释放一个空闲对象。</T>
   //
   // @param item 对象
   //============================================================
   public synchronized void free(T item){
      if(item != null){
         _items.push(item);
      }
      _freeTotal++;
   }
}
