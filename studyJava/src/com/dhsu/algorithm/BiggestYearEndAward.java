package com.dhsu.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName： BiggestYearEndAward
 * @Author: dhSu
 * @Description:求最大的年终奖
 * @Date:Created in 2018年11月13日
 */

/*无论怎么走结果都是9个数相加，定义一个类，九个数就是九个属性，提供一个方法求和*/
class PossibilityOfAward{
	
	int[] poss = new int[9];
	public PossibilityOfAward() {
		poss[0] = 100;
		poss[8] = 200;
	}
	int getSum() {
		int sum = 0;
		for(int i=0;i<poss.length;i++) {
			sum += poss[i];
		}
	return sum;
	}
}

//路标，代表一个数
class Guidepost{
	int row;//行
	int col;//列
	int vaule;//数值
	
	public Guidepost(int row, int col, int vaule) {
		this.row = row;
		this.col = col;
		this.vaule = vaule;
	}
}

public class BiggestYearEndAward {
	/*小明公司发年终奖，规则是从起点到终点，每次只能向右或者向下走一步，路过的数相加，最后
	的总数就是年终奖的钱数，问：怎样才能拿的最多？*/
	static int[][] array = {{100,	1000,	800,	400,	300},
							{500,	600,	700,	100,	900},
							{1000,	100,	200,	700,	600},
							{400,	900,	700,	600,	300},
							{500,	400,	700,	600,	200}
						};
	static int count = 0;
	public static void main(String[] args) {
		//可能性列表
		List<Guidepost> list = new ArrayList<Guidepost>();
		for(int i = 0;i < 5;i ++) {
			for(int j = 0;j < 5;j ++ ) {
				list.add(new Guidepost(i,j,array[i][j]));
			}		
		}
		for(int a = 0;a < 255;a ++) {
			System.out.println(Integer.toBinaryString(a));
		}
	}
	/*把每一步定义为右/下 ,那么一种走法等效为一个包含4个右4个下的序列
	 * eg 右右右右下下下下；下右下右下右下右；问题转化为4个和4个下任意排列的问题*/
	/*把0~255的整数的二进制打印出来*/
	
	
}
