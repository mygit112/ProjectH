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
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import BUS.BacSiBUS;
import DTO.BacSiDTO;
import DTO.TaiKhoanDTO;
import GUI.Login;
import GUI.component.IntegratedSearch;
import GUI.component.ScrollBar;
import GUI.component.Table;
import java.awt.FlowLayout;

public class BacSi extends JPanel implements ActionListener, KeyListener, PropertyChangeListener, ItemListener {

	private static final long serialVersionUID = 1L;
	protected Table table;
	private DefaultTableModel model;
	private Color FontColor = new Color(96, 125, 139);
	private JPanel pnAdd;
	private JPanel pnModify;
	private AddBacSi addbs;
	private BacSiBUS bsBUS = new BacSiBUS(this);
	private BacSiDTO bsDTO = new BacSiDTO();
	private ArrayList<BacSiDTO> listbs = bsBUS.getListBS();
	protected int selectedRow;
	private IntegratedSearch search;
	private TaiKhoanDTO tkDTO;
	
	public BacSi(TaiKhoanDTO tkDTO) {
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
					"Mã bác sĩ", "Tên bác sĩ", "Giới tính", "Địa chỉ", "Email", "Số điện thoại", "Chuyên khoa"
				}
		);
		// lay du lieu tu database hien thi len bang
		loadDataTable(listbs);
		
		table = new Table();
		table.setModel(model);
		table.setFont(new Font("SansSerif", Font.PLAIN, 12));
		table.setBounds(0, 0, 1140, 398);
		
		// xu ly su kien nhan vao bang
		tableAction(table);
		
		JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(table); // Thiết lập bảng cho JScrollPane
        scroll.setBounds(0, 0, 1115, 604);
		scroll.setVerticalScrollBar(new ScrollBar());
        
		panel.add(scroll);
		add(panel);
		
		JPanel pnMenuBar = new JPanel();
		pnMenuBar.setBackground(Color.WHITE);
		pnMenuBar.setBounds(10, 11, 1110, 92);
		
		add(pnMenuBar);
		
		pnAdd = new JPanel();
		pnAdd.setBounds(10, 10, 114, 70);
		pnAdd.setBackground(Color.WHITE);
		
		pnModify = new JPanel();
		pnModify.setBounds(134, 10, 106, 70);
		pnModify.setBackground(Color.WHITE);
		
		// String[] options = {"Option 1", "Option 2", "Option 3"};
		search = new IntegratedSearch();
		JTextField searchField = search.getTxtSearchForm();
		JButton resetButton = search.getBtnReset();
		search.setBounds(630, 9, 452, 71);
		searchField.addKeyListener(this);
		resetButton.addActionListener(this);
		pnMenuBar.add(search);
		pnMenuBar.revalidate();
		pnMenuBar.repaint();
		
		JLabel lblModifyIcon = new JLabel("");
		lblModifyIcon.setIcon(new ImageIcon(BacSi.class.getResource("/Entity/pencil.png")));
		
		JLabel lblModify = new JLabel("Sửa");
		lblModify.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		JPanel pnDelete = new JPanel();
		pnDelete.setBounds(250, 10, 104, 70);
		pnDelete.setBackground(Color.WHITE);
		
		JLabel lblDeleteIcon = new JLabel("");
		lblDeleteIcon.setIcon(new ImageIcon(BacSi.class.getResource("/Entity/delete.png")));
		
		JLabel lblDelete = new JLabel("Xoá");
		lblDelete.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		JLabel lblIconAdd = new JLabel("");
		lblIconAdd.setIcon(new ImageIcon(BacSi.class.getResource("/Entity/add.png")));
		
		JLabel lblAdd = new JLabel("Thêm");
		lblAdd.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		// xu ly xu kien chuot
		eventMouse(pnAdd, 1);
		eventMouse(pnModify, 2);
		eventMouse(pnDelete, 3);
		pnMenuBar.setLayout(null);
		pnMenuBar.add(pnAdd);
		pnAdd.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pnAdd.add(lblIconAdd);
		pnAdd.add(lblAdd);
		pnMenuBar.add(pnModify);
		pnModify.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pnModify.add(lblModifyIcon);
		pnModify.add(lblModify);
		pnMenuBar.add(pnDelete);
		pnDelete.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pnDelete.add(lblDeleteIcon);
		pnDelete.add(lblDelete);
		
		//addRow("Nguyễn Văn A", "Name", "HCM", "123aa@gmail.com", "0123456789", "Nhi");
	}
	
//	public void addRow(String tenBs, String gioiTinh, String DiaChi, String Email, String soDT, String chuyenKhoa) {
//        model.addRow(new Object[] { tenBs, gioiTinh, DiaChi, Email, soDT, chuyenKhoa });
//    }
	
	public void eventMouse(JPanel pn, int i) {
		pn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
            	pn.setBackground(FontColor);
        		pn.setForeground(Color.gray);
            }
            
            // xu ly xu kien bam nut dang nhap
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
        	// them bac si
        	if(tkDTO.getPhanQuyen() != 1) {
        		JOptionPane.showMessageDialog(null, "Bạn không có quyền thực hiện chức năng này!", "Cảnh báo!", JOptionPane.ERROR_MESSAGE);
        	}else {
        		addbs = new AddBacSi(bsDTO, bsBUS, this, "them", "THÊM BÁC SĨ");
            	addbs.setVisible(true);
        	}
        }else if(i == 2) {
        	// sua bac su
        	if(tkDTO.getPhanQuyen() != 1) {
        		JOptionPane.showMessageDialog(null, "Bạn không có quyền thực hiện chức năng này!", "Cảnh báo!", JOptionPane.ERROR_MESSAGE);
        	}else {
        		selectedRow = getRowSelected();
            	if(selectedRow != -1) {
            		addbs = new AddBacSi(bsDTO, bsBUS, this, "sua", "SỬA BÁC SĨ");
                	addbs.setVisible(true);
            	}
        	}
        }else if(i == 3) {
        	// xoa bac si
        	if(tkDTO.getPhanQuyen() != 1) {
        		JOptionPane.showMessageDialog(null, "Bạn không có quyền thực hiện chức năng này!", "Cảnh báo!", JOptionPane.ERROR_MESSAGE);
        	}else {
        		selectedRow = getRowSelected();
            	if(selectedRow != -1) {
            		int input = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa?", "Xoá bệnh nhân", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            		if(input == 0) {
            			bsBUS.deleteBS(listbs.get(selectedRow));
            			loadDataTable(listbs);
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
			JOptionPane.showMessageDialog(null, "Vui lòng chọn một bệnh nhân.", "Thông báo", JOptionPane.WARNING_MESSAGE);
		}
		return selected;
	}
	
	public BacSiDTO getBacSi() {
		return listbs.get(table.getSelectedRow());
	}
	
	public void loadDataTable(ArrayList<BacSiDTO> list) {
		listbs = list;
		model.setRowCount(0);
		for(BacSiDTO bs : listbs) {
			model.addRow(new Object[] {
				bs.getId(), bs.getTenbs(), bs.getGioitinh() == 1 ? "Nam" : "Nữ", bs.getDiachi(), bs.getEmail(), bs.getSdt(), bs.getChuyenkhoa()	
			});
		}
	}
	
	public void tableAction(Table table) {
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				selectedRow = table.getSelectedRow();
				
				if(selectedRow != -1) {
					int id = (int) table.getValueAt(selectedRow, 0);
					
					bsDTO.setId(id);
				}
			}
		});
	}
	
	public void Fillter() throws ParseException{
		String input = search.txtSearchForm.getText() != null ? search.txtSearchForm.getText() : "";
		System.out.println(input);
		this.listbs = bsBUS.fillterBacSi(input);
		loadDataTable(listbs);
	}
	
	public void resetForm() {
		this.listbs = bsBUS.getListBS();
		loadDataTable(listbs);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		try {
			Fillter();
		} catch (ParseException e2) {
			Logger.getLogger(BacSi.class.getName()).log(Level.SEVERE, null, e2);
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		try {
			Fillter();
		} catch (ParseException e2) {
			Logger.getLogger(BacSi.class.getName()).log(Level.SEVERE, null, e2);
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
			Logger.getLogger(BacSi.class.getName()).log(Level.SEVERE, null, e2);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == search.getBtnReset()) {
	        resetForm();
	    }
	}
	
}
