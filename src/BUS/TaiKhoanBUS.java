package BUS;

import java.util.ArrayList;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import GUI.Panel.BacSi;

public class TaiKhoanBUS {
	private BacSi bs;
	private ArrayList<TaiKhoanDTO> listtk = TaiKhoanDAO.getInstance().selectAll();
}
