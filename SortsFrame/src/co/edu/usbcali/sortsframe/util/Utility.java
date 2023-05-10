package co.edu.usbcali.sortsframe.util;

import java.util.Arrays;

/**
 *
 * @author dpareja
 */
public class Utility {
    public static int[] stringToInt(String cadena) {
        return Arrays.stream(cadena.split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
    
    public static String arrayIntToString(int[] array) {
        String retorno = "";
        for (int i = 0; i < array.length; i++) {
            
            retorno+=(array[i])+", ";
            //if (i != array.length-1) {
                
            //}
            if ((i+1) % 30 == 0) {
                retorno+="\n";
            }
        }
        return retorno;
    }
    
    public static void printArray(int[] array) {
        System.out.println("Cantidad de elementos: "+array.length);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length-1) {
                System.out.print(", ");
            }
            if ((i+1) % 30 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
