package org.mo.content.dbexport;

import org.mo.com.logging.RLogger;
import org.mo.content.common.RRs3Configuration;
import org.mo.content.engine.core.storage.IResStorageConsole;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.data.IDatabaseConsole;

public class RDbExportData
{
   //============================================================
   // <T>导入处理。</T>
   //============================================================
   public static void importProcess() throws Exception{
      // 设置数据
      String path = RRs3Configuration.RootPath + "/MoResource/Assest";
      // 导入处理
      IDatabaseConsole dbConsole = RAop.find(IDatabaseConsole.class);
      try(ILogicContext logicContext = new FLogicContext(dbConsole)){
         IResStorageConsole storageConsole = RAop.find(IResStorageConsole.class);
         storageConsole.exportData(logicContext, path);
         //storageConsole.exportStorage(logicContext, path);
      }
   }

   //============================================================
   // <T>主函数。</T>
   //============================================================
   public static void main(String[] args) throws Exception{
      String configPath = RRs3Configuration.RootPath + "/MoCloud";
      RAop.configConsole().defineCollection().attributes().set("application", configPath);
      RAop.initialize(configPath + "/mp-cloud-content/src/config/" + RRs3Configuration.Config);
      try{
         importProcess();
      }catch(Exception e){
         RLogger.find(RDbExportData.class).error(null, "main", e);
      }
      RAop.release();
   }
}
