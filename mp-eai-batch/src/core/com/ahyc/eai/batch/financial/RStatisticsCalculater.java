package com.ahyc.eai.batch.financial;

import org.mo.com.lang.FAttributes;
import org.mo.com.lang.FObject;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.eng.data.IDatabaseConsole;

//============================================================
// <T>统计计算器。</T>
//============================================================
public class RStatisticsCalculater
      extends FObject
{
   // 日志输出接口
   protected static ILogger _logger = RLogger.find(RStatisticsCalculater.class);

   //============================================================
   // <T>投资阶段处理。</T>
   //============================================================
   public static void main(String[] args){
      // 设置属性
      FAttributes attributes = RAop.configConsole().defineCollection().attributes();
      attributes.set("application", "/data/eai/eai.batch");
      // 加载配置
      RAop.initialize("/data/eai/eai.batch/webroot/WEB-INF/classes/application-test.xml");
      // 逻辑处理
      IDatabaseConsole databaseConsole = RAop.find(IDatabaseConsole.class);
      try(FLogicContext logicContext = new FLogicContext(databaseConsole)){
         //         FStatisticsInvestmentCalculater calculater = new FStatisticsInvestmentCalculater();
         //         calculater.process(logicContext);
         FStatisticsRedemptionCalculater calculater = new FStatisticsRedemptionCalculater();
         calculater.process(logicContext);
      }catch(Exception exception){
         _logger.error(null, "main", exception);
      }
      RAop.release();
   }
}
