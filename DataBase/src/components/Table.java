/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import customClasses.CustomRenderer;
import customClasses.Methods;
import customClasses.PersonList;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mndzr
 */
public class Table extends JTable implements MouseListener {

    /**
     Names from Table columns
     */
    public static final String[] columnNames = {"Nombre", "Apellido P", "Apellido M", "Edad", "Id"};
    private DefaultTableModel tableModel;
    private String[][] data;
    private Boolean orderType = true;
    int column = -1;
    private final PersonList personList;

    public Table(PersonList p) {
        personList = p;
        data = personList.getArrayData();
        tableModel = new DefaultTableModel(data, columnNames);
        this.setModel(tableModel);
        setDefaultEditor(Object.class, null);
        getTableHeader().setReorderingAllowed(false);
        this.getTableHeader().addMouseListener(this);
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public String[][] getData() {
        return data;
    }

    public void setData(String[][] data) {
        this.data = data;
    }

    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        boolean isSameColumn = column == columnAtPoint(e.getPoint());
        column = columnAtPoint(e.getPoint());
        String name = getColumnName(column);

        if (isSameColumn) {
            if (orderType) {
                Methods.accionBoton(name, "ASC", personList);
                data = personList.getArrayData();
                tableModel = new DefaultTableModel(data, columnNames);
                setModel(tableModel);
                getColumnModel().getColumn(column).setHeaderRenderer(new CustomRenderer());
                orderType = !orderType;
            } else {
                Methods.accionBoton(name, "DSC", personList);
                data = personList.getArrayData();
                tableModel = new DefaultTableModel(data, columnNames);
                setModel(tableModel);
                getColumnModel().getColumn(column).setHeaderRenderer(new CustomRenderer());
                orderType = !orderType;
            }
        } else {
            Methods.accionBoton(name, "ASC", personList);
            data = personList.getArrayData();
            tableModel = new DefaultTableModel(data, columnNames);
            setModel(tableModel);
            getColumnModel().getColumn(column).setHeaderRenderer(new CustomRenderer());
            orderType = false;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

}
