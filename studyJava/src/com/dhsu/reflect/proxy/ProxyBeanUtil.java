package com.dhsu.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName： ProxyBeanUtil
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2018年11月21日
 */

public class ProxyBeanUtil implements InvocationHandler{
	//被代理的对象
	private Object obj;
	//拦截器
	private Interceptor interceptor;
	
	public static Object getBean(Object obj,Interceptor interceptor) {
		//使用当前类，作为代理方法，此时被代理的对象执行方法的时候，会进入当前类的invoke方法里
		ProxyBeanUtil _this = new ProxyBeanUtil();
		//保存被代理对象
		_this.obj = obj;
		//保存拦截器
		_this.interceptor = interceptor;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),_this);
	}
	
	public Object invoke(Object proxy,Method method,Object[] args) throws Throwable{
		Object retObj = null;
		//是否产生异常
		boolean exceptionFlag = false;
		//before方法
		interceptor.before(obj);
		
		try {
			//反射原有方法
			retObj = method.invoke(obj,args);
		}catch (Exception e) {
			exceptionFlag = true;
		}finally {
			//after方法
			interceptor.after(obj);
		}
		
		if(exceptionFlag) {
			//执行afterThrowing方法
			interceptor.afterThrowing(obj);
		}else {
			//执行afterReturning方法
			interceptor.afterReturning(obj);
		}
		return retObj;
	}

}
