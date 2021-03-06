//============================================================
// <T>会话信息实体定义。</T>
//
// @version 1.0.1
// @auto 代码器管理的代码，如需修改请在手动修改标出的地方修改。
//============================================================
package com.cyou.gccloud.define.entity;

import com.cyou.gccloud.common.INetObject;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>会话信息实体。</T>
//============================================================
public class SGcSession
      implements
         INetObject
{
   // 实体代码
   public final static String CODE = "Session";

   // 代码
   protected String _code;

   //============================================================
   // <T>构造实体的实例对象。</T>
   //
   // @return 实例对象
   //============================================================
   public SGcSession(){
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
   // @param value 代码
   //============================================================
   public void setCode(String value){
      _code = value;
   }

   //============================================================
   // <T>接收对象内容。</T>
   //
   // @param value 对象
   //============================================================
   public void assign(Object value){
      SGcSession object = (SGcSession)value;
      _code = object._code;
   }

   //============================================================
   // <T>序列化到输入流中。</T>
   //
   // @param output 输入流
   //============================================================
   public void saveConfig(FXmlNode xconfig){
      xconfig.set("code", _code);
   }

   //============================================================
   // <T>从输出流中反序列化。</T>
   //
   // @param input 输出流
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      _code = xconfig.get("code", null);
   }

   //============================================================
   // <T>重置内容。</T>
   //============================================================
   public void reset(){
      _code = null;
   }
}
