package org.mo.content.common;

import org.mo.cloud.logic.system.FGcSessionInfo;

public class RRs3Configuration
{
   public static String RootPath = "D:/Microbject";

   public static String Config = "application-home.xml";

   //============================================================
   // <T>生成一个会话。</T>
   //============================================================
   public static FGcSessionInfo makeSession(){
      FGcSessionInfo session = new FGcSessionInfo();
      session.setUserId(1);
      return session;
   }
}
