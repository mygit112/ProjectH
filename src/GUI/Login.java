package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import GUI.component.LoginComponent;
import Model.BCrypt;

public class Login extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_3;
	LoginComponent txtUsername, txtPassword;
	
	Color FontColor = new Color(96, 125, 139);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					//e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 500, 500);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/img/login.png")));
		lblNewLabel_2.setBounds(0, 0, 500, 500);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(499, 0, 460, 123);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đăng nhập vào hệ thống");
		lblNewLabel.setBounds(150, 45, 220, 67);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(499, 122, 501, 247);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 1));
		
		txtUsername = new LoginComponent("Tên đăng nhập");
		panel_2.add(txtUsername);
		txtPassword = new LoginComponent("Mật khẩu", "password");
        panel_2.add(txtPassword);

        txtUsername.setText("bacsi1");
        //txtPassword.setText("123456");
		
		panel_3 = new JPanel();
		panel_3.setBounds(620, 388, 291, 46);
		contentPane.add(panel_3);
		
		panel_3.putClientProperty("Tahoma", "arc: 99" );
		panel_3.setBackground(Color.BLACK);
		panel_3.setPreferredSize(new Dimension(380, 45));
		panel_3.setLayout(new FlowLayout(1, 0, 15));
		
		JLabel lblNewLabel_1 = new JLabel("ĐĂNG NHẬP");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		
		panel_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                pnlLogInMouseEntered(evt);
            }
            
            // xu ly xu kien bam nut dang nhap
            @Override
            public void mousePressed(MouseEvent evt) {
                try {
                    pnlLogInMousePressed(evt);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                pnlLogInMouseExited(evt);
            }
        });
		panel_3.add(lblNewLabel_1);
		
		// thoat chuong trinh
		JLabel lblNewLabel_3 = new JLabel("X");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				close();
			}
		});
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(982, 0, 12, 30);
		contentPane.add(lblNewLabel_3);
		this.setLocationRelativeTo(null);
	}
	
	public void checkLogin() {
//		Main main = new Main();
//		AudioPlayer au = new AudioPlayer();
//		au.startAudio(1);
//		this.setVisible(false);
//		main.setVisible(true);
		String usernameCheck = txtUsername.getText();
		String passworkCheck = txtPassword.getPass();
		if(usernameCheck.equals("") || passworkCheck.equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);	
		}else {
			TaiKhoanDTO tk = TaiKhoanDAO.getInstance().selectByUser(usernameCheck);
			if(tk == null) {
				JOptionPane.showMessageDialog(this, "Tài khoản của bạn không tồn tại trên hệ thống", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
			}else {
				if(tk.getTrangthai() == -1) {
					JOptionPane.showMessageDialog(this, "Tài khoản của bạn đang bị khóa", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
				}else {
					if(BCrypt.checkpw(passworkCheck, tk.getPasswork())) {
						try {
							this.dispose();
							Main main = new Main(tk);
							main.setVisible(true);
						} catch (Exception e) {
							Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
						}
					}else {
						JOptionPane.showMessageDialog(this, "Mật khẩu không đúng!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
			
		}
	}
	
	private void pnlLogInMousePressed(java.awt.event.MouseEvent evt) throws UnsupportedLookAndFeelException {
        checkLogin();
    }
	
	private void pnlLogInMouseEntered(java.awt.event.MouseEvent evt) {
		panel_3.setBackground(FontColor);
		panel_3.setForeground(Color.black);
    }

    private void pnlLogInMouseExited(java.awt.event.MouseEvent evt) {
    	panel_3.setBackground(Color.BLACK);
    	panel_3.setForeground(Color.white);
    }
	
	public void close() {
		this.dispose();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			checkLogin();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
