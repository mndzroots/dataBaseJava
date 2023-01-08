/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customClasses;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

/**
 *
 * @author mndzr
 */
public class StringComparator implements Comparator<Person> {

    public static final int nombre = 1;
    public static final int apellidoP = 2;
    public static final int apellidoM = 3;

    private final int parametro;

    private static Collator collator;

    public StringComparator(int tipo) {
        parametro = tipo;
    }

    @Override
    public int compare(Person o1, Person o2) {
        
        collator = Collator.getInstance(new Locale("es"));       
        collator.setStrength(Collator.TERTIARY);
        
        switch (parametro) {
            case 1:
                return collator.compare(o1.getNombre(), o2.getNombre());
            case 2:
                return collator.compare(o1.getApellidoP(), o2.getApellidoP());
            case 3:
                return collator.compare(o1.getApellidoM(), o2.getApellidoM());
            default:
                throw new IllegalArgumentException("Parameter must be a OrdenarString constant");
        }


    }

}
