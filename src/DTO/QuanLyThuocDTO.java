package DTO;

public class QuanLyThuocDTO {
	private int mathuoc;
	private String tenthuoc;
	private String donvitinh;
	private double gia;
	private String nhomthuoc;
	private int soluong;
	private int trangthai;
	
	public QuanLyThuocDTO() {}

	public QuanLyThuocDTO(int mathuoc, String tenthuoc, String donvitinh, double gia, String nhomthuoc, int soluong,
			int trangthai) {
		super();
		this.mathuoc = mathuoc;
		this.tenthuoc = tenthuoc;
		this.donvitinh = donvitinh;
		this.gia = gia;
		this.nhomthuoc = nhomthuoc;
		this.soluong = soluong;
		this.trangthai = trangthai;
	}

	public int getMathuoc() {
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

	public int getSoluong() {
		return soluong;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setMathuoc(int mathuoc) {
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

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

}
