package PreparedStatementExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteQueryExecution {

	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/java_batch";
		String username = "root";
		String password = "root";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String deleteQuery = "delete from user_data where user_id = ?";
		
		try {
			connection = DriverManager.getConnection(url , username , password);
			if(connection != null) {
				preparedStatement = connection.prepareStatement(deleteQuery);
				if(preparedStatement != null) {
					preparedStatement.setInt(1, 3);
					int rowdelete = preparedStatement.executeUpdate();
					System.out.println("row deleted : " + rowdelete);
				}
			}
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			connection.close();
		}
		

	}

}
