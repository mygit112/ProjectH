package DTO;

public class BacSiDTO {
	private String tenbs;
	private String gioitinh;
	private String diachi;
	private String email;
	private String sodienthoai;
	private String chuyenkhoa;
	
	public BacSiDTO() {}

	public BacSiDTO(String tenbs, String gioitinh, String diachi, String email, String sodienthoai, String chuyenkhoa) {
		this.tenbs = tenbs;
		this.gioitinh = gioitinh;
		this.diachi = diachi;
		this.email = email;
		this.sodienthoai = sodienthoai;
		this.chuyenkhoa = chuyenkhoa;
	}

	public String getTenbs() {
		return tenbs;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public String getDiachi() {
		return diachi;
	}

	public String getEmail() {
		return email;
	}

	public String getSodienthoai() {
		return sodienthoai;
	}

	public String getChuyenkhoa() {
		return chuyenkhoa;
	}

	public void setTenbs(String tenbs) {
		this.tenbs = tenbs;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public void setChuyenkhoa(String chuyenkhoa) {
		this.chuyenkhoa = chuyenkhoa;
	}
	
}
