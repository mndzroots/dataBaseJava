/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customClasses;

/**
 *
 * @author mndzr
 */
public class Person {

    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private int edad;
    private int id;

    public Person() {
        nombre = "";
        apellidoP = "";
        apellidoM = "";
        edad = 0;
        id = 0;
    }

    public Person(String n, String ap, String am, int e, int id) {
        nombre = n;
        apellidoP = ap;
        apellidoM = am;
        edad = e;
        this.id = id;
    }
    
    public String personToString(String s) {
        return nombre + s + apellidoP + s + apellidoM + s + edad + s + id;
    }
    

    @Override
    public String toString() {
        return "{Nombre=" + nombre + ", Apellido Paterno=" + apellidoP + ", Apellido Materno=" + apellidoM + ", Edad=" + edad + ", Id=" + id + '}';
    }

    public void imprimePersona() {
        System.out.println("{Nombre=" + nombre + ", Apellido Paterno=" + apellidoP + ", Apellido Materno=" + apellidoM + ", Edad=" + edad + ", Id=" + id + '}');
    }
    
    public String appendPersona() {
        return nombre+" "+apellidoP + " " + apellidoM + " " + edad + " " + id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
