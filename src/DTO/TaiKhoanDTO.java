package DTO;

public class TaiKhoanDTO {
	private int manv;
	private String username;
	private String passwork;
	private int trangthai;
	private int phanQuyen;
	
	public TaiKhoanDTO() {}

	public TaiKhoanDTO(int manv, String username, String passwork, int trangthai, int phanQuyen) {
		this.manv = manv;
		this.username = username;
		this.passwork = passwork;
		this.trangthai = trangthai;
		this.phanQuyen = phanQuyen;
	}

	public int getManv() {
		return manv;
	}

	public String getUsername() {
		return username;
	}

	public String getPasswork() {
		return passwork;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public int getPhanQuyen() {
		return phanQuyen;
	}

	public void setManv(int manv) {
		this.manv = manv;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPasswork(String passwork) {
		this.passwork = passwork;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public void setPhanQuyen(int phanQuyen) {
		this.phanQuyen = phanQuyen;
	}

	@Override
	public String toString() {
		return "TaiKhoanDTO [manv=" + manv + ", username=" + username + ", passwork=" + passwork + ", trangthai="
				+ trangthai + ", phanQuyen=" + phanQuyen + "]";
	}
	
}
