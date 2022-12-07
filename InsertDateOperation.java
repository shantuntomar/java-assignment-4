package DateOperationsExamples;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class InsertDateOperation {

	public static void main(String[] args) throws ParseException, SQLException {
		
		String url = "jdbc:mysql://localhost:3306/java_batch";
		String username = "root";
		String password = "root";
		
		Connection connection = null;
		PreparedStatement pstmt = null;

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the name:: ");
		String name = scanner.next();
		
		System.out.println("enter the address");
		String addr = scanner.next();
		
		System.out.print("Enter the doj::(dd-mm-YYYY) ");
		String sdoj = scanner.next();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date uDate = sdf.parse(sdoj);
		long time = uDate.getTime();
		java.sql.Date sqlDate = new java.sql.Date(time);
		
		System.out.print("Enter the dob::(mm-dd-yyyy) ");
		String sdob = scanner.next();
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date uDate1 = sdf1.parse(sdoj);
		long time1 = uDate1.getTime();
		java.sql.Date sqlDate1 = new java.sql.Date(time1);
		
		System.out.print("Enter the dom::(yyyy-mm-dd) ");
		String sdom = scanner.next();
		java.sql.Date sqlDate2 = java.sql.Date.valueOf(sdom);
		
		String dateQuery = "Insert into employee(`name` , `address` , `DOJ` , `DOB` , `DOM`) values(? , ? , ? , ? , ?)";
		
		try {

			connection = DriverManager.getConnection(url , username , password);

			if (connection != null)
				pstmt = connection.prepareStatement(dateQuery);

			if (pstmt != null) {
				pstmt.setString(1, name);
				pstmt.setString(2, addr);
				pstmt.setDate(3, sqlDate);
				pstmt.setDate(4, sqlDate1);
				pstmt.setDate(5, sqlDate2);

				int rowAffected = pstmt.executeUpdate();

				System.out.println("No of rows affected is:: " + rowAffected);
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
