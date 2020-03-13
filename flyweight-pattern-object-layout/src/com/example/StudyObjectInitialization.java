package com.example;

public class StudyObjectInitialization {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		C c1 = new C();	
		C c2 = new C(42);	

	}

}
// -XX:+DisableExplicitGC System.gc()
class C {
	static {
		System.out.println("What is this static block?");		
	}
	{
		System.out.println("What is this 1?");		
	}
	public int fun(){ return 42;}
	
	{
		System.out.println("What is that 2?");		
	}
	C(){
		init();
		System.out.println("A()");
	}
	C(int i){
		init();
		System.out.println("A(int)");
	}
	void init() {}
}
