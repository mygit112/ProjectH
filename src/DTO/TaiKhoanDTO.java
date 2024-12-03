package DTO;

public class TaiKhoanDTO {
	private int manv;
	private String username;
	private String passwork;
	private int status;
	
	public TaiKhoanDTO() {}
	
	public TaiKhoanDTO(int manv, String username,String passwork, int status) {
		this.manv = manv;
		this.username = username;
		this.passwork = passwork;
		this.status = status;
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

	public int getStatus() {
		return status;
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

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TaiKhoanDTO [manv=" + manv + ", username=" + username + ", passwork=" + passwork + ", status=" + status
				+ "]";
	}
	
}
