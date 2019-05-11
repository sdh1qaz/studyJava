package 枚举学习;

import java.awt.Button;

/**
 * @ClassName： Burrito
 * @Author: dhSu
 * @Description:枚举在switch内使用
 * @Date:Created in 2019年5月11日
 */

public class Burrito {
	Spiciness degree;
	public Burrito(Spiciness degree) {
		this.degree = degree;
	}
	
	public void describe() {
		System.out.print("The burrito is: ");
		switch(degree) {
			case NOT:
				System.out.println("not spicy at all.");
				break;
			case MILD:
			case MEDIUM:
				System.out.println("a little hot.");
				break;
			case HOT:
			case FALMING:
				default:
					System.out.println("may be too hot.");
		}
	}
	
	public static void main(String[] args) {
		Burrito 
		plain = new Burrito(Spiciness.MILD),
		greenChile = new Burrito(Spiciness.MEDIUM),
		jalapeno = new Burrito(Spiciness.HOT);
		
		plain.describe();
		greenChile.describe();
		jalapeno.describe();
		
		
	}
}
