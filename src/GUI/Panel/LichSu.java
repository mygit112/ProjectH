package GUI.Panel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UnsupportedLookAndFeelException;

import GUI.Login;
import GUI.component.ScrollBar;
import GUI.component.Table;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class LichSu extends JPanel {

	private static final long serialVersionUID = 1L;
	private Table table;
	private DefaultTableModel model;
	Color FontColor = new Color(96, 125, 139);
	private SearchBar searchBar;
	private AddBenhNhan adbn;

	public LichSu() {
		setBackground(new Color(240, 240, 240));
		setBounds(220, 0, 1166, 729);
		
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(25, 159, 1115, 570);
		panel.setLayout(null);
		
		model = new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"Mã bệnh nhân", "Tên bệnh nhân", "Ngày khám", "Chuẩn đoán", "Ghi chú"
				}
			);
		
		table = new Table();
		table.setModel(model);
		table.setFont(new Font("SansSerif", Font.PLAIN, 12));
		table.setBounds(0, 0, 1140, 398);
		
		JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(table); // Thiết lập bảng cho JScrollPane
        scroll.setBounds(0, 0, 1115, 560);
		scroll.setVerticalScrollBar(new ScrollBar());
        
		panel.add(scroll);
		add(panel);
		
		JPanel pnMenuBar = new JPanel();
		pnMenuBar.setBackground(Color.WHITE);
		pnMenuBar.setBounds(25, 37, 1115, 92);
		
		searchBar = new SearchBar();
		searchBar.setBounds(474, 11, 631, 71);
		pnMenuBar.add(searchBar);
		
		add(pnMenuBar);
		pnMenuBar.setLayout(null);
		
		addRow("001", "Nguyễn Văn A", "Nam", "01/01/1990", "Hà Nội");
        addRow("002", "Trần Thị B", "Nữ", "02/02/1995", "Đà Nẵng");
        addRow("001", "Nguyễn Văn A", "Nam", "01/01/1990", "Hà Nội");
        addRow("002", "Trần Thị B", "Nữ", "02/02/1995", "Đà Nẵng");
        addRow("001", "Nguyễn Văn A", "Nam", "01/01/1990", "Hà Nội");
        addRow("002", "Trần Thị B", "Nữ", "02/02/1995", "Đà Nẵng");
        addRow("001", "Nguyễn Văn A", "Nam", "01/01/1990", "Hà Nội");
        addRow("002", "Trần Thị B", "Nữ", "02/02/1995", "Đà Nẵng");
        addRow("001", "Nguyễn Văn A", "Nam", "01/01/1990", "Hà Nội");
        addRow("002", "Trần Thị B", "Nữ", "02/02/1995", "Đà Nẵng");
        addRow("001", "Nguyễn Văn A", "Nam", "01/01/1990", "Hà Nội");
        addRow("002", "Trần Thị B", "Nữ", "02/02/1995", "Đà Nẵng");
        addRow("001", "Nguyễn Văn A", "Nam", "01/01/1990", "Hà Nội");
        addRow("002", "Trần Thị B", "Nữ", "02/02/1995", "Đà Nẵng");
	}
	
	public void addRow(String maBenhNhan, String tenBenhNhan, String ngayKham, String chuanDoan, String ghiChu) {
        model.addRow(new Object[] { maBenhNhan, tenBenhNhan, ngayKham, chuanDoan, ghiChu });
    }
	
	public void eventMouse(JPanel pn, int i) {
	}
	
	public void pnlLogInMousePressed(java.awt.event.MouseEvent evt, int i) throws UnsupportedLookAndFeelException {
        
    }
	
//	private void pnlLogInMouseEntered(java.awt.event.MouseEvent evt, JPanel pn) {
//		pn.setBackground(FontColor);
//		pn.setForeground(Color.gray);
//    }
//
//    private void pnlLogInMouseExited(java.awt.event.MouseEvent evt, JPanel pn) {
//    	pn.setBackground(Color.white);
//    	pn.setForeground(Color.white);
//    }
}
