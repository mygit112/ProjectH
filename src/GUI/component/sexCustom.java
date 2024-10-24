package GUI.component;

import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class sexCustom extends JComboBox<String> {
	
	public sexCustom() {
		super(new String[]{"Chọn giới tính", "Nam", "Nữ"});

        setBorder(new EmptyBorder(5, 5, 5, 5));
        setBackground(new Color(240, 240, 240));
        setForeground(Color.BLACK);
        setSelectedIndex(0);
        
        setFont(new Font("Arial", Font.PLAIN, 12));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Vẽ viền màu xám
        g.setColor(Color.GRAY);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
    }

    // Phương thức để lấy giới tính đã chọn
    public String getSelectedGender() {
        return (String) getSelectedItem();
    }
}
