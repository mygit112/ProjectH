package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.cj.jdbc.JdbcConnection;

import DTO.QuanLyThuocDTO;
import config.JDBCConect;

public class QuanLyThuocDAO implements DAOInterface<QuanLyThuocDTO> {

	public static QuanLyThuocDAO getInstance() {
		return new QuanLyThuocDAO();
	}
	
	@Override
	public int insert(QuanLyThuocDTO t) {
		int result = 0;
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			String sql = "INSERT INTO `quanlythuoc`(`mathuoc`, `tenthuoc`, `donvitinh`, `gia`, `nhomthuoc`, `soluong`, `trangthai`) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setInt(1, t.getMathuoc());
			pst.setString(2, t.getTenthuoc());
			pst.setString(3, t.getDonvitinh());
			pst.setDouble(4, t.getGia());
			pst.setString(5, t.getNhomthuoc());
			pst.setInt(6, t.getSoluong());
			pst.setInt(7, t.getTrangthai());
			result = pst.executeUpdate();
			JDBCConect.closeConnection(conn);
		} catch (SQLException e) {
			Logger.getLogger(QuanLyThuocDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return result;
	}

	@Override
	public int update(QuanLyThuocDTO t) {
		int result = 0;
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			String sql = "UPDATE `quanlythuoc` SET `tenthuoc` = ?, `donvitinh` = ?, `gia` = ?, `nhomthuoc` = ?, `soluong` = ? WHERE `mathuoc` = ?";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, t.getTenthuoc());
			pst.setString(2, t.getDonvitinh());
			pst.setDouble(3, t.getGia());
			pst.setString(4, t.getNhomthuoc());
			pst.setInt(5, t.getSoluong());
			pst.setInt(6, t.getMathuoc());
			result = pst.executeUpdate();
			JDBCConect.closeConnection(conn);
		} catch (SQLException e) {
			Logger.getLogger(QuanLyThuocDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return result;
	}

	@Override
	public int delete(String t) {
		int result = 0;
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			String sql = "UPDATE `quanlythuoc` SET `trangthai` = 0 WHERE `mathuoc` = ?";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, t);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			Logger.getLogger(BenhNhanDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return result;
	}

	@Override
	public ArrayList<QuanLyThuocDTO> selectAll() {
		ArrayList<QuanLyThuocDTO> result = new ArrayList<QuanLyThuocDTO>();
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			String sql = "SELECT * FROM quanlythuoc WHERE trangthai = 1";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = (ResultSet) pst.executeQuery();
			while(rs.next()) {
				int mathuoc = rs.getInt("mathuoc");
				String tenthuoc = rs.getString("tenthuoc");
				String donvitinh = rs.getString("donvitinh");
				double gia = rs.getDouble("gia");
				String nhomthuoc = rs.getString("nhomthuoc");
				int soluong = rs.getInt("soluong");
				int trangthai = rs.getInt("trangthai");
				QuanLyThuocDTO qlt = new QuanLyThuocDTO(mathuoc, tenthuoc, donvitinh, gia, nhomthuoc, soluong, trangthai);
				result.add(qlt);
			}
			JDBCConect.closeConnection(conn);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public QuanLyThuocDTO selectById(String t) {
		QuanLyThuocDTO result = null;
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			String sql = "SELECT * FROM quanlythuoc WHERE mathuoc=?";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, t);
			ResultSet rs = (ResultSet) pst.executeQuery();
			while(rs.next()) {
				int mathuoc = rs.getInt("id");
				String tenthuoc =  rs.getString("tenthuoc");
				String donvitinh = rs.getString("donvitinh");
				double gia = rs.getDouble("gia");
				String nhomthuoc = rs.getString("nhomthuoc");
				int soluong = rs.getInt("soluong");
				int trangthai = rs.getInt("trangthai");
				result = new QuanLyThuocDTO(mathuoc, tenthuoc, donvitinh, gia, nhomthuoc, soluong, trangthai);
			}
			JDBCConect.closeConnection(conn);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int getAutoIncrement() {
		int result = -1;
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			String sql = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'quanlykhamchuabenh' AND   TABLE_NAME   = 'quanlythuoc'";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(!rs.isBeforeFirst()) {
				System.out.println("No data");
			}else {
				while(rs.next()) {
					result = rs.getInt("AUTO_INCREMENT");
				}
			}
		} catch (SQLException e) {
			Logger.getLogger(QuanLyThuocDTO.class.getName()).log(Level.SEVERE, null, e);
		}
		return result;
	}
	
}
