package DTO;

import java.sql.Date;

public class BenhNhanDTO {
	private String mabn;
	private String tenbn;
	private Date ngaysinh;
	private int tuoi;
	private String gioitinh;
	private String thannhan;
	private String bhyt;
	private String diachi;
	private String sodienthoai;
	private double cannang;
	private String chuandoan;
	
	public BenhNhanDTO() {}

	public BenhNhanDTO(String mabn, String tenbn, Date ngaysinh, int tuoi, String gioitinh, String thannhan, String bhyt, String diachi,
			String sodienthoai, double cannang, String chuandoan) {
		this.mabn = mabn;
		this.tenbn = tenbn;
		this.ngaysinh = ngaysinh;
		this.tuoi = tuoi;
		this.gioitinh = gioitinh;
		this.thannhan = thannhan;
		this.bhyt = bhyt;
		this.diachi = diachi;
		this.sodienthoai = sodienthoai;
		this.cannang = cannang;
		this.chuandoan = chuandoan;
	}

	public String getMabn() {
		return mabn;
	}
	
	public String getTenbn() {
		return tenbn;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public int getTuoi() {
		return tuoi;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public String getThanNhan() {
		return thannhan;
	}

	public String getBhyt() {
		return bhyt;
	}

	public String getDiachi() {
		return diachi;
	}

	public String getSodienthoai() {
		return sodienthoai;
	}

	public double getCannang() {
		return cannang;
	}

	public String getChuandoan() {
		return chuandoan;
	}

	public void setMabn(String mabn) {
		this.mabn = mabn;
	}
	
	public void setTenbn(String tenbn) {
		this.tenbn = tenbn;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public void setThanNhan(String thannhan) {
		this.thannhan = thannhan;
	}

	public void setBhyt(String bhyt) {
		this.bhyt = bhyt;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public void setCannang(double cannang) {
		this.cannang = cannang;
	}

	public void setChuandoan(String chuandoan) {
		this.chuandoan = chuandoan;
	}
	
	
}
