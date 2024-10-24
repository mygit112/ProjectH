package GUI.component;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Graphics;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateCustom extends JTextField {
	
	public DateCustom() {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setSelectionColor(new Color(220, 204, 182));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Vẽ viền màu xám
        g.setColor(Color.GRAY);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

        if (getText().length() == 0) {
            int c0 = getBackground().getRGB();
            int c1 = getForeground().getRGB();
            int m = 0xfefefefe;
            int c2 = ((c0 & m) >>> 1) + ((c1 & m) >>> 1);
            g.setColor(new Color(c2, true));
        }
    }

    public void validateDate() {
        String dateString = getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false); // Ngăn chặn việc phân tích ngày không hợp lệ
        
        try {
            dateFormat.parse(dateString); // Kiểm tra định dạng
            JOptionPane.showMessageDialog(this, "Ngày hợp lệ: " + dateString);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Định dạng ngày không hợp lệ. Vui lòng nhập theo định dạng dd/MM/yyyy");
        }
    }
}
