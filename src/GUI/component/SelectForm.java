package GUI.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;

import java.awt.Insets;

public class SelectForm extends JPanel {
    private JLabel lblTitle;
    private JComboBox<String> cbb;
    
    public SelectForm(String[] obj) {
        this.setLayout(new GridLayout(1, 1));
        this.setBackground(Color.white);
        this.setBorder(new EmptyBorder(0, 0, 0, 0));

        // Tạo JComboBox và tùy chỉnh giao diện
        cbb = new JComboBox<>(obj);
        
        // Tùy chỉnh font chữ và màu nền
        cbb.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cbb.setBackground(new Color(248, 248, 248)); // Màu nền sáng, hiện đại
        cbb.setForeground(new Color(50, 50, 50)); // Màu chữ
        cbb.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 1)); // Viền nhẹ
        cbb.setPreferredSize(new java.awt.Dimension(200, 40));

        // Thay đổi icon mũi tên của JComboBox
        cbb.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                // Tạo một mũi tên tùy chỉnh nhỏ hơn
                JButton arrowButton = super.createArrowButton();
                // Thiết lập kích thước mũi tên nhỏ
                arrowButton.setIcon(new ImageIcon(getClass().getResource("/Entity/select.png")));
                arrowButton.setPreferredSize(new java.awt.Dimension(10, 10)); // Kích thước mũi tên nhỏ
                return arrowButton;
            }
        });

        // Tùy chỉnh ItemRenderer để các item đẹp hơn
        cbb.setRenderer(new DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                java.awt.Component comp = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                comp.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                if (isSelected) {
                    comp.setBackground(new Color(32, 178, 170)); // Màu nền khi chọn
                    comp.setForeground(Color.white); // Màu chữ khi chọn
                } else {
                    comp.setBackground(Color.white);
                    comp.setForeground(new Color(50, 50, 50));
                }
                return comp;
            }
        });

        // Thêm ComboBox vào JPanel
        this.add(cbb);
    }

    // Phương thức thiết lập lại danh sách mục trong comboBox
    public void setArr(String[] obj) {
        this.cbb.setModel(new DefaultComboBoxModel<>(obj));
    }

    public String getValue() {
        return (String) cbb.getSelectedItem();
    }
    
    public Object getSelectedItem() {
        return cbb.getSelectedItem();
    }
    
    public int getSelectedIndex() {
        return cbb.getSelectedIndex();
    }

    public void setSelectedIndex(int i) {
        cbb.setSelectedIndex(i);
    }

    public void setSelectedItem(Object a) {
        cbb.setSelectedItem(a);
    }

    public JLabel getLblTitle() {
        return lblTitle;
    }

    public void setLblTitle(JLabel lblTitle) {
        this.lblTitle = lblTitle;
    }

    public JComboBox<String> getCbb() {
        return cbb;
    }

    public void setCbb(JComboBox<String> cbb) {
        this.cbb = cbb;
    }

    // Vô hiệu hóa ComboBox
    public void setDisable(){
        cbb.setEnabled(false);
    }
}
