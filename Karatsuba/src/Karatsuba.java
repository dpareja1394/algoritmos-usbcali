import java.util.ArrayList;
import java.util.List;

public class Karatsuba {

    public static Long[] separarNumeros(Long n) {
        Long[] numerosSeparados = new Long[2];

        numerosSeparados[0] = n/100;
        numerosSeparados[1] = n%100;

        return numerosSeparados;
    }

    public static Long aplicarMultiplicacion(Long[] l1, Long[] l2) {
        Long a = l1[0];
        Long b = l1[1];
        Long c = l2[0];
        Long d = l2[1];

        System.out.println("a = "+a+ ", b = "+b + ", c = "+c + ", d = "+d);

        Long formula = ((a*100)+b) * ((c*100) + d);


        return formula;
    }

}
