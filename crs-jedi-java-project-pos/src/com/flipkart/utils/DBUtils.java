package com.flipkart.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtils {
	static final String DB_URL = "jdbc:mysql://localhost/CRS-Schema";
	static final String USER = "root";
	static final String PASS = "yashwant";

	public static Connection getConnection() {
		Connection conn = null;
		if (conn != null)
			return conn;
		else {
			try {
				Properties prop = new Properties();
                InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("./config.properties");
                prop.load(inputStream);
                String url = prop.getProperty("db_url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("pass");
//                System.out.print(url+" "+user+" "+password);
                
				conn = DriverManager.getConnection(url, user, password);
//				conn = DriverManager.getConnection(DB_URL, USER, PASS);

			}
			 catch (SQLException e) {
	                e.printStackTrace();
	            }
	            catch (FileNotFoundException e) {
	                e.printStackTrace();
	            }
	            catch (IOException e) {
	                e.printStackTrace();
	            }
			return conn;
		}

	}

}