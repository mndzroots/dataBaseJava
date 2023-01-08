/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frames;

import components.Table;
import customClasses.PersonList;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import panels.MainPanel;

/**
 *
 * @author mndzr
 */
public class MainFrame extends JFrame {

    private final MainPanel mainPanel;
    private final JScrollPane tableScrollPane;
    private final Table jTable;

    public MainFrame(PersonList personList) {

        setSize(650, 520);
        setLocationRelativeTo(null);
        setTitle("Base De Datos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new MainPanel();
        jTable = new Table(personList);
        tableScrollPane = new JScrollPane(jTable);

        mainPanel.add(tableScrollPane, BorderLayout.CENTER);

        add(mainPanel);

        setVisible(true);
    }
}
