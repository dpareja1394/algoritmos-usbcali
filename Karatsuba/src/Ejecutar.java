import java.util.ArrayList;
import java.util.List;

public class Ejecutar {

    public static void main(String[] args) {
        Long n1 = 12345L;

        Long n2 = -67891L;

        //List<Long> separacionN1 = separarNumeros(n1);
        //List<Long> separacionN2 = separarNumeros(n2);

        Long[] separacionN1 = Karatsuba.separarNumeros(n1);
        Long[] separacionN2 = Karatsuba.separarNumeros(n2);

        Long resultado = Karatsuba.aplicarMultiplicacion(separacionN1, separacionN2);

        System.out.println("Resultado "+resultado);

    }

    public static List<Long> separarNumeros(Long n) {
        List<Long> numerosSeparados = new ArrayList<>();

        numerosSeparados.add(n/100);
        numerosSeparados.add(n%100);

        return numerosSeparados;
    }

    public static void imprimirLista(List<Long> lista) {
        lista.stream().forEach(System.out::println);
    }

    public static Long aplicarMultiplicacion(List<Long> l1, List<Long> l2) {
        Long a = l1.get(0);
        Long b = l1.get(1);
        Long c = l2.get(0);
        Long d = l2.get(1);

        System.out.println("a = "+a+ "b = "+b + "c = "+c + "d = "+d);

        Long formula = ((a*100)+b) * ((c*100) + d);


        return formula;
    }


}
