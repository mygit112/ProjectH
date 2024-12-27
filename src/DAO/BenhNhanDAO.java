package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.BenhNhanDTO;
import config.JDBCConect;

public class BenhNhanDAO implements DAOInterface<BenhNhanDTO> {

	public static BenhNhanDAO getInstance() {
		return new BenhNhanDAO();
	}
	
	// chuc nang them benh nhan
	@Override
	public int insert(BenhNhanDTO t) {
		int result = 0;
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			String sql = "INSERT INTO `benhnhan` (`mabn`, `hoten`, `tuoi`, `gioitinh`, `bhyt`, `diachi`, `sdt`, `chieucao`, `cannang`, `ngaykham`, `trieuchung`, `chuandoan`, `loidan`, `ngaytaikham`, `bacsi_id`, `trangthai`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setInt(1, t.getMabn());
			pst.setString(2, t.getHoten());
			pst.setInt(3, t.getTuoi());
			pst.setInt(4, t.getGioitinh());
			pst.setString(5, t.getBhyt());
			pst.setString(6, t.getDiachi());
			pst.setString(7, t.getSdt());
			pst.setInt(8, t.getChieucao());
			pst.setInt(9, t.getCannang());
			pst.setDate(10, t.getNgaykham());
			pst.setString(11, t.getTrieuchung());
			pst.setString(12, t.getChuandoan());
			pst.setString(13, t.getLoidan());
			pst.setDate(14, t.getNgaytaikham());
			pst.setInt(15, t.getBacsiid());
			pst.setInt(16, t.getTrangthai());
			result = pst.executeUpdate();
			JDBCConect.closeConnection(conn);
		} catch (Exception e) {
			Logger.getLogger(BenhNhanDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return result;
	}

	@Override
	public int update(BenhNhanDTO t) {
		int result = 0;
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			String sql = "UPDATE `benhnhan` SET `hoten`=?, `tuoi`=?, `gioitinh`=?, `bhyt`=?, `diachi`=?, `sdt`=?, `chieucao`=?, `cannang`=?, `trieuchung`=? WHERE `mabn`=?";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, t.getHoten());
			pst.setInt(2, t.getTuoi());
			pst.setInt(3, t.getGioitinh());
			pst.setString(4, t.getBhyt());
			pst.setString(5, t.getDiachi());
			pst.setString(6, t.getSdt());
			pst.setInt(7, t.getChieucao());
			pst.setInt(8, t.getCannang());
			pst.setString(9, t.getTrieuchung());
			pst.setInt(10, t.getMabn());
			result = pst.executeUpdate();
			JDBCConect.closeConnection(conn);
		} catch (SQLException e) {
			Logger.getLogger(BenhNhanDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return result;
	}
	
	public int updateMore(BenhNhanDTO t) {
		int result = 0;
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			String sql = "UPDATE `benhnhan` SET `chuandoan`=?, `loidan`=?, `ngaytaikham`=? WHERE `mabn`=?";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, t.getChuandoan());
			pst.setString(2, t.getLoidan());
			pst.setDate(3, t.getNgaytaikham());
			pst.setInt(4, t.getMabn());
			result = pst.executeUpdate();
			JDBCConect.closeConnection(conn);
		} catch (SQLException e) {
			Logger.getLogger(BenhNhanDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return result;
	}

	@Override
	public int delete(String t) {
		int result = 0;
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			 //String sql = "UPDATE `benhnhan` SET `trangthai` = '0' WHERE `mabn` = ?";
			String sql = "DELETE FROM `benhnhan` WHERE `mabn` = ?";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, t);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			Logger.getLogger(BenhNhanDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return result;
	}
	
	public int complete(String t) {
		int result = 0;
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			String sql = "UPDATE `benhnhan` SET `trangthai` = '0' WHERE `mabn` = ?";
			// String sql = "DELETE FROM `benhnhan` WHERE `mabn` = ?";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, t);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			Logger.getLogger(BenhNhanDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return result;
	}
	
	@Override
	public ArrayList<BenhNhanDTO> selectAll() {
		ArrayList<BenhNhanDTO> result = new ArrayList<BenhNhanDTO>();
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			String sql = "SELECT * FROM benhnhan WHERE trangthai=1";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = (ResultSet) pst.executeQuery();
			while(rs.next()) {
				int mabn = rs.getInt("mabn");
				String hoten = rs.getString("hoten");
				int tuoi = rs.getInt("tuoi");
				int gioitinh = rs.getInt("gioitinh");
				String bhyt = rs.getString("bhyt");
				String diachi = rs.getString("diachi");
				String sdt = rs.getString("sdt");
				int chieucao = rs.getInt("chieucao");
				int cannang = rs.getInt("cannang");
				Date ngaykham = rs.getDate("ngaykham");
				String trieuchung = rs.getString("trieuchung");
				String chuandoan = rs.getString("chuandoan");
				String loidan = rs.getString("loidan");
				Date ngaytaikham = rs.getDate("ngaytaikham");
				int bacsiid = rs.getInt("bacsi_id");
				int trangthai = rs.getInt("trangthai");
				BenhNhanDTO bn = new BenhNhanDTO(mabn, hoten, tuoi, gioitinh, bhyt, diachi, sdt, chieucao, cannang, ngaykham, trieuchung, chuandoan, loidan, ngaytaikham, bacsiid, trangthai);
				result.add(bn);
			}
			JDBCConect.closeConnection(conn);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	public ArrayList<BenhNhanDTO> selectAllPDF(String t) {
		ArrayList<BenhNhanDTO> result = new ArrayList<BenhNhanDTO>();
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			String sql = "SELECT * FROM benhnhan WHERE mabn=?";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, sql);
			ResultSet rs = (ResultSet) pst.executeQuery();
			while(rs.next()) {
				int mabn = rs.getInt("mabn");
				String hoten = rs.getString("hoten");
				int tuoi = rs.getInt("tuoi");
				int gioitinh = rs.getInt("gioitinh");
				String bhyt = rs.getString("bhyt");
				String diachi = rs.getString("diachi");
				String sdt = rs.getString("sdt");
				int chieucao = rs.getInt("chieucao");
				int cannang = rs.getInt("cannang");
				Date ngaykham = rs.getDate("ngaykham");
				String trieuchung = rs.getString("trieuchung");
				String chuandoan = rs.getString("chuandoan");
				String loidan = rs.getString("loidan");
				Date ngaytaikham = rs.getDate("ngaytaikham");
				int bacsiid = rs.getInt("bacsi_id");
				int trangthai = rs.getInt("trangthai");
				BenhNhanDTO bn = new BenhNhanDTO(mabn, hoten, tuoi, gioitinh, bhyt, diachi, sdt, chieucao, cannang, ngaykham, trieuchung, chuandoan, loidan, ngaytaikham, bacsiid, trangthai);
				result.add(bn);
			}
			JDBCConect.closeConnection(conn);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	public ArrayList<BenhNhanDTO> selectAllComplete(){
		ArrayList<BenhNhanDTO> result = new ArrayList<BenhNhanDTO>();
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			String sql = "SELECT * FROM benhnhan WHERE trangthai=0";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = (ResultSet) pst.executeQuery();
			while(rs.next()) {
				int mabn = rs.getInt("mabn");
				String hoten = rs.getString("hoten");
				int tuoi = rs.getInt("tuoi");
				int gioitinh = rs.getInt("gioitinh");
				String bhyt = rs.getString("bhyt");
				String diachi = rs.getString("diachi");
				String sdt = rs.getString("sdt");
				int chieucao = rs.getInt("chieucao");
				int cannang = rs.getInt("cannang");
				Date ngaykham = rs.getDate("ngaykham");
				String trieuchung = rs.getString("trieuchung");
				String chuandoan = rs.getString("chuandoan");
				String loidan = rs.getString("loidan");
				Date ngaytaikham = rs.getDate("ngaytaikham");
				int bacsiid = rs.getInt("bacsi_id");
				int trangthai = rs.getInt("trangthai");
				BenhNhanDTO bn = new BenhNhanDTO(mabn, hoten, tuoi, gioitinh, bhyt, diachi, sdt, chieucao, cannang, ngaykham, trieuchung, chuandoan, loidan, ngaytaikham, bacsiid, trangthai);
				result.add(bn);
			}
			JDBCConect.closeConnection(conn);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public BenhNhanDTO selectById(String t) {
		BenhNhanDTO result = null;
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			String sql = "SELECT * FROM benhnhan WHERE mabn=?";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, t);
			ResultSet rs = (ResultSet) pst.executeQuery();
			while(rs.next()) {
				int mabn = rs.getInt("mabn");
				String hoten = rs.getString("hoten");
				int tuoi = rs.getInt("tuoi");
				int gioitinh = rs.getInt("gioitinh");
				String bhyt = rs.getString("bhyt");
				String diachi = rs.getString("diachi");
				String sdt = rs.getString("sdt");
				int chieucao = rs.getInt("chieucao");
				int cannang = rs.getInt("cannang");
				Date ngaykham = rs.getDate("ngaykham");
				String trieuchung = rs.getString("trieuchung");
				String chuandoan = rs.getString("chuandoan");
				String loidan = rs.getString("loidan");
				Date ngaytaikham = rs.getDate("ngaytaikham");
				int bacsiid = rs.getInt("bacsi_id");
				int trangthai = rs.getInt("trangthai");
				result = new BenhNhanDTO(mabn, hoten, tuoi, gioitinh, bhyt, diachi, sdt, chieucao, cannang, ngaykham, trieuchung, chuandoan, loidan, ngaytaikham, bacsiid, trangthai);
			}
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
			String sql = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'quanlykhamchuabenh' AND   TABLE_NAME   = 'benhnhan'";
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
			Logger.getLogger(BenhNhanDAO.class.getName()).log(Level.SEVERE, null ,e);
		}
		return result;
	}

}
