package GUI.Panel;

import javax.swing.JPanel;

import GUI.component.MenuComponent;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

import javax.swing.*;
import java.awt.*;
import javax.swing.GroupLayout.Alignment;

public class MenuItem extends JPanel {

    private static final long serialVersionUID = 1L;
    private boolean selected;
    private boolean over;
    private JLabel lblIcon;
    private JLabel lblMenuName;

    public MenuItem(MenuComponent data) {
        setOpaque(false);

        lblIcon = new JLabel();
        lblIcon.setForeground(new Color(255, 255, 255));
        lblIcon.setFont(new Font("SansSerif", Font.PLAIN, 12));

        lblMenuName = new JLabel("Menu Name");
        lblMenuName.setForeground(new Color(255, 255, 255));
        lblMenuName.setFont(new Font("SansSerif", Font.PLAIN, 16));
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(20)
        			.addComponent(lblIcon)
        			.addContainerGap())
        		.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
        			.addGap(59)
        			.addComponent(lblMenuName, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(20)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblMenuName)
        				.addComponent(lblIcon))
        			.addContainerGap(16, Short.MAX_VALUE))
        );
        setLayout(groupLayout);

        if (data.getType() == MenuComponent.MenuType.MENU) {
            lblIcon.setIcon(data.toIcon());
            lblMenuName.setText(data.getName());
        } else if (data.getType() == MenuComponent.MenuType.TITLE) {
            lblIcon.setText(data.getName());
            lblIcon.setFont(new Font("sansserif", Font.BOLD, 12));
            lblMenuName.setVisible(false);
        } else {
            lblMenuName.setText(" ");
        }
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }
    
    public void setOver(boolean over) {
    	this.over = over;
    	repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (selected || over) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if(selected) {
            	g2.setColor(new Color(255, 255, 255, 80));
            }else {
            	g2.setColor(new Color(255, 255, 255, 20));
            }
            g2.fillRoundRect(10, 0, getWidth() - 20, getHeight(), 5, 5);
        }
    }
}
