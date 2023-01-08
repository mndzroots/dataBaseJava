/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import customClasses.PersonList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mndzr
 */
public class Table extends JTable{
    /**
     Names from Table columns
     */
    public static final String[] columnNames = {"Nombre", "Apellido P", "Apellido M", "Edad", "Id"};
    private DefaultTableModel tableModel;
    private String[][] data;
    private final PersonList personList;

    public Table(PersonList p) {
        personList = p;
        data = personList.getArrayData();
        tableModel = new DefaultTableModel(data, columnNames);
        this.setModel(tableModel);
        setDefaultEditor(Object.class, null);
        getTableHeader().setReorderingAllowed(false);
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
}
