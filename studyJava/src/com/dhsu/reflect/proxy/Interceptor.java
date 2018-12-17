package com.dhsu.reflect.proxy;
/**
 * @ClassName： Interceptor
 * @Author: dhSu
 * @Description: 拦截接口，等效于aop中的切面
 * @Date:Created in 2018年11月21日
 */

public interface Interceptor {
	
	void before(Object obj);
	
	void after(Object obj);
	
	void afterReturning(Object obj);
	
	void afterThrowing(Object obj);
}
