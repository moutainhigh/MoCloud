package org.mo.eai.template.department;

import org.mo.com.io.FLinesFile;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RString;
import org.mo.eai.RResourceConfiguration;

//============================================================
// <T>部门模板。</T>
//============================================================
public class FDepartmentTemplate
{
   // 部门资源集合
   protected FObjects<FDepartmentResource> _departments = new FObjects<FDepartmentResource>(FDepartmentResource.class);

   //============================================================
   // <T>获得部门集合。</T>
   //
   // @return 部门集合
   //============================================================
   public FObjects<FDepartmentResource> departments(){
      return _departments;
   }

   //============================================================
   // <T>解析处理。</T>
   //============================================================
   public void parser(){
      String fielName = RResourceConfiguration.HomeData + "/department.csv";
      // 打开文件
      FLinesFile file = new FLinesFile();
      file.loadFile(fielName, "GB2312");
      // 读取所有行
      int count = file.count();
      for(int n = 1; n < count; n++){
         String line = file.line(n);
         if(!RString.isEmpty(line)){
            String[] items = RString.split(line.trim(), ',');
            if(items.length != 3){
               throw new FFatalError("Line is invalid.");
            }
            FDepartmentResource department = new FDepartmentResource();
            department.setCode(RString.trim(items[0]));
            department.setLabel(RString.trim(items[1]));
            department.setFullLabel(RString.trim(items[2]));
            _departments.push(department);
            //System.out.println(items[0] + " - " + items[1] + " - " + items[2] + " - " + items[3] + " - " + items[4] + " - " + items[5] + " - " + items[6]);
         }
      }
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      output.writeInt32(_departments.count());
      for(FDepartmentResource department : _departments){
         department.serialize(output);
      }
   }
}