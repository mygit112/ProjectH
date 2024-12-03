package BUS;

import java.util.ArrayList;

import DAO.BenhNhanDAO;
import DTO.BenhNhanDTO;
import GUI.Panel.BenhNhan;

public class BenhNhanBUS {
	private final BenhNhanDAO bnDAO = new BenhNhanDAO();
	public ArrayList<BenhNhanDTO> listBenhNhan = new ArrayList<BenhNhanDTO>();
	
	public BenhNhanBUS() {
		listBenhNhan = bnDAO.selectAll();
	}
	
	public ArrayList<BenhNhanDTO> getAll(){
		return this.listBenhNhan;
	}
	
	public BenhNhanDTO getByIndex(int index) {
		return this.listBenhNhan.get(index);
	}
	
	// chuc nang them benh nhan
	public Boolean add(BenhNhanDTO bn) {
		boolean check = bnDAO.insert(bn) != 0;
		if(check) {
			this.listBenhNhan.add(bn);
		}
		return check;
	}
	
	public boolean update(BenhNhanDTO bn) {
		boolean check = bnDAO.update(bn) != 0;
		if(check) {
			// this.listBenhNhan.set(getin, bn)
		}
		return check;
	}
	
	public boolean delete(BenhNhanDTO bn) {
		boolean check = bnDAO.delete(bn.getMabn()) != 0;
		if(check) {
			this.listBenhNhan.remove(bn);
		}
		return check;
	}
}
