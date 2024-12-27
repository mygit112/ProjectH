package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			String sql = "INSERT INTO `users` (`id`, `username`, `password`, `trangthai`, `phanquyen`) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setInt(1, t.getManv());
			pst.setString(2, t.getUsername());
			pst.setString(3, t.getPasswork());
			pst.setInt(4, t.getTrangthai());
			pst.setInt(5, t.getPhanQuyen());			
			result = pst.executeUpdate();
			JDBCConect.closeConnection(conn);
		} catch (SQLException e) {
			Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return result;
	}

	@Override
	public int update(TaiKhoanDTO t) {
		int result = 0;
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			String sql = "UPDATE `users` SET `username`=?, `password`=? WHERE `id`=?";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, t.getUsername());
			pst.setString(2, t.getPasswork());
			pst.setInt(3, t.getManv());
			result = pst.executeUpdate();
			JDBCConect.closeConnection(conn);
		} catch (SQLException e) {
			Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return result;
	}
	
	// chuc nang xoa tai khoan
	@Override
	public int delete(String t) {
		int result = 0;
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			String sql = "UPDATE `users` SET `trangthai `='-1' WHERE id = ?";
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
		ArrayList<TaiKhoanDTO> result = new ArrayList<TaiKhoanDTO>();
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			String sql = "SELECT * FROM users WHERE trangthai = '1'";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = (ResultSet) pst.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				int trangthai = rs.getInt("trangthai");
				int phanquyen = rs.getInt("phanquyen");
				TaiKhoanDTO tk = new TaiKhoanDTO(id, username, password, trangthai, phanquyen);
				result.add(tk);
			}
		} catch (SQLException e) {
			Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return result;
	}

	@Override
	public TaiKhoanDTO selectById(String t) {
		TaiKhoanDTO result = null;
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			String sql = "SELECT * FROM users WHERE id = ?";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, t);
			ResultSet rs = (ResultSet) pst.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				int trangthai = rs.getInt("trangthai");
				int phanquyen = rs.getInt("phanquyen");
				result = new TaiKhoanDTO(id, username, password, trangthai, phanquyen);
			}
		} catch (SQLException e) {
			Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return result;
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
				int trangthai = rs.getInt("trangthai");
				int phanQuyen = rs.getInt("phanquyen");
				TaiKhoanDTO tk = new TaiKhoanDTO(id, username, password, trangthai, phanQuyen);
				result = tk;
			}
			JDBCConect.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// lay thong tin cua nguoi dang nhap
	
	
}
