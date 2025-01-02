package Model;

import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import BUS.BacSiBUS;
import DAO.BenhNhanDAO;
import DTO.BenhNhanDTO;
import DTO.TaiKhoanDTO;
import GUI.Panel.BenhNhan;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class writePDF {

    DecimalFormat formatter = new DecimalFormat("###,###,###");
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm");
    SimpleDateFormat formatDateNgayTaiKham = new SimpleDateFormat("dd/MM/YYYY");
    Document document = new Document();
    FileOutputStream file;
    JFrame jf = new JFrame();
    FileDialog fd = new FileDialog(jf, "Xuất pdf", FileDialog.SAVE);
    Font fontNormal10;
    Font fontBold15;
    Font fontBold25;
    Font fontBoldItalic15;
    Font fontBold10;
    BacSiBUS bsBUS = new BacSiBUS();
    private ArrayList<String> listTenThuoc, listGhiChu;
    private ArrayList<Integer> listSoNgay, listSang, listTrua, listToi, listSoLuong;

    public writePDF() {
        try {
            fontNormal10 = new Font(BaseFont.createFont("lib/TimesNewRoman/SVN-Times New Roman.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 12, Font.NORMAL);
            fontBold25 = new Font(BaseFont.createFont("lib/TimesNewRoman/SVN-Times New Roman Bold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 25, Font.NORMAL);
            fontBold15 = new Font(BaseFont.createFont("lib/TimesNewRoman/SVN-Times New Roman Bold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 15, Font.NORMAL);
            fontBold10 = new Font(BaseFont.createFont("lib/TimesNewRoman/SVN-Times New Roman Bold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 12, Font.NORMAL);
            fontBoldItalic15 = new Font(BaseFont.createFont("lib/TimesNewRoman/SVN-Times New Roman Bold Italic.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 15, Font.NORMAL);
            
            listTenThuoc = new ArrayList<>();
            listGhiChu = new ArrayList<>();
            listSoNgay = new ArrayList<>();
            listSang = new ArrayList<>();
            listTrua = new ArrayList<>();
            listToi = new ArrayList<>();
            listSoLuong = new ArrayList<>();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(writePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void chooseURL(String url) {
        try {
            document.close();
            document = new Document();
            file = new FileOutputStream(url);
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Khong tim thay duong dan file " + url);
        } catch (DocumentException ex) {
            JOptionPane.showMessageDialog(null, "Khong goi duoc document !");
        }
    }

    public void setTitle(String title) {
        try {
            Paragraph pdfTitle = new Paragraph(new Phrase(title, fontBold25));
            pdfTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(pdfTitle);
            document.add(Chunk.NEWLINE);
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
    }

    private String getFile(String name) {
        fd.pack();
        fd.setSize(800, 600);
        fd.validate();
        Rectangle rect = jf.getContentPane().getBounds();
        double width = fd.getBounds().getWidth();
        double height = fd.getBounds().getHeight();
        double x = rect.getCenterX() - (width / 2);
        double y = rect.getCenterY() - (height / 2);
        Point leftCorner = new Point();
        leftCorner.setLocation(x, y);
        fd.setLocation(leftCorner);
        fd.setFile(name);
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile();
        if (url.equals("null")) {
            return null;
        }
        return url;
    }

    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static Chunk createWhiteSpace(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(" ");
        }
        return new Chunk(builder.toString());
    }

    public void writePN(BenhNhan bn, BenhNhanDTO bnDTO, TaiKhoanDTO tkDTO) {
        String url = "";
        try {
            fd.setTitle("In phiếu nhập");
            fd.setLocationRelativeTo(null);
            url = getFile(bnDTO.getMabn() + "");
            if (url.equals("nullnull")) {
                return;
            }
            url = url + ".pdf";
            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();

            Paragraph company = new Paragraph("BỆNH VIỆN ĐA KHOA XYZ", fontBold15);
            company.add(new Chunk(createWhiteSpace(20)));
            Date today = new Date(System.currentTimeMillis());
            company.add(new Chunk("Thời gian in phiếu: " + formatDate.format(today), fontNormal10));
            company.setAlignment(Element.ALIGN_LEFT);
            document.add(company);
            // Thêm tên công ty vào file PDF
            document.add(Chunk.NEWLINE);
            Paragraph header = new Paragraph("Đơn thuốc", fontBold25);
            header.setAlignment(Element.ALIGN_CENTER);
            document.add(header);
            //BenhNhanDTO bnDTO = BenhNhanDAO.getInstance().selectById(mabn + "");
            // Thêm dòng Paragraph vào file PDF

            Paragraph paragraph1 = new Paragraph("Mã phiếu: BN" + bnDTO.getMabn(), fontNormal10);
            String tenbn = bnDTO.getHoten();
            Paragraph paragraph2 = new Paragraph("Tên bệnh nhân: " + tenbn, fontNormal10);
            paragraph2.add(new Chunk(createWhiteSpace(5)));
            paragraph2.add(new Chunk("Tuổi: ")); 
            int tuoiint = bnDTO.getTuoi();
            String tuoi = Integer.toString(tuoiint);
            paragraph2.add(new Chunk(tuoi, fontNormal10));
            paragraph2.add(new Chunk(createWhiteSpace(5)));
            paragraph2.add(new Chunk("Giới tính: "));
            int gioitintint = bnDTO.getGioitinh();
            String gioitinh = Integer.toString(gioitintint) == "1" ? "Nam" : "Nữ";
            paragraph2.add(new Chunk(gioitinh, fontNormal10));
            
            String diachi = bnDTO.getDiachi();
            Paragraph paragraph3 = new Paragraph("Địa chỉ: " + diachi, fontNormal10);
            String bhyt = bnDTO.getBhyt();
            Paragraph paragraph4 = new Paragraph("Số BHYT: " + bhyt, fontNormal10);
            String chuandoan = bnDTO.getChuandoan();
            Paragraph paragraph5 = new Paragraph("Chuẩn đoán: " + chuandoan, fontNormal10);
            document.add(paragraph1);
            document.add(paragraph2);
            document.add(paragraph3);
            document.add(paragraph4);
            document.add(paragraph5);
            document.add(Chunk.NEWLINE);
            // Thêm table 7 cột vào file PDF
            PdfPTable table = new PdfPTable(7);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{30f, 15f, 15f, 15f, 15f, 25f, 30f});
            PdfPCell cell;

            table.addCell(new PdfPCell(new Phrase("Tên thuốc", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Số ngày", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Sáng", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Trưa", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Tối", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Số lượng", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Ghi chú", fontBold15)));
            for (int i = 0; i < 7; i++) {
                cell = new PdfPCell(new Phrase(""));
                table.addCell(cell);
            }
  
            listTenThuoc = bn.getTenThuoc();
            listGhiChu = bn.getGhiChu();
            listSoNgay = bn.getSoNgay();
            listSang = bn.getSang();
            listTrua = bn.getTrua();
            listToi = bn.getToi();
            listSoLuong = bn.getSoluong();
            for(int i=0;i<listTenThuoc.size();i++) {
            	String tenthuoc = listTenThuoc.get(i);
            	table.addCell(new PdfPCell(new Phrase(tenthuoc, fontNormal10)));
            	int songayint = listSoNgay.get(i);
            	String songay = Integer.toString(songayint);
            	table.addCell(new PdfPCell(new Phrase(songay, fontNormal10)));
            	int sangint = listSang.get(i);
            	String sang = Integer.toString(sangint);
            	table.addCell(new PdfPCell(new Phrase(sang, fontNormal10)));
            	int truaint = listTrua.get(i);
            	String trua = Integer.toString(truaint);
            	table.addCell(new PdfPCell(new Phrase(trua, fontNormal10)));
            	int toiint = listToi.get(i);
            	String toi = Integer.toString(toiint);
            	table.addCell(new PdfPCell(new Phrase(toi, fontNormal10)));
            	int soluongint = listToi.get(i);
            	String soluong = Integer.toString(soluongint);
            	table.addCell(new PdfPCell(new Phrase(soluong, fontNormal10)));
            	String ghichu = listTenThuoc.get(i);
            	table.addCell(new PdfPCell(new Phrase(ghichu, fontNormal10)));
            }

            document.add(table);
            document.add(Chunk.NEWLINE);

            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);

            Paragraph paragraph = new Paragraph();
            paragraph.setIndentationLeft(22);
            paragraph.add(new Chunk(createWhiteSpace(80)));
            paragraph.add(new Chunk("Hẹn ngày tái khám: " +formatDateNgayTaiKham.format(bnDTO.getNgaytaikham()), fontBoldItalic15));
            paragraph.add(new Chunk(createWhiteSpace(80)));
            Paragraph taikham = new Paragraph();
            taikham.setIndentationLeft(23);
            taikham.add(new Chunk(createWhiteSpace(88)));
            Date ngaykham = new Date(System.currentTimeMillis());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(ngaykham);
            taikham.add(new Chunk("Ngày "+calendar.get(Calendar.DAY_OF_MONTH)+ " tháng "+calendar.get(Calendar.MONTH)+ " năm "+calendar.get(Calendar.YEAR), fontNormal10));
            
            Paragraph bskham = new Paragraph();
            bskham.setIndentationLeft(24);
            bskham.add(new Chunk(createWhiteSpace(98)));
            bskham.add(new Chunk("Bác sĩ điều trị", fontBold10));
            
            Paragraph tenbs = new Paragraph();
            tenbs.setIndentationLeft(27);
            tenbs.add(new Chunk(createWhiteSpace(95)));
            tenbs.add(new Chunk(bsBUS.getNameById(bnDTO.getBacsiid()), fontBoldItalic15));
            
            document.add(paragraph);
            document.add(taikham);
            document.add(bskham);
            document.add(tenbs);

            document.close();
            writer.close();
            openFile(url);

        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
        }

    }

}
