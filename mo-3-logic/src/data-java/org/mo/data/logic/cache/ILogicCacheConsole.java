package org.mo.data.logic.cache;

import org.mo.eng.memorycache.FMemoryChannel;

//============================================================
// <T>逻辑单元缓冲控制台接口。</T>
//============================================================
public interface ILogicCacheConsole
{
   //============================================================
   // <T>测试是否允许。</T>
   //
   // @return 是否允许
   //============================================================
   boolean isEnable();

   //============================================================
   // <T>收集逻辑单元缓冲频道。</T>
   //
   // @param 内存频道 memoryChannel
   // @return 缓冲频道
   //============================================================
   FLogicCacheChannel alloc(FMemoryChannel memoryChannel);

   //============================================================
   // <T>释放逻辑单元缓冲频道。</T>
   //
   // @param channel 内存频道
   //============================================================
   void free(FLogicCacheChannel channel);
}
