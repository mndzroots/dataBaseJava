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
import panels.ButtonPanel;
import panels.MainPanel;
import panels.MenuPanel;

/**
 *
 * @author mndzr
 */
public class MainFrame extends JFrame {

    private final MainPanel mainPanel;
    private final ButtonPanel buttonPanel;
    private final JScrollPane tableScrollPane;
    private final Table jTable;
    private final MenuPanel menuPanel;

    public MainFrame(PersonList personList) {
        
        setSize(650, 520);
        setLocationRelativeTo(null);
        setTitle("Base De Datos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new MainPanel();
        jTable = new Table(personList);
        tableScrollPane = new JScrollPane(jTable);
        buttonPanel = new ButtonPanel(personList,jTable);
        menuPanel = new MenuPanel(personList,tableScrollPane);

        mainPanel.add(menuPanel, BorderLayout.PAGE_START);
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.PAGE_END);

        add(mainPanel);

        setVisible(true);
    }
}
