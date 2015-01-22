package org.mo.data.logic.cache;

import org.mo.eng.memorycache.FMemoryChannel;

//============================================================
// <T>逻辑单元缓冲控制台接口。</T>
//============================================================
public interface ILogicCacheConsole
{
   //============================================================
   // <T>获得当前代码。</T>
   //
   // @param channel 内存缓冲频道
   // @return 代码
   //============================================================
   String currentCode(FMemoryChannel channel);

   //============================================================
   // <T>刷新处理。</T>
   //
   // @param channel 内存缓冲频道
   //============================================================
   void flush(FMemoryChannel channel);

   //============================================================
   // <T>同步获得缓冲表格。</T>
   //
   // @return 缓冲表格
   //============================================================
   FLogicCacheTable syncTable(String name);

   //============================================================
   // <T>收集逻辑单元缓冲频道。</T>
   //
   // @return 内存频道
   //============================================================
   FLogicCacheChannel alloc();

   //============================================================
   // <T>释放逻辑单元缓冲频道。</T>
   //
   // @param channel 内存频道
   //============================================================
   void free(FLogicCacheChannel channel);
}
