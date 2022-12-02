import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteQuery {

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
					String delete_query = "delete from student where stud_id = 6";
					int noOfRowsDeleted = statement.executeUpdate(delete_query);
					System.out.println("Rows deleted : "+noOfRowsDeleted);
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
