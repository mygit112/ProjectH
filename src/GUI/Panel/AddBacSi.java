package GUI.Panel;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import GUI.Login;
import GUI.component.Text;
import GUI.component.sexCustom;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class AddBacSi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Text tName, tAddress, tEmail, tPhoneNumber;
	private JLabel lblName;
	private JLabel lblSex;
	private sexCustom sex;
	Color FontColor = new Color(96, 125, 139);
	private JLabel lblTitile;
	private JLabel lblAdd_Save;
	private JLabel lblCancel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					AddBacSi frame = new AddBacSi();
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddBacSi(String type, String title) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		contentPane.setLayout(null);
		
		setContentPane(contentPane);
		
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
		pnMain.setBounds(0, 78, 859, 328);
		contentPane.add(pnMain);
		pnMain.setLayout(null);
		
		tName = new Text();
		tName.setBounds(10, 60, 400, 45);
		pnMain.add(tName);
		
		lblName = new JLabel("Tên bác sĩ");
		lblName.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblName.setBounds(10, 12, 200, 37);
		pnMain.add(lblName);
		
		lblSex = new JLabel("Giới tính");
		lblSex.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblSex.setBounds(435, 12, 200, 37);
		pnMain.add(lblSex);
		
		sex = new sexCustom();
		sex.setBounds(435, 60, 400, 45);
		pnMain.add(sex);
		
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
		
		tAddress = new Text();
		tAddress.setBounds(10, 164, 400, 45);
		pnMain.add(tAddress);
		
		JLabel lblPhoneNumber = new JLabel("Số điện thoại");
		lblPhoneNumber.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(10, 220, 200, 37);
		pnMain.add(lblPhoneNumber);
		
		tPhoneNumber = new Text();
		tPhoneNumber.setBounds(10, 268, 400, 45);
		pnMain.add(tPhoneNumber);
		
		JLabel lblspecialty = new JLabel("Chuyên khoa");
		lblspecialty.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblspecialty.setBounds(435, 220, 200, 37);
		pnMain.add(lblspecialty);
		
		sexCustom sex_1 = new sexCustom();
		sex_1.setBounds(435, 268, 400, 45);
		pnMain.add(sex_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 406, 859, 85);
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
			// them bac si
			this.setVisible(false);
		}else if(i == 2) {
			// huy bo viec them
			this.setVisible(false);
			dispose();
		}else if(i == 3) {
			// luu thong tin da sua(chua code)
			this.setVisible(false);
			dispose();
		}
	}
}
