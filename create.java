import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class InsertQueryUsingUserInput {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in); // taking the user input.
		
		/*
		
		System.out.println("enter the name");
		String name = sc.next();
		
		System.out.println("enter the age");
		int age = sc.nextInt();
		
		System.out.println("enter the address");
		String addr = sc.next();
		
		//formatting the variables.
		name = " ' " + name + " ' ";
		addr = " ' " + addr + " ' ";
		
		*/
		
		String url = "jdbc:mysql://localhost:3306/java_batch";
		String username = "root";
		String password = "root";
		
		//creating global variable : 
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DriverManager.getConnection(url , username , password);
			if(connection != null) {
				statement = connection.createStatement();
				if(statement != null) {
					//formatted query.
					
					/*
					String insert_query = "insert into student(`stud_id`, `student_name`, `student_age`, `student_addr`) values(" + 6 + " , " + name + " , " + age + " , " + addr + ")";
					int noOfRowsEffected = statement.executeUpdate(insert_query);
					System.out.println(noOfRowsEffected);
					*/
					
					String qry = String.format("insert into student(`stud_id`, `student_name`, `student_age`, `student_addr`) values('%d' , '%s' , '%d' , '%s')" , 7 , "shikant" , 44 , "banglore");
					int newRowsUpdated = statement.executeUpdate(qry);
					System.out.println(newRowsUpdated);				
				}	
			}
			
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(resultSet != null) resultSet.close();
			if(statement != null) statement.close();
			if(connection != null) connection.close();
			if(sc != null) sc.close();
		}
	}
}
