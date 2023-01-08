/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panels;

import customClasses.Methods;
import customClasses.PersonList;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author mndzr
 */
public class MenuPanel extends JPanel implements ActionListener {

    JMenuBar menuBar;
    JMenu menuFile;
    JMenuItem menuItemExport;
    JMenuItem menuItemSaveImage;
    JMenuItem menuItemCTCB;
    JFileChooser mainFileChooser;
    PersonList personList;
    Component c;

    public MenuPanel(PersonList personList, Component c) {
        this.personList = personList;
        this.c = c;
        mainFileChooser = new JFileChooser();
        mainFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        menuBar = new JMenuBar();
        menuFile = new JMenu("Archivo");
        menuItemExport = new JMenuItem("Exportar Csv");
        menuItemSaveImage = new JMenuItem("Exportar Csv");
        menuItemSaveImage = new JMenuItem("Guardar imagen de tabla");
        menuItemCTCB = new JMenuItem("Copiar imagen de tabla al portapapeles");
        menuBar.add(menuFile);
        menuFile.add(menuItemExport);
        menuFile.add(menuItemSaveImage);
        menuFile.add(menuItemCTCB);
        menuItemExport.addActionListener(this);
        menuItemExport.setActionCommand("Exportar");
        menuItemSaveImage.addActionListener(this);
        menuItemSaveImage.setActionCommand("Guardar");
        menuItemCTCB.addActionListener(this);
        menuItemCTCB.setActionCommand("Copiar");
        add(menuBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();

        switch (action) {
            case "Exportar" -> {
                System.out.println("Exportando CSV");
                Methods.exportarCsv(personList.getList(), ",", mainFileChooser);
            }
            case "Copiar" -> {
                System.out.println("Guardando en el portapapeles");
                Methods.saveComponentToClipboard(c);
            }
            case "Guardar" -> {
                System.out.println("Guardando screenshot");
                Methods.saveImage(mainFileChooser, c);
            }

        }

    }

}
