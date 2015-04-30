package org.mo.content.resource.common;

import org.mo.com.geom.SFloatVector3;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObject;

//============================================================
// <T>资源动画帧缩放。</T>
//============================================================
public class FResFrameScale
      extends FObject
{
   // 索引
   private int _index;

   // 矩阵
   protected SFloatVector3 _data = new SFloatVector3();

   //============================================================
   // <T>构造资源动画帧缩放。</T>
   //============================================================
   public FResFrameScale(){
   }

   //============================================================
   // <T>获得索引。</T>
   //
   // @return 索引
   //============================================================
   public int index(){
      return _index;
   }

   //============================================================
   // <T>设置索引。</T>
   //
   // @param index 索引
   //============================================================
   public void setIndex(int index){
      _index = index;
   }

   //============================================================
   // <T>获得数据。</T>
   //
   // @return 数据
   //============================================================
   public SFloatVector3 data(){
      return _data;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      output.writeFloat(_data.x);
      output.writeFloat(_data.y);
      output.writeFloat(_data.z);
   }
}
