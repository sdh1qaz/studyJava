package com.dhsu.hsahset;

import java.util.HashSet;

/**
 * @ClassName： HashTest
 * @Author: dhSu
 * @Description: 测试HashSet
 * @Date:Created in 2018年3月13日
 */

public class HashTest {
    public static void main(String[] args) {
    	HashSet<Node> hashSet = new HashSet<Node>();
    	
		Node node1 = new Node("5", "0", "1");
		Node node2 = new Node("2", "0", "2");
		Node node3 = new Node("9", "0", "3");
		
		hashSet.add(node1);
		hashSet.add(node2);
		hashSet.add(node3);
		
		for(Node node:hashSet)
			System.out.println(node.toString());
	}
}

