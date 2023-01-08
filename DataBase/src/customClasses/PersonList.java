/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customClasses;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mndzr
 */
public class PersonList {

    static final int ASC = 1;
    static final int DSC = 2;
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

    public void sortByAge(int modo) {
        Person temp;

        if (modo == 1 || modo == 2) {
            if (modo == 1) {
                for (int i = 1; i < list.size(); i++) {
                    for (int j = 0; j < list.size() - 1; j++) {
                        if (list.get(j).getEdad() > list.get(j + 1).getEdad()) {
                            temp = list.get(j);
                            list.set(j, list.get(j + 1));
                            list.set(j + 1, temp);
                        }
                    }
                }
            } else {
                for (int i = 1; i < list.size(); i++) {
                    for (int j = 0; j < list.size() - 1; j++) {
                        if (list.get(j).getEdad() < list.get(j + 1).getEdad()) {
                            temp = list.get(j);
                            list.set(j, list.get(j + 1));
                            list.set(j + 1, temp);
                        }
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Parameter must be a Metodos class constant");
        }
    }

    public void sortByName(int modo) {
        if (modo == 1 || modo == 2) {

            if (modo == 1) {
                list.sort(new StringComparator(StringComparator.nombre));
            } else {
                list.sort(new StringComparator(StringComparator.nombre).reversed());
            }
        } else {
            throw new IllegalArgumentException("Parameter must be a Metodos constant");
        }

    }

    public void sortByApellidoPaterno(int modo) {
        if (modo == 1 || modo == 2) {
            if (modo == 1) {
                list.sort(new StringComparator(StringComparator.apellidoP));
            } else {
                list.sort(new StringComparator(StringComparator.apellidoP).reversed());
            }
        } else {
            throw new IllegalArgumentException("Parameter must be a Metodos constant");
        }

    }

    public void sortByApellidoMaterno(int modo) {
        if (modo == 1 || modo == 2) {
            if (modo == 1) {
                list.sort(new StringComparator(StringComparator.apellidoM));
            } else {
                list.sort(new StringComparator(StringComparator.apellidoM).reversed());
            }
        } else {
            throw new IllegalArgumentException("Parameter must be a Metodos constant");
        }

    }

    public void sortById(int modo) {
        if (modo == 1 || modo == 2) {

            Comparator<Person> byId = Comparator.comparing(Person::getId);

            if (modo == 1) {
                list.sort(byId);
            } else {
                list.sort(byId.reversed());
            }
        } else {
            throw new IllegalArgumentException("Parameter must be a Metodos constant");
        }

    }


    public String[][] getArrayData() {

        String[][] datos = new String[list.size()][5];

        for (int i = 0; i < datos.length; i++) {
            datos[i][0] = list.get(i).getNombre();
            datos[i][1] = list.get(i).getApellidoP();
            datos[i][2] = list.get(i).getApellidoM();
            datos[i][3] = String.valueOf(list.get(i).getEdad());
            datos[i][4] = String.valueOf(list.get(i).getId());
        }
        return datos;
    }

    public void searchByName(String s) {

        ArrayList<Person> res = new ArrayList();

        for (Person p : list) {
            if (p.getNombre().contains(s)) {
                res.add(p);
            }
        }

        list = res;
    }

    public ArrayList<Person> getList() {
        return list;
    }

    public void setList(ArrayList<Person> list) {
        this.list = list;
    }

}
