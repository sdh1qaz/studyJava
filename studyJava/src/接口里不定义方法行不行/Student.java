package 接口里不定义方法行不行;
/**
 * @ClassName： Student
 * @Author: dhSu
 * @Description:了解下对象克隆接口Cloneable吧
 * @Date:Created in 2019年2月16日
 */

public class Student implements Cloneable{
	private String name;//姓名
	
	//覆写Object类中的clone方法
	public Object clone() throws CloneNotSupportedException {
		//调用父类的克隆方法
		return super.clone();
	}
	
	@Override
	public String toString() {
		return "姓名： " + this.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
