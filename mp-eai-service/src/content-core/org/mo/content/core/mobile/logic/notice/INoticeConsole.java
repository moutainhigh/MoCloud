package org.mo.content.core.mobile.logic.notice;

import com.cyou.gccloud.data.data.FDataLogicNoticeUnit;
import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;

//============================================================
//<T>号令控制台接口</T>
//============================================================
public interface INoticeConsole
{

   // ============================================================
   // <T>分页获取号令相关信息。</T>
   // @param pageNum 页数
   // @param pageSize 每页的行数
   // @param logicContext 逻辑上下文
   // ============================================================
   FLogicDataset<FDataLogicNoticeUnit> select(int pageNum,
                                              int pageSize,
                                              String sessionCode,
                                              ILogicContext logicContext);

   // ============================================================
   // <T>获取用户总数</T>
   // @param pageNum 页数
   // @param pageSize 每页的行数
   // @param logicContext 逻辑上下文
   // ============================================================

   public FLogicDataset<FDataPersonUserUnit> getUserCount(ILogicContext logicContext);

   // ============================================================
   // <T>标记号令已读</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // ============================================================
   String markRead(String noticeGuid,
                   long userId,
                   float locationLongitude,
                   float locationLatitude,
                   ILogicContext logicContext,
                   IWebSession sessionContext);

   // ============================================================
   // <T>号令发布</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // ============================================================
   String noticePublish(long userId,
                        String label,
                        String content,
                        ILogicContext logicContext);

   // ============================================================
   // <T>通过用户id找到用户</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // ============================================================
   FDataPersonUserUnit getUserById(ILogicContext logicContext,
                                   long usserId);

   // ============================================================
   // <T>分页获取号令前五条。</T>
   // @param pageNum 页数
   // @param pageSize 每页的行数
   // @param logicContext 逻辑上下文
   // ============================================================
   FLogicDataset<FNoticeModel> fetch(int pageNum,
                                     int pageSize,
                                     String sessionCode,
                                     ILogicContext logicContext);
}
