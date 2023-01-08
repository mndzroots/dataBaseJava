/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customClasses;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author mndzr
 */
public class CustomRenderer extends JLabel implements TableCellRenderer {

    public CustomRenderer() {
        this.setOpaque(true);
        this.setFont(new Font("Courier",Font.PLAIN,12));
        this.setHorizontalAlignment(CENTER);
        this.setBorder(BorderFactory.createLineBorder(Color.gray));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());
        return this;
    }

}
