package DTO;

public class BacSiDTO {
	private int id;
	private String tenbs;
	private int gioitinh;
	private String diachi;
	private String email;
	private String sdt;
	private String chuyenkhoa;
	private int trangthai;
	
	public BacSiDTO() {}

	public BacSiDTO(int id, String tenbs, int gioitinh, String diachi, String email, String sdt, String chuyenkhoa,
			int trangthai) {
		this.id = id;
		this.tenbs = tenbs;
		this.gioitinh = gioitinh;
		this.diachi = diachi;
		this.email = email;
		this.sdt = sdt;
		this.chuyenkhoa = chuyenkhoa;
		this.trangthai = trangthai;
	}

	public int getId() {
		return id;
	}

	public String getTenbs() {
		return tenbs;
	}

	public int getGioitinh() {
		return gioitinh;
	}

	public String getDiachi() {
		return diachi;
	}

	public String getEmail() {
		return email;
	}

	public String getSdt() {
		return sdt;
	}

	public String getChuyenkhoa() {
		return chuyenkhoa;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTenbs(String tenbs) {
		this.tenbs = tenbs;
	}

	public void setGioitinh(int gioitinh) {
		this.gioitinh = gioitinh;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public void setChuyenkhoa(String chuyenkhoa) {
		this.chuyenkhoa = chuyenkhoa;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}
	
}