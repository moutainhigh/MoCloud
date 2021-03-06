package org.mo.web.core.webform.control;

//============================================================
// <T>列组件接口对象的XML节点基类。</T>
//============================================================
public interface XIColumnFace
      extends
         XControlFace,
         XEditDescriptorFace,
         XEditValueFace,
         XZoomFace
{
   // 名称定义
   String NAME = "IColumn";

   // 类型图片集的名称定义
   String PTY_VIEW_ICONS = "view_icons";

   // 显示固定的名称定义
   String PTY_DISP_FIXED = "disp_fixed";

   // 搜索方式的名称定义
   String PTY_SEARCH_TYPE = "search_type";

   // 数据类型的名称定义
   String PTY_DATA_TYPE = "data_type";

   // 字体颜色的名称定义
   String PTY_EDIT_COLOR = "edit_color";

   // 背景颜色的名称定义
   String PTY_EDIT_BGCOLOR = "edit_bgcolor";

   // 搜索字段的名称定义
   String PTY_DATA_SEARCH = "data_search";

   // 排序可的名称定义
   String PTY_ORDER_ABLE = "order_able";

   //============================================================
   // <T>获得类型图片集的内容。</T>
   //
   // @return 类型图片集
   //============================================================
   String getViewIcons();

   //============================================================
   // <T>设置类型图片集的内容。</T>
   //
   // @param value 类型图片集
   //============================================================
   void setViewIcons(String value);

   //============================================================
   // <T>获得显示固定的内容。</T>
   //
   // @return 显示固定
   //============================================================
   Boolean getDispFixed();

   //============================================================
   // <T>设置显示固定的内容。</T>
   //
   // @param value 显示固定
   //============================================================
   void setDispFixed(Boolean value);

   //============================================================
   // <T>获得搜索方式的内容。</T>
   //
   // @return 搜索方式
   //============================================================
   String getSearchType();

   //============================================================
   // <T>设置搜索方式的内容。</T>
   //
   // @param value 搜索方式
   //============================================================
   void setSearchType(String value);

   //============================================================
   // <T>获得数据类型的内容。</T>
   //
   // @return 数据类型
   //============================================================
   String getDataType();

   //============================================================
   // <T>设置数据类型的内容。</T>
   //
   // @param value 数据类型
   //============================================================
   void setDataType(String value);

   //============================================================
   // <T>获得字体颜色的内容。</T>
   //
   // @return 字体颜色
   //============================================================
   String getEditColor();

   //============================================================
   // <T>设置字体颜色的内容。</T>
   //
   // @param value 字体颜色
   //============================================================
   void setEditColor(String value);

   //============================================================
   // <T>获得背景颜色的内容。</T>
   //
   // @return 背景颜色
   //============================================================
   String getEditBgcolor();

   //============================================================
   // <T>设置背景颜色的内容。</T>
   //
   // @param value 背景颜色
   //============================================================
   void setEditBgcolor(String value);

   //============================================================
   // <T>获得搜索字段的内容。</T>
   //
   // @return 搜索字段
   //============================================================
   String getDataSearch();

   //============================================================
   // <T>设置搜索字段的内容。</T>
   //
   // @param value 搜索字段
   //============================================================
   void setDataSearch(String value);

   //============================================================
   // <T>获得排序可的内容。</T>
   //
   // @return 排序可
   //============================================================
   String getOrderAble();

   //============================================================
   // <T>设置排序可的内容。</T>
   //
   // @param value 排序可
   //============================================================
   void setOrderAble(String value);
}
