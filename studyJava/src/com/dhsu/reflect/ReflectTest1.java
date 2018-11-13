package com.dhsu.reflect;
/**
 * ����Class��û�й��췽��������ʵ����Class��ķ�ʽ�е����⣬�����ַ�ʽ��
         ����.getClass( )
        ��.Class
  forName( )
 * @author Administrator
 *
 */

public class ReflectTest1 {
	public static void main(String[] args) {
        //��ʽһ��
        Test t = new Test();
        Class<? extends Test> c1 = t.getClass();
        System.out.println(c1);
         
        //��ʽ����
        //Ϊ�˱��������ԣ����ﲻ��Test�࣬����java���е�String��
        Class<String> c2 = String.class;
        System.out.println(c2);
         
        //��ʽ����
        //forName()�������׳��쳣
        Class<?> c3 = null;
        try {
            c3 = Class.forName("Test");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(c3);
    }
}
