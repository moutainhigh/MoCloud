package org.mo.cloud.common.datetime;

import org.mo.com.collections.FRow;
import org.mo.com.data.ISqlConnection;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.type.TDateTime;
import org.mo.core.monitor.common.FAbstractMonitor;
import org.mo.eng.data.IDatabaseConsole;

//============================================================
// <T>时间监视器。</T>
//============================================================
public class FDataTimeMonitor
      extends FAbstractMonitor
{
   //============================================================
   // <T>构造时间监视器。</T>
   //============================================================
   public FDataTimeMonitor(){
      _name = "time.monitorr";
      _valid = true;
      _interval = 300000;
   }

   private static final String gettimesql = "select CURRENT_TIMESTAMP";

   private IDatabaseConsole _databaseConsole;

   private ISqlConnection _sqlconn;

   private volatile long _timeDiff;

   private TDateTime _tickTime;

   public TDateTime getCurrentTime(){
      TDateTime currentTime = RDateTime.currentDateTime();
      currentTime.add(_timeDiff);
      return currentTime;
   }

   public void setDatabaseConsole(IDatabaseConsole console){
      _databaseConsole = console;
   }

   private void tick(){
      FRow row = _sqlconn.find(gettimesql);
      if(row.count() > 0){
         String time = row.value(0);
         _tickTime.parse(time);
      }
      TDateTime currentTime = RDateTime.currentDateTime();
      _timeDiff = _tickTime.get() - currentTime.get();
   }

   @Override
   public void initialize(){
      _tickTime = new TDateTime();
      _sqlconn = _databaseConsole.alloc();
      tick();
      super.initialize();
   }

   @Override
   public boolean onExecute(){
      tick();
      return super.onExecute();
   }
}
