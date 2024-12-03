package DTO;

public class QuanLyThuocDTO {
	private String mathuoc;
	private String tenthuoc;
	private String donvitinh;
	private double gia;
	private String nhomthuoc;
	
	public QuanLyThuocDTO() {}

	public QuanLyThuocDTO(String mathuoc, String tenthuoc, String donvitinh, double gia, String nhomthuoc) {
		this.mathuoc = mathuoc;
		this.tenthuoc = tenthuoc;
		this.donvitinh = donvitinh;
		this.gia = gia;
		this.nhomthuoc = nhomthuoc;
	}

	public String getMathuoc() {
		return mathuoc;
	}

	public String getTenthuoc() {
		return tenthuoc;
	}

	public String getDonvitinh() {
		return donvitinh;
	}

	public double getGia() {
		return gia;
	}

	public String getNhomthuoc() {
		return nhomthuoc;
	}

	public void setMathuoc(String mathuoc) {
		this.mathuoc = mathuoc;
	}

	public void setTenthuoc(String tenthuoc) {
		this.tenthuoc = tenthuoc;
	}

	public void setDonvitinh(String donvitinh) {
		this.donvitinh = donvitinh;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public void setNhomthuoc(String nhomthuoc) {
		this.nhomthuoc = nhomthuoc;
	}
	
	
}
