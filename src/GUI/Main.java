package GUI;

import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import GUI.Panel.BacSi;
import GUI.Panel.BenhNhan;
import GUI.Panel.LichSu;
import GUI.Panel.MenuTaskbar;
import GUI.Panel.QuanLyThuoc;
import GUI.Panel.TrangChu;
import Model.EventMenuSelected;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MenuTaskbar mt;
	private JPanel pnMain;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					//frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setForm(JComponent component) {
		pnMain.removeAll();
		pnMain.add(component);
		pnMain.repaint();
		pnMain.revalidate();
	}
	
	public Main() {
		mt = new MenuTaskbar();
		
		mt.setBounds(0, 0, 220, 1035);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1386, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.add(mt);
		mt.setLayout(null);
		mt.addEventMenuSelected(new EventMenuSelected() {

			@Override
			public void selected(int index) {
				// System.out.println("Index: " + index);
				if(index == 0) {
					setForm(new TrangChu());
				}else if(index == 1) {
					setForm(new BenhNhan());
				}else if(index == 2) {
					setForm(new LichSu());
				}else if(index == 3) {
					setForm(new QuanLyThuoc());
				}else if(index == 4) {
					setForm(new BacSi());
				}else if(index == 5) {
					UIManager.put("OptionPane.background", Color.WHITE);
					UIManager.put("Panel.background", Color.WHITE);
					UIManager.put("OptionPane.messageForeground", Color.BLACK);
					UIManager.put("Button.background", new Color(70, 130, 180));
					UIManager.put("Button.foreground", Color.WHITE);

					int response = JOptionPane.showConfirmDialog(
							null,
							"Bạn có muốn đăng xuất?",
							"Đăng xuất",
							JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE
							);

					if (response == JOptionPane.OK_OPTION) {
						Login login = new Login();
						close();
						login.setVisible(true);
					}
				}
			}	
		});
		
		setContentPane(contentPane);
		
		pnMain = new JPanel();
		pnMain.setOpaque(false);
		pnMain.setBounds(220, 0, 1166, 729);
		contentPane.add(pnMain);
		pnMain.setLayout(new BorderLayout(0, 0));
		this.setLocationRelativeTo(null);
	}
	
	public void close() {
		this.setVisible(false);
		dispose();
	}
}
