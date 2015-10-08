package org.mo.content.face;

import org.mo.eng.data.common.ISqlContext;

//============================================================
// <P>首页。</P>
//
// @author maocy
// @version 150427
//============================================================
public class FIndexAction
      implements
         IIndexAction
{
   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   //============================================================
   @Override
   public String construct(ISqlContext context,
                           FIndexPage areaPage){
      return "/service/news/News.wa?do=getNewInfo";
   }

   @Override
   public String getNewsInfo(ISqlContext context,
                             FIndexPage areaPage){
      return "/service/news/News.wa?do=getNewInfo";
   }
}
