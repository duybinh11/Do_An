package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sql {
	public static Connection ket_noi() { 
		Connection conn =null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			try {
				conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=THU_VIEN_5;user=sa;password=Duybinh1412");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
