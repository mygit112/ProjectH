package GUI.component;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollBar;

public class ScrollBar extends JScrollBar {
	public ScrollBar() {
        setUI(new ScrollBarUI());
        setPreferredSize(new Dimension(5, 5));
        setBackground(new Color(242, 242, 242));
        setUnitIncrement(20);
    }
}
