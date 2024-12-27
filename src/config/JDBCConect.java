package config;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class JDBCConect {
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			String url = "jdbc:mysql://localhost:3306/quanlykhamchuabenh";
            String username = "root";
            String password = "";   
            
            // tao ket noi voi database
            conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không thể kết nối đến cơ sở dữ liệu !", "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
		}
		return conn;
	}
	
	// dong ket noi
	public static void closeConnection(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
