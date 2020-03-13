package com.example;

import java.io.Closeable;
import java.io.IOException;

public class CatchMeIfYouCan {
	public static int fun() {
		try( // try with resources 
				PreciousResource res1 = new PreciousResource(1);
				PreciousResource res2 = new PreciousResource(2);
				PreciousResource res3 = new PreciousResource(3);
				) {
			throw new IllegalStateException("Ooopss");
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} 
		return 42;
	}

	public static void main(String[] args) {
		//System.out.println(fun());
		int x = 0645;
		System.out.println(x);
	}

}

class PreciousResource implements Closeable {
	private int id;

	public PreciousResource(int id) {
		this.id = id;
	}

	@Override
	public void close() throws IOException {
		System.err.println("Closing the resource " + id);
		throw new IllegalStateException("Cannot close the precious resource " + id);
	}

}
