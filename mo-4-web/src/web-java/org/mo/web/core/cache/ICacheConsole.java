package org.mo.web.core.cache;

import org.mo.com.lang.FString;

//============================================================
// <T>缓冲控制台接口。</T>
//============================================================
public interface ICacheConsole
{
   //============================================================
   // <T>根据网页地址获得缓冲字符串。</T>
   //
   // @param uri 网页地址
   // @return 缓冲字符串
   //============================================================
   FString find(String uri);
}
