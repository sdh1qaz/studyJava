package com.dhsu.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * �ο���http://blog.csdn.net/u010127245/article/details/50937384
 * @author Administrator
 */
public class GoThroughHashMap {
   public static void main(String[] args) {
	   Map<String,String> map = new HashMap<String,String>();
	   //��������
	   for(int i=0;i<8050;i++){
		   map.put("key" + i,"value" + i);
	   } 
	   //����һ Ч�ʸߵ�
	   /**
	    * entrySet()�ķ���ֵҲ�Ƿ���һ��Set���ϣ��˼��ϵ�����ΪMap.Entry��
          Map.Entry��Map������һ���ڲ��ӿڣ��˽ӿ�Ϊ���ͣ�����ΪEntry<K,V>��
                                 ����ʾMap�е�һ��ʵ�壨һ��key-value�ԣ����ӿ�����getKey(),getValue������
	    */
	   Iterator iter = map.entrySet().iterator();
	   int count = 0;
	   while (iter.hasNext()) {
           Map.Entry entry = (Map.Entry) iter.next();
           Object key = entry.getKey();
           Object val = entry.getValue();
           System.out.println(key + " -- " + val);
	   }
   }
}
