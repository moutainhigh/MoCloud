package org.mo.eng.memorycache;

//============================================================
// <T>内存缓冲控制台接口。</T>
//============================================================
public interface IMemoryCacheConsole
{
   //============================================================
   // <T>测试是否允许。</T>
   //
   // @return 是否允许
   //============================================================
   boolean isEnable();

   //============================================================
   // <T>获得代码。</T>
   //
   // @return 代码
   //============================================================
   String code();

   //============================================================
   // <T>收集一个内存频道。</T>
   //
   // @return 内存频道
   //============================================================
   FMemoryChannel alloc();

   //============================================================
   // <T>释放一个内存频道。</T>
   //
   // @param channel 内存频道
   //============================================================
   void free(FMemoryChannel channel);
}
