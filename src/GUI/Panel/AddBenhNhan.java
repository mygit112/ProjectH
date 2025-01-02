package GUI.Panel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BUS.BenhNhanBUS;
import DAO.BenhNhanDAO;
import DTO.BenhNhanDTO;
import DTO.TaiKhoanDTO;
import GUI.Login;
import GUI.component.SelectForm;
import GUI.component.Text;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;

public class AddBenhNhan extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Text tHoten, tTuoi, tTrieuchung, tBHYT, tDiachi, tSDT, tChieucao, tCannang;
	Color FontColor = new Color(96, 125, 139);
	private JLabel lblTitle;
	private JLabel lblAdd_Save;
	private JLabel lblCancel;
	private SelectForm cbxGioitinh;
	private BenhNhanBUS bnBUS;
	private BenhNhan bn;
	private BenhNhanDTO bnDTOa;
	private TaiKhoanDTO tkDTO;

	public AddBenhNhan(TaiKhoanDTO tkDTO, BenhNhanDTO bnDTOa, BenhNhanBUS bnBUS, BenhNhan bn, String type, String title) {
		this.tkDTO = tkDTO;
		this.bnDTOa = bnDTOa;
		this.bnBUS = bnBUS;
		this.bn = bn;
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(0, 0, 895, 79);
		contentPane.add(panel);
		
		lblTitle = new JLabel(title);
		lblTitle.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblTitle.setForeground(new Color(255, 255, 255));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(241)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(361, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(21))
		);
		panel.setLayout(gl_panel);
		

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 78, 738, 408);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		tHoten = new Text();
		tHoten.setBounds(10, 59, 200, 37);

		panel_1.add(tHoten);
		
		JLabel lblNewLabel_1 = new JLabel("Tên bệnh nhân");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 11, 200, 37);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Chiều cao");
		lblNewLabel_1_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 226, 200, 37);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tuổi");
		lblNewLabel_1_2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(270, 11, 200, 37);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Giới tính");
		lblNewLabel_1_3.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(528, 11, 200, 37);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Triệu chứng");
		lblNewLabel_1_4.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(528, 226, 200, 37);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Số thẻ BHYT (nếu có)");
		lblNewLabel_1_5.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1_5.setBounds(10, 117, 200, 37);
		panel_1.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Địa chỉ");
		lblNewLabel_1_6.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1_6.setBounds(270, 117, 200, 37);
		panel_1.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Số điện thoại");
		lblNewLabel_1_7.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1_7.setBounds(528, 117, 200, 37);
		panel_1.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("Cân nặng");
		lblNewLabel_1_8.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1_8.setBounds(270, 226, 200, 37);
		panel_1.add(lblNewLabel_1_8);
		
		tTuoi = new Text();
		tTuoi.setBounds(270, 59, 200, 37);
		panel_1.add(tTuoi);
		
		tTrieuchung = new Text();
		tTrieuchung.setBounds(528, 274, 200, 37);
		panel_1.add(tTrieuchung);
		
		tBHYT = new Text();
		tBHYT.setBounds(10, 165, 200, 37);
		panel_1.add(tBHYT);
		
		tDiachi = new Text();
		tDiachi.setBounds(270, 165, 200, 37);
		panel_1.add(tDiachi);
		
		tSDT = new Text();
		tSDT.setBounds(528, 165, 200, 37);
		panel_1.add(tSDT);
		
		tCannang = new Text();
		tCannang.setBounds(270, 274, 200, 37);
		panel_1.add(tCannang);
		
//		sex = new sexCustom();
//		sex.setBounds(528, 59, 200, 37);
//		panel_1.add(sex);
		
		// handle
//		String[] listbn = bnBUS.getArrGioiTinh();
//		listbn = Stream.concat(Stream.of("Tất cả"), Arrays.stream(listbn)).toArray(String[]::new);
		String[] gender = {"Nam", "Nữ"};
		gender = Stream.concat(Stream.of("Tất cả"), Arrays.stream(gender)).toArray(String[]::new);
		
		// init cbx
		cbxGioitinh = new SelectForm(gender);
		cbxGioitinh.setBounds(528, 59, 200, 37);
		panel_1.add(cbxGioitinh);
		
		tChieucao = new Text();
		tChieucao.setBounds(10, 274, 200, 37);
		panel_1.add(tChieucao);
		
		JPanel pnAdd = new JPanel();
		pnAdd.setBounds(220, 340, 136, 49);
		panel_1.add(pnAdd);
		pnAdd.setBackground(new Color(0, 206, 209));
		pnAdd.setLayout(null);
	
		JPanel pnCancel = new JPanel();
		pnCancel.setBounds(380, 340, 136, 49);
		panel_1.add(pnCancel);
		pnCancel.setBackground(new Color(255, 0, 51));
		pnCancel.setLayout(null);

		switch (type) {
		case "them":
			lblAdd_Save = new JLabel("Thêm");
			lblAdd_Save.setForeground(new Color(255, 255, 255));
			lblAdd_Save.setFont(new Font("SansSerif", Font.PLAIN, 26));
			lblAdd_Save.setBounds(27, 0, 109, 49);
			pnAdd.add(lblAdd_Save);
		
			lblCancel = new JLabel("Huỷ bỏ");
			lblCancel.setForeground(new Color(255, 255, 255));
			lblCancel.setFont(new Font("SansSerif", Font.PLAIN, 26));
			lblCancel.setBounds(24, 0, 112, 49);
			pnCancel.add(lblCancel);
			
			// xu ly su kien bam nut
			eventMouse(pnAdd, 1);
			eventMouse(pnCancel, 2);
			break;
		case "sua":
			int selectedRow = bn.table.getSelectedRow();
			String hoten = (String) bn.table.getValueAt(selectedRow, 1);
			int tuoiint = (Integer) bn.table.getValueAt(selectedRow, 2);
			String tuoi = Integer.toString(tuoiint);
			String gioitinh = (String) bn.table.getValueAt(selectedRow, 3);
			String bhyt = (String) bn.table.getValueAt(selectedRow, 4);
			String diachi = (String) bn.table.getValueAt(selectedRow, 5);
			String sdt = (String) bn.table.getValueAt(selectedRow, 6);
			int chieucaoint = (Integer) bn.table.getValueAt(selectedRow, 7);
			String chieucao = Integer.toString(chieucaoint);
			int cannangint = (Integer) bn.table.getValueAt(selectedRow, 8);
			String cannang = Integer.toString(cannangint);
			String trieuchung = (String) bn.table.getValueAt(selectedRow, 10);
			
			tHoten.setText(hoten);
			tTuoi.setText(tuoi);
			cbxGioitinh.setSelectedIndex(0);
			tBHYT.setText(bhyt);
			tDiachi.setText(diachi);
			tSDT.setText(sdt);
			tChieucao.setText(chieucao);
			tCannang.setText(cannang);
			tTrieuchung.setText(trieuchung);
			
			lblAdd_Save = new JLabel("Lưu");
			lblAdd_Save.setForeground(new Color(255, 255, 255));
			lblAdd_Save.setFont(new Font("SansSerif", Font.PLAIN, 26));
			lblAdd_Save.setBounds(42, 0, 109, 49);
			pnAdd.add(lblAdd_Save);
		
			lblCancel = new JLabel("Huỷ bỏ");
			lblCancel.setForeground(new Color(255, 255, 255));
			lblCancel.setFont(new Font("SansSerif", Font.PLAIN, 26));
			lblCancel.setBounds(24, 0, 112, 49);
			pnCancel.add(lblCancel);
			
			// xu ly su kien bam nut
			eventMouse(pnAdd, 3);
			eventMouse(pnCancel, 2);
			break;
		default:
			break;
		}
		
		this.setLocationRelativeTo(null);
	}
	
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
            	if(i == 1) {
            		pn.setBackground(new Color(0, 206, 209));
                	pn.setForeground(Color.white);
            	}else if(i == 2) {
            		pn.setBackground(new Color(255, 0, 51));
                	pn.setForeground(Color.white);
            	}
            }
        });
	}
	
	public void pnlLogInMousePressed(java.awt.event.MouseEvent evt, int i) throws UnsupportedLookAndFeelException {
		addOrCanCel(i);
    }
	
	public void addOrCanCel(int i) {
		if(i == 1) {
			// them
			if(validForm()) {
				int id = BenhNhanDAO.getInstance().getAutoIncrement();
				String txtHoten = tHoten.getText();
				int txtTuoi = Integer.parseInt(tTuoi.getText());
				int txtGioitinh;
				String gioitinhChon = (String) cbxGioitinh.getSelectedItem();
				if (gioitinhChon.equals("Nam")) {
				    txtGioitinh = 1; // Nam = 1
				} else if (gioitinhChon.equals("Nữ")) {
				    txtGioitinh = 0; // Nữ = 0
				} else {
				    txtGioitinh = -1;
				}
				String txtBHYT = tBHYT.getText();
				String txtDiachi = tDiachi.getText();
				String txtSDT = tSDT.getText();
				int txtChieucao = Integer.parseInt(tChieucao.getText());
				int txtCannang = Integer.parseInt(tCannang.getText());
				String txtTrieuchung = tTrieuchung.getText();
				Date currentDate = new Date(System.currentTimeMillis());			
				BenhNhanDTO bn = new BenhNhanDTO(id, txtHoten, txtTuoi, txtGioitinh, txtBHYT, txtDiachi, txtSDT, txtChieucao, txtCannang, currentDate, txtTrieuchung, "", "", null, tkDTO.getManv(), 1);
				BenhNhanDAO.getInstance().insert(bn);
				bnBUS.insertBN(bn);
				bnBUS.loadTable();
				this.setVisible(false);
			}
		}else if(i == 2) {
			// huy bo
			this.setVisible(false);
			dispose();
		}else if(i == 3) {
			// luu thong tin da chinh sua			//System.out.println(bnDTOa.getHoten());
			// int id = BenhNhanDAO.getInstance().getAutoIncrement();
			if(validForm()) {
				String txtHoten = tHoten.getText();
				int txtTuoi = Integer.parseInt(tTuoi.getText());
				int txtGioitinh;
				String gioitinhChon = (String) cbxGioitinh.getSelectedItem();
				if (gioitinhChon.equals("Nam")) {
				    txtGioitinh = 1; // Nam = 1
				} else if (gioitinhChon.equals("Nữ")) {
				    txtGioitinh = 0; // Nữ = 0
				} else {
				    txtGioitinh = -1;
				}
				String txtBHYT = tBHYT.getText();
				String txtDiachi = tDiachi.getText();
				String txtSDT = tSDT.getText();
				int txtChieucao = Integer.parseInt(tChieucao.getText());
				int txtCannang = Integer.parseInt(tCannang.getText());
				String txtTrieuchung = tTrieuchung.getText();
				Date currentDate = new Date(System.currentTimeMillis());
				//System.out.println(tkDTO.getManv());
				BenhNhanDTO bnDTO = new BenhNhanDTO(bnDTOa.getMabn(), txtHoten, txtTuoi, txtGioitinh, txtBHYT, txtDiachi, txtSDT, txtChieucao, txtCannang, currentDate, txtTrieuchung, "", "", null, tkDTO.getManv(), 1);
				BenhNhanDAO.getInstance().update(bnDTO);
				bnBUS.listBN.set(bnBUS.getIndex(), bnDTO);
				bnBUS.loadTable();
				this.setVisible(false);
				dispose();
			}
		}
	}
	
	public boolean validForm() {
	    try {
	        if (tHoten.getText().equals("") || tTuoi.getText().equals("") || cbxGioitinh.getSelectedIndex() == 0 ||
	                tDiachi.getText().equals("") || tSDT.getText().equals("") || tChieucao.getText().equals("") ||
	                tCannang.getText().equals("") || tTrieuchung.getText().equals("")) {
	            JOptionPane.showMessageDialog(null, "Bạn chưa nhập đầy đủ thông tin!", "Cảnh báo!", JOptionPane.ERROR_MESSAGE);
	            return false;
	        }

	        int txtTuoi = Integer.parseInt(tTuoi.getText());
	        if (txtTuoi <= 0) {
	            JOptionPane.showMessageDialog(null, "Tuổi phải là một số hợp lệ!", "Cảnh báo!", JOptionPane.ERROR_MESSAGE);
	            return false;
	        }

	        int chieucao = Integer.parseInt(tChieucao.getText());
	        int cannang = Integer.parseInt(tCannang.getText());
	        if (chieucao <= 0 || cannang <= 0) {
	            JOptionPane.showMessageDialog(null, "Chiều cao và cân nặng phải là một số hợp lệ!", "Cảnh báo!", JOptionPane.ERROR_MESSAGE);
	            return false;
	        }

	        if (!tSDT.getText().matches("\\d{10}")) {
	            JOptionPane.showMessageDialog(null, "Số điện thoại phải gồm 10 chữ số!", "Cảnh báo!", JOptionPane.ERROR_MESSAGE);
	            return false;
	        }

	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Thông tin nhập không hợp lệ!", "Cảnh báo!", JOptionPane.ERROR_MESSAGE);
	        return false;
	    }
	    return true;
	}
}
