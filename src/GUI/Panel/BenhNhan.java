package GUI.Panel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UnsupportedLookAndFeelException;

import GUI.Login;
import GUI.component.InputDate;
import GUI.component.ScrollBar;
import GUI.component.SelectForm;
import GUI.component.SuggestionPopup;
import GUI.component.Table;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import BUS.BenhNhanBUS;
import BUS.QuanLyThuocBUS;
import DAO.BenhNhanDAO;
import DTO.BenhNhanDTO;
import DTO.QuanLyThuocDTO;
import DTO.TaiKhoanDTO;

import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

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
	private ArrayList<String> drugList;
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
		lblModifyIcon.setIcon(new ImageIcon(BenhNhan.class.getResource("/Entity/pencil.png")));
		
		JLabel lblModify = new JLabel("Sửa");
		lblModify.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		JPanel pnXoa = new JPanel();
		pnXoa.setBackground(Color.WHITE);
		
		JLabel lblDeleteIcon = new JLabel("");
		lblDeleteIcon.setIcon(new ImageIcon(BenhNhan.class.getResource("/Entity/delete.png")));
		
		JLabel lblDelete = new JLabel("Xoá");
		lblDelete.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		JLabel lblIconAdd = new JLabel("");
		lblIconAdd.setIcon(new ImageIcon(BenhNhan.class.getResource("/Entity/add.png")));
		
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
		lblDeleteIcon_1.setIcon(new ImageIcon(BenhNhan.class.getResource("/Entity/save.png")));
		pnLuu.add(lblDeleteIcon_1);
		
		JLabel lblLuuw = new JLabel("Lưu");
		lblLuuw.setFont(new Font("SansSerif", Font.PLAIN, 16));
		pnLuu.add(lblLuuw);
		
		JPanel pnKhamxong = new JPanel();
		pnKhamxong.setBackground(Color.WHITE);
		pnMenuBar.add(pnKhamxong);
		pnKhamxong.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblModifyIcon_1 = new JLabel("");
		lblModifyIcon_1.setIcon(new ImageIcon(BenhNhan.class.getResource("/Entity/complete.png")));
		pnKhamxong.add(lblModifyIcon_1);
		
		JLabel lblKhmXong = new JLabel("Khám xong");
		lblKhmXong.setFont(new Font("SansSerif", Font.PLAIN, 16));
		pnKhamxong.add(lblKhmXong);
		
		JPanel pnXuatpdf = new JPanel();
		pnXuatpdf.setBackground(Color.WHITE);
		pnMenuBar.add(pnXuatpdf);
		
		JLabel lblIconXuat = new JLabel("");
		lblIconXuat.setIcon(new ImageIcon(BenhNhan.class.getResource("/Entity/pdf.png")));
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
		
		drugList = new ArrayList<>();
	    drugList.addAll(qltBUS.getArrTenThuoc());
//		drugList.add("Paracetamol");
//	        drugList.add("Ibuprofen");
//	        drugList.add("Aspirin");
//	        drugList.add("Amoxicillin");
//	        drugList.add("Metformin");
//	        drugList.add("Omeprazole");
	     
		
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
		
		
//		addRow(1, "Nguyen Van A", 30, 1, "Có", "Hà Nội", "0123456789", 1, 1, new Date(01/01/1990));
//        addRow(1, "Nguyen Van A", 30, 1, "Có", "Hà Nội", "0123456789", 11, 61, new Date(01/01/1990));
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
	
	// test them du lieu thu cong
//	public void addRow(int mabn, String hoten, int tuoi, int gioitinh, String bhyt, String diachi,
//			String sdt, int chieucao, int cannang, Date ngaykham) {
//        model.addRow(new Object[] { mabn, hoten, tuoi, gioitinh, bhyt, diachi, sdt, chieucao, cannang, ngaykham});
//	}
	
	// load du lieu tu database
//	public void loadDataTable(ArrayList<BenhNhanDTO> result) {
//		model.setRowCount(0);
//		for(BenhNhanDTO bn : result) {
//			model.addRow(new Object[] {bn.getMabn(), bn.getHoten(),
//					bn.getTuoi(), bn.getGioitinh(), bn.getBhyt(),
//					bn.getDiachi(), bn.getSdt(), bn.getChieucao(),
//					bn.getCannang(), bn.getNgaykham()
//					
//			});
//		}
//	}
	
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
        	//System.out.println(bnDTO.getMabn());
        	writePDF w = new writePDF();
        	w.writePN(this, bnDTO, tkDTO);
        }else if(i == 7) {
        	// chuc nang nhap thuoc vao bang
        	AddDataTableThuoc();
        }else if(i == 8) {
        	// chuc nang xoa thuoc
        	int selected = tablethuoc.getSelectedRow();
    		if(selected == -1) {
    			JOptionPane.showMessageDialog(null, "Vui lòng chọn một thuốc.", "Thông báo", JOptionPane.WARNING_MESSAGE);
    		}else {
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
    		String tenThuoc = (String) tablethuoc.getValueAt(j, 0); // Cột 0: Tên thuốc
    	    String ghiChu = (String) tablethuoc.getValueAt(j, 6);  // Cột 1: Ghi chú
    	    Integer soNgay = (Integer) tablethuoc.getValueAt(j, 1); // Cột 2: Số ngày
    	    Integer sangValue = (Integer) tablethuoc.getValueAt(j, 2); // Cột 3: Sáng
    	    Integer truaValue = (Integer) tablethuoc.getValueAt(j, 3); // Cột 4: Trưa
    	    Integer toiValue = (Integer) tablethuoc.getValueAt(j, 4); // Cột 5: Tối
    	    Integer soLuong = (Integer) tablethuoc.getValueAt(j, 5); // Cột 6: Số lượng

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
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  // Định dạng ngày theo yêu cầu
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
					System.out.println(ngaytaikham);
					bnDTO.setNgaytaikham(ngaytaikham);
					bnDTO.setBacsiid(tkDTO.getManv());
				}
			}
		});
	}
	
	public void AddDataTableThuoc() {
		String tenthuoc = tTenthuoc.getText();
		String ngaySuDungStr = tNgaysudung.getText();
		int songaydung = validateThuoc(ngaySuDungStr);
		String sangStr = tSang.getText();
		int sang = validateThuoc(sangStr);
		String truaStr = tTrua.getText();
		int trua = validateThuoc(truaStr);
		String toiStr = tToi.getText();
		int toi = validateThuoc(toiStr);
		int soluong = (sang + trua + toi) * songaydung;
		String ghichu = tGhichu.getText();
		modelthuoc.addRow(new Object[] {
				tenthuoc, songaydung, sang, trua, toi, soluong, ghichu
		});
	}
	
	public int validateThuoc(String value) {
		int result = 0;
		try {
		    result = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			if(tNgaysudung.getText() != "" || tSang.getText() != "" || tTrua.getText() != "" || tToi.getText() != "") {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập một số hợp lệ!", "Cảnh báo!", JOptionPane.ERROR_MESSAGE);
			}			
		}
		return result;
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
