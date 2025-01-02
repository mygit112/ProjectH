package GUI.Panel;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;

public class TrangChu extends JPanel {

	private static final long serialVersionUID = 1L;

	public TrangChu() {
		setForeground(new Color(188, 153, 125));
		setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1166, 768);
		lblNewLabel.setIcon(new ImageIcon(TrangChu.class.getResource("/img/sologan.png")));
		setBounds(220, 0, 1166, 768);
		setLayout(null);
		add(lblNewLabel);

	}
}
