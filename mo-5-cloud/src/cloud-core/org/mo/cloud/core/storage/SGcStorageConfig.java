package org.mo.cloud.core.storage;

import org.mo.core.aop.face.AProperty;

//============================================================
//<T>存储信息。</T>
//============================================================
public class SGcStorageConfig
{
   // 类型
   @AProperty
   protected String _type;

   // 代码
   @AProperty
   protected String _code;

   // 主机
   @AProperty
   protected String _host;

   // 路径
   @AProperty
   protected String _path;

   //============================================================
   // <T>获得类型。</T>
   //
   // @return 类型
   //============================================================
   public String type(){
      return _type;
   }

   //============================================================
   // <T>设置类型。</T>
   //
   // @param type 类型
   //============================================================
   public void setType(String type){
      _type = type;
   }

   //============================================================
   // <T>获得代码。</T>
   //
   // @return 代码
   //============================================================
   public String code(){
      return _code;
   }

   //============================================================
   // <T>设置代码。</T>
   //
   // @param code 代码
   //============================================================
   public void setCode(String code){
      _code = code;
   }

   //============================================================
   // <T>获得主机。</T>
   //
   // @return 主机
   //============================================================
   public String host(){
      return _host;
   }

   //============================================================
   // <T>设置主机。</T>
   //
   // @param host 主机
   //============================================================
   public void setHost(String host){
      _host = host;
   }

   //============================================================
   // <T>获得路径。</T>
   //
   // @return 路径
   //============================================================
   public String path(){
      return _path;
   }

   //============================================================
   // <T>设置路径。</T>
   //
   // @param source 路径
   //============================================================
   public void setPath(String path){
      _path = path;
   }
}
