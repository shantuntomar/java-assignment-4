package PreparedStatementExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateQueryExecution {

	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/java_batch";
		String username = "root";
		String password = "root";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String updateQuery = "update user_data set user_age = 22 where user_id = ?";
		
		try {
			connection = DriverManager.getConnection(url , username , password);
			if(connection != null) {
				preparedStatement = connection.prepareStatement(updateQuery);
				if(preparedStatement != null) {
					preparedStatement.setInt(1, 2);
					int rowUpdated = preparedStatement.executeUpdate();
					System.out.println("number of rows updated : " + rowUpdated);
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
