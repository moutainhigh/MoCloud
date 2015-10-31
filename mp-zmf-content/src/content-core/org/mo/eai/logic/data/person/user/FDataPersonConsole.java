package org.mo.eai.logic.data.person.user;

import com.cyou.gccloud.data.data.FDataPersonAccessAuthorityLogic;
import com.ycjt.ead.ThreeDes;
import java.net.URLEncoder;
import java.util.Date;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.encoding.RMd5;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.net.http.FHttpConnection;
import org.mo.core.aop.face.AProperty;

//============================================================
// <T>数据人员访问授权信息控制台。</T>
//============================================================
public class FDataPersonConsole
      extends FAbstractLogicUnitConsole<FDataPersonAccessAuthorityLogic, FDataPersonAccessAuthority>
      implements
         IDataPersonConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FDataPersonConsole.class);

   @AProperty
   protected boolean _oaLoginEnable;

   @AProperty
   protected String _oaLoginUrl;

   //============================================================
   // <T>构造数据人员访问授权信息控制台。</T>
   //============================================================
   public FDataPersonConsole(){
      super(FDataPersonAccessAuthorityLogic.class, FDataPersonAccessAuthority.class);
   }

   //============================================================
   // <T>请求OA登录接口</T>
   //
   // @param url 接口链接
   // @param passport 用户名
   // @param password 密码
   // @return 登录结果（0：验证成功，1：签名不通过，2：参数不完整，3：用户名或密码错误，98：IP不在白名单中，99：系统异常）
   //============================================================
   @Override
   public String oaLogin(String passport,
                         String password){
      //设置参数
      String key = "ycjt*&^%$3fyg";
      String encodePassport = ThreeDes.encode(key, passport);
      String encodePassword = ThreeDes.encode(key, password);
      String appDate = String.valueOf(new Date().getTime());
      String from = "H5";
      String validate = RMd5.encode(encodePassport + encodePassword + appDate + from + key);
      // 拼装参数
      String parem = null;
      try{
         parem = "?username=" + URLEncoder.encode(encodePassport, "utf-8") + "&pwd=" + URLEncoder.encode(encodePassword, "utf-8") + "&appDate=" + appDate + "&from=" + from + "&validate=" + validate;
      }catch(Exception error){
         _logger.error(null, "oaLogin", error, "ROALoginUnit oaLogin", "OA login fail.");
      }
      _logger.debug(null, "ROALoginUnit oaLogin", "OA login. (url={1})", _oaLoginUrl + parem);
      // 发送请求
      String result = null;
      try(FHttpConnection connection = new FHttpConnection(_oaLoginUrl + parem)){
         result = connection.fetch();
      }
      return RString.trim(result);
   }

}
