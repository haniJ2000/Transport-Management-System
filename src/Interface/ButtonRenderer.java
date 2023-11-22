package Interface;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ButtonRenderer extends JButton implements TableCellRenderer {
    private static final long serialVersionUID = 1L;  
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
    	setName("Delete");
        setText((value == null) ? "" : value.toString());
        setBackground(new Color(128, 0, 0)); // Set a common background color for all buttons
        setForeground(Color.WHITE);
        return this;
    }
}

