/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usbcali.sortsframe.controller.implementation;

import co.edu.usbcali.sortsframe.controller.SortControllerInterface;
import co.edu.usbcali.sortsframe.util.Utility;
import java.util.Date;

/**
 *
 * @author dpareja
 */
public class QuickSortControllerImplementation implements SortControllerInterface{

    @Override
    public int[] sortArray(String text) {
        
        int[] array = Utility.stringToInt(text);
        Utility.printArray(array);

        System.out.println("Se ha llamado al QuickSort "+new Date());
        int[] arregloOrdenado = quicksort(array, 0, array.length-1);
        System.out.println("Finalizó llamada al QuickSort "+new Date());

        Utility.printArray(arregloOrdenado);
        return arregloOrdenado;
        
    }
    
    
    public static int[] quicksort(int[] array, int izq, int der) {

        int pivote=array[izq]; // tomamos primer elemento como pivote
        int i=izq;         // i realiza la búsqueda de izquierda a derecha
        int j=der;         // j realiza la búsqueda de derecha a izquierda
        int aux;

        while(i < j){                          // mientras no se crucen las búsquedas
            while(array[i] <= pivote && i < j) i++; // busca elemento mayor que pivote
            while(array[j] > pivote) j--;           // busca elemento menor que pivote
            if (i < j) {                        // si no se han cruzado
                aux= array[i];                      // los intercambia
                array[i]=array[j];
                array[j]=aux;
            }
        }

        array[izq]=array[j];      // se coloca el pivote en su lugar de forma que tendremos
        array[j]=pivote;      // los menores a su izquierda y los mayores a su derecha

        if(izq < j-1)
            quicksort(array,izq,j-1);          // ordenamos subarray izquierdo
        if(j+1 < der)
            quicksort(array,j+1,der);          // ordenamos subarray derecho


        return array;
    }
}
