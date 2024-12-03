package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.BenhNhanDTO;
import config.JDBCConect;

public class BenhNhanDAO implements DAOInterface<BenhNhanDTO> {

	public static BenhNhanDAO getInstace() {
		return new BenhNhanDAO();
	}
	
	// chuc nang them benh nhan
	@Override
	public int insert(BenhNhanDTO t) {
		int result = 0;
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			String sql = "INSERT INTO `benhnhan` (`tenbenhnhan`, `ngaysinh`, `tuoi`, `gioitinh`, `thannhan`, `bhyt`, `diachi`, `sdt`, `cannang`, `chuandoan`";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, t.getTenbn());
			pst.setDate(2, t.getNgaysinh());
			pst.setInt(3, t.getTuoi());
			pst.setString(4, t.getGioitinh());
			pst.setString(5, t.getThanNhan());
			pst.setString(6, t.getBhyt());
			pst.setString(7, t.getDiachi());
			pst.setString(8, t.getSodienthoai());
			pst.setDouble(9, t.getCannang());
			pst.setString(10, t.getChuandoan());
			result = pst.executeUpdate();
			JDBCConect.closeConnection(conn);
		} catch (Exception e) {
			Logger.getLogger(BenhNhanDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return result;
	}

	@Override
	public int update(BenhNhanDTO t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String t) {
		int result = 0;
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			// String sql = "UPDATE `benhnhan` SET `"
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	// chua code xong (trang thai ???)
	@Override
	public ArrayList<BenhNhanDTO> selectAll() {
		ArrayList<BenhNhanDTO> result = new ArrayList<BenhNhanDTO>();
		try {
			Connection conn = (Connection) JDBCConect.getConnection();
			String sql = "SELECT * FROM benhnhan";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = (ResultSet) pst.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String tenbn = rs.getString("tenbenhnhan");
				Date ngaysinh = rs.getDate("ngaysinh");
				int tuoi = rs.getInt("tuoi");
				String gioitinh = rs.getString("gioitinh");
				String thannhan = rs.getString("thannhan"); //
				String bhyt = rs.getString("bhyt");
				String diachi = rs.getString("diachi");
				String sdt = rs.getString("sdt"); //
				double cannang = rs.getDouble("cannang");
				String chuandoan = rs.getString("chuandoan");
				//
			}
			JDBCConect.closeConnection(conn);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public BenhNhanDTO selectById(String t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAutoIncrement() {
		// TODO Auto-generated method stub
		return 0;
	}

}
