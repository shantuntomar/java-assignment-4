package PreparedStatementExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateQueryExecution {

	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/java_batch";
		String username = "root";
		String password = "root";
		
		 Connection connection = null;
		 PreparedStatement preparedStatement = null;
		 
		 Scanner scanner = new Scanner(System.in);
		 
		 System.out.println("Enter Name :");
		 String name = scanner.next();
		 
		 System.out.println("Enter age : ");
		 int age = scanner.nextInt();
		 
		 String sqlInsertQuery = "insert into user_data (`user_id` , `user_name` , `user_age`) values(?,?,?)";
		 
		 try {
			 connection = DriverManager.getConnection(url , username , password);
			 if(connection != null) {
				 preparedStatement = connection.prepareStatement(sqlInsertQuery);
			 }
			 if(preparedStatement != null) {
				 preparedStatement.setInt(1, 3);
				 preparedStatement.setString(2, name);
				 preparedStatement.setInt(3, age);
				 
				 int rowAffected = preparedStatement.executeUpdate();
				 System.out.println("row affected are : " + rowAffected);
			 }
		 }
		 catch(SQLException se) {
			 se.printStackTrace();
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 finally {
			connection.close();
			if(scanner != null) {
				scanner.close();
			}
		}
		

	}

}
