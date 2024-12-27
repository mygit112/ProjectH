package GUI.component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SuggestionPopup extends JPopupMenu {
    private JTextField textField;

    public SuggestionPopup(JTextField textField) {
        this.textField = textField;
    }

    // Hiển thị các gợi ý trong popup
    public void showSuggestions(List<String> suggestions) {
        this.removeAll();  // Xóa tất cả các mục cũ trong popup
        
        // Nếu không có gợi ý, ẩn popup
        if (suggestions.isEmpty()) {
            this.setVisible(false);
            return;
        }

        // Thêm các gợi ý vào JPopupMenu
        for (String suggestion : suggestions) {
            JMenuItem item = new JMenuItem(suggestion);
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Khi người dùng chọn một gợi ý, điền vào JTextField
                    textField.setText(suggestion);
                    setVisible(false); // Ẩn popup sau khi chọn
                }
            });
            this.add(item);
        }

        // Hiển thị JPopupMenu tại vị trí dưới JTextField
        this.show(textField, 0, textField.getHeight());
    }
}

