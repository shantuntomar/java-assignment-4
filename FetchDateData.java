package DateOperationsExamples;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FetchDateData {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/java_batch";
		String username = "root";
		String password = "root";
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		String selectQuery = "select name , address , DOJ , DOB , DOM from employee";
		
		try {

			connection = DriverManager.getConnection(url , username , password);

			if (connection != null)
				pstmt = connection.prepareStatement(selectQuery);

			if (pstmt != null) {

				if(pstmt != null) {
					resultSet = pstmt.executeQuery();
				}
				if(resultSet != null) {
					System.out.println("NAME\tADDRESS\tDOJ\tDOB\tDOM");
					if(resultSet.next()) {
						String name = resultSet.getString(1);
						String addr = resultSet.getString(2);
						java.sql.Date doj = resultSet.getDate(3);
						SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
						String dojString = sdf.format(doj);
						
						java.sql.Date dob = resultSet.getDate(4);
						SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
						String dojString1 = sdf1.format(doj);
						
						java.sql.Date dom = resultSet.getDate(3);
						SimpleDateFormat sdf2 = new SimpleDateFormat("dd-mm-yyyy");
						String dojString2 = sdf.format(doj);
						
						System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getDate(3) + "\t" + resultSet.getDate(4) + "\t" + resultSet.getDate(5) );
					}
				}
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

	}

}
