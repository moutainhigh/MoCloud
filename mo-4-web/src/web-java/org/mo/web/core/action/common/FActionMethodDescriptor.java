/*
 * @(#)FMethodDescriptor.java
 *
 * Copyright 2008 microbject, All Rights Reserved.
 *
 */
package org.mo.web.core.action.common;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.mo.com.data.ASqlConnect;
import org.mo.com.lang.FError;
import org.mo.com.lang.FFatalError;
import org.mo.web.core.container.AContainer;
import org.mo.web.core.face.AWebLogin;
import org.mo.web.core.face.AWebSession;

//============================================================
// <T>命令函数描述器。</T>
//============================================================
public class FActionMethodDescriptor
{
   // 页面命令的描述器
   private FActionDescriptor _actionDescriptor;

   // 调用函数对象
   private Method _method;

   // 类描述对象
   private Class<?>[] _types;

   // 表单描述器数组
   private AContainer[] _forms;

   // 数据链接数组
   private ASqlConnect[] _sqlConnects;

   // 会话的描述器
   protected AWebSession _sessionDescriptor;

   // 是否需要会话
   protected boolean _sessionRequire;

   // 登录的描述器
   protected AWebLogin _loginDescriptor;

   // 是否需要登录
   protected boolean _loginRequire;

   //============================================================
   // <T>构造命令函数描述器。</T>
   //============================================================
   public FActionMethodDescriptor(){
   }

   //============================================================
   // <T>建立内部信息。</T>
   //
   // @param method 函数
   //============================================================
   public void build(Method method){
      _method = method;
      _sessionRequire = _actionDescriptor.sessionRequire();
      _loginRequire = _actionDescriptor.loginRequire();
      // 获得函数的描述器
      Annotation[] methodAnnotations = _method.getAnnotations();
      if(null != methodAnnotations){
         for(Annotation annotation : methodAnnotations){
            if(annotation instanceof AWebSession){
               _sessionDescriptor = (AWebSession)annotation;
               _sessionRequire = _sessionDescriptor.require();
            }else if(annotation instanceof AWebLogin){
               _loginDescriptor = (AWebLogin)annotation;
               _loginRequire = _loginDescriptor.require();
            }
         }
      }
      // 获得函数的参数信息
      _types = _method.getParameterTypes();
      _forms = new AContainer[_types.length];
      _sqlConnects = new ASqlConnect[_types.length];
      // 获得函数的参数描述器
      Annotation[][] annos = _method.getParameterAnnotations();
      for(int n = 0; n < _types.length; n++){
         for(Annotation anno : annos[n]){
            if(anno instanceof AContainer){
               _forms[n] = (AContainer)anno;
               break;
            }
            if(anno instanceof ASqlConnect){
               _sqlConnects[n] = (ASqlConnect)anno;
               break;
            }
         }
      }
   }

   //============================================================
   // <T>获得命令描述器。</T>
   //
   // @return 命令描述器
   //============================================================
   public FActionDescriptor actionDescriptor(){
      return _actionDescriptor;
   }

   //============================================================
   // <T>设置命令描述器。</T>
   //
   // @param actionDescriptor 命令描述器
   //============================================================
   public void setActionDescriptor(FActionDescriptor actionDescriptor){
      _actionDescriptor = actionDescriptor;
   }

   //============================================================
   // <T>获得类型描述器集合。</T>
   //
   // @return 类型描述器集合
   //============================================================
   public Class<?>[] types(){
      return _types;
   }

   //============================================================
   // <T>获得表单描述器集合。</T>
   //
   // @return 表单描述器集合
   //============================================================
   public AContainer[] forms(){
      return _forms;
   }

   //============================================================
   // <T>获得数据链接描述器集合。</T>
   //
   // @return 链接描述器集合
   //============================================================
   public ASqlConnect[] sqlConnects(){
      return _sqlConnects;
   }

   //============================================================
   // <T>获得会话描述器。</T>
   //
   // @return 会话描述器
   //============================================================
   public AWebSession sessionDescriptor(){
      return _sessionDescriptor;
   }

   //============================================================
   // <T>获得是否需要会话。</T>
   //
   // @return 是否需要
   //============================================================
   public boolean sessionRequire(){
      return _sessionRequire;
   }

   //============================================================
   // <T>获得登录描述器。</T>
   //
   // @return 登录描述器
   //============================================================
   public AWebLogin loginDescriptor(){
      return _loginDescriptor;
   }

   //============================================================
   // <T>获得是否需要登录。</T>
   //
   // @return 是否需要
   //============================================================
   public boolean loginRequire(){
      return _loginRequire;
   }

   //============================================================
   // <T>函数调用处理。</T>
   //
   // @param instance 实例
   // @param params 参数集合
   // @return 处理结果
   //============================================================
   public Object invoke(Object instance,
                        Object[] params){
      try{
         return _method.invoke(instance, params);
      }catch(Exception e){
         // 获得原始例外
         Throwable throwable = null;
         if(e instanceof InvocationTargetException){
            throwable = ((InvocationTargetException)e).getTargetException();
         }else{
            throwable = e;
         }
         // 产生新例外
         FError error = null;
         if(throwable instanceof FError){
            error = (FError)throwable;
         }else{
            error = new FFatalError(e);
         }
         throw error;
      }
   }
}