package 常规;
/**
 * @ClassName： SomeObject
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年12月11日
 */

public class SomeObject {
	private int no;
	private String name;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SomeObject(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	
	protected void dosomething() {
	}
}
