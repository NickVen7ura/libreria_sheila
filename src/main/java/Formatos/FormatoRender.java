package Formatos;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class FormatoRender extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object objeto, boolean isSelected, boolean hasFocus, int row, int column) {
        if (objeto instanceof JButton) {
            return (JButton)objeto;
        }
        return super.getTableCellRendererComponent(table, objeto, isSelected, hasFocus, row, column);
    }
}
