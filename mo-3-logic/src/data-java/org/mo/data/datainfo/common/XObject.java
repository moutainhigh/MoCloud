package org.mo.data.datainfo.common;

import org.mo.com.xml.IXmlObject;

//============================================================
// <T>对象的XML节点基类。</T>
//============================================================
public interface XObject
      extends
         IXmlObject
{
   // 名称定义
   String NAME = "IObject";

   // 的名称定义
   String PTY_NAME = "name";

   // 的名称定义
   String PTY_LABEL = "label";

   // 的名称定义
   String PTY_NOTE = "note";

   // 的名称定义
   String PTY_DATA_NAME = "data_name";

   //============================================================
   // <T>获得的内容。</T>
   //
   // @return 
   //============================================================
   String getName();

   //============================================================
   // <T>设置的内容。</T>
   //
   // @param value 
   //============================================================
   void setName(String value);

   //============================================================
   // <T>获得的内容。</T>
   //
   // @return 
   //============================================================
   String getLabel();

   //============================================================
   // <T>设置的内容。</T>
   //
   // @param value 
   //============================================================
   void setLabel(String value);

   //============================================================
   // <T>获得的内容。</T>
   //
   // @return 
   //============================================================
   public String getNote();

   //============================================================
   // <T>设置的内容。</T>
   //
   // @param value 
   //============================================================
   void setNote(String value);

   //============================================================
   // <T>获得的内容。</T>
   //
   // @return 
   //============================================================
   String getDataName();

   //============================================================
   // <T>设置的内容。</T>
   //
   // @param value 
   //============================================================
   void setDataName(String value);
}
