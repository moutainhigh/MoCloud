package org.mo.cloud.core.storage;

import java.io.File;
import org.mo.com.io.FByteFile;
import org.mo.com.io.RFile;
import org.mo.com.lang.FAttributes;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.RString;
import org.mo.com.lang.RUuid;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;

//============================================================
// <T>存储信息。</T>
//============================================================
public class SGcStorage
{
   // 日志输出接口
   private final static ILogger _logger = RLogger.find(SGcStorage.class);

   // 分类
   protected String _catalog;

   // 类型
   protected String _type;

   // 日期
   protected String _date;

   // 代码
   protected String _code;

   // 名称
   protected String _name;

   // 扩展名
   protected String _extension;

   // 数据
   protected byte[] _data;

   // 大小
   protected int _size;

   // 网络地址
   protected String _uri;

   // 网络地址
   protected String _url;

   // 图片集合
   //protected SGcStorageImages _images = new SGcStorageImages();

   //============================================================
   // <T>构造存储信息。</T>
   //============================================================
   public SGcStorage(){
      _date = RDateTime.format("YYMMDD");
      _code = RUuid.makeUniqueIdLower();
      _name = RUuid.makeUniqueIdLower();
   }

   //============================================================
   // <T>构造存储信息。</T>
   //
   // @param catalog 分类
   // @param file 文件
   //============================================================
   public SGcStorage(String catalog,
                     File file){
      _catalog = catalog;
      _date = RDateTime.format("YYMMDD");
      _code = RUuid.makeUniqueIdLower();
      _name = RUuid.makeUniqueIdLower();
      loadFile(file.getAbsolutePath());
   }

   //============================================================
   // <T>获得分类。</T>
   //
   // @return 分类
   //============================================================
   public String catalog(){
      return _catalog;
   }

   //============================================================
   // <T>设置分类。</T>
   //
   // @param type 分类
   //============================================================
   public void setCatalog(String catalog){
      _catalog = catalog;
   }

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
   // <T>获得日期。</T>
   //
   // @return 日期
   //============================================================
   public String date(){
      return _date;
   }

   //============================================================
   // <T>设置日期。</T>
   //
   // @param date 日期
   //============================================================
   public void setDate(String date){
      _date = date;
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
   // <T>获得名称。</T>
   //
   // @return 名称
   //============================================================
   public String name(){
      return _name;
   }

   //============================================================
   // <T>设置名称。</T>
   //
   // @param name 名称
   //============================================================
   public void setName(String name){
      _name = name;
   }

   //============================================================
   // <T>获得扩展名。</T>
   //
   // @return 扩展名
   //============================================================
   public String extension(){
      return _extension;
   }

   //============================================================
   // <T>设置扩展名。</T>
   //
   // @param extension 扩展名
   //============================================================
   public void setExtension(String extension){
      _extension = extension;
   }

   //============================================================
   // <T>获得数据。</T>
   //
   // @return 数据
   //============================================================
   public byte[] data(){
      return _data;
   }

   //============================================================
   // <T>设置数据。</T>
   //
   // @param data 数据
   //============================================================
   public void setData(byte[] data){
      _data = data;
   }

   //============================================================
   // <T>获得大小。</T>
   //
   // @return 大小
   //============================================================
   public int size(){
      return _size;
   }

   //============================================================
   // <T>设置大小。</T>
   //
   // @param size 大小
   //============================================================
   public void setSize(int size){
      _size = size;
   }

   //============================================================
   // <T>获得网络地址。</T>
   //
   // @return 网络地址
   //============================================================
   public String uri(){
      return _uri;
   }

   //============================================================
   // <T>设置网络地址。</T>
   //
   // @param url 网络地址
   //============================================================
   public void setUri(String uri){
      _uri = uri;
   }

   //============================================================
   // <T>获得网络地址。</T>
   //
   // @return 网络地址
   //============================================================
   public String url(){
      return _url;
   }

   //============================================================
   // <T>设置网络地址。</T>
   //
   // @param url 网络地址
   //============================================================
   public void setUrl(String url){
      _url = url;
   }

   //   //============================================================
   //   // <T>获得图片集合。</T>
   //   //
   //   // @return 图片集合
   //   //============================================================
   //   public SGcStorageImages images(){
   //      return _images;
   //   }
   //
   //   //============================================================
   //   // <T>增加一个图片。</T>
   //   //
   //   // @param width 宽度
   //   // @param height 高度
   //   //============================================================
   //   public void pushImage(int width,
   //                         int height){
   //      pushImage(width, height, 0);
   //   }
   //
   //   //============================================================
   //   // <T>增加一个图片。</T>
   //   //
   //   // @param width 宽度
   //   // @param height 高度
   //   // @param round 圆角
   //   //============================================================
   //   public void pushImage(int width,
   //                         int height,
   //                         int round){
   //      SGcStorageImage image = new SGcStorageImage();
   //      image.setWidth(width);
   //      image.setHeight(height);
   //      image.setRound(round);
   //      //_images.push(image);
   //   }

   //============================================================
   // <T>设置网络地址。</T>
   //
   // @param url 网络地址
   //============================================================
   public void loadFile(String fileName){
      // 检查文件存在性
      if(!RFile.exists(fileName)){
         throw new FFatalError("File is not exists. (file_name={1})", fileName);
      }
      // 设置名称
      if(RString.isEmpty(_name)){
         _name = RFile.shortName(fileName);
      }
      // 设置扩展
      if(RString.isEmpty(_extension)){
         _extension = RFile.extension(fileName);
      }
      // 加载文件
      try(FByteFile file = new FByteFile(fileName)){
         _data = file.toArray();
      }catch(Exception exception){
         _logger.error(this, "loadFile", exception);
      }
   }

   //============================================================
   // <T>打包处理。</T>
   //
   // @return 打包字符串
   //============================================================
   public String pack(){
      if(_data == null){
         return null;
      }
      FAttributes map = new FAttributes();
      map.set("catalog", _catalog);
      map.set("date", _date);
      map.set("code", _code);
      map.set("name", _name);
      map.set("extension", _extension);
      map.set("size", _data.length);
      return map.pack();
   }

   //============================================================
   // <T>解包处理。</T>
   //
   // @param pack 打包字符串
   //============================================================
   public void unpack(String pack){
      FAttributes map = new FAttributes();
      map.unpack(pack);
      _catalog = map.get("catalog");
      _date = map.get("date");
      _code = map.get("code");
      _name = map.get("name");
      _extension = map.get("extension");
      _size = map.getInt("size");
   }
}
