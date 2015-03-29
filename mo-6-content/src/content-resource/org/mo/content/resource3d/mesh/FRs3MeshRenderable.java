package org.mo.content.resource3d.mesh;

import org.mo.com.io.IDataOutput;
import org.mo.com.xml.FXmlNode;
import org.mo.content.resource3d.common.FRs3Object;
import org.mo.content.resource3d.common.SFloatMatrix3d;

//============================================================
// <T>场景渲染。</T>
//============================================================
public class FRs3MeshRenderable
      extends FRs3Object
{
   // 矩阵
   protected SFloatMatrix3d _matrix = new SFloatMatrix3d();

   //============================================================
   // <T>构造场景渲染。</T>
   //============================================================
   public FRs3MeshRenderable(){
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      _matrix.serialize(output);
   }

   //============================================================
   // <T>从配置节点中加载数据信息。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      super.loadConfig(xconfig);
      // 处理所有节点
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("Matrix")){
            _matrix.loadConfig(xnode);
         }
      }
   }

   //============================================================
   // <T>存储数据信息到配置节点中。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void saveConfig(FXmlNode xconfig){
      super.saveConfig(xconfig);
      // 存储属性
      _matrix.saveConfig(xconfig.createNode("Matrix"));
   }

   //============================================================
   // <T>从配置节点中合并数据信息。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void mergeConfig(FXmlNode xconfig){
      super.mergeConfig(xconfig);
      // 处理所有节点
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("Matrix")){
            _matrix.loadConfig(xnode);
         }
      }
   }
}