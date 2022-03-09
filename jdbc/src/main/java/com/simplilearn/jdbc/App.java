package com.simplilearn.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main( String[] args )
    {
     
				Connection conn = DBUtil.getDBConnection();
				
			
				
			try {
				
				//String insert = "insert into employee values(?,?,current_date,?)";  // ? positional params
				
				String update = "update  employee set  ename = ? , salary = ? where eid = ?";
				PreparedStatement pstmt =	conn.prepareStatement(update);
				
			/*// insert query
			 * pstmt.setInt(1, 111);
			 * 
			 * pstmt.setString(2, "banerjee"); pstmt.setInt(3, 50000);
			 */
				
				
						pstmt.setString(1, "tom cruise");
						pstmt.setInt(2, 45000);
						pstmt.setInt(3, 102);
						
						
					int count =	pstmt.executeUpdate();
				
				System.out.println(count + " records effected .....");
				
				
					Connection conn2 =	DBUtil.getDBConnection();
				
					
						
					String select = "select * from employee";
					
					PreparedStatement pstmt2 =	conn2.prepareStatement(select);
				ResultSet rs = 		pstmt2.executeQuery();
				
					while(rs.next()) {
						
						System.out.println(rs.getInt("eid") +"  "+rs.getString("ename")+" "+rs.getInt("salary"));
						
					}
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
    }
}
