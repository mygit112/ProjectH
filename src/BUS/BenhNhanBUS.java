package BUS;

import java.sql.Date;
import java.util.ArrayList;

import DAO.BenhNhanDAO;
import DTO.BenhNhanDTO;
import GUI.Panel.BenhNhan;
import GUI.Panel.LichSuKham;

public class BenhNhanBUS {
	private BenhNhan bn;
	private LichSuKham ls;
	private final BenhNhanDAO bnDAO = new BenhNhanDAO();
	public ArrayList<BenhNhanDTO> listBN = new ArrayList<BenhNhanDTO>();
	
	public BenhNhanBUS() {
	}
	
	public BenhNhanBUS(LichSuKham ls) {
		this.ls = ls;
		listBN = bnDAO.selectAllComplete();
	}
	
	public BenhNhanBUS(BenhNhan bn) {
		this.bn = bn;
		listBN = bnDAO.selectAll();
	}
	
	public ArrayList<BenhNhanDTO> getListBn(){
		return this.listBN;
	}
	
	public BenhNhanDTO getByIndex(int index) {
		return this.listBN.get(index);
	}
	
	public int getIndexById(int id) {
		int i = 0;
		int vitri = -1;
		int size = this.listBN.size();
		while(i < size && vitri == -1) {
			if(this.listBN.get(i).getMabn() == id) {
				vitri = i;
			}else {
				i++;
			}
		}
		return vitri;
	}
	
	public String getNameById(int id) {
		return bnDAO.selectById(id+"").getHoten();
	}
	
	public String getChuanDoanbyId(int id) {
		return bnDAO.selectById(id+"").getChuandoan();
	}
	
	public Date getNgayTaiKhamById(int id) {
		return bnDAO.selectById(id+"").getNgaytaikham();
	}
	
	// chuc nang them benh nhan
	public Boolean add(BenhNhanDTO bn) {
		boolean check = bnDAO.insert(bn) != 0;
		if(check) {
			this.listBN.add(bn);
		}
		return check;
	}
	
	public void insertBN(BenhNhanDTO bn) {
		listBN.add(bn);
	}
	
	public void update(int index, BenhNhanDTO bn) {
		listBN.set(index, bn);
	}
	
	public void delete(BenhNhanDTO bn) {
		BenhNhanDAO.getInstance().delete(bn.getMabn()+"");
		listBN.removeIf(n ->(n.getMabn() == bn.getMabn()));
		loadTable();
	}
	
	public void complete(BenhNhanDTO bn) {
		BenhNhanDAO.getInstance().complete(bn.getMabn()+"");
		listBN.removeIf(n ->(n.getMabn() == bn.getMabn()));
		loadTable();
	}
	
	public int getIndex() {
		return bn.getRow();
	}
	
	public void loadTable() {
		bn.loadDataTable(listBN);
	}
	
	public String[] getArrGioiTinh() {
		int size = listBN.size();
		String[] result = new String[size];
		for(int i = 0; i < size; i++) {
			result[i] = listBN.get(i).getGioitinh() == 1 ? "Nam" : "Nữ";
		}
		return result;
	}
	
	public String getTenBN(int mabn) {
		return this.listBN.get(getIndexById(mabn)).getHoten();
	}
	
	public ArrayList<BenhNhanDTO> fillter(String input){
		ArrayList<BenhNhanDTO> result = new ArrayList<BenhNhanDTO>();
		for(BenhNhanDTO bn : getListBn()) {
			if(Integer.toString(bn.getMabn()).contains(input)||
					this.getTenBN(bn.getMabn()).toLowerCase().contains(input.toLowerCase())) {
				result.add(bn);
			}
		}
		return result;
	}
	
}
