package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.BacSiDTO;
import config.JDBCConect;

public class BacSiDAO implements DAOInterface<BacSiDTO> {

	public static BacSiDAO getInstance() {
		return new BacSiDAO();
	}
	
	@Override
	public int insert(BacSiDTO t) {
		int result = 0;
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			String sql = "INSERT INTO `bacsi` (`id`, `tenbacsi`, `gioitinh`, `diachi`, `email`, `sdt`, `chuyenkhoa`, `trangthai`) VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setInt(1, t.getId());
			pst.setString(2, t.getTenbs());
			pst.setInt(3, t.getGioitinh());
			pst.setString(4, t.getDiachi());
			pst.setString(5, t.getEmail());
			pst.setString(6, t.getSdt());
			pst.setString(7, t.getChuyenkhoa());
			pst.setInt(8, t.getTrangthai());
			result = pst.executeUpdate();
			JDBCConect.closeConnection(conn);
		} catch (SQLException e) {
			Logger.getLogger(BacSiDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return result;
	}

	@Override
	public int update(BacSiDTO t) {
		int result = 0;
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			String sql = "UPDATE `bacsi` SET `tenbacsi`=?, `gioitinh`=?, `diachi`=?, `email`=?, `sdt`=?, `chuyenkhoa`=? WHERE `id`=?";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, t.getTenbs());
			pst.setInt(2, t.getGioitinh());
			pst.setString(3, t.getDiachi());
			pst.setString(4, t.getEmail());
			pst.setString(5, t.getSdt());
			pst.setString(6, t.getChuyenkhoa());
			pst.setInt(7, t.getId());
			result= pst.executeUpdate();
			JDBCConect.closeConnection(conn);
		} catch (SQLException e) {
			Logger.getLogger(BacSiDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return result;
	}

	@Override
	public int delete(String t) {
		int result = 0;
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			//String sql = "UPDATE bacsi SET `trangthai` = -1 WHERE id = ?";
			String sql = "UPDATE `users` SET `trangthai`='-1' WHERE id = ?";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, t);
			result = pst.executeUpdate();
			JDBCConect.closeConnection(conn);
		} catch (SQLException e) {
			Logger.getLogger(BacSiDAO.class.getName()).log(Level.SEVERE, null, e);;
		}
		return result;
	}

	@Override
	public ArrayList<BacSiDTO> selectAll() {
		ArrayList<BacSiDTO> result = new ArrayList<BacSiDTO>();
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			String sql = "SELECT * FROM bacsi WHERE trangthai = '1'";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = (ResultSet) pst.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String tenbs = rs.getString("tenbacsi");
				int gioitinh = rs.getInt("gioitinh");
				String diachi = rs.getString("diachi");
				String email = rs.getString("email");
				String sdt = rs.getString("sdt");
				String chuyenkhoa = rs.getString("chuyenkhoa");
				int trangthai = rs.getInt("trangthai");
				BacSiDTO bs = new BacSiDTO(id, tenbs, gioitinh, diachi, email, sdt, chuyenkhoa, trangthai);
				result.add(bs);
			}
			JDBCConect.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public BacSiDTO selectById(String t) {
		BacSiDTO result = null;
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			String sql = "SELECT * FROM bacsi WHERE id=?";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, t);
			ResultSet rs = (ResultSet) pst.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String tenbs = rs.getString("tenbacsi");
				int gioitinh = rs.getInt("gioitinh");
				String diachi = rs.getString("diachi");
				String email = rs.getString("email");
				String sdt = rs.getString("sdt");
				String chuyenkhoa = rs.getString("chuyenkhoa");
				int trangthai = rs.getInt("trangthai");
				result = new BacSiDTO(id, tenbs, gioitinh, diachi, email, sdt, chuyenkhoa, trangthai);
			}
			JDBCConect.closeConnection(conn);
		} catch (SQLException e) {
			Logger.getLogger(BacSiDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return result;
	}

	@Override
	public int getAutoIncrement() {
		int result = -1;
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			String sql = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'quanlykhamchuabenh' AND   TABLE_NAME   = 'bacsi'";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery(sql);
			if(!rs.isBeforeFirst()) {
				System.out.println("No data");
			}else {
				while(rs.next()) {
					result = rs.getInt("AUTO_INCREMENT");
				}
			}
		} catch (SQLException e) {
			Logger.getLogger(BacSiDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return result;
	}
	
}
