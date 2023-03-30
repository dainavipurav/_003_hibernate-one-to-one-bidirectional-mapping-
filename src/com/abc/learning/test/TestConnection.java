package com.abc.learning.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
	public static void main(String[] args) {
		 String url = "jdbc:mysql://localhost:3306/hibernate_mapping_ont_to_one?useSSL=false";
		 String username = "root";
		 String password = "root";

		Connection con = null;

		try {
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection established succefully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connection not established");
		}
	}
}
