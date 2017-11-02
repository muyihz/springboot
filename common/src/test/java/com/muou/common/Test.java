package com.muou.common;

import java.lang.reflect.Field;
import java.util.Iterator;

public class Test {
	
	public static void testField() throws Exception{
		TestPojo pojo = new TestPojo();
		System.out.println(pojo);
		
		Field[] fields = pojo.getClass().getDeclaredFields();
		
		for (Field field : fields) {
			System.out.println(field.getName());
			if(field.isAnnotationPresent(AnnotationTest.class)){
				AnnotationTest anno = field.getAnnotation(AnnotationTest.class);
				String stranno = anno.value();
				field.setAccessible(true);
				field.set(pojo, stranno);
				
			}
		}
		System.out.println(pojo);
	}
	
	public void testParam() {
		
	}
	public static void main(String[] args) throws Exception {
		testField();
	}
	
}
