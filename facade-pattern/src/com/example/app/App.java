package com.example.app;

import com.example.facade.DataBaseTableFacade;

public class App {

	public static void main(String[] args) throws Exception {
		DataBaseTableFacade.getTableNames("jdbc:mysql://localhost:3306/world?useSSL=false",
				 "root", "Secret_123")
		.forEach(System.err::println);

	}

}
