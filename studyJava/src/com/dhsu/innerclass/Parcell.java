package com.dhsu.innerclass;
/**
 * @ClassName： Parcell
 * @Author: dhSu
 * @Description: 来自java编程思想中文版 P191
 * @Date:Created in 2018年4月8日
 */

public class Parcell {
	
   class Contents{
	   private int i = 11;
	   public int value() {
		   return i;
       }
   }
   
   class Destination{
	   private String label;
	   Destination(String whereTo) {
		   label = whereTo;
	   }
	   String readLabel() {
		   return label;
	   }
   }
   
   public void ship(String dest) {
	   Contents contents = new Contents();
	   Destination destination = new Destination(dest);
	   System.out.println(destination.readLabel());
   }
   
   public static void main(String[] args) {
	Parcell parcell = new Parcell();
	parcell.ship("Tasmania");
}
}
