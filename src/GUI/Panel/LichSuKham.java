package GUI.Panel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;

import GUI.Login;
import GUI.component.IntegratedSearch;
import GUI.component.ScrollBar;
import GUI.component.Table;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.table.DefaultTableModel;

import BUS.BacSiBUS;
import BUS.BenhNhanBUS;
import DTO.BacSiDTO;
import DTO.BenhNhanDTO;
import DTO.TaiKhoanDTO;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LichSuKham extends JPanel implements ActionListener, KeyListener, PropertyChangeListener, ItemListener {

	private static final long serialVersionUID = 1L;
	private Table table;
	private DefaultTableModel model;
	Color FontColor = new Color(96, 125, 139);
	private AddBenhNhan adbn;
	BenhNhanBUS bnBUS = new BenhNhanBUS(this);
	BenhNhanDTO bnDTO = new BenhNhanDTO();
	ArrayList<BenhNhanDTO> listbn = bnBUS.getListBn();
	private TaiKhoanDTO tkDTO;
	private BacSiDTO bsDTO = new BacSiDTO();
	private BacSiBUS bsBUS = new BacSiBUS();
	IntegratedSearch search;

	public LichSuKham(TaiKhoanDTO tkDTO) {
		this.tkDTO = tkDTO;
		
		setBackground(new Color(240, 240, 240));
		setBounds(220, 0, 1130, 729);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 114, 1110, 604);
		panel.setBackground(new Color(255, 255, 255));
		
		model = new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"Mã bệnh nhân", "Tên bệnh nhân", "Tuổi", "Giới tính", "Số BHYT", "Địa chỉ", "SDT",
							"Chiều cao", "Cân nặng", "Ngày khám", "Triệu chứng", "Chuẩn đoán",
							"Lời dặn", "Ngày tái khám", "Bác sĩ khám"
				}
			);
		panel.setLayout(new BorderLayout(0, 0));
		
		table = new Table();
		table.setModel(model);
		table.setFont(new Font("SansSerif", Font.PLAIN, 12));
		table.setBounds(0, 0, 1140, 398);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(table);
		scroll.setVerticalScrollBar(new ScrollBar());
		scroll.setHorizontalScrollBar(new ScrollBar());
		
//        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
//        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        
		// load du lieu cho bang
		loadDataTable(listbn);
		
		panel.add(scroll);
		
		JPanel pnMenuBar = new JPanel();
		pnMenuBar.setBounds(10, 11, 1110, 92);
		pnMenuBar.setBackground(Color.WHITE);
		
//		searchBar = new SearchBar();
//		searchBar.setBounds(474, 11, 631, 71);
//		pnMenuBar.add(searchBar);
		
		search = new IntegratedSearch();
		search.setBounds(630, 9, 452, 71);
		JTextField searchField = search.getTxtSearchForm();
		JButton resetButton = search.getBtnReset();
		searchField.addKeyListener(this);
		resetButton.addActionListener(this);
		pnMenuBar.revalidate();
		pnMenuBar.repaint();
		setLayout(null);
		add(panel);
		add(pnMenuBar);
		pnMenuBar.setLayout(null);
		pnMenuBar.add(search);
		
//		addRow("001", "Nguyễn Văn A", "Nam", "01/01/1990", "Hà Nội");
//        addRow("002", "Trần Thị B", "Nữ", "02/02/1995", "Đà Nẵng");
//        addRow("001", "Nguyễn Văn A", "Nam", "01/01/1990", "Hà Nội");
//        addRow("002", "Trần Thị B", "Nữ", "02/02/1995", "Đà Nẵng");
//        addRow("001", "Nguyễn Văn A", "Nam", "01/01/1990", "Hà Nội");
//        addRow("002", "Trần Thị B", "Nữ", "02/02/1995", "Đà Nẵng");
//        addRow("001", "Nguyễn Văn A", "Nam", "01/01/1990", "Hà Nội");
//        addRow("002", "Trần Thị B", "Nữ", "02/02/1995", "Đà Nẵng");
//        addRow("001", "Nguyễn Văn A", "Nam", "01/01/1990", "Hà Nội");
//        addRow("002", "Trần Thị B", "Nữ", "02/02/1995", "Đà Nẵng");
//        addRow("001", "Nguyễn Văn A", "Nam", "01/01/1990", "Hà Nội");
//        addRow("002", "Trần Thị B", "Nữ", "02/02/1995", "Đà Nẵng");
//        addRow("001", "Nguyễn Văn A", "Nam", "01/01/1990", "Hà Nội");
//        addRow("002", "Trần Thị B", "Nữ", "02/02/1995", "Đà Nẵng");
	}
	
	// ham dung de test du lieu thu cong
//	public void addRow(String maBenhNhan, String tenBenhNhan, String ngayKham, String chuanDoan, String ghiChu) {
//        model.addRow(new Object[] { maBenhNhan, tenBenhNhan, ngayKham, chuanDoan, ghiChu });
//    }
	
	public void eventMouse(JPanel pn, int i) {
	}
	
	public void pnlLogInMousePressed(java.awt.event.MouseEvent evt, int i) throws UnsupportedLookAndFeelException {
        
    }
	
	public void loadDataTable(ArrayList<BenhNhanDTO> list) {
		listbn = list;
		model.setRowCount(0);
		for(BenhNhanDTO bn : listbn) {
			model.addRow(new Object[] {bn.getMabn(), bn.getHoten(), bn.getTuoi(),
					bn.getGioitinh() == 1 ? "Nam" : "Nữ", bn.getBhyt(), bn.getDiachi(),
					bn.getSdt(), bn.getChieucao(), bn.getCannang(), bn.getNgaykham(),
					bn.getTrieuchung(), bn.getChuandoan(), bn.getLoidan(),
					bn.getNgaytaikham(), bsBUS.getNameById(tkDTO.getManv())
			});
		}
	}
	
	public void Fillter() throws ParseException{
		String input = search.txtSearchForm.getText() != null ? search.txtSearchForm.getText() : "";
		System.out.println(input);
		this.listbn = bnBUS.fillter(input);
		loadDataTable(listbn);
	}
	
	public void resetForm() {
		this.listbn = bnBUS.getListBn();
		loadDataTable(listbn);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		try {
			Fillter();
		} catch (ParseException e2) {
			Logger.getLogger(LichSuKham.class.getName()).log(Level.SEVERE, null, e2);
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		try {
			Fillter();
		} catch (ParseException e2) {
			Logger.getLogger(LichSuKham.class.getName()).log(Level.SEVERE, null, e2);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		try {
			Fillter();
		} catch (ParseException e2) {
			Logger.getLogger(LichSuKham.class.getName()).log(Level.SEVERE, null, e2);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == search.getBtnReset()) {
	        resetForm();
	    }
	}
	
//	private void pnlLogInMouseEntered(java.awt.event.MouseEvent evt, JPanel pn) {
//		pn.setBackground(FontColor);
//		pn.setForeground(Color.gray);
//    }
//
//    private void pnlLogInMouseExited(java.awt.event.MouseEvent evt, JPanel pn) {
//    	pn.setBackground(Color.white);
//    	pn.setForeground(Color.white);
//    }
}
