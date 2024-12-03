package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.TaiKhoanDTO;
import config.JDBCConect;

public class TaiKhoanDAO implements DAOInterface<TaiKhoanDTO> {
	
	public static TaiKhoanDAO getInstance(){
        return new TaiKhoanDAO();
    }

	// chuc nang them tai khoan
	@Override
	public int insert(TaiKhoanDTO t) {
		int result = 0;
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			String sql = "INSERT INTO `users` (`id`, `username`, `password`, `status`) VALUES (?, ?, ?, ?)";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setInt(1, t.getManv());
			pst.setString(2, t.getUsername());
			pst.setString(3, t.getPasswork());
			pst.setInt(4, t.getStatus());
			result = pst.executeUpdate();
			JDBCConect.closeConnection(conn);
		} catch (Exception e) {
			Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return result;
	}

	@Override
	public int update(TaiKhoanDTO t) {
		
		return 0;
	}
	
	// chuc nang xoa tai khoan
	@Override
	public int delete(String t) {
		int result = 0;
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			String sql = "UPDATE `users` SET `status `='-1' WHERE id = ?";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setInt(1, Integer.parseInt(sql));
			result = pst.executeUpdate();
			JDBCConect.closeConnection(conn);
		} catch (Exception e) {
			Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return result;
	}

	@Override
	public ArrayList<TaiKhoanDTO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaiKhoanDTO selectById(String t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAutoIncrement() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	// check tai khoan truoc khi dang nhap vao main
	public TaiKhoanDTO selectByUser(String t) {
		TaiKhoanDTO result = null;
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			String sql = "SELECT * FROM users WHERE username=?";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, t);
			ResultSet rs = (ResultSet) pst.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				int status = rs.getInt("status");
				TaiKhoanDTO tk = new TaiKhoanDTO(id, username, password, status);
				result = tk;
			}
			JDBCConect.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
