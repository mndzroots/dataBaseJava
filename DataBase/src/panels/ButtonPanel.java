/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panels;

import components.Table;
import database.DataBase;
import customClasses.PersonList;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mndzr
 */
public class ButtonPanel extends JPanel implements ActionListener{
    
    private final JTextField searchTextField;
    private final JButton searchButton;
    private final JButton cleanSearchButton;
    private final PersonList personList;
    private final Table table;
    
    public ButtonPanel(PersonList personList, Table table){
        this.personList = personList;
        this.table = table;
        searchTextField = new JTextField();
        searchTextField.setPreferredSize(new Dimension(150, 25));

        searchButton = new JButton("Buscar");
        searchButton.addActionListener(this);
        searchButton.setActionCommand("Buscar");

        cleanSearchButton = new JButton("Limpiar");
        cleanSearchButton.setEnabled(false);
        cleanSearchButton.addActionListener(this);
        cleanSearchButton.setActionCommand("Limpiar");
        
        add(searchTextField);
        add(searchButton);
        add(cleanSearchButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action) {
            case "Buscar" -> {
                personList.searchByName(this.searchTextField.getText());
                table.setData(personList.getArrayData());
                table.setModel(new DefaultTableModel(table.getData(), Table.columnNames));
                cleanSearchButton.setEnabled(true);
            }
            case "Limpiar" -> {
                personList.setList(DataBase.list);
                table.setData(personList.getArrayData());
                table.setModel(new DefaultTableModel(table.getData(), Table.columnNames));
                cleanSearchButton.setEnabled(false);
            }
        }
    }
    
}
