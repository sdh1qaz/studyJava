package reflect;
/**
 * 由于Class类没有构造方法，所以实例化Class类的方式有点特殊，有三种方式：
         对象.getClass( )
        类.Class
  forName( )
 * @author Administrator
 *
 */

public class ReflectTest1 {
	public static void main(String[] args) {
        //方式一：
        Test t = new Test();
        Class<? extends Test> c1 = t.getClass();
        System.out.println(c1);
         
        //方式二：
        //为了避免特殊性，这里不用Test类，而用java库中的String类
        Class<String> c2 = String.class;
        System.out.println(c2);
         
        //方式三：
        //forName()方法会抛出异常
        Class<?> c3 = null;
        try {
            c3 = Class.forName("Test");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(c3);
    }
}
