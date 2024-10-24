package GUI.Panel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import GUI.Login;
import GUI.component.DateCustom;
import GUI.component.Text;
import GUI.component.sexCustom;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;

public class MdfBenhNhan extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Text tName, tAge, tParent, tPro, tAdress, tPNumer, tWeight, tDia;
	private sexCustom sex;
	private DateCustom dcustom;
	Color FontColor = new Color(96, 125, 139);
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBenhNhan frame = new AddBenhNhan();
					frame.setVisible(true);
					// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MdfBenhNhan() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(0, 0, 895, 79);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("THAY ĐỔI BỆNH NHÂN");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(292, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
					.addGap(268))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(20))
		);
		panel.setLayout(gl_panel);
		

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 78, 738, 526);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		tName = new Text();
		tName.setBounds(10, 59, 200, 37);

		panel_1.add(tName);
		
		JLabel lblNewLabel_1 = new JLabel("Tên bệnh nhân");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 11, 200, 37);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ngày sinh");
		lblNewLabel_1_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(270, 11, 200, 37);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tuổi");
		lblNewLabel_1_2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(528, 11, 200, 37);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Giới tính");
		lblNewLabel_1_3.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(10, 117, 200, 37);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Tên bố/mẹ/người giám hộ");
		lblNewLabel_1_4.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(270, 117, 200, 37);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Số thẻ BHYT (nếu có)");
		lblNewLabel_1_5.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1_5.setBounds(528, 117, 200, 37);
		panel_1.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Địa chỉ");
		lblNewLabel_1_6.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1_6.setBounds(10, 226, 200, 37);
		panel_1.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Số điện thoại");
		lblNewLabel_1_7.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1_7.setBounds(270, 226, 200, 37);
		panel_1.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("Cân nặng");
		lblNewLabel_1_8.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1_8.setBounds(528, 226, 200, 37);
		panel_1.add(lblNewLabel_1_8);
		
		tAge = new Text();
		tAge.setBounds(528, 59, 200, 37);
		panel_1.add(tAge);
		
		tParent = new Text();
		tParent.setBounds(270, 165, 200, 37);
		panel_1.add(tParent);
		
		tPro = new Text();
		tPro.setBounds(528, 165, 200, 37);
		panel_1.add(tPro);
		
		tAdress = new Text();
		tAdress.setBounds(10, 274, 200, 37);
		panel_1.add(tAdress);
		
		tPNumer = new Text();
		tPNumer.setBounds(270, 274, 200, 37);
		panel_1.add(tPNumer);
		
		tWeight = new Text();
		tWeight.setBounds(528, 274, 200, 37);
		panel_1.add(tWeight);
		
		tDia = new Text("left");
		tDia.setBounds(10, 385, 718, 105);
		panel_1.add(tDia);
		
		sex = new sexCustom();
		sex.setBounds(10, 165, 200, 37);
		panel_1.add(sex);
		
		dcustom = new DateCustom();
		dcustom.setBounds(270, 59, 200, 37);
		panel_1.add(dcustom);
		
		JLabel lblNewLabel_1_9 = new JLabel("Chuẩn đoán");
		lblNewLabel_1_9.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1_9.setBounds(10, 337, 200, 37);
		panel_1.add(lblNewLabel_1_9);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 206, 209));
		panel_2.setBounds(748, 103, 136, 49);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		eventMouse(panel_2, 1);
		
		JLabel lblNewLabel_2 = new JLabel("Thay đổi");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 26));
		lblNewLabel_2.setBounds(17, 0, 109, 49);
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(255, 0, 51));
		panel_2_1.setBounds(748, 181, 136, 49);
		contentPane.add(panel_2_1);
		panel_2_1.setLayout(null);
		eventMouse(panel_2_1, 2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Huỷ bỏ");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("SansSerif", Font.PLAIN, 26));
		lblNewLabel_2_1.setBounds(24, 0, 112, 49);
		panel_2_1.add(lblNewLabel_2_1);
		
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
			
			this.setVisible(false);
		}else if(i == 2) {
			this.setVisible(false);
			dispose();
		}
	}
}
