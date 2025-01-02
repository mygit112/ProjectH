package GUI.Panel;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import DAO.BacSiDAO;
import DTO.BacSiDTO;
import DTO.TaiKhoanDTO;
import GUI.component.ListMenu;
import GUI.component.MenuComponent;
import Model.EventMenuSelected;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class MenuTaskbar extends JPanel {

	private static final long serialVersionUID = 1L;
	private ListMenu<Object> list;
	private EventMenuSelected event;
	TaiKhoanDTO tkDTO;
	BacSiDTO bsDTO;
	private JLabel lblName;
	private JLabel lblPhanQuyen;
	
	public void addEventMenuSelected(EventMenuSelected event) {
		this.event = event;
		list.addEventMenuSelected(event);
	}
	
	public MenuTaskbar(TaiKhoanDTO tkDTO) {
		this.tkDTO = tkDTO;
		this.bsDTO = BacSiDAO.getInstance().selectById(Integer.toString(tkDTO.getManv()));
		
		setOpaque(false);
		setLayout(null);
		
		list = new ListMenu<Object>();
		list.setOpaque(false);
		list.setBounds(0, 82, 245, 413);
		add(list);
		init();
		
		JPanel panel1 = new JPanel();
		panel1.setOpaque(false);
		panel1.setBounds(0, 0, 245, 80);
		add(panel1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MenuTaskbar.class.getResource("/img/doctor.png")));
		
		if(bsDTO == null) {
			this.bsDTO = new BacSiDTO();
			this.bsDTO.setTenbs("Quản trị viên");
			lblName = new JLabel(bsDTO.getTenbs());
			lblName.setForeground(Color.WHITE);
			lblName.setFont(new Font("SansSerif", Font.BOLD, 16));
		}else {
			
		}
		lblName = new JLabel(bsDTO.getTenbs());
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("SansSerif", Font.BOLD, 16));
		// để 3 dong code ở else xuống dưới để mở design
		
		lblPhanQuyen = new JLabel(tkDTO.getPhanQuyen() == 1 ? "Admin" : "Bác sĩ");
		lblPhanQuyen.setForeground(Color.WHITE);
		lblPhanQuyen.setFont(new Font("SansSerif", Font.PLAIN, 15));
		GroupLayout gl_panel1 = new GroupLayout(panel1);
		gl_panel1.setHorizontalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel)
					.addGap(6)
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblName)
						.addComponent(lblPhanQuyen))
					.addGap(29))
		);
		gl_panel1.setVerticalGroup(
			gl_panel1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblName)
							.addGap(18)
							.addComponent(lblPhanQuyen))
						.addComponent(lblNewLabel))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel1.setLayout(gl_panel1);
		
		
		
	}
	
	// them thanh phan vao thanh taskbar
	public void init() {
		list.addItem(new MenuComponent("trangchu", "Trang chủ", MenuComponent.MenuType.MENU));
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
	    g2.fillRect(0, 0, getWidth(), getHeight());
	    super.paintChildren(g); 
	}

}
