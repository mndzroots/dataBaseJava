/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package database;

import customClasses.Person;
import customClasses.PersonList;
import frames.MainFrame;
import java.util.ArrayList;

/**
 *
 * @author mndzr
 */
public class DataBase {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<Person> list;
    public static void main(String[] args) {
        PersonList personList = new PersonList();
        personList.arrayListFromTxt("src\\Files\\sourceData.txt");
        list = personList.getList();
        new MainFrame(personList);
    }
    
}
