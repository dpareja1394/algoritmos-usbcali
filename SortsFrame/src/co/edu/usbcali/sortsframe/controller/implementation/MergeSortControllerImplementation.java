package co.edu.usbcali.sortsframe.controller.implementation;

import co.edu.usbcali.sortsframe.controller.SortControllerInterface;
import co.edu.usbcali.sortsframe.util.Utility;
import java.util.Date;

/**
 *
 * @author dpareja
 */
public class MergeSortControllerImplementation implements SortControllerInterface{

    @Override
    public int[] sortArray(String text) {
        int[] array = Utility.stringToInt(text);
        Utility.printArray(array);

        System.out.println("Se ha llamado al MergeSort "+new Date());
        int[] arregloOrdenado = mergesort(array);
        System.out.println("Finalizó llamada al MergeSort "+new Date());

        Utility.printArray(arregloOrdenado);
        return arregloOrdenado;
    }
    
    private static int[] mergesort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        // Dividir el arreglo a la mitad
        int[] left = new int[array.length/2];
        int[] right = new int[array.length - left.length];
        System.arraycopy(array, 0, left, 0, left.length);
        System.arraycopy(array, left.length, right, 0, right.length);

        // Ordenar cada mitad recursivamente
        mergesort(left);
        mergesort(right);

        // Combinar las dos mitades ordenadas en un solo arreglo
        merge(left, right, array);

        return array;
    }
    
    private static void merge(int[] left, int[] right, int[] result) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        // Copiar los elementos restantes de la mitad izquierda
        while (i < left.length) {
            result[k++] = left[i++];
        }

        // Copiar los elementos restantes de la mitad derecha
        while (j < right.length) {
            result[k++] = right[j++];
        }
    }
    
}
