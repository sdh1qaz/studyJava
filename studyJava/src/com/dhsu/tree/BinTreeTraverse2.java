package com.dhsu.tree;
import java.util.LinkedList;  
import java.util.List;  
  
/** 
 * ���ܣ���һ�������ֵ����������У�Ȼ�����3�ַ�ʽ�ı��� 
 * �ο�����0:���ݽṹ(C���԰�)��ε�� 
 * �ο�����1��http://zhidao.baidu.com/question/81938912.html 
 * �ο�����2��http://cslibrary.stanford.edu/110/BinaryTrees.html#java 
 * @author ocaicai@yeah.net @date: 2011-5-17 
 */  
public class BinTreeTraverse2 {  
  
    private int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };  
    private static List<Node> nodeList = null;  
  
    /** 
     * �ڲ��ࣺ�ڵ� 
     * @author ocaicai@yeah.net @date: 2011-5-17 
     */  
    private static class Node {  
        Node leftChild;  //��
        Node rightChild;  //��
        int data;  //����
  
        Node(int newData) {  //����
            leftChild = null;  
            rightChild = null;  
            data = newData;  
        }  
    }  
  
    public void createBinTree() {  
        nodeList = new LinkedList<Node>();  
        // ��һ�������ֵ����ת��ΪNode�ڵ�  
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {  
            nodeList.add(new Node(array[nodeIndex]));  
        }  
        // ��ǰlastParentIndex-1�����ڵ㰴�ո��ڵ��뺢�ӽڵ�����ֹ�ϵ����������  
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {  
            // ����  
            nodeList.get(parentIndex).leftChild = nodeList  
                    .get(parentIndex * 2 + 1);  
            // �Һ���  
            nodeList.get(parentIndex).rightChild = nodeList  
                    .get(parentIndex * 2 + 2);  
        }  
        // ���һ�����ڵ�:��Ϊ���һ�����ڵ����û���Һ��ӣ����Ե����ó�������  
        int lastParentIndex = array.length / 2 - 1;  
        // ����  
        nodeList.get(lastParentIndex).leftChild = nodeList  
                .get(lastParentIndex * 2 + 1);  
        // �Һ���,�������ĳ���Ϊ�����Ž����Һ���  
        if (array.length % 2 == 1) {  
            nodeList.get(lastParentIndex).rightChild = nodeList  
                    .get(lastParentIndex * 2 + 2);  
        }  
    }  
  
    /** 
     * ������� 
     * �����ֲ�ͬ�ı����ṹ����һ���ģ�ֻ���Ⱥ�˳��һ������ 
     * @param node 
     * �����Ľڵ� 
     */  
    public static void preOrderTraverse(Node node) {  
        if (node == null)  
            return;  
        System.out.print(node.data + " ");  
        preOrderTraverse(node.leftChild);  
        preOrderTraverse(node.rightChild);  
    }  
  
    /** 
     * ������� 
     * �����ֲ�ͬ�ı����ṹ����һ���ģ�ֻ���Ⱥ�˳��һ������ 
     * @param node 
     * �����Ľڵ� 
     */  
    public static void inOrderTraverse(Node node) {  
        if (node == null)  
            return;  
        inOrderTraverse(node.leftChild);  
        System.out.print(node.data + " ");  
        inOrderTraverse(node.rightChild);  
    }  
  
    /** 
     * ������� 
     * �����ֲ�ͬ�ı����ṹ����һ���ģ�ֻ���Ⱥ�˳��һ������ 
     * @param node 
     * �����Ľڵ� 
     */  
    public static void postOrderTraverse(Node node) {  
        if (node == null)  
            return;  
        postOrderTraverse(node.leftChild);  
        postOrderTraverse(node.rightChild);  
        System.out.print(node.data + " ");  
    }  
  
    public static void main(String[] args) {  
        BinTreeTraverse2 binTree = new BinTreeTraverse2();  
        binTree.createBinTree();  
        // nodeList�е�0����������ֵ��Ϊ���ڵ�  
        Node root = nodeList.get(0);  
  
        System.out.println("���������");  
        preOrderTraverse(root);  
        System.out.println();  
  
        System.out.println("���������");  
        inOrderTraverse(root);  
        System.out.println();  
  
        System.out.println("���������");  
        postOrderTraverse(root);  
    }  
  
}  
