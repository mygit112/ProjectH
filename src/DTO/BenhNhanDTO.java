package DTO;

import java.sql.Date;

public class BenhNhanDTO {
	private int mabn;
	private String hoten;
	private int tuoi;
	private int gioitinh;
	private String bhyt;
	private String diachi;
	private String sdt;
	private int chieucao;
	private int cannang;
	private Date ngaykham;
	private String trieuchung;
	private String chuandoan;
	private String loidan;
	private Date ngaytaikham;
	private int bacsiid;
	private int trangthai;
	
	public BenhNhanDTO() {
	}
	
	public BenhNhanDTO(int mabn, String hoten, int tuoi, int gioitinh, String bhyt, String diachi, String sdt,
			int chieucao, int cannang, Date ngaykham, String trieuchung, String chuandoan, String loidan,
			Date ngaytaikham, int bacsiid, int trangthai) {
		this.mabn = mabn;
		this.hoten = hoten;
		this.tuoi = tuoi;
		this.gioitinh = gioitinh;
		this.bhyt = bhyt;
		this.diachi = diachi;
		this.sdt = sdt;
		this.chieucao = chieucao;
		this.cannang = cannang;
		this.ngaykham = ngaykham;
		this.trieuchung = trieuchung;
		this.chuandoan = chuandoan;
		this.loidan = loidan;
		this.ngaytaikham = ngaytaikham;
		this.bacsiid = bacsiid;
		this.trangthai = trangthai;
	}

	public int getMabn() {
		return mabn;
	}

	public String getHoten() {
		return hoten;
	}

	public int getTuoi() {
		return tuoi;
	}

	public int getGioitinh() {
		return gioitinh;
	}

	public String getBhyt() {
		return bhyt;
	}

	public String getDiachi() {
		return diachi;
	}

	public String getSdt() {
		return sdt;
	}

	public int getChieucao() {
		return chieucao;
	}

	public int getCannang() {
		return cannang;
	}

	public Date getNgaykham() {
		return ngaykham;
	}

	public String getTrieuchung() {
		return trieuchung;
	}

	public String getChuandoan() {
		return chuandoan;
	}

	public String getLoidan() {
		return loidan;
	}

	public Date getNgaytaikham() {
		return ngaytaikham;
	}

	public int getBacsiid() {
		return bacsiid;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setMabn(int mabn) {
		this.mabn = mabn;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public void setGioitinh(int gioitinh) {
		this.gioitinh = gioitinh;
	}

	public void setBhyt(String bhyt) {
		this.bhyt = bhyt;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public void setChieucao(int chieucao) {
		this.chieucao = chieucao;
	}

	public void setCannang(int cannang) {
		this.cannang = cannang;
	}

	public void setNgaykham(Date ngaykham) {
		this.ngaykham = ngaykham;
	}

	public void setTreuchung(String trieuchung) {
		this.trieuchung = trieuchung;
	}

	public void setChuandoan(String chuandoan) {
		this.chuandoan = chuandoan;
	}

	public void setLoidan(String loidan) {
		this.loidan = loidan;
	}

	public void setNgaytaikham(Date ngaytaikham) {
		this.ngaytaikham = ngaytaikham;
	}

	public void setBacsiid(int bacsiid) {
		this.bacsiid = bacsiid;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}
	
}
