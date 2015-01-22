package org.mo.mime.zip;

import java.util.zip.ZipEntry;
import org.mo.com.lang.FObject;

//============================================================
// <T>ZIP节点。</T>
//============================================================
public class FZipEntry
      extends FObject
{
   // 节点
   protected ZipEntry _entry;

   //============================================================
   // <T>构造ZIP节点。</T>
   //
   // @param name 名称
   //============================================================
   protected FZipEntry(String name){
      _entry = new ZipEntry(name);
   }

   //============================================================
   // <T>构造ZIP节点。</T>
   //
   // @param entry 节点
   //============================================================
   protected FZipEntry(ZipEntry entry){
      _entry = entry;
   }

   //============================================================
   // <T>获得是否目录。</T>
   //
   // @return 是否目录
   //============================================================
   public boolean isDirectory(){
      return _entry.isDirectory();
   }

   //============================================================
   // <T>获得名称。</T>
   //
   // @return 名称
   //============================================================
   public String name(){
      return _entry.getName();
   }

   //============================================================
   // <T>获得大小。</T>
   //
   // @return 大小
   //============================================================
   public long size(){
      return _entry.getSize();
   }

   //============================================================
   // <T>设置大小。</T>
   //
   // @param size 大小
   //============================================================
   public void setSize(long size){
      _entry.setSize(size);
   }

   //============================================================
   // <T>获得压缩大小。</T>
   //
   // @return 压缩大小
   //============================================================
   public long compressedSize(){
      return _entry.getCompressedSize();
   }

   //============================================================
   // <T>设置压缩大小。</T>
   //
   // @param compressedSize 压缩大小
   //============================================================
   public void setCompressedSize(long compressedSize){
      _entry.setCompressedSize(compressedSize);
   }

   //============================================================
   // <T>获得CRC校验码。</T>
   //
   // @return CRC校验码
   //============================================================
   public long crc(){
      return _entry.getCrc();
   }

   //============================================================
   // <T>设置CRC校验码。</T>
   //
   // @param crc CRC校验码
   //============================================================
   public void setCrc(long crc){
      _entry.setCrc(crc);
   }

   //============================================================
   // <T>获得函数。</T>
   //
   // @return 函数
   //============================================================
   public int method(){
      return _entry.getMethod();
   }

   //============================================================
   // <T>设置函数。</T>
   //
   // @param method 函数
   //============================================================
   public void setMethod(int method){
      _entry.setMethod(method);
   }

   //============================================================
   // <T>获得附带数据。</T>
   //
   // @return 附带数据
   //============================================================
   public byte[] extra(){
      return _entry.getExtra();
   }

   //============================================================
   // <T>设置附带数据。</T>
   //
   // @param extra 附带数据
   //============================================================
   public void setExtra(byte[] extra){
      _entry.setExtra(extra);
   }

   //============================================================
   // <T>获得备注。</T>
   //
   // @return 备注
   //============================================================
   public String comment(){
      return _entry.getComment();
   }

   //============================================================
   // <T>设置备注。</T>
   //
   // @param comment 备注
   //============================================================
   public void setComment(String comment){
      _entry.setComment(comment);
   }

   //============================================================
   // <T>获得时间。</T>
   //
   // @return 时间
   //============================================================
   public long time(){
      return _entry.getTime();
   }

   //============================================================
   // <T>设置时间。</T>
   //
   // @param time 时间
   //============================================================
   public void setTime(long time){
      _entry.setTime(time);
   }
}
