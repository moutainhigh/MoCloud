package org.mo.cloud.content.design.frame.base;

import org.mo.cloud.content.design.configuration.FContentField;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.com.lang.face.AName;

//============================================================
// <T>页面对象的内容基类。</T>
//
// @author autosource
//============================================================
public abstract class XBaseFrame
      extends XContentObject
{
   // 组件名称
   public static final String NAME = "Frame";

   // 类名称的定义
   public final static FContentField FieldClassName = new FContentField("class_name");

   // 名称的定义
   public final static FContentField FieldName = new FContentField("name");

   // 有效性的定义
   public final static FContentField FieldValid = new FContentField("valid");

   // 标签的定义
   public final static FContentField FieldLabel = new FContentField("label");

   // 位置的定义
   public final static FContentField FieldLocation = new FContentField("location");

   // 尺寸的定义
   public final static FContentField FieldSize = new FContentField("size");

   // 内空白的定义
   public final static FContentField FieldPadding = new FContentField("padding");

   // 外空白的定义
   public final static FContentField FieldMargin = new FContentField("margin");

   // 页面来源的定义
   public final static FContentField FieldFrameSource = new FContentField("frame_source");

   //============================================================
   // <T>判断是否指定实例。</T>
   //
   // @param name 名称
   //============================================================
   public static boolean isInstance(String name){
      return NAME.equals(name);
   }

   //============================================================
   // <T>判断是否指定实例。</T>
   //
   // @param xinstance 实例
   //============================================================
   public static boolean isInstance(XContentObject xinstance){
      return NAME.equals(xinstance.contentClass().name());
   }

   // 类名称
   @AName("class_name")
   protected String _className;

   // 名称
   @AName("name")
   protected String _name;

   // 有效性
   @AName("valid")
   protected boolean _valid;

   // 标签
   @AName("label")
   protected String _label;

   // 位置
   @AName("location")
   protected String _location;

   // 尺寸
   @AName("size")
   protected String _size;

   // 内空白
   @AName("padding")
   protected String _padding;

   // 外空白
   @AName("margin")
   protected String _margin;

   // 页面来源
   @AName("frame_source")
   protected String _frameSource;

   //============================================================
   // <T>获得类名称的内容。</T>
   //
   // @return 类名称
   //============================================================
   public String getClassName(){
      return _className;
   }

   //============================================================
   // <T>设置类名称的内容。</T>
   //
   // @param value 类名称
   //============================================================
   public void setClassName(String value){
      _className = value;
   }

   //============================================================
   // <T>获得名称的内容。</T>
   //
   // @return 名称
   //============================================================
   public String getName(){
      return _name;
   }

   //============================================================
   // <T>设置名称的内容。</T>
   //
   // @param value 名称
   //============================================================
   public void setName(String value){
      _name = value;
   }

   //============================================================
   // <T>获得有效性的内容。</T>
   //
   // @return 有效性
   //============================================================
   public Boolean getValid(){
      return _valid;
   }

   //============================================================
   // <T>设置有效性的内容。</T>
   //
   // @param value 有效性
   //============================================================
   public void setValid(Boolean value){
      _valid = value;
   }

   //============================================================
   // <T>获得标签的内容。</T>
   //
   // @return 标签
   //============================================================
   public String getLabel(){
      return _label;
   }

   //============================================================
   // <T>设置标签的内容。</T>
   //
   // @param value 标签
   //============================================================
   public void setLabel(String value){
      _label = value;
   }

   //============================================================
   // <T>获得位置的内容。</T>
   //
   // @return 位置
   //============================================================
   public String getLocation(){
      return _location;
   }

   //============================================================
   // <T>设置位置的内容。</T>
   //
   // @param value 位置
   //============================================================
   public void setLocation(String value){
      _location = value;
   }

   //============================================================
   // <T>获得尺寸的内容。</T>
   //
   // @return 尺寸
   //============================================================
   public String getSize(){
      return _size;
   }

   //============================================================
   // <T>设置尺寸的内容。</T>
   //
   // @param value 尺寸
   //============================================================
   public void setSize(String value){
      _size = value;
   }

   //============================================================
   // <T>获得内空白的内容。</T>
   //
   // @return 内空白
   //============================================================
   public String getPadding(){
      return _padding;
   }

   //============================================================
   // <T>设置内空白的内容。</T>
   //
   // @param value 内空白
   //============================================================
   public void setPadding(String value){
      _padding = value;
   }

   //============================================================
   // <T>获得外空白的内容。</T>
   //
   // @return 外空白
   //============================================================
   public String getMargin(){
      return _margin;
   }

   //============================================================
   // <T>设置外空白的内容。</T>
   //
   // @param value 外空白
   //============================================================
   public void setMargin(String value){
      _margin = value;
   }

   //============================================================
   // <T>获得页面来源的内容。</T>
   //
   // @return 页面来源
   //============================================================
   public String getFrameSource(){
      return _frameSource;
   }

   //============================================================
   // <T>设置页面来源的内容。</T>
   //
   // @param value 页面来源
   //============================================================
   public void setFrameSource(String value){
      _frameSource = value;
   }

}
