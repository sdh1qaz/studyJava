package com.dhsu.hsahset;
/**
 * @ClassName： Node
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2018年3月13日
 */

public class Node {
	
	private String id;
	private String pid;
	private String name;
	
	public Node(String id, String pid, String name) {
		super();
		this.id = id;
		this.pid = pid;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", pid=" + pid + ", name=" + name + "]";
	}
	
	//重写hashcode方法
	public int hashCode()//重写    
    {  
        return id.hashCode() + pid.hashCode() + name.hashCode() ;  
    }  
	
	//重写equals方法
	public boolean equals(Object obj)//重写   Object不能换  
    {  
          if(!(obj instanceof Node))  
              return false;  
          Node p=(Node)obj;  
          return this.id.equals(p.id) && this.pid==p.pid && this.name==p.name;  
    } 
	
	
}
