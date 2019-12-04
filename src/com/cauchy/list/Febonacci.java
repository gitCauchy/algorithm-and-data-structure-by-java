package com.cauchy.list;

/**
 * 
 * @author Cauchy
 * @ClassName Febonacci.java
 * @Date 2019年12月3日
 * @Description 斐波那契数列
 * @Version v0.1
 *
 */
public class Febonacci {
	public int getElemByNo(int num) {
		if (num == 1 || num == 2) {
			return 1;
		} else {
			return getElemByNo(num - 1) + getElemByNo(num - 2);
		}
	}
}
