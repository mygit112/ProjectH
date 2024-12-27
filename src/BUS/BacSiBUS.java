package BUS;

import java.util.ArrayList;

import DAO.BacSiDAO;
import DAO.TaiKhoanDAO;
import DTO.BacSiDTO;
import GUI.Panel.BacSi;

public class BacSiBUS {
	
	public BacSi bs;
	public ArrayList<BacSiDTO> listBS = BacSiDAO.getInstance().selectAll();
	public BacSiDAO bsDAO = BacSiDAO.getInstance();
	
	public BacSiBUS() {
	}
	
	public BacSiBUS(BacSi bs) {
		this.bs = bs;
		this.listBS = BacSiDAO.getInstance().selectAll();
	}

	public ArrayList<BacSiDTO> getListBS() {
		return listBS;
	}

	public BacSiDAO getBsDAO() {
		return bsDAO;
	}

	public void setListBS(ArrayList<BacSiDTO> listBS) {
		this.listBS = listBS;
	}

	public void setBsDAO(BacSiDAO bsDAO) {
		this.bsDAO = bsDAO;
	}
	
	public int getIndexById(int id) {
		int i = 0;
		int vitri = -1;
		int size = this.listBS.size();
		while(i < size && vitri == -1) {
			if(this.listBS.get(i).getId() == id) {
				vitri = i;
			}else {
				i++;
			}
		}
		return vitri;
	}
	
	public String getNameById(int id) {
		return bsDAO.selectById(id+"").getTenbs();
	}
	
	public String[] getArrTenBacSi() {
		int size = listBS.size();
		String[] result = new String[size];
		for(int i=0;i<size;i++) {
			result[i] = listBS.get(i).getTenbs();
		}
		return result;
	}
	
	public void insertBS(BacSiDTO bs) {
		listBS.add(bs);
	}
	
	public void updateBS(int index, BacSiDTO bs) {
		listBS.set(index, bs);
	}
	
	public int getIndex() {
		return bs.getRow();
	}
	
	public void deleteBS(BacSiDTO bs) {
		BacSiDAO.getInstance().delete(bs.getId()+"");
		TaiKhoanDAO.getInstance().delete(bs.getId()+"");
		listBS.removeIf(n ->(n.getId() == bs.getId()));
		loadTable();
	}
	
	public void loadTable() {
		bs.loadDataTable(listBS);
	}
	
	public void searchLoadTable(ArrayList<BacSiDTO> list) {
		bs.loadDataTable(list);
	}
	
	public String getTenBS(int id) {
		return this.listBS.get(getIndexById(id)).getTenbs();
	}
	
	public ArrayList<BacSiDTO> fillterBacSi(String input){
		ArrayList<BacSiDTO> result = new ArrayList<BacSiDTO>();
		for(BacSiDTO bs : getListBS()) {
			if(Integer.toString(bs.getId()).contains(input)||
					this.getTenBS(bs.getId()).toLowerCase().contains(input.toLowerCase())) {
				result.add(bs);
			}
		}
		return result;
	}
}
