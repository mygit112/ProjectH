package DAO;

import java.util.ArrayList;

import DTO.BenhNhanDTO;

public class LichSuKhamDAO implements DAOInterface<BenhNhanDTO> {
	
	public static LichSuKhamDAO getInstance() {
		return new LichSuKhamDAO();
	}
	
	@Override
	public int insert(BenhNhanDTO t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BenhNhanDTO t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<BenhNhanDTO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BenhNhanDTO selectById(String t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAutoIncrement() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
