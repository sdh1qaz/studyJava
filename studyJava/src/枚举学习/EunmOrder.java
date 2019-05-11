package 枚举学习;
/**
 * @ClassName： EunmOrder
 * @Author: dhSu
 * @Description: 枚举中的常量值发的声明顺序
 * @Date:Created in 2019年5月11日
 */

public class EunmOrder {
	public static void main(String[] args) {
		for(Spiciness s : Spiciness.values()) {
			System.out.println(s + ",ordinal " + s.ordinal());
		}
	}
}
