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
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBacSi frame = new AddBacSi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddBacSi() {
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
		
		JLabel lblThmBcS = new JLabel("THÊM BÁC SĨ");
		lblThmBcS.setForeground(Color.WHITE);
		lblThmBcS.setFont(new Font("SansSerif", Font.PLAIN, 30));
		GroupLayout gl_pnTitle = new GroupLayout(pnTitle);
		gl_pnTitle.setHorizontalGroup(
			gl_pnTitle.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTitle.createSequentialGroup()
					.addGap(331)
					.addComponent(lblThmBcS)
					.addContainerGap(338, Short.MAX_VALUE))
		);
		gl_pnTitle.setVerticalGroup(
			gl_pnTitle.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTitle.createSequentialGroup()
					.addGap(20)
					.addComponent(lblThmBcS)
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
		
		JLabel lblNewLabel_2 = new JLabel("Thêm");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 26));
		lblNewLabel_2.setBounds(27, 0, 109, 49);
		pnAdd.add(lblNewLabel_2);
		
		JPanel pnCancel = new JPanel();
		pnCancel.setLayout(null);
		pnCancel.setBackground(new Color(255, 0, 51));
		pnCancel.setBounds(437, 11, 136, 49);
		panel.add(pnCancel);
		
		JLabel lblNewLabel_2_1 = new JLabel("Huỷ bỏ");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("SansSerif", Font.PLAIN, 26));
		lblNewLabel_2_1.setBounds(24, 0, 112, 49);
		pnCancel.add(lblNewLabel_2_1);
		
		// xu ly su kien bam nut
		eventMouse(pnAdd, 1);
		eventMouse(pnCancel, 2);
		
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
		}
	}
}
