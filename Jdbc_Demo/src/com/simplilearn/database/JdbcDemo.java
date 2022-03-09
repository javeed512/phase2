package com.simplilearn.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {

	public static void main(String[] args) {

		// step1 Register Driver

		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

			// step2 Get DB Connection

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mphasis", "root", "admin");

			// step3 create any one statement 1. Statement 2. PreparedStatement 3.
			// CallableStatement

			Statement stmt = conn.createStatement(); // use statement for static queries

			/*
			 * String query =
			 * "insert into  employee values(104,'narendra',current_date,80000)"; // step 4
			 * write query and execute query int count = stmt.executeUpdate(query);
			 * 
			 * System.out.println(count + " records inserted .....");
			 */

			String query = "select * from employee"; // static query

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				int eid = rs.getInt("eid");
				String ename = rs.getString("ename");
				int salary = rs.getInt(3);
				
				System.out.println(eid +"  "+ename+"  "+salary+"  "+rs.getDate("doj"));

			}

			// step5
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
