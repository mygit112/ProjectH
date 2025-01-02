package BUS;

import java.util.ArrayList;

import DAO.QuanLyThuocDAO;
import DTO.BacSiDTO;
import DTO.QuanLyThuocDTO;
import GUI.Panel.QuanLyThuoc;

public class QuanLyThuocBUS {
	private final QuanLyThuocDAO qltDAO = new QuanLyThuocDAO();
	public ArrayList<QuanLyThuocDTO> listqlt = new ArrayList<QuanLyThuocDTO>();
	private QuanLyThuoc qlt;
	
	public QuanLyThuocBUS() {
		this.listqlt = qltDAO.selectAll();
	}
	
	public QuanLyThuocBUS(QuanLyThuoc qlt) {
		this.qlt = qlt;
		this.listqlt = QuanLyThuocDAO.getInstance().selectAll();
	}

	public QuanLyThuocDAO getQltDAO() {
		return qltDAO;
	}

	public ArrayList<QuanLyThuocDTO> getListqlt() {
		return listqlt; // ham getall()
	}

	public void setListqlt(ArrayList<QuanLyThuocDTO> listqlt) {
		this.listqlt = listqlt;
	}
	
	public QuanLyThuocDTO getByIndex(int index) {
		return this.listqlt.get(index);
	}
	
	public boolean add(QuanLyThuocDTO qlt) {
		boolean check = qltDAO.insert(qlt) != 0;
		if(check) {
			this.listqlt.add(qlt);
		}
		return check;
	}
	
	public void insertThuoc(QuanLyThuocDTO qlt) {
		listqlt.add(qlt);
	}
	
	public String getNameById(int id) {
		return qltDAO.selectById(id+"").getTenthuoc();
	}
	
	public int getIdByName(String name) {
		return qltDAO.selectedByName(name).getMathuoc();
	}
	
//	public boolean delete(QuanLyThuocDTO qlt, int index) {
//		boolean check = qltDAO.delete(Integer.toString(qlt.getMathuoc())) != 0;
//		// ham delete phia tren chua code
//		if(check) {
//			this.listqlt.remove(index);
//		}
//		return check;
//	}
	
	public void delete(QuanLyThuocDTO qlt) {
		QuanLyThuocDAO.getInstance().delete(qlt.getMathuoc()+"");
		listqlt.removeIf(n -> (n.getMathuoc() == qlt.getMathuoc()));
		loadTable();
	}
	
//	public boolean update(QuanLyThuocDTO qlt) {
//		boolean check = qltDAO.update(qlt) != 0;
//		// ham update phia tren chua code
//		if(check) {
//			this.listqlt.set(getIndexByMaThuoc(qlt.getMathuoc()), qlt);
//		}
//		return check;
//	}
	
	public int getIndexByMaThuoc(int mathuoc) {
		int i = 0;
		int vt = -1;
		while(i < this.listqlt.size() && vt == -1) {
			if(listqlt.get(i).getMathuoc() == mathuoc) {
				vt = i;
			}else {
				i++;
			}
		}
		return vt;
	}
	
	public int getIndex() {
		return qlt.getRow();
	}
	
	public void loadTable() {
		qlt.loadDataTable(listqlt);
	}
	
	public String[] getArrTenDangUong() {
		int size = listqlt.size();
		String[] result = new String[size];
		for(int i = 0; i < size; i++) {
			result[i] = listqlt.get(i).getDonvitinh();
		}
		return result;
	}
	
	public String[] getArrNhomThuoc() {
		int size = listqlt.size();
		String[] result = new String[size];
		for(int i = 0; i < size; i++) {
			result[i] = listqlt.get(i).getNhomthuoc();
		}
		return result;
	}
	
	public ArrayList<String> getArrTenThuoc() {
		int size = listqlt.size();
		ArrayList<String> result = new ArrayList<String>();
		for(int i = 0; i < size; i++) {
			result.add(listqlt.get(i).getTenthuoc());
		}
		return result;
	}
	
	public String getTenThuoc(int id) {
		return this.listqlt.get(getIndexByMaThuoc(id)).getTenthuoc();
	}
	
	public ArrayList<QuanLyThuocDTO> fillterQLT(String input){
		ArrayList<QuanLyThuocDTO> result = new ArrayList<QuanLyThuocDTO>();
		for(QuanLyThuocDTO qlt : getListqlt()) {
			if(Integer.toString(qlt.getMathuoc()).contains(input)||
					this.getTenThuoc(qlt.getMathuoc()).toLowerCase().contains(input.toLowerCase())) {
				result.add(qlt);
			}
		}
		return result;
	}
	
}
