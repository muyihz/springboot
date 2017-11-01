package com.muou.common;

import com.muou.common.support.Attribution;

public class Test {
	public static void main(String[] args) {
		test("1111111111111111111");
	}
	
	public static void test(@Attribution(paramName = "11") String param) {
		System.out.println(param);
	}
}
