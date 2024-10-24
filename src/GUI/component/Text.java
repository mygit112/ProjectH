package GUI.component;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Text extends JTextField {
	
	public Text() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
        setSelectionColor(new Color(220, 204, 182));
	}
	
	public Text(String text) {
		setBorder(new EmptyBorder(5, 5, 5, 5));
        setSelectionColor(new Color(220, 204, 182));
        setHorizontalAlignment(JTextField.LEFT);
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
}
