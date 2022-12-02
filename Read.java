import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcImplementationUsingTryCatch {

	public static void main(String[] args) throws SQLException {
		
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
					String query = "select stud_id, student_name, student_age, student_addr from student";
					resultSet = statement.executeQuery(query);
					if(resultSet != null) {
						System.out.println("SID\tSNAME\tSAGE\tSADDR");
						System.out.println("==================================");
						while(resultSet.next()) {
							int sid = resultSet.getInt("stud_id");
							String name = resultSet.getString("student_name");
							int sage = resultSet.getInt("student_age");
							String addr = resultSet.getString("student_addr");
							System.out.println(sid+"\t"+name+"\t"+sage+"\t"+addr);
						}
					}
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
		}
	}

}
