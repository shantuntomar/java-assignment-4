package PreparedStatementExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadQueryExecution {

	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/java_batch";
		String username = "root";
		String password = "root";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String selectQuery = "select * from user_data";
		
		try {
			connection = DriverManager.getConnection(url , username , password);
			if(connection != null) {
				preparedStatement = connection.prepareStatement(selectQuery);
				if(preparedStatement != null) {
					resultSet = preparedStatement.executeQuery();
				}
				if(resultSet != null) {
					System.out.println("SID\tSNAME\tSAGE");
					while(resultSet.next()) {
						System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3));
					}
				}
			}
		}
		catch(SQLException se) {
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
