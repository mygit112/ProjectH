package GUI;

import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import DTO.TaiKhoanDTO;
import GUI.Panel.BacSi;
import GUI.Panel.BenhNhan;
import GUI.Panel.LichSuKham;
import GUI.Panel.MenuTaskbar;
import GUI.Panel.QuanLyThuoc;
import GUI.Panel.TrangChu;
import Model.EventMenuSelected;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MenuTaskbar mt;
	private JPanel pnMain;
	
	public void setForm(JComponent component) {
		pnMain.removeAll();
		pnMain.add(component);
		pnMain.repaint();
		pnMain.revalidate();
	}
	
	public Main(TaiKhoanDTO tkDTO) {
		this.setTitle("Hệ thống quản lý khám chữa bệnh");
		this.setUndecorated(true);
		
		mt = new MenuTaskbar(tkDTO);
		
		mt.setBounds(0, 0, 240, 1035);
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
					setForm(new BenhNhan(tkDTO));
				}else if(index == 2) {
					setForm(new LichSuKham(tkDTO));
				}else if(index == 3) {
					setForm(new QuanLyThuoc(tkDTO));
				}else if(index == 4) {
					setForm(new BacSi(tkDTO));
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
		pnMain.setBounds(240, 0, 1130, 729);
		contentPane.add(pnMain);
		pnMain.setLayout(new BorderLayout(0, 0));
		this.setLocationRelativeTo(null);
		
		setForm(new TrangChu());
	}
	
	public void close() {
		this.setVisible(false);
		dispose();
	}
	
}
