package 常规;
/**
 * @ClassName： GetOutPut
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年12月11日
 */

public class SomeObjectB extends SomeObject{

	private String mark;

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public SomeObjectB(int no, String name,String mark) {
		super(no, name);
		this.mark = mark;
	}
	
	@Override
	protected void dosomething() {
		String s = String.format("no=%d,name=%s,mark=%s", this.getNo(),this.getName(),this.getMark());
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		SomeObjectB object2 = new SomeObjectB(2, "object2", "mark2");
		object2.dosomething();
		
		SomeObject object = (SomeObject)object2;
		object.dosomething();
	}
}
