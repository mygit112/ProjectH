package GUI.Panel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import DTO.BenhNhanDTO;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import GUI.Login;
import GUI.component.Text;
import GUI.component.sexCustom;

public class AddDonThuoc extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Color FontColor = new Color(96, 125, 139);
	private JLabel lblThemThuoc;
	private JLabel lblThem_XN;
	private JLabel lblHuyBo;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDonThuoc frame = new AddDonThuoc("sua", "TÊN THUỐC");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddDonThuoc(String type, String title) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setBackground(new Color(0, 153, 255));
		pnTitle.setBounds(0, 0, 859, 79);
		contentPane.add(pnTitle);
		
		lblThemThuoc = new JLabel(title);
		lblThemThuoc.setForeground(Color.WHITE);
		lblThemThuoc.setFont(new Font("SansSerif", Font.PLAIN, 30));
		GroupLayout gl_pnTitle = new GroupLayout(pnTitle);
		gl_pnTitle.setHorizontalGroup(
			gl_pnTitle.createParallelGroup(Alignment.LEADING)
				.addGap(0, 859, Short.MAX_VALUE)
				.addGroup(gl_pnTitle.createSequentialGroup()
					.addGap(331)
					.addComponent(lblThemThuoc)
					.addContainerGap(338, Short.MAX_VALUE))
		);
		gl_pnTitle.setVerticalGroup(
			gl_pnTitle.createParallelGroup(Alignment.LEADING)
				.addGap(0, 79, Short.MAX_VALUE)
				.addGroup(gl_pnTitle.createSequentialGroup()
					.addGap(20)
					.addComponent(lblThemThuoc)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		pnTitle.setLayout(gl_pnTitle);
		
		JPanel pnMain = new JPanel();
		pnMain.setLayout(null);
		pnMain.setBounds(0, 78, 859, 234);
		contentPane.add(pnMain);
		
		Text txtThuoc = new Text();
		txtThuoc.setBounds(10, 60, 400, 45);
		pnMain.add(txtThuoc);
		
		JLabel lblTenThuoc = new JLabel("Tên thuốc");
		lblTenThuoc.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblTenThuoc.setBounds(10, 12, 200, 37);
		pnMain.add(lblTenThuoc);
		
		JLabel lblDonVi = new JLabel("Dơn vị tính");
		lblDonVi.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblDonVi.setBounds(435, 12, 200, 37);
		pnMain.add(lblDonVi);
		
		JLabel lblNhomThuoc = new JLabel("Nhóm thuốc");
		lblNhomThuoc.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNhomThuoc.setBounds(435, 116, 200, 37);
		pnMain.add(lblNhomThuoc);
		
		JLabel lblGiaThuoc = new JLabel("Giá thuốc");
		lblGiaThuoc.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblGiaThuoc.setBounds(10, 116, 200, 37);
		pnMain.add(lblGiaThuoc);
		
		Text txtGiaThuoc = new Text();
		txtGiaThuoc.setBounds(10, 164, 400, 45);
		pnMain.add(txtGiaThuoc);
		
		Text txtDonVi = new Text();
		txtDonVi.setBounds(435, 60, 400, 45);
		pnMain.add(txtDonVi);
		
		sexCustom sex = new sexCustom();
		sex.setBounds(435, 164, 400, 45);
		pnMain.add(sex);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 311, 859, 85);
		contentPane.add(panel);
		
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
		
		
		
		
		
		// xu ly nhap vao them hoac sua
		switch (type) {
		case "them":
			lblThem_XN = new JLabel("Thêm");
			lblThem_XN.setForeground(Color.WHITE);
			lblThem_XN.setFont(new Font("SansSerif", Font.PLAIN, 26));
			lblThem_XN.setBounds(27, 0, 109, 49);
			pnAdd.add(lblThem_XN);
			
			lblHuyBo = new JLabel("Huỷ bỏ");
			lblHuyBo.setForeground(Color.WHITE);
			lblHuyBo.setFont(new Font("SansSerif", Font.PLAIN, 26));
			lblHuyBo.setBounds(24, 0, 112, 49);
			pnCancel.add(lblHuyBo);
			
			// xu ly su kien bam nut
			eventMouse(pnAdd, 1);
			eventMouse(pnCancel, 2);
			break;
		case "sua":
			lblThem_XN = new JLabel("Lưu");
			lblThem_XN.setForeground(Color.WHITE);
			lblThem_XN.setFont(new Font("SansSerif", Font.PLAIN, 26));
			lblThem_XN.setBounds(42, 0, 109, 49);
			pnAdd.add(lblThem_XN);
			
			lblHuyBo = new JLabel("Huỷ bỏ");
			lblHuyBo.setForeground(Color.WHITE);
			lblHuyBo.setFont(new Font("SansSerif", Font.PLAIN, 26));
			lblHuyBo.setBounds(24, 0, 112, 49);
			pnCancel.add(lblHuyBo);
			
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
	
	public void loadDataTable(ArrayList<BenhNhanDTO> result) {
		BenhNhan bnhan = new BenhNhan();
		bnhan.model.setRowCount(0);
		for(BenhNhanDTO bn : result) {
			bnhan.model.addRow(new Object[] {bn.getMabn(), bn.getTenbn(),
					bn.getGioitinh(), bn.getNgaysinh(), bn.getDiachi()
			});
		}
	}
	
	public void addOrCanCel(int i) {
		if(i == 1) {
			// them thuoc bai bang (chua code)
			loadDataTable(null);
			
			this.setVisible(false);
			dispose();
		}else if(i == 2) {
			// huy bo viec them
			this.setVisible(false);
			dispose();
		}else if(i == 3) {
			// thuc hien thay doi thongtin trong bang (chua code)
			System.out.println("meo");
			this.setVisible(false);
			dispose();
		}
	}
}
