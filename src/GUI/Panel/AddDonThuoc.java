package GUI.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import BUS.QuanLyThuocBUS;
import DAO.QuanLyThuocDAO;
import DTO.QuanLyThuocDTO;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import GUI.Login;
import GUI.component.SelectForm;
import GUI.component.Text;

public class AddDonThuoc extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Color FontColor = new Color(96, 125, 139);
	private JLabel lblThemThuoc;
	private JLabel lblThem_XN;
	private JLabel lblHuyBo;
	private QuanLyThuoc ql;
	private Text tTenthuoc;
	private Text tGia;
	private Text tDonvi;
	private Text tSoluong;
	private SelectForm cbxNhomThuoc;
	private QuanLyThuocBUS qltBUS = new QuanLyThuocBUS();
	private QuanLyThuocDTO qltDTO;
	private QuanLyThuoc qlt;

	public AddDonThuoc(QuanLyThuocDTO qltDTO, QuanLyThuocBUS qltBUS, QuanLyThuoc qlt, String type, String title) {
		this.qltDTO = qltDTO;
		this.qltBUS = qltBUS;
		this.qlt = qlt;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 704);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setBackground(new Color(0, 153, 255));
		pnTitle.setBounds(0, 0, 420, 79);
		contentPane.add(pnTitle);
		
		lblThemThuoc = new JLabel(title);
		lblThemThuoc.setForeground(Color.WHITE);
		lblThemThuoc.setFont(new Font("SansSerif", Font.PLAIN, 30));
		GroupLayout gl_pnTitle = new GroupLayout(pnTitle);
		gl_pnTitle.setHorizontalGroup(
			gl_pnTitle.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTitle.createSequentialGroup()
					.addGap(135)
					.addComponent(lblThemThuoc)
					.addContainerGap(576, Short.MAX_VALUE))
		);
		gl_pnTitle.setVerticalGroup(
			gl_pnTitle.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTitle.createSequentialGroup()
					.addGap(20)
					.addComponent(lblThemThuoc)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		pnTitle.setLayout(gl_pnTitle);
		
		JPanel pnMain = new JPanel();
		pnMain.setLayout(null);
		pnMain.setBounds(0, 78, 420, 539);
		contentPane.add(pnMain);
		
		tTenthuoc = new Text();
		tTenthuoc.setBounds(10, 60, 400, 45);
		pnMain.add(tTenthuoc);
		
		JLabel lblTenThuoc = new JLabel("Tên thuốc");
		lblTenThuoc.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblTenThuoc.setBounds(10, 12, 200, 37);
		pnMain.add(lblTenThuoc);
		
		JLabel lblDonVi = new JLabel("Dơn vị tính");
		lblDonVi.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblDonVi.setBounds(10, 116, 200, 37);
		pnMain.add(lblDonVi);
		
		JLabel lblNhomThuoc = new JLabel("Nhóm thuốc");
		lblNhomThuoc.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNhomThuoc.setBounds(10, 324, 200, 37);
		pnMain.add(lblNhomThuoc);
		
		JLabel lblGiaThuoc = new JLabel("Giá thuốc");
		lblGiaThuoc.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblGiaThuoc.setBounds(10, 220, 200, 37);
		pnMain.add(lblGiaThuoc);
		
		tGia = new Text();
		tGia.setBounds(10, 268, 400, 45);
		pnMain.add(tGia);
		
		tDonvi = new Text();
		tDonvi.setBounds(10, 164, 400, 45);
		pnMain.add(tDonvi);
		
//		sexCustom sex = new sexCustom();
//		sex.setBounds(10, 372, 400, 45);
//		pnMain.add(sex);
		
		// handle
		String[] listnhomthuoc = qltBUS.getArrNhomThuoc();
		listnhomthuoc = Stream.concat(Stream.of("Tất cả"), Arrays.stream(listnhomthuoc)).toArray(String[]::new);
		
		// init cbx
		cbxNhomThuoc = new SelectForm(listnhomthuoc);
		cbxNhomThuoc.setBounds(10, 372, 400, 45);
		pnMain.add(cbxNhomThuoc);
		
		JLabel lblGiaThuoc_1 = new JLabel("Số lượng");
		lblGiaThuoc_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblGiaThuoc_1.setBounds(10, 428, 200, 37);
		pnMain.add(lblGiaThuoc_1);
		
		tSoluong = new Text();
		tSoluong.setBounds(10, 476, 400, 45);
		pnMain.add(tSoluong);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 618, 420, 85);
		contentPane.add(panel);
		
		JPanel pnAdd = new JPanel();
		pnAdd.setLayout(null);
		pnAdd.setBackground(new Color(0, 206, 209));
		pnAdd.setBounds(57, 11, 136, 49);
		panel.add(pnAdd);
		
		JPanel pnCancel = new JPanel();
		pnCancel.setLayout(null);
		pnCancel.setBackground(new Color(255, 0, 51));
		pnCancel.setBounds(219, 11, 136, 49);
		panel.add(pnCancel);
		
		// xu ly nhap vao them hoac sua
		switch (type) {
		case "them":
			lblThem_XN = new JLabel("Thêm");
			lblThem_XN.setForeground(Color.WHITE);
			lblThem_XN.setFont(new Font("SansSerif", Font.PLAIN, 26));
			lblThem_XN.setBounds(27, 0, 109, 49);
			pnAdd.add(lblThem_XN);
			
			lblHuyBo = new JLabel("Huỷ bỏ");
			lblHuyBo.setForeground(Color.WHITE);
			lblHuyBo.setFont(new Font("SansSerif", Font.PLAIN, 26));
			lblHuyBo.setBounds(24, 0, 112, 49);
			pnCancel.add(lblHuyBo);
			
			// xu ly su kien bam nut
			eventMouse(pnAdd, 1);
			eventMouse(pnCancel, 2);
			break;
		case "sua":
			int selectedRow = qlt.table.getSelectedRow();
			String tenthuoc = (String) qlt.table.getValueAt(selectedRow, 1);
			String donvitinh = (String) qlt.table.getValueAt(selectedRow, 2);
			double giadb = (Double) qlt.table.getValueAt(selectedRow, 3);
			String gia = Double.toString(giadb);
			String nhomthuoc = (String) qlt.table.getValueAt(selectedRow, 4);
			int soluongint = (Integer) qlt.table.getValueAt(selectedRow, 5);
			String soluong = Integer.toString(soluongint);
			
			tTenthuoc.setText(tenthuoc);
			tDonvi.setText(donvitinh);
			tGia.setText(gia);
			cbxNhomThuoc.setSelectedIndex(0);
			tSoluong.setText(soluong);
			
			lblThem_XN = new JLabel("Lưu");
			lblThem_XN.setForeground(Color.WHITE);
			lblThem_XN.setFont(new Font("SansSerif", Font.PLAIN, 26));
			lblThem_XN.setBounds(42, 0, 109, 49);
			pnAdd.add(lblThem_XN);
			
			lblHuyBo = new JLabel("Huỷ bỏ");
			lblHuyBo.setForeground(Color.WHITE);
			lblHuyBo.setFont(new Font("SansSerif", Font.PLAIN, 26));
			lblHuyBo.setBounds(24, 0, 112, 49);
			pnCancel.add(lblHuyBo);
			
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
			// them thuoc bai bang (chua code)
			if (validForm()) {
				int mathuoc = QuanLyThuocDAO.getInstance().getAutoIncrement();
				String tenthuoc = tTenthuoc.getText();
				String donvitinh = tDonvi.getText();
				double gia = Double.parseDouble(tGia.getText());
				String nhomthuoc = (String) cbxNhomThuoc.getSelectedItem();
				int soluong = Integer.parseInt(tSoluong.getText());
				QuanLyThuocDTO qlt = new QuanLyThuocDTO(mathuoc, tenthuoc, donvitinh, gia, nhomthuoc, soluong, 1);
				QuanLyThuocDAO.getInstance().insert(qlt);
				qltBUS.insertThuoc(qlt);;
				qltBUS.loadTable();
				this.setVisible(false);
				dispose();
			}
		}else if(i == 2) {
			// huy bo viec them
			this.setVisible(false);
			dispose();
		}else if(i == 3) {
			// thuc hien thay doi thong tin trong bang
			//System.out.println(qltDTO.getTenthuoc());
			if(validForm()) {
				String tenthuoc = tTenthuoc.getText();
				String donvitinh = tDonvi.getText();
				double gia = Double.parseDouble(tGia.getText());
				String nhomthuoc = (String) cbxNhomThuoc.getSelectedItem();
				int soluong = Integer.parseInt(tSoluong.getText());
				QuanLyThuocDTO qlt = new QuanLyThuocDTO(qltDTO.getMathuoc(), tenthuoc, donvitinh, gia, nhomthuoc, soluong, 1);
				QuanLyThuocDAO.getInstance().update(qlt);
				qltBUS.listqlt.set(qltBUS.getIndex(), qlt);
				qltBUS.loadTable();
				this.setVisible(false);
				dispose();
			}
		}
	}
	
	public boolean validForm() {
	    // Kiểm tra tên thuốc không được để trống
	    if (tTenthuoc.getText().trim().equals("")) {
	        JOptionPane.showMessageDialog(null, "Tên thuốc không được để trống!", "Cảnh báo!", JOptionPane.ERROR_MESSAGE);
	        return false;
	    }

	    // Kiểm tra đơn vị tính không được để trống
	    if (tDonvi.getText().trim().equals("")) {
	        JOptionPane.showMessageDialog(null, "Đơn vị tính không được để trống!", "Cảnh báo!", JOptionPane.ERROR_MESSAGE);
	        return false;
	    }

	    // Kiểm tra giá thuốc phải là một số và lớn hơn 0
	    try {
	        double gia = Double.parseDouble(tGia.getText());
	        if (gia <= 0) {
	            JOptionPane.showMessageDialog(null, "Giá thuốc phải lớn hơn 0!", "Cảnh báo!", JOptionPane.ERROR_MESSAGE);
	            return false;
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Giá thuốc không hợp lệ! Vui lòng nhập lại.", "Cảnh báo!", JOptionPane.ERROR_MESSAGE);
	        return false;
	    }

	    // Kiểm tra số lượng thuốc phải là một số nguyên và lớn hơn hoặc bằng 0
	    try {
	        int soluong = Integer.parseInt(tSoluong.getText());
	        if (soluong < 0) {
	            JOptionPane.showMessageDialog(null, "Số lượng thuốc phải lớn hơn hoặc bằng 0!", "Cảnh báo!", JOptionPane.ERROR_MESSAGE);
	            return false;
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Số lượng thuốc không hợp lệ! Vui lòng nhập lại.", "Cảnh báo!", JOptionPane.ERROR_MESSAGE);
	        return false;
	    }

	    // Kiểm tra nhóm thuốc phải được chọn
	    if (cbxNhomThuoc.getSelectedIndex() == 0 || cbxNhomThuoc.getSelectedItem().toString().equals("Chọn nhóm thuốc")) {
	        JOptionPane.showMessageDialog(null, "Vui lòng chọn nhóm thuốc!", "Cảnh báo!", JOptionPane.ERROR_MESSAGE);
	        return false;
	    }

	    // Nếu tất cả các kiểm tra đều hợp lệ
	    return true;
	}

	
	public void loadDataTable(ArrayList<QuanLyThuocDTO> result) {
		ql.model.setRowCount(0);
		for(QuanLyThuocDTO thuoc : result) {
			ql.model.addRow(new Object[] {thuoc.getMathuoc(), thuoc.getTenthuoc(),
					thuoc.getDonvitinh(), thuoc.getGia(), thuoc.getNhomthuoc()
			});
		}
	}
}
