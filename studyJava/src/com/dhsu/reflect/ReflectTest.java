package com.dhsu.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ReflectTest {
	public static void main(String[] args) throws Throwable {
    /*    Test1 t = new Test1();
        //System.out.println(t.getClass());
        //System.out.println(t.getClass().getName());
        t.getClass().getMethod("say",String.class).invoke(t, "malbisssss");
        t.getClass().getMethod("hello", String.class).invoke(t, "hahhahahahahaahahahahahahah");*/
	   /* ClassLoader loader = Thread.currentThread().getContextClassLoader();
	    Class clazz = loader.loadClass("reflect.Car");
	    
	    Constructor constructor = clazz.getConstructor((Class[]) null);
	    Car car = (Car)constructor.newInstance();
	    
	    Method setBrand = clazz.getMethod("setBrand", String.class);
	    setBrand.invoke(car, "红旗");
	    
	    car.introduce();*/
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		System.out.println("current loader:" + loader);
		System.out.println("parent loader:" + loader.getParent());
		//因为无法再java中获得它的句柄，所以直接返回null
		System.out.println("grandparent loader:" + loader.getParent().getParent());
    }
}

class Test {
    
}

class Test1{
	public void say(String str){
		System.out.println("Test1---say" + str);
	}
	
	public void  hello(String str) {
		System.out.println("Test-----hell" + str);
	}
	
}