package GUI.component;


import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class InputDate extends JPanel {

    public JDateChooser date;
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm");
    private final SimpleDateFormat dateFormat;

    public InputDate() {
        this.setLayout(new GridLayout(1, 1));
        this.setBackground(Color.white);
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        date = new JDateChooser();
        date.setDateFormatString("dd/MM/yyyy");
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.add(date);
    }

    public InputDate(String title, int w, int h) {
        this.setLayout(new GridLayout(1, 1));
        this.setBackground(Color.white);
        this.setPreferredSize(new Dimension(w, h));
        date = new JDateChooser();
        date.setDateFormatString("dd/MM/yyyy");
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.add(date);
    }
    
    public JDateChooser getDateChooser() {
        return this.date;
    }

    public Date getDate() throws ParseException {
        Date dt = date.getDate();
        if (dt != null) {
            String txt_date = dateFormat.format(dt);
            return dateFormat.parse(txt_date);
        } else {
            return null;
        }
    }

    public void setDate(JDateChooser date) {
        this.date = date;
    }

    public void setDate(Date date) {
        this.date.setDate(date);
    }

    public void setDisable() {
        JTextFieldDateEditor editor = (JTextFieldDateEditor) date.getDateEditor();
        editor.setEditable(false);
    }
    
    public void setMinSelectableDate(Date date) {
        this.date.setMinSelectableDate(date);
    }
}

