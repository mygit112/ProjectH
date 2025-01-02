package GUI.Panel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UnsupportedLookAndFeelException;

import GUI.Login;
import GUI.component.InputDate;
import GUI.component.ScrollBar;
import GUI.component.SuggestionPopup;
import GUI.component.Table;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;

import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import BUS.BenhNhanBUS;
import BUS.QuanLyThuocBUS;
import DAO.BenhNhanDAO;
import DAO.QuanLyThuocDAO;
import DTO.BenhNhanDTO;
import DTO.QuanLyThuocDTO;
import DTO.TaiKhoanDTO;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ImageIcon;

import GUI.component.Text;
import Model.writePDF;

import java.awt.FlowLayout;

public class BenhNhan extends JPanel {

	private static final long serialVersionUID = 1L;
	protected Table table, tablethuoc;
	protected DefaultTableModel model, modelthuoc;
	Color FontColor = new Color(96, 125, 139);
	private JPanel pnThem;
	private JPanel pnSua;
	private AddBenhNhan addbn;
	protected InputDate Ngaytaikham;
	protected int selectedRow;
	private QuanLyThuocBUS qltBUS = new QuanLyThuocBUS();
	private BenhNhanBUS bnBUS = new BenhNhanBUS(this);
	private BenhNhanDTO bnDTO = new BenhNhanDTO();
	private ArrayList<BenhNhanDTO> listbn = bnBUS.getListBn();
	protected Text tHoten, tTuoi, tChuandoan, tLoiDan, tNgaykham, tGioitinh, tTenthuoc, tGhichu, tNgaysudung, tSang, tTrua, tToi;
	private JPanel pnNhapthuoc;
	private JPanel pnXoathuoc;
	private SuggestionPopup suggestionPopup;
	private ArrayList<String> drugList = new ArrayList<String>();
	private ArrayList<String> tenthuoc, ghichu;
	private ArrayList<Integer> songay, sang, trua, toi, soluong;
	private TaiKhoanDTO tkDTO;
	
	public BenhNhan(TaiKhoanDTO tkDTO) {
		this.tkDTO = tkDTO;
		
		setBackground(new Color(240, 240, 240));
		setBounds(220, 0, 1130, 729);
		
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 114, 297, 604);
		panel.setLayout(null);
		
		model = new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"Mã bệnh nhân", "Tên bệnh nhân", "Tuổi", "Giới tính", "Số BHYT", "Địa chỉ",
					"SDT", "Chiều cao", "Cân nặng", "Ngày khám", "Triệu chứng"
				}
			);
		
		table = new Table();
		table.setModel(model);
		table.setFont(new Font("SansSerif", Font.PLAIN, 12));
//		table.setBounds(0, 0, 1140, 398);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
		loadDataTable(listbn);
		
		// xu ly su kien nhan vao bang
		tableAction(table);
		
		// custom kích thước chiều ngang cột
//		TableColumnModel columnModel = table.getColumnModel();
//		TableColumn column = columnModel.getColumn(0);
//		column.setPreferredWidth(150);
		
		JScrollPane scroll = new JScrollPane();
		
        scroll.setViewportView(table); // Thiết lập bảng cho JScrollPane
//        scroll.setBounds(0, 11, 298, 331);
		scroll.setVerticalScrollBar(new ScrollBar()); // lam thanh truot dep hon
        // scroll.setHorizontalScrollBar(new ScrollBar());
		
		panel.add(scroll);
		add(panel);
		
		JPanel pnMenuBar = new JPanel();
		pnMenuBar.setBackground(Color.WHITE);
		pnMenuBar.setBounds(10, 11, 1110, 92);
		
		add(pnMenuBar);
		
		pnThem = new JPanel();
		pnThem.setBackground(Color.WHITE);
		
		pnSua = new JPanel();
		pnSua.setBackground(Color.WHITE);
		
		JLabel lblModifyIcon = new JLabel("");
		lblModifyIcon.setIcon(new ImageIcon(BenhNhan.class.getResource("/img/pencil.png")));
		
		JLabel lblModify = new JLabel("Sửa");
		lblModify.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		JPanel pnXoa = new JPanel();
		pnXoa.setBackground(Color.WHITE);
		
		JLabel lblDeleteIcon = new JLabel("");
		lblDeleteIcon.setIcon(new ImageIcon(BenhNhan.class.getResource("/img/delete.png")));
		
		JLabel lblDelete = new JLabel("Xoá");
		lblDelete.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		JLabel lblIconAdd = new JLabel("");
		lblIconAdd.setIcon(new ImageIcon(BenhNhan.class.getResource("/img/add.png")));
		
		JLabel lblAdd = new JLabel("Thêm");
		lblAdd.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		pnMenuBar.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		pnMenuBar.add(pnThem);
		pnThem.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pnThem.add(lblIconAdd);
		pnThem.add(lblAdd);
		pnMenuBar.add(pnSua);
		pnSua.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pnSua.add(lblModifyIcon);
		pnSua.add(lblModify);
		pnMenuBar.add(pnXoa);
		pnXoa.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pnXoa.add(lblDeleteIcon);
		pnXoa.add(lblDelete);
		
		JPanel pnLuu = new JPanel();
		pnLuu.setBackground(Color.WHITE);
		pnMenuBar.add(pnLuu);
		pnLuu.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblDeleteIcon_1 = new JLabel("");
		lblDeleteIcon_1.setIcon(new ImageIcon(BenhNhan.class.getResource("/img/save.png")));
		pnLuu.add(lblDeleteIcon_1);
		
		JLabel lblLuuw = new JLabel("Lưu");
		lblLuuw.setFont(new Font("SansSerif", Font.PLAIN, 16));
		pnLuu.add(lblLuuw);
		
		JPanel pnKhamxong = new JPanel();
		pnKhamxong.setBackground(Color.WHITE);
		pnMenuBar.add(pnKhamxong);
		pnKhamxong.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblModifyIcon_1 = new JLabel("");
		lblModifyIcon_1.setIcon(new ImageIcon(BenhNhan.class.getResource("/img/complete.png")));
		pnKhamxong.add(lblModifyIcon_1);
		
		JLabel lblKhmXong = new JLabel("Khám xong");
		lblKhmXong.setFont(new Font("SansSerif", Font.PLAIN, 16));
		pnKhamxong.add(lblKhmXong);
		
		JPanel pnXuatpdf = new JPanel();
		pnXuatpdf.setBackground(Color.WHITE);
		pnMenuBar.add(pnXuatpdf);
		
		JLabel lblIconXuat = new JLabel("");
		lblIconXuat.setIcon(new ImageIcon(BenhNhan.class.getResource("/img/pdf.png")));
		pnXuatpdf.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pnXuatpdf.add(lblIconXuat);
		
		JLabel lblXuat = new JLabel("Xuất PDF");
		lblXuat.setFont(new Font("SansSerif", Font.PLAIN, 16));
		pnXuatpdf.add(lblXuat);
		
		JPanel pnThongTin = new JPanel();
		pnThongTin.setBackground(new Color(255, 255, 255));
		pnThongTin.setBounds(317, 114, 333, 604);
		add(pnThongTin);
		pnThongTin.setLayout(null);
		
		JLabel lblThngTinBnh = new JLabel("Thông tin bệnh nhân");
		lblThngTinBnh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblThngTinBnh.setBounds(10, 11, 167, 20);
		pnThongTin.add(lblThngTinBnh);
		
		JLabel lblHTen = new JLabel("Họ tên");
		lblHTen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHTen.setBounds(28, 42, 54, 30);
		pnThongTin.add(lblHTen);
		
		tHoten = new Text();
		tHoten.setEditable(false);
		tHoten.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tHoten.setBounds(112, 42, 211, 30);
		pnThongTin.add(tHoten);
		
		JLabel lblTui = new JLabel("Tuổi");
		lblTui.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTui.setBounds(38, 83, 35, 30);
		pnThongTin.add(lblTui);
		
		tTuoi = new Text();
		tTuoi.setEditable(false);
		tTuoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tTuoi.setBounds(112, 83, 46, 30);
		pnThongTin.add(tTuoi);
		
		JLabel lblTui_1 = new JLabel("Giới tính");
		lblTui_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTui_1.setBounds(166, 83, 72, 30);
		pnThongTin.add(lblTui_1);
		
		JLabel lblaCh_1_1 = new JLabel("Ngày khám");
		lblaCh_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblaCh_1_1.setBounds(10, 124, 94, 30);
		pnThongTin.add(lblaCh_1_1);
		
		JLabel lblaCh_1_1_1_1 = new JLabel("Chuẩn đoán");
		lblaCh_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblaCh_1_1_1_1.setBounds(10, 165, 102, 30);
		pnThongTin.add(lblaCh_1_1_1_1);
		
		tChuandoan = new Text();
		tChuandoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tChuandoan.setBounds(112, 165, 211, 30);
		pnThongTin.add(tChuandoan);
		
		JLabel lblaCh_1_1_1_2 = new JLabel("Lời dặn");
		lblaCh_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblaCh_1_1_1_2.setBounds(39, 208, 65, 30);
		pnThongTin.add(lblaCh_1_1_1_2);
		
		tLoiDan = new Text();
		tLoiDan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tLoiDan.setBounds(112, 208, 211, 30);
		pnThongTin.add(tLoiDan);
		
		JLabel lblaCh_1_1_1_2_1 = new JLabel("Tái khám");
		lblaCh_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblaCh_1_1_1_2_1.setBounds(26, 249, 78, 30);
		pnThongTin.add(lblaCh_1_1_1_2_1);
		
		tNgaykham = new Text();
		tNgaykham.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tNgaykham.setEditable(false);
		tNgaykham.setBounds(112, 124, 211, 30);
		pnThongTin.add(tNgaykham);
		
		JPanel pnDonThuoc = new JPanel();
		pnDonThuoc.setBackground(new Color(255, 255, 255));
		pnDonThuoc.setBounds(660, 114, 460, 604);
		add(pnDonThuoc);
		pnDonThuoc.setLayout(null);
		
		JLabel lblnThuc = new JLabel("Kê đơn thuốc");
		lblnThuc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblnThuc.setBounds(10, 11, 106, 20);
		pnDonThuoc.add(lblnThuc);
		
		JLabel lblTnThuc = new JLabel("Tên thuốc");
		lblTnThuc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTnThuc.setBounds(25, 42, 83, 30);
		pnDonThuoc.add(lblTnThuc);
		
		// handle
		String[] listqlt = qltBUS.getArrTenDangUong();
		listqlt = Stream.concat(Stream.of("Tất cả"), Arrays.stream(listqlt)).toArray(String[]::new);
		
		JLabel lblTnThuc_1 = new JLabel("Ghi chú");
		lblTnThuc_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTnThuc_1.setBounds(25, 165, 83, 30);
		pnDonThuoc.add(lblTnThuc_1);
		
		tGhichu = new Text();
		tGhichu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tGhichu.setBounds(121, 165, 319, 30);
		pnDonThuoc.add(tGhichu);
		
		pnNhapthuoc = new JPanel();
		pnNhapthuoc.setBackground(Color.WHITE);
		pnNhapthuoc.setBackground(new Color(0, 206, 209));
		pnNhapthuoc.setBounds(81, 206, 125, 50);
		pnDonThuoc.add(pnNhapthuoc);
		
		JLabel lblNhp = new JLabel("Nhập");
		lblNhp.setFont(new Font("SansSerif", Font.PLAIN, 16));
		GroupLayout gl_pnNhapthuoc = new GroupLayout(pnNhapthuoc);
		gl_pnNhapthuoc.setHorizontalGroup(
			gl_pnNhapthuoc.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnNhapthuoc.createSequentialGroup()
					.addContainerGap(40, Short.MAX_VALUE)
					.addComponent(lblNhp, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(35))
		);
		gl_pnNhapthuoc.setVerticalGroup(
			gl_pnNhapthuoc.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnNhapthuoc.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNhp)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		pnNhapthuoc.setLayout(gl_pnNhapthuoc);
		
		pnXoathuoc = new JPanel();
		pnXoathuoc.setBackground(Color.WHITE);
		pnXoathuoc.setBackground(new Color(255, 0, 51));
		pnXoathuoc.setBounds(244, 206, 125, 50);
		pnDonThuoc.add(pnXoathuoc);
		
		JLabel lblAdd_1_1 = new JLabel("Xoá");
		lblAdd_1_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		GroupLayout gl_pnXoathuoc = new GroupLayout(pnXoathuoc);
		gl_pnXoathuoc.setHorizontalGroup(
			gl_pnXoathuoc.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 125, Short.MAX_VALUE)
				.addGroup(gl_pnXoathuoc.createSequentialGroup()
					.addContainerGap(40, Short.MAX_VALUE)
					.addComponent(lblAdd_1_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(35))
		);
		gl_pnXoathuoc.setVerticalGroup(
			gl_pnXoathuoc.createParallelGroup(Alignment.LEADING)
				.addGap(0, 50, Short.MAX_VALUE)
				.addGroup(gl_pnXoathuoc.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAdd_1_1)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		pnXoathuoc.setLayout(gl_pnXoathuoc);
		
		
		
		modelthuoc = new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"Tên thuốc", "Số ngày dùng", "Sáng", "Trưa", "Tối", "số lượng", "ghi chú"
				}
			);
		
		tablethuoc = new Table();
		tablethuoc.setModel(modelthuoc);
		tablethuoc.setFont(new Font("SansSerif", Font.PLAIN, 12));
		tablethuoc.setBounds(10, 308, 430, 252);
		tablethuoc.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JScrollPane scroll_1 = new JScrollPane();

		
		scroll_1.setViewportView(tablethuoc); // Thiết lập bảng cho JScrollPane
		scroll_1.setBounds(6, 267, 447, 337);
		scroll_1.setVerticalScrollBar(new ScrollBar()); // lam thanh truot dep hon
        // scroll.setHorizontalScrollBar(new ScrollBar());

		
		pnDonThuoc.add(scroll_1);
		
		tNgaysudung = new Text();
		tNgaysudung.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tNgaysudung.setBounds(121, 83, 319, 30);
		pnDonThuoc.add(tNgaysudung);
		
        scroll.setViewportView(table); // Thiết lập bảng cho JScrollPane
        scroll.setBounds(0, 0, 297, 604);
		scroll.setVerticalScrollBar(new ScrollBar()); // lam thanh truot dep hon
		
		// init jcalendar
		Ngaytaikham = new InputDate();
		Calendar currentCalendar = Calendar.getInstance();
		Date currentDate = new Date(currentCalendar.getTimeInMillis());
		Ngaytaikham.setMinSelectableDate(currentDate);
		Ngaytaikham.getDateChooser().setBounds(0, 10, 211, 30);
		Ngaytaikham.setBounds(112, 237, 211, 42);
		pnThongTin.add(Ngaytaikham);
		Ngaytaikham.setLayout(null);
		
		tGioitinh = new Text();
		tGioitinh.setEditable(false);
		tGioitinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tGioitinh.setBounds(248, 83, 75, 30);
		pnThongTin.add(tGioitinh);
		
		// xu ly xu kien chuot
		eventMouse(pnThem, 1, tkDTO);
		eventMouse(pnSua, 2, tkDTO);
		eventMouse(pnXoa, 3, tkDTO);
		eventMouse(pnLuu, 4, tkDTO);
		eventMouse(pnKhamxong, 5, tkDTO);
		eventMouse(pnXuatpdf, 6, tkDTO);
		eventMouse(pnNhapthuoc, 7, tkDTO);
		eventMouse(pnXoathuoc, 8, tkDTO);
		
		tTenthuoc = new Text();
		tTenthuoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tTenthuoc.setBounds(121, 42, 319, 30);
		pnDonThuoc.add(tTenthuoc);
		
//		String[] listqlt = qltBUS.getArrTenDangUong();
//		listqlt = Stream.concat(Stream.of("Tất cả"), Arrays.stream(listqlt)).toArray(String[]::new);
		
		// drugList = new ArrayList<>();
	    drugList.addAll(qltBUS.getArrTenThuoc());
	     
		suggestionPopup = new SuggestionPopup(tTenthuoc);
		
		JLabel lblSNgy = new JLabel("Số ngày");
		lblSNgy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSNgy.setBounds(35, 81, 72, 30);
		pnDonThuoc.add(lblSNgy);
		
		JLabel lblSng = new JLabel("Sáng");
		lblSng.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSng.setBounds(57, 124, 51, 30);
		pnDonThuoc.add(lblSng);
		
		tSang = new Text();
		tSang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tSang.setBounds(121, 124, 43, 30);
		pnDonThuoc.add(tSang);
		
		JLabel lblSNgy_1_1 = new JLabel("Trưa");
		lblSNgy_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSNgy_1_1.setBounds(191, 124, 43, 30);
		pnDonThuoc.add(lblSNgy_1_1);
		
		tTrua = new Text();
		tTrua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tTrua.setBounds(253, 124, 43, 30);
		pnDonThuoc.add(tTrua);
		
		JLabel lblSNgy_1_2 = new JLabel("Tối");
		lblSNgy_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSNgy_1_2.setBounds(320, 124, 43, 30);
		pnDonThuoc.add(lblSNgy_1_2);
		
		tToi = new Text();
		tToi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tToi.setBounds(373, 124, 43, 30);
		pnDonThuoc.add(tToi);
		
		tTenthuoc.setEditable(false);
		tNgaysudung.setEditable(false);
		tSang.setEditable(false);
		tTrua.setEditable(false);
		tToi.setEditable(false);
		tGhichu.setEditable(false);
		
		tTenthuoc.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String input = tTenthuoc.getText().toLowerCase();
                if (input.isEmpty()) {
                    suggestionPopup.setVisible(false); // Ẩn popup nếu không có nhập liệu
                    return;
                }

                // Lọc danh sách tên thuốc theo chuỗi đã nhập
                ArrayList<String> filteredDrugs = getFilteredDrugs(input);
                suggestionPopup.showSuggestions(filteredDrugs);
                
                
            }
        });
	}
	
	private ArrayList<String> getFilteredDrugs(String input) {
        ArrayList<String> filteredDrugs = new ArrayList<>();
        for (String drug : drugList) {
            if (drug.toLowerCase().contains(input)) {
                filteredDrugs.add(drug);
            }
        }
        return filteredDrugs;
    }
	
	public void eventMouse(JPanel pn, int i, TaiKhoanDTO tkDTO) {
		pn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
            	pn.setBackground(FontColor);
        		pn.setForeground(Color.gray);
            }
            
            @Override
            public void mousePressed(MouseEvent evt) {
                try {
                    pnlLogInMousePressed(evt, i, tkDTO);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseExited(MouseEvent evt) {
            	if(i == 7) {
            		pn.setBackground(new Color(0, 206, 209));
                	pn.setForeground(Color.white);
            	}else if(i == 8) {
            		pn.setBackground(new Color(255, 0, 51));
                	pn.setForeground(Color.white);
            	}else {
            		pn.setBackground(Color.white);
                	pn.setForeground(Color.white);
            	}
            }
        });
	}
	
	public void pnlLogInMousePressed(java.awt.event.MouseEvent evt, int i, TaiKhoanDTO tkDTO) throws UnsupportedLookAndFeelException {
        if(i == 1) {
        	// chuc nang them benh nhan (da xong)
        	addbn = new AddBenhNhan(tkDTO, bnDTO, bnBUS, this, "them", "THÊM BỆNH NHÂN");
        	addbn.setVisible(true);
        }else if(i == 2) {
        	// chuc nang sua du lieu benh nhan
        	selectedRow = getRowSelected();
        	if(selectedRow != -1) {
        		addbn = new AddBenhNhan(tkDTO, bnDTO, bnBUS, this, "sua", "SỬA BỆNH NHÂN");
            	addbn.setVisible(true);
        	}
        }else if(i == 3) {
        	// chuc nang xoa
        	selectedRow = getRowSelected();
        	if(selectedRow != -1) {
        		int input = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa?", "Xoá bệnh nhân", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        		if(input == 0) {
        			bnBUS.delete(listbn.get(selectedRow));
        			loadDataTable(listbn);
        		}
        	}
        }else if(i == 4) {
        	// chuc nang luu
        	selectedRow = getRowSelected();
        	if(selectedRow != -1) {
        		String chuandoan = tChuandoan.getText();
        		String loidan = tLoiDan.getText();
        		try {
        			java.util.Date utilDate = Ngaytaikham.getDate();
        			java.sql.Date taikham = new java.sql.Date(utilDate.getTime());
					//Date taikham = (Date) Ngaytaikham.getDate();
					bnDTO.setChuandoan(chuandoan);
	        		bnDTO.setLoidan(loidan);
	        		bnDTO.setNgaytaikham(taikham);
	        		BenhNhanDAO.getInstance().updateMore(bnDTO);
	        		bnBUS.listBN.set(bnBUS.getIndex(), bnDTO);
	        		//bnBUS.loadTable();
	        		JOptionPane.showMessageDialog(null, "Lưu thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        		} catch (ParseException e) {
					//e.printStackTrace();
				}
        		
        	}
        }else if(i == 5) {
        	// chuc nang xac nhan kham xong
        	selectedRow = getRowSelected();
        	if(selectedRow != -1) {
        		int input = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn đã khám xong?", "Khám bệnh nhân", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        		if(input == 0) {
        			bnBUS.complete(listbn.get(selectedRow));
        			loadDataTable(listbn);
        		}
        	}
        }else if(i == 6) {
        	// chuc nang xuat filde pdf
        	getDataThuoc();
        	if(tChuandoan.getText().equals("") || tLoiDan.getText().equals("")) {
        		JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        		return;
        	}else {
        		writePDF w = new writePDF();
            	w.writePN(this, bnDTO, tkDTO);
        	}

        }else if(i == 7) {
        	// chuc nang nhap thuoc vao bang
        	AddDataTableThuoc();
        }else if(i == 8) {
        	// chuc nang xoa thuoc
        	int selected = tablethuoc.getSelectedRow();
    		if(selected == -1) {
    			JOptionPane.showMessageDialog(null, "Vui lòng chọn một thuốc!", "Thông báo", JOptionPane.WARNING_MESSAGE);
    		}else {
    			// trả lại số lượng thuốc ban đầu nếu huỷ
    			int soluong = (int) modelthuoc.getValueAt(selected, 5);
    			String tenthuoc = (String) modelthuoc.getValueAt(selected, 0);
    			QuanLyThuocDTO qlt = new QuanLyThuocDTO();
    			qlt.setTenthuoc(tenthuoc);
    			QuanLyThuocDAO.getInstance().updateQuantityIfCancel(qlt, soluong);
    			
    			modelthuoc.removeRow(selected);
    		}
        }
    }
	
	public void getDataThuoc() {
		tenthuoc = new ArrayList<String>();
    	ghichu = new ArrayList<String>();
    	songay = new ArrayList<Integer>();
    	sang = new ArrayList<Integer>();
    	trua = new ArrayList<Integer>();
    	toi = new ArrayList<Integer>();
    	soluong = new ArrayList<Integer>();

    	for (int j = 0; j < tablethuoc.getRowCount(); j++) {
    		String tenThuoc = (String) tablethuoc.getValueAt(j, 0);
    	    String ghiChu = (String) tablethuoc.getValueAt(j, 6);
    	    Integer soNgay = (Integer) tablethuoc.getValueAt(j, 1);
    	    Integer sangValue = (Integer) tablethuoc.getValueAt(j, 2);
    	    Integer truaValue = (Integer) tablethuoc.getValueAt(j, 3);
    	    Integer toiValue = (Integer) tablethuoc.getValueAt(j, 4);
    	    Integer soLuong = (Integer) tablethuoc.getValueAt(j, 5);

    	    // Thêm giá trị vào các ArrayList
    	    tenthuoc.add(tenThuoc);
    	    ghichu.add(ghiChu);
    	    songay.add(soNgay);
    	    sang.add(sangValue);
    	    trua.add(truaValue);
    	    toi.add(toiValue);
    	    soluong.add(soLuong);
    	}
	}
	
	public int getRow() {
		return table.getSelectedRow();
	}
	
	public int getRowSelected() {
		int selected = table.getSelectedRow();
		if(selected == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn một bệnh nhân.", "Thông báo", JOptionPane.WARNING_MESSAGE);
		}
		return selected;
	}
	
	public BenhNhanDTO getBenhNhan() {
		return listbn.get(table.getSelectedRow());
	}
	
	public void loadDataTable(ArrayList<BenhNhanDTO> list) {
		listbn = list;
		model.setRowCount(0);
		for(BenhNhanDTO bn : listbn) {
			model.addRow(new Object[] {bn.getMabn(), bn.getHoten(),
					bn.getTuoi(), bn.getGioitinh() == 1 ? "Nam" : "Nữ", bn.getBhyt(),
					bn.getDiachi(), bn.getSdt(), bn.getChieucao(),
					bn.getCannang(), bn.getNgaykham(), bn.getTrieuchung()
					
			});
		}
	}
	
	// phuong thuc lay vi tri cua du lieu khi nhan vao bang
	public void tableAction(Table table) {
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				selectedRow = table.getSelectedRow();
				
				if(selectedRow != -1) {
					tTenthuoc.setEditable(true);
					tNgaysudung.setEditable(true);
					tSang.setEditable(true);
					tTrua.setEditable(true);
					tToi.setEditable(true);
					tGhichu.setEditable(true);
					
					int id = (int) table.getValueAt(selectedRow, 0);
					String hoten = (String) table.getValueAt(selectedRow, 1);
					int tuoiint = (Integer) table.getValueAt(selectedRow, 2);
					String tuoi = Integer.toString(tuoiint);
					String gioitinh = (String) table.getValueAt(selectedRow, 3);
					Date ngaykhamDate = (Date) table.getValueAt(selectedRow, 9);
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					String ngaykham = dateFormat.format(ngaykhamDate);
					
					tHoten.setText(hoten);
					tTuoi.setText(tuoi);
					tGioitinh.setText(gioitinh);
					tNgaykham.setText(ngaykham);
					
					bnDTO.setMabn(id);
					bnDTO.setHoten(hoten);
					bnDTO.setTuoi(tuoiint);
					bnDTO.setGioitinh(tuoiint);
					String bhyt = (String) table.getValueAt(selectedRow, 4);
					bnDTO.setBhyt(bhyt);
					String diachi = (String) table.getValueAt(selectedRow, 5);
					bnDTO.setDiachi(diachi);
					String chuandoan = bnBUS.getChuanDoanbyId(id);
					System.out.println(chuandoan);
					bnDTO.setChuandoan(chuandoan);
					Date ngaytaikham = bnBUS.getNgayTaiKhamById(id);
					//System.out.println(ngaytaikham);
					bnDTO.setNgaytaikham(ngaytaikham);
					bnDTO.setBacsiid(tkDTO.getManv());
				}
			}
		});
	}
	
	public void AddDataTableThuoc() {
	    if (validFormThuoc()) {
	        String tenthuoc = tTenthuoc.getText();
	        // Kiểm tra thuốc đã tồn tại trong bảng chưa
	        if (isThuocExists(tenthuoc)) {
	            JOptionPane.showMessageDialog(null, "Tên thuốc đã tồn tại trong bảng!", "Cảnh báo!", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        // Kiểm tra thuốc có tồn tại trong kho không
	        if (!isThuocExistArr()) {
	            return;
	        }
	        String ngaySuDungStr = tNgaysudung.getText();
	        int songaydung = Integer.parseInt(ngaySuDungStr);
	        String sangStr = tSang.getText();
	        int sang = Integer.parseInt(sangStr);
	        String truaStr = tTrua.getText();
	        int trua = Integer.parseInt(truaStr);
	        String toiStr = tToi.getText();
	        int toi = Integer.parseInt(toiStr);
	        int soluong = (sang + trua + toi) * songaydung;
	        String ghichu = tGhichu.getText();
	        // Thêm dữ liệu vào bảng
	        modelthuoc.addRow(new Object[]{
	                tenthuoc, songaydung, sang, trua, toi, soluong, ghichu
	        });
	        
	        // cập nhật lại dữ liệu trong bảng thuốc
	        QuanLyThuocDTO qlt = new QuanLyThuocDTO();
        	drugList.addAll(qltBUS.getArrTenThuoc());
        	//String tenthuoc = qltBUS.getNameById(drugList.indexOf(tTenthuoc.getText()));
        	int mathuoc = drugList.indexOf(tTenthuoc.getText());
        	int soluongtru = soluong;
        	qlt.setMathuoc(mathuoc + 1);
        	//System.out.println("ma thuoc: "+ mathuoc + 1);
        	QuanLyThuocDAO.getInstance().updateQuantity(qlt, soluongtru);
	    }
	}

	// kiểm tra thuốc có tồn tại trong kho hay không
	public boolean isThuocExistArr() {
	    ArrayList<String> checkArr = new ArrayList<String>();
	    checkArr.addAll(qltBUS.getArrTenThuoc());
	    String tenthuoc = tTenthuoc.getText();
	    // Kiểm tra tên thuốc tồn tại trong kho
	    boolean check = compareWithArrayList(checkArr, tenthuoc);
	    if (!check) {
	        JOptionPane.showMessageDialog(null, "Thuốc không tồn tại trong kho!", "Cảnh báo!", JOptionPane.ERROR_MESSAGE);
	    }

	    return check;
	}
	
	public static boolean compareWithArrayList(ArrayList<String> list, String inputString) {
        for (String element : list) {
            if (element.equals(inputString)) {
                return true;
            }
        }
        return false;
    }
	
	// kiểm tra thuốc thêm vào có trùng lặp với thuốc đã thêm trước đó hay không
	public boolean isThuocExists(String tenthuoc) {
	    for (int i = 0; i < modelthuoc.getRowCount(); i++) {
	        String existingTenThuoc = (String) modelthuoc.getValueAt(i, 0);
	        if (existingTenThuoc.equalsIgnoreCase(tenthuoc)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public boolean validFormThuoc() {
		try {
			if(tTenthuoc.getText().equals("") || tNgaysudung.getText().equals("") ||
					(tSang.getText().equals("") && tTrua.getText().equals("") && tToi.getText().equals("")) ||
					tGhichu.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn chưa nhập đầy đủ thông tin!", "Cảnh báo!", JOptionPane.ERROR_MESSAGE);
				return false;
			}else {
				if(tSang.getText().equals(""))
					tSang.setText("0");
				if(tTrua.getText().equals(""))
					tTrua.setText("0");
				if(tToi.getText().equals(""))
					tToi.setText("0");
			}
			
			int ngaydung = Integer.parseInt(tNgaysudung.getText());
			if(ngaydung < 0) {
				JOptionPane.showMessageDialog(null, "Số ngày dùng không âm!", "Cảnh báo!", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Thông tin nhập không hợp lệ!", "Cảnh báo!", JOptionPane.ERROR_MESSAGE);
	        return false;
		}
		return true;
	}
	
	public ArrayList<String> getTenThuoc(){
		return tenthuoc;
	}
	
	public ArrayList<String> getGhiChu(){
		return ghichu;
	}
	
	public ArrayList<Integer> getSoNgay(){
		return songay;
	}
	
	public ArrayList<Integer> getSang(){
		return sang;
	}
	
	public ArrayList<Integer> getTrua(){
		return trua;
	}
	
	public ArrayList<Integer> getToi(){
		return toi;
	}
	
	public ArrayList<Integer> getSoluong(){
		return soluong;
	}
}
