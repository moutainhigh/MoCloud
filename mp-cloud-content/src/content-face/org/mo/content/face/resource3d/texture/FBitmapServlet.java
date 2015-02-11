package org.mo.content.face.resource3d.texture;

import com.cyou.gccloud.data.data.FDataResourceBitmapImageUnit;
import javax.servlet.http.HttpServletResponse;
import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.net.EMime;
import org.mo.content.core.resource3d.texture.IC3dBitmapConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.image.FImage;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>上传处理。</T>
//============================================================
public class FBitmapServlet
      extends FObject
      implements
         IBitmapServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FBitmapServlet.class);

   // 缓冲时间
   protected static long CacheTimeout = 3600 * 24 * 7 * 4;

   // 存储管理接口
   @ALink
   protected IGcStorageConsole _storageConsole;

   // 纹理位图接口
   @ALink
   protected IC3dBitmapConsole _bitmapConsole;

   //============================================================
   // <T>逻辑处理。</T>
   // <P>catalog:分类</P>
   // <P>date:日期</P>
   // <P>code:代码</P>
   // <P>version:版本</P>
   // <P>type:类型，没有的话，存储为 bin</P>
   // <P>size:大小</P>
   // <P>存储位置：\{catalog}\{date:yyyymmdd}\{code}\{version}.{type}</P>
   //
   // @param context 环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public void process(IWebContext context,
                       ILogicContext logicContext,
                       IWebServletRequest request,
                       IWebServletResponse response){
      // 检查代码
      String code = context.parameter("code");
      if(RString.isEmpty(code)){
         throw new FFatalError("Model code is empty.");
      }
      // 检查版本
      String version = context.parameter("version");
      // 环境贴图处理
      String type = null;
      if(code.contains("-")){
         String[] items = RString.split(code, '-');
         if(items.length == 2){
            code = items[0];
            type = items[1];
         }
      }
      // 获得数据
      FDataResourceBitmapImageUnit imageUnit = _bitmapConsole.findBitmapUnit(logicContext, code, version);
      String formatCode = imageUnit.formatCode();
      SGcStorage resource = _storageConsole.find(EGcStorageCatalog.ResourceBitmapImage, imageUnit.guid());
      byte[] data = resource.data();
      // 获得部分数据
      if(type != null){
         FImage image = new FImage(data);
         int x = 0;
         int y = 0;
         int height = image.height();
         switch(type){
            case "x1":
               x = 0;
               break;
            case "x2":
               x = height;
               break;
            case "y1":
               x = height * 2;
               break;
            case "y2":
               x = height * 3;
               break;
            case "z1":
               x = height * 4;
               break;
            case "z2":
               x = height * 5;
               break;
            default:
               throw new FFatalError("Unknown type. (type={1})", type);
         }
         synchronized(this){
            FImage dataImage = image.imageRectangle(x, y, height, height);
            data = dataImage.toBytes("jpg");
         }
      }
      int dataLength = data.length;
      // 发送数据
      _logger.debug(this, "process", "Send data. (length={1})", dataLength);
      response.setCharacterEncoding("utf-8");
      response.setStatus(HttpServletResponse.SC_OK);
      response.setHeader("Cache-Control", "max-age=" + CacheTimeout);
      response.addHeader("Last-Modified", System.currentTimeMillis());
      response.addHeader("Expires", System.currentTimeMillis() + CacheTimeout * 1000);
      switch(formatCode){
         case "jpg":
            response.setContentType(EMime.Jpg.mime());
            break;
         case "png":
            response.setContentType(EMime.Png.mime());
            break;
         default:
            response.setContentType(EMime.Bin.mime());
      }
      response.setContentLength(dataLength);
      response.write(data, 0, dataLength);
   }
}