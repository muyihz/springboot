package com.muou.common;

public class TestPojo {
	@AnnotationTest(value = "zhangsan")
	private String name;
	//@AnnotationTest(value = "beijing")
	private String addr;
	@Override
	public String toString() {
		return this.name + "======" + this.addr;
	}
	
	public void testParam(@AnnoParamTest(value = "dasdsdsada") String value) {
		System.out.println(value);
	}
}
