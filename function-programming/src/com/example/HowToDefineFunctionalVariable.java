package com.example;

public class HowToDefineFunctionalVariable {

	public static void main(String[] args) {
		MyFunction f1 = new MyFunction() {

			@Override
			public int fun(int x) {
				return 2 * x;
			}
		};
		ABC abc = new ABC();
		System.out.println(f1.fun(42));
		MyFunction f2 = y ->  2 * y; // stateless
		System.out.println(f2.fun(42));
		MyFunction f3 = MyFunction::twice;
		System.out.println(f3.fun(42));
		MyFunction f4 = abc::sun;
		System.out.println(f4.fun(42)); // bytecode: invokeDynamic // call site
		MyFunction f5 = ABC::run;
		System.out.println(f5.fun(42));
		int []x= {42}; // effectively final
		new Thread(() ->{ 
			x[0]++;
			System.out.println("Hello Mars: " + x[0] );
   	    }).start(); 
	}

}

class ABC {
	public int sun(int r) {
		System.err.println("ABC::sun");
		return 3 * r;
	}

	public static int run(int r) {
		System.err.println("ABC::run");
		return 4 * r;
	}

}

@FunctionalInterface
interface MyFunction {
	int fun(int x);

	static int twice(int z) {
		System.err.println("twice!");
		return 2 * z;
	}

	default double gun() {
		return Math.PI;
	}
}