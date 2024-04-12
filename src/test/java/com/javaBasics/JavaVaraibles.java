package com.javaBasics;

public class JavaVaraibles {
	int a = 34;//instance/global variables : declared inside a class and out side a method
	static char ch = 'w'; //static variables : variable declared with static keyword
	double s=3.2;
	static String str="I am learning selenium and java";
	char[] chrs= {'q','w','e','r','t','y'};
	
	public int sum(int a,int b) {//local variables : declared inside a method
		return a+b;
	}
	
	public static void Display() {
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		System.out.println("hello word! My first java progran");
		int sum = 3;//local variable
		JavaVaraibles obj = new JavaVaraibles();
		System.out.println("the value of a:"+obj.a);
		System.out.println("the value of ch:"+ch);
		System.out.println("the value of ch present at 3rd index:"+obj.chrs[3]);
		System.out.println(obj.sum(5, 9));
		Display();
	}
}
