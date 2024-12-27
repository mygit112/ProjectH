package GUI.Panel;

import java.awt.Color;
import java.awt.Font;
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
import java.lang.reflect.Array;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import BUS.QuanLyThuocBUS;
import DTO.QuanLyThuocDTO;
import DTO.TaiKhoanDTO;
import GUI.Login;
import GUI.component.IntegratedSearch;
import GUI.component.ScrollBar;
import GUI.component.Table;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.FlowLayout;

public class QuanLyThuoc extends JPanel implements ActionListener, KeyListener, PropertyChangeListener, ItemListener {

	private static final long serialVersionUID = 1L;
	protected Table table;
	protected DefaultTableModel model;
	Color FontColor = new Color(96, 125, 139);
	private AddDonThuoc addDonThuoc;
	protected int selectedRow;
	private QuanLyThuocBUS qltBUS = new QuanLyThuocBUS(this);
	private QuanLyThuocDTO qltDTO = new QuanLyThuocDTO();
	private ArrayList<QuanLyThuocDTO> listqlt = qltBUS.getListqlt();
	private TaiKhoanDTO tkDTO;
	private IntegratedSearch search;
	
	public QuanLyThuoc(TaiKhoanDTO tkDTO) {
		this.tkDTO = tkDTO;
		
		setBackground(new Color(240, 240, 240));
		setBounds(220, 0, 1130, 729);
		
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 114, 1115, 604);
		panel.setLayout(null);
		
		model = new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"Mã thuốc", "Tên thuốc", "Đơn vị tính", "Giá", "Nhóm thuốc", "Số lượng"
				}
			);
		
		// lay du lieu tu database hien thi len bang
		loadDataTable(listqlt);
		add(panel);
		
		JPanel pnMenuBar = new JPanel();
		pnMenuBar.setBackground(Color.WHITE);
		pnMenuBar.setBounds(10, 11, 1115, 92);
		pnMenuBar.revalidate();
		pnMenuBar.repaint();
		
		add(pnMenuBar);
		
		JPanel pnAdd = new JPanel();
		pnAdd.setBounds(10, 10, 114, 70);
		pnAdd.setBackground(Color.WHITE);
		
		JLabel lblIconAdd = new JLabel("");
		lblIconAdd.setIcon(new ImageIcon(QuanLyThuoc.class.getResource("/Entity/add.png")));
		
		JLabel lblAdd = new JLabel("Thêm");
		lblAdd.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		JPanel pnModify = new JPanel();
		pnModify.setBounds(134, 10, 106, 70);
		pnModify.setBackground(Color.WHITE);
		
		JLabel lblModifyIcon = new JLabel("");
		lblModifyIcon.setIcon(new ImageIcon(QuanLyThuoc.class.getResource("/Entity/pencil.png")));
		
		JLabel lblModify = new JLabel("Sửa");
		lblModify.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		JPanel pnDelete = new JPanel();
		pnDelete.setBounds(250, 10, 104, 70);
		pnDelete.setBackground(Color.WHITE);
		
		JLabel lblDelete = new JLabel("Xoá");
		lblDelete.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		// xu ly xu kien chuot
		eventMouse(pnAdd, 1);
		eventMouse(pnModify, 2);
		eventMouse(pnDelete, 3);
		pnMenuBar.setLayout(null);
		pnAdd.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pnAdd.add(lblIconAdd);
		pnAdd.add(lblAdd);
		pnModify.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pnModify.add(lblModifyIcon);
		pnModify.add(lblModify);
		pnMenuBar.setLayout(null);
		pnMenuBar.add(pnAdd);
		pnMenuBar.add(pnModify);
		pnMenuBar.add(pnDelete);
		pnDelete.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblDeleteIcon = new JLabel("");
		lblDeleteIcon.setIcon(new ImageIcon(QuanLyThuoc.class.getResource("/Entity/delete.png")));
		pnDelete.add(lblDeleteIcon);
		pnDelete.add(lblDelete);
		
		search = new IntegratedSearch();
		JTextField searchField = search.getTxtSearchForm();
		JButton resetButton = search.getBtnReset();
		search.setBounds(630, 9, 452, 71);
		searchField.addKeyListener(this);
		resetButton.addActionListener(this);
		pnMenuBar.add(search);
		
		table = new Table();
		table.setModel(model);
		table.setFont(new Font("SansSerif", Font.PLAIN, 12));
		table.setBounds(0, 0, 1140, 398);
		
		// xu ly su kien nhan vao bang
		tableAction(table);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(0, 0, 1115, 604);
		panel.add(scroll);
		scroll.setViewportView(table);
		scroll.setVerticalScrollBar(new ScrollBar());
		
//		addRow("001", "Nguyễn Văn A", "Nam", 10000, "Hà Nội");
//        addRow("002", "Trần Thị B", "Nữ", 10000, "Đà Nẵng");
//        addRow("001", "Nguyễn Văn A", "Nam", 10000, "Hà Nội");
//        addRow("002", "Trần Thị B", "Nữ", 10000, "Đà Nẵng");
//        addRow("001", "Nguyễn Văn A", "Nam", 10000, "Hà Nội");
	}
	
//	public void addRow(String maThuoc, String tenThuoc, String donVi, double gia, String nhomThuoc) {
//        model.addRow(new Object[] { maThuoc, tenThuoc, donVi, gia, nhomThuoc });
//    }
	
	public void loadTable() {
		addDonThuoc.loadDataTable(null);
	}
	
	public void eventMouse(JPanel pn, int i) {
		pn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
            	pn.setBackground(FontColor);
        		pn.setForeground(Color.gray);
            }
            
            @Override
            public void mousePressed(MouseEvent evt) {
                try {
                    pnlLogInMousePressed(evt, i);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseExited(MouseEvent evt) {
            	pn.setBackground(Color.white);
            	pn.setForeground(Color.white);
            }
        });
	}
	
	public void pnlLogInMousePressed(java.awt.event.MouseEvent evt, int i) throws UnsupportedLookAndFeelException {
        if(i == 1) {
        	// chuc nang them
        	if(tkDTO.getPhanQuyen() != 1) {
        		JOptionPane.showMessageDialog(null, "Bạn không có quyền thực hiện chức năng này!", "Cảnh báo!", JOptionPane.ERROR_MESSAGE);
        	}else {
        		addDonThuoc = new AddDonThuoc(qltDTO, qltBUS, this, "them", "THÊM THUỐC");
            	addDonThuoc.setVisible(true);
        	}
        }else if(i == 2) {
        	// chuc nang sua
        	if(tkDTO.getPhanQuyen() != 1) {
        		JOptionPane.showMessageDialog(null, "Bạn không có quyền thực hiện chức năng này!", "Cảnh báo!", JOptionPane.ERROR_MESSAGE);
        	}else {
        		selectedRow = getRowSelected();
            	if(selectedRow != -1) {
            		addDonThuoc = new AddDonThuoc(qltDTO, qltBUS, this, "sua", "SỬA THUỐC");
                	addDonThuoc.setVisible(true);
            	}
        	}
        }else if(i == 3) {
        	// chuc nang xoa
        	if(tkDTO.getPhanQuyen() != 1) {
        		JOptionPane.showMessageDialog(null, "Bạn không có quyền thực hiện chức năng này!", "Cảnh báo!", JOptionPane.ERROR_MESSAGE);
        	}else {
        		selectedRow = getRowSelected();
            	if(selectedRow != -1) {
            		int input = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa?", "Xoá thuốc", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            		if(input == 0) {
            			qltBUS.delete(listqlt.get(selectedRow));
            			loadDataTable(listqlt);
            		}
            	}
        	}
        }
    }
	
	public int getRow() {
		return table.getSelectedRow();
	}
	
	public int getRowSelected() {
		int selected = table.getSelectedRow();
		if(selected == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn một thuốc.", "Thông báo", JOptionPane.WARNING_MESSAGE);
		}
		return selected;
	}
	
	public QuanLyThuocDTO getThuoc() {
		return listqlt.get(table.getSelectedRow());
	}
	
	public void loadDataTable(ArrayList<QuanLyThuocDTO> list) {
		listqlt = list;
		model.setRowCount(0);
		for(QuanLyThuocDTO qlt : listqlt) {
			model.addRow(new Object[] {
					qlt.getMathuoc(), qlt.getTenthuoc(), qlt.getDonvitinh(), qlt.getGia(), qlt.getNhomthuoc(), qlt.getSoluong()	
				});
		}
	}
	
	public void tableAction(Table table) {
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				selectedRow = table.getSelectedRow();
				
				if(selectedRow != -1) {
					int mathuoc = (int) table.getValueAt(selectedRow, 0);
					String tenthuoc = (String) table.getValueAt(selectedRow, 1);
					String donvitinh = (String) table.getValueAt(selectedRow, 2);
					double giadb = (Double) table.getValueAt(selectedRow, 3);
					String gia = Double.toString(giadb);
					String nhomthuoc = (String) table.getValueAt(selectedRow, 4);
					int soluongint = (Integer) table.getValueAt(selectedRow, 5);
					String soluong = Integer.toString(soluongint);
					
					qltDTO.setMathuoc(mathuoc);
				}
			}
		});
	}
	
	public void Fillter() throws ParseException{
		String input = search.txtSearchForm.getText() != null ? search.txtSearchForm.getText() : "";
		System.out.println(input);
		this.listqlt = qltBUS.fillterQLT(input);
		loadDataTable(listqlt);
	}
	
	public void resetForm() {
		this.listqlt = qltBUS.getListqlt();
		loadDataTable(listqlt);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		try {
			Fillter();
		} catch (ParseException e2) {
			Logger.getLogger(QuanLyThuoc.class.getName()).log(Level.SEVERE, null, e2);
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		try {
			Fillter();
		} catch (ParseException e2) {
			Logger.getLogger(QuanLyThuoc.class.getName()).log(Level.SEVERE, null, e2);
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
			Logger.getLogger(QuanLyThuoc.class.getName()).log(Level.SEVERE, null, e2);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == search.getBtnReset()) {
	        resetForm();
	    }
	}
}