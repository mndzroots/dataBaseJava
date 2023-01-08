/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customClasses;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author mndzr
 */
public class Methods {

    static ArrayList<Person> personas;
    private static final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    static final int ASC = 1;
    static final int DSC = 2;

    public static void accionBoton(String s, String tipo, PersonList p) {

        switch (s) {
            case "Nombre" -> {
                if (tipo.equals("ASC")) {
                    p.sortByName(ASC);
                } else {
                    p.sortByName(DSC);
                }
            }
            case "Apellido P" -> {
                if (tipo.equals("ASC")) {
                    p.sortByApellidoPaterno(ASC);
                } else {
                    p.sortByApellidoPaterno(DSC);
                }
            }
            case "Apellido M" -> {
                if (tipo.equals("ASC")) {
                    p.sortByApellidoMaterno(ASC);
                } else {
                    p.sortByApellidoMaterno(DSC);
                }
            }
            case "Edad" -> {
                if (tipo.equals("ASC")) {
                    p.sortByAge(ASC);
                } else {
                    p.sortByAge(DSC);
                }
            }
            case "Id" -> {
                if (tipo.equals("ASC")) {
                    p.sortById(ASC);
                } else {
                    p.sortById(DSC);
                }
            }
        }
    }



    private record TransferableImage(Image i) implements Transferable {

        @Override
        public Object getTransferData(DataFlavor flavor)
                throws UnsupportedFlavorException {
            if (flavor.equals(DataFlavor.imageFlavor) && i != null) {
                return i;
            } else {
                throw new UnsupportedFlavorException(flavor);
            }
        }

        @Override
        public DataFlavor[] getTransferDataFlavors() {
            DataFlavor[] flavors = new DataFlavor[1];
            flavors[0] = DataFlavor.imageFlavor;
            return flavors;
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            DataFlavor[] flavors = getTransferDataFlavors();
            for (DataFlavor dataFlavor : flavors) {
                if (flavor.equals(dataFlavor)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void copyToClipboard(BufferedImage img) {
        clipboard.setContents(new TransferableImage(img), null);
    }

    public static void saveComponentToClipboard(Component comp) {
        BufferedImage image = new BufferedImage(comp.getWidth(), comp.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = image.createGraphics();
        comp.paint(graphics2D);
        copyToClipboard(image);
    }

  

    public static void exportarCsv(ArrayList<Person> lista, String separator, JFileChooser chooser) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
        LocalDateTime now = LocalDateTime.now();
        String timestamp = dtf.format(now);
        String path = "";
        int result = chooser.showOpenDialog(chooser);

        if (result != JFileChooser.CANCEL_OPTION) {

            File fileName = chooser.getSelectedFile();

            if ((fileName == null) || (fileName.getName().equals(""))) {
                path = "...";
                JOptionPane.showMessageDialog(null, "No se encontró la ruta");
            } else {
                path = fileName.getAbsolutePath();
            }
            Writer out = null;
            path = path + "\\" + timestamp + ".csv";
            try {
                out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
                for (int i = 0; i < lista.size(); i++) {
                    if (i == lista.size() - 1) {
                        out.write(lista.get(i).personToString(separator));
                    } else {
                        out.write(lista.get(i).personToString(separator) + "\n");
                    }
                }
                JOptionPane.showMessageDialog(null, "Se exportó con éxito el archivo Csv");
                out.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "No se encontró la ruta", "Error al exportar", JOptionPane.ERROR_MESSAGE);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Codificacion no soportada", "Error al exportar", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "IOException", "Error al exportar", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void saveImage(JFileChooser chooser, Component comp) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
        LocalDateTime now = LocalDateTime.now();
        String timestamp = dtf.format(now);
        String path = "";
        int result = chooser.showOpenDialog(chooser);

        if (result != JFileChooser.CANCEL_OPTION) {

            File fileName = chooser.getSelectedFile();

            if ((fileName == null) || (fileName.getName().equals(""))) {
                path = "...";
                JOptionPane.showMessageDialog(null, "No se encontró la ruta");
            } else {
                path = fileName.getAbsolutePath();
            }
            path = path + "\\" + timestamp + ".png";
            BufferedImage image = new BufferedImage(comp.getWidth(), comp.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = image.createGraphics();
            comp.paint(graphics2D);
            File outputfile = new File(path);
            try {
                ImageIO.write(image, "png", outputfile);
                JOptionPane.showMessageDialog(null, "Se exportó con éxito la captura de la tabla");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "No se encontró la ruta", "Error al exportar", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
