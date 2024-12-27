package GUI.Panel;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import BUS.BacSiBUS;
import DAO.BacSiDAO;
import DAO.TaiKhoanDAO;
import DTO.BacSiDTO;
import DTO.TaiKhoanDTO;
import GUI.Login;
import GUI.component.SelectForm;
import GUI.component.Text;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class AddBacSi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Text tHoten, tDiachi, tEmail, tSDT, tUsername;
	private JLabel lblName;
	private JLabel lblSex;
	Color FontColor = new Color(96, 125, 139);
	private JLabel lblTitile;
	private JLabel lblAdd_Save;
	private JLabel lblCancel;
	private BacSiBUS bsBUS;
	private BacSi bs;
	private BacSiDTO bsDTO;
	private SelectForm cbxGioitinh, cbxChuyenkhoa;
	private JPasswordField jPassword;
	
	public AddBacSi(BacSiDTO bsDTO, BacSiBUS bsBUS, BacSi bs, String type, String title) {
		this.bsDTO = bsDTO;
		this.bsBUS = bsBUS;
		this.bs = bs;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		contentPane.setLayout(null);
		
		setContentPane(contentPane);
		
		// bsBUS = new BacSiBUS();
		
		JPanel pnTitle = new JPanel();
		pnTitle.setBackground(new Color(0, 153, 255));
		pnTitle.setBounds(0, 0, 859, 79);
		contentPane.add(pnTitle);
		
		lblTitile = new JLabel(title);
		lblTitile.setForeground(Color.WHITE);
		lblTitile.setFont(new Font("SansSerif", Font.PLAIN, 30));
		GroupLayout gl_pnTitle = new GroupLayout(pnTitle);
		gl_pnTitle.setHorizontalGroup(
			gl_pnTitle.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTitle.createSequentialGroup()
					.addGap(331)
					.addComponent(lblTitile)
					.addContainerGap(338, Short.MAX_VALUE))
		);
		gl_pnTitle.setVerticalGroup(
			gl_pnTitle.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTitle.createSequentialGroup()
					.addGap(20)
					.addComponent(lblTitile)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		pnTitle.setLayout(gl_pnTitle);
		
		JPanel pnMain = new JPanel();
		pnMain.setBounds(0, 78, 845, 445);
		contentPane.add(pnMain);
		pnMain.setLayout(null);
		
		tHoten = new Text();
		tHoten.setBounds(10, 60, 400, 45);
		pnMain.add(tHoten);
		
		lblName = new JLabel("Tên bác sĩ");
		lblName.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblName.setBounds(10, 12, 200, 37);
		pnMain.add(lblName);
		
		lblSex = new JLabel("Giới tính");
		lblSex.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblSex.setBounds(435, 12, 200, 37);
		pnMain.add(lblSex);
		
//		sex = new sexCustom();
//		sex.setBounds(435, 60, 400, 45);
//		pnMain.add(sex);
		
		// handle
		String[] gender = {"Nam", "Nữ"};
		gender = Stream.concat(Stream.of("Tất cả"), Arrays.stream(gender)).toArray(String[]::new);
		
		// init cbxgioitinh
		cbxGioitinh = new SelectForm(gender);
		cbxGioitinh.setBounds(435, 60, 400, 45);
		pnMain.add(cbxGioitinh);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblEmail.setBounds(435, 116, 200, 37);
		pnMain.add(lblEmail);
		
		tEmail = new Text();
		tEmail.setBounds(435, 164, 400, 45);
		pnMain.add(tEmail);
		
		JLabel lblAddress = new JLabel("Địa chỉ");
		lblAddress.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblAddress.setBounds(10, 116, 200, 37);
		pnMain.add(lblAddress);
		
		tDiachi = new Text();
		tDiachi.setBounds(10, 164, 400, 45);
		pnMain.add(tDiachi);
		
		JLabel lblPhoneNumber = new JLabel("Số điện thoại");
		lblPhoneNumber.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(10, 220, 200, 37);
		pnMain.add(lblPhoneNumber);
		
		tSDT = new Text();
		tSDT.setBounds(10, 268, 400, 45);
		pnMain.add(tSDT);
		
		JLabel lblspecialty = new JLabel("Chuyên khoa");
		lblspecialty.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblspecialty.setBounds(435, 220, 200, 37);
		pnMain.add(lblspecialty);
		
//		sexCustom sex_1 = new sexCustom();
//		sex_1.setBounds(435, 268, 400, 45);
//		pnMain.add(sex_1);
		
		// handle
		String[] specialty = {"Khoa Nội tổng hợp", "Khoa Nội tim mạch", "Khoa Nội tiêu hóa", "Khoa Nội cơ – xương – khớp", "Khoa Nội thận – tiết niệu", "Khoa Nội tiết", "Khoa Dị ứng", "Khoa Huyễn Học lâm sàng", "Khoa Truyền nhiễm", "Khoa Lao", "Khoa Da Liễu", "Khoa Thần kinh", "Khoa Tâm thần", "Khoa Y học cổ truyền", "Khoa Lão học", "Khoa Nhi", "Khoa Ngoại tổng hợp", "Khoa Ngoại thần kinh", "Khoa Ngoại lồng ngực", "Khoa Ngoại tiêu hóa", "Khoa Ngoại thận – tiết niệu", "Khoa Chấn thương chỉnh hình", "Khoa Bỏng", "Khoa Phẫu thuật gây mê hồi sức", "Khoa Phụ sản", "Khoa Tai – mũi – họng", "Khoa Răng - hàm – mặt", "Khoa Mắt", "Khoa Vật lý trị liệu – phục hồi chức năng"};
		specialty = Stream.concat(Stream.of("Tất cả"), Arrays.stream(specialty)).toArray(String[]::new);
		
		// int cbx chuyen khoa
		cbxChuyenkhoa = new SelectForm(specialty);
		cbxChuyenkhoa.setBounds(435, 268, 400, 45);
		pnMain.add(cbxChuyenkhoa);
		
		JLabel lblAddress_1 = new JLabel("Tên đăng nhập");
		lblAddress_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblAddress_1.setBounds(10, 324, 200, 37);
		pnMain.add(lblAddress_1);
		
		tUsername = new Text();
		tUsername.setBounds(10, 372, 400, 45);
		pnMain.add(tUsername);
		
		JLabel lblEmail_1 = new JLabel("Mật khẩu");
		lblEmail_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblEmail_1.setBounds(435, 324, 200, 37);
		pnMain.add(lblEmail_1);
		
//		Text tPassword = new Text();
//		tPassword.setBounds(435, 372, 400, 45);
//		pnMain.add(tPassword);
		
		jPassword = new JPasswordField();
		jPassword.setBounds(435, 372, 400, 45);
		pnMain.add(jPassword);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 523, 845, 85);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel pnAdd = new JPanel();
		pnAdd.setLayout(null);
		pnAdd.setBackground(new Color(0, 206, 209));
		pnAdd.setBounds(275, 11, 136, 49);
		panel.add(pnAdd);
		
		JPanel pnCancel = new JPanel();
		pnCancel.setLayout(null);
		pnCancel.setBackground(new Color(255, 0, 51));
		pnCancel.setBounds(437, 11, 136, 49);
		panel.add(pnCancel);
		
		switch (type) {
		case "them":
			lblAdd_Save = new JLabel("Thêm");
			lblAdd_Save.setForeground(Color.WHITE);
			lblAdd_Save.setFont(new Font("SansSerif", Font.PLAIN, 26));
			lblAdd_Save.setBounds(27, 0, 109, 49);
			pnAdd.add(lblAdd_Save);
			
			lblCancel = new JLabel("Huỷ bỏ");
			lblCancel.setForeground(Color.WHITE);
			lblCancel.setFont(new Font("SansSerif", Font.PLAIN, 26));
			lblCancel.setBounds(24, 0, 112, 49);
			pnCancel.add(lblCancel);
			
			// xu ly su kien bam nut
			eventMouse(pnAdd, 1);
			eventMouse(pnCancel, 2);
			break;
		case "sua":
			int selectedRow = bs.table.getSelectedRow();
			String tenbs = (String) bs.table.getValueAt(selectedRow, 1);
			//SelectForm gioitinh = (SelectForm) bs.table.getValueAt(selectedRow, 2);
			//
			String diachi = (String) bs.table.getValueAt(selectedRow, 3);
			String email = (String) bs.table.getValueAt(selectedRow, 4);
			String sdt = (String) bs.table.getValueAt(selectedRow, 5);
			//SelectForm chuyenkhoa = (SelectForm) bs.table.getValueAt(selectedRow, 6);
			
			tHoten.setText(tenbs);
			//cbxGioitinh.setSelectedItem(gioitinh);
			tDiachi.setText(diachi);
			tEmail.setText(email);
			tSDT.setText(sdt);
			//cbxChuyenkhoa.setSelectedItem(chuyenkhoa);
			
			lblAdd_Save = new JLabel("Lưu");
			lblAdd_Save.setForeground(Color.WHITE);
			lblAdd_Save.setFont(new Font("SansSerif", Font.PLAIN, 26));
			lblAdd_Save.setBounds(42, 0, 109, 49);
			pnAdd.add(lblAdd_Save);
			
			lblCancel = new JLabel("Huỷ bỏ");
			lblCancel.setForeground(Color.WHITE);
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
			// thuc hien chuc nang them bac si
			int id = BacSiDAO.getInstance().getAutoIncrement();
			String tenbs = tHoten.getText();
			int gioitinh;
			String gioitinhChon = (String) cbxGioitinh.getSelectedItem();
			if (gioitinhChon.equals("Nam")) {
			    gioitinh = 1; // Nam = 1
			} else if (gioitinhChon.equals("Nữ")) {
			    gioitinh = 0; // Nữ = 0
			} else {
			    gioitinh = -1;
			}
			String diachi = tDiachi.getText();
			String email = tEmail.getText();
			String sdt = tSDT.getText();
			String chuyenkhoa = (String) cbxChuyenkhoa.getSelectedItem();
			String username = tUsername.getText();
			char[] passwordchar = jPassword.getPassword();
			String password = new String(passwordchar);
			password = Model.BCrypt.hashpw(password, Model.BCrypt.gensalt(12));
			
			System.out.println(id);
			
			TaiKhoanDTO tk = new TaiKhoanDTO(id, username, password, 1, 0);
			TaiKhoanDAO.getInstance().insert(tk);
			
			BacSiDTO bs = new BacSiDTO(id, tenbs, gioitinh, diachi, email, sdt, chuyenkhoa, 1);
			BacSiDAO.getInstance().insert(bs);
			bsBUS.insertBS(bs);
			bsBUS.loadTable();
			this.setVisible(false);
		}else if(i == 2) {
			// thuc hien chuc nang huy bo viec them
			this.setVisible(false);
			dispose();
		}else if(i == 3) {
			// luu thong tin da sua(chua code)
			String tenbs = tHoten.getText();
			int gioitinh;
			String gioitinhChon = (String) cbxGioitinh.getSelectedItem();
			if (gioitinhChon.equals("Nam")) {
			    gioitinh = 1; // Nam = 1
			} else if (gioitinhChon.equals("Nữ")) {
			    gioitinh = 0; // Nữ = 0
			} else {
			    gioitinh = -1;
			}
			String diachi = tDiachi.getText();
			String email = tEmail.getText();
			String sdt = tSDT.getText();
			String chuyenkhoa = (String) cbxChuyenkhoa.getSelectedItem();
			BacSiDTO bs = new BacSiDTO(bsDTO.getId(), tenbs, gioitinh, diachi, email, sdt, chuyenkhoa, 1);
			BacSiDAO.getInstance().update(bs);

			String username = tUsername.getText();
			char[] passwordchar = jPassword.getPassword();
			String password = new String(passwordchar);
			password = Model.BCrypt.hashpw(password, Model.BCrypt.gensalt(12));
			TaiKhoanDTO tk = new TaiKhoanDTO(bsDTO.getId(), username, password, 1, 0);
			TaiKhoanDAO.getInstance().update(tk);
			
			bsBUS.listBS.set(bsBUS.getIndex(), bs);
			bsBUS.loadTable();
			this.setVisible(false);
			dispose();
		}
	}
}
