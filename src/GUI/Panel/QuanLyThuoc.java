package GUI.Panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import GUI.Login;
import GUI.component.ScrollBar;
import GUI.component.Table;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

public class QuanLyThuoc extends JPanel {

	private static final long serialVersionUID = 1L;
	private Table table;
	private DefaultTableModel model;
	Color FontColor = new Color(96, 125, 139);
	private SearchBar searchBar;
	private AddBenhNhan adbn;
	private MdfBenhNhan mdfbn;

	public QuanLyThuoc() {
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
					"Mã thuốc", "Tên thuốc", "Đơn vị tính", "Giá", "Nhóm thuốc"
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
		
		JPanel pnAdd = new JPanel();
		pnAdd.setBackground(Color.WHITE);
		pnAdd.setBounds(10, 11, 67, 71);
		pnMenuBar.add(pnAdd);
		
		JLabel lblIconAdd = new JLabel("");
		lblIconAdd.setIcon(new ImageIcon(QuanLyThuoc.class.getResource("/Entity/1.png")));
		
		JLabel lblAdd = new JLabel("Thêm");
		lblAdd.setFont(new Font("SansSerif", Font.PLAIN, 16));
		GroupLayout gl_pnAdd = new GroupLayout(pnAdd);
		gl_pnAdd.setHorizontalGroup(
			gl_pnAdd.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 67, Short.MAX_VALUE)
				.addGroup(gl_pnAdd.createSequentialGroup()
					.addGap(20)
					.addComponent(lblIconAdd)
					.addContainerGap(27, Short.MAX_VALUE))
				.addGroup(gl_pnAdd.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAdd, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
		);
		gl_pnAdd.setVerticalGroup(
			gl_pnAdd.createParallelGroup(Alignment.LEADING)
				.addGap(0, 71, Short.MAX_VALUE)
				.addGroup(gl_pnAdd.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblIconAdd)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblAdd)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pnAdd.setLayout(gl_pnAdd);
		
		JPanel pnModify = new JPanel();
		pnModify.setBackground(Color.WHITE);
		pnModify.setBounds(83, 11, 67, 71);
		pnMenuBar.add(pnModify);
		
		JLabel lblModifyIcon = new JLabel("");
		lblModifyIcon.setIcon(new ImageIcon(QuanLyThuoc.class.getResource("/Entity/1.png")));
		
		JLabel lblModify = new JLabel("Sửa");
		lblModify.setFont(new Font("SansSerif", Font.PLAIN, 16));
		GroupLayout gl_pnModify = new GroupLayout(pnModify);
		gl_pnModify.setHorizontalGroup(
			gl_pnModify.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 67, Short.MAX_VALUE)
				.addGroup(gl_pnModify.createSequentialGroup()
					.addGap(20)
					.addComponent(lblModifyIcon)
					.addContainerGap(27, Short.MAX_VALUE))
				.addGroup(gl_pnModify.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblModify, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
		);
		gl_pnModify.setVerticalGroup(
			gl_pnModify.createParallelGroup(Alignment.LEADING)
				.addGap(0, 71, Short.MAX_VALUE)
				.addGroup(gl_pnModify.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblModifyIcon)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblModify)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pnModify.setLayout(gl_pnModify);
		
		JPanel pnDelete = new JPanel();
		pnDelete.setBackground(Color.WHITE);
		pnDelete.setBounds(156, 11, 67, 71);
		pnMenuBar.add(pnDelete);
		
		JLabel lblDeleteIcon = new JLabel("");
		lblDeleteIcon.setIcon(new ImageIcon(QuanLyThuoc.class.getResource("/Entity/1.png")));
		
		JLabel lblDelete = new JLabel("Xoá");
		lblDelete.setFont(new Font("SansSerif", Font.PLAIN, 16));
		GroupLayout gl_pnDelete = new GroupLayout(pnDelete);
		gl_pnDelete.setHorizontalGroup(
			gl_pnDelete.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnDelete.createSequentialGroup()
					.addGroup(gl_pnDelete.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnDelete.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDelete, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
						.addGroup(gl_pnDelete.createSequentialGroup()
							.addGap(22)
							.addComponent(lblDeleteIcon)))
					.addContainerGap())
		);
		gl_pnDelete.setVerticalGroup(
			gl_pnDelete.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnDelete.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDeleteIcon)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDelete)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pnDelete.setLayout(gl_pnDelete);
		
		// xu ly xu kien chuot
		eventMouse(pnAdd, 1);
		eventMouse(pnModify, 2);
		eventMouse(pnDelete, 3);
		pnMenuBar.setLayout(null);
		pnMenuBar.add(pnAdd);
		pnMenuBar.add(pnModify);
		pnMenuBar.add(pnDelete);
		
		addRow("001", "Nguyễn Văn A", "Nam", 10000, "Hà Nội");
        addRow("002", "Trần Thị B", "Nữ", 10000, "Đà Nẵng");
        addRow("001", "Nguyễn Văn A", "Nam", 10000, "Hà Nội");
        addRow("002", "Trần Thị B", "Nữ", 10000, "Đà Nẵng");
        addRow("001", "Nguyễn Văn A", "Nam", 10000, "Hà Nội");
	}
	
	public void addRow(String maThuoc, String tenThuoc, String donVi, double gia, String nhomThuoc) {
        model.addRow(new Object[] { maThuoc, tenThuoc, donVi, gia, nhomThuoc });
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
            	pn.setBackground(Color.white);
            	pn.setForeground(Color.white);
            }
        });
	}
	
	public void pnlLogInMousePressed(java.awt.event.MouseEvent evt, int i) throws UnsupportedLookAndFeelException {
        if(i == 1) {
        	adbn = new AddBenhNhan();
        	adbn.setVisible(true);
        }else if(i == 2) {
        	mdfbn = new MdfBenhNhan();
        	mdfbn.setVisible(true);
        }else if(i == 3) {
        	
        }
    }
}
