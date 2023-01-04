/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mndzr
 */
public class PersonList {

    private ArrayList<Person> list;

    public PersonList() {
        list = new ArrayList();
    }

    public void arrayListFromTxt(String archivo) {
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            String cadena;

            while ((cadena = br.readLine()) != null) {
                list.add(stringToPerson(cadena));
            }

            br.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(PersonList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PersonList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Person stringToPerson(String cadena) {

        String[] elementos = cadena.split("\\|");

        Person p = new Person(elementos[0], elementos[1], elementos[2], Integer.parseInt(elementos[3]), Integer.parseInt(elementos[4]));

        return p;
    }

    public void printPersonList() {
        for (Person p : list) {
            System.out.println(p);
        }
    }

}
