package com.example.facade;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DataBaseTableFacade {
	public static List<String> getTableNames(String jdbcUrl,
			String user,String password) throws Exception{
		Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
		System.out.println(connection.getClass());
		DatabaseMetaData metaData = connection.getMetaData();
		System.out.println(metaData.getClass());
		ResultSet rs = metaData.getTables(null, null, null, null);
		System.out.println(rs.getClass());
		List<String> names = new ArrayList<>();
		while (rs.next()) {
			names.add(rs.getString("TABLE_NAME"));
		}
		return names;
	}
}
