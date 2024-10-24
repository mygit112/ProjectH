package GUI.Panel;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import GUI.component.ListMenu;
import GUI.component.MenuComponent;
import Model.EventMenuSelected;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class MenuTaskbar extends JPanel {

	private static final long serialVersionUID = 1L;
	private ListMenu<Object> list;
	private EventMenuSelected event;
	
	public void addEventMenuSelected(EventMenuSelected event) {
		this.event = event;
		list.addEventMenuSelected(event);
	}
	
	public MenuTaskbar() {
		
		setOpaque(false);
		setLayout(null);
		
		list = new ListMenu<Object>();
		list.setOpaque(false);
		list.setBounds(0, 82, 245, 413);
		add(list);
		init();
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setOpaque(false);
		panel1.setBounds(0, 0, 245, 80);
		add(panel1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MenuTaskbar.class.getResource("/Entity/doctor.png")));
		lblNewLabel.setBounds(0, 0, 80, 80);
		panel1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("mèo nè");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNewLabel_1.setBounds(85, 0, 155, 51);
		panel1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Khè");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(85, 51, 155, 29);
		panel1.add(lblNewLabel_2);
		
		
		
	}
	
	// them thanh phan vao thanh taskbar
	public void init() {
		list.addItem(new MenuComponent("2", "Trang chủ", MenuComponent.MenuType.MENU));
		list.addItem(new MenuComponent("patient", "Bệnh nhân", MenuComponent.MenuType.MENU));
		list.addItem(new MenuComponent("history", "Lịch sử khám", MenuComponent.MenuType.MENU));
		list.addItem(new MenuComponent("medicine", "Quản lý thuốc", MenuComponent.MenuType.MENU));
		list.addItem(new MenuComponent("doctorteam", "Bác sĩ", MenuComponent.MenuType.MENU));
		list.addItem(new MenuComponent("logout", "Đăng xuất", MenuComponent.MenuType.MENU));
	}
	
	@Override
	protected void paintChildren(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#1CB5E0"), 0, getHeight(), Color.decode("#000046"));
        g2.setPaint(gp);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(g);
		super.paintChildren(g);
	}
	
}
