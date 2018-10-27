/**
 * @ClassName： Types
 * 
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2018年10月9日
 */

public enum Types {
	TAG("tag", "TAG"),
	HELLO("hello","HELLO");

	private String type;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public java.lang.String getType() {
		return type;
	}

	public void setType(java.lang.String type) {
		this.type = type;
	}

	Types(java.lang.String type, String name) {
		this.type = type;
		this.name = name;
	}
}