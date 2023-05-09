import java.util.Arrays;
import java.util.Date;

public class Ejecucion {

    public static void main(String[] args) {

        // Crear el arreglo
        int[] arreglo = {
                705, 278, 413, 756, 333, 349, 893, 744, 422, 723,
                577, 435, 244, 821, 534, 88, 927, 333, 704, 250,
                165, 764, 636, 622, 197, 275, 404, 544, 326, 869,
                347, 513, 277, 463, 622, 993, 929, 115, 822, 154,
                389, 40, 267, 537, 404, 1, 530, 41, 764, 368, 110,
                13, 441, 791, 189, 481, 761, 811, 361, 86, 0, 126,
                831, 848, 586, 815, 860, 902, 853, 888, 571, 630,
                338, 516, 796, 450, 568, 811, 262, 915, 408, 3,
                879, 60, 823, 539, 254, 630, 897, 507, 480, 822, 965, 40, 136, 556, 983, 235, 487, 705
        };


        System.out.println("Se ha llamado al QuickSort "+new Date());
        int[] arregloOrdenado = quicksort(arreglo, 0, arreglo.length-1);
        System.out.println("Finalizó llamada al QuickSort "+new Date());

        Arrays.stream(arregloOrdenado).forEach(numero -> System.out.print(numero+", "));


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
