package co.edu.usbcali.sortsframe.util;

import java.util.Arrays;

/**
 *
 * @author dpareja
 */
public class MapArray {
    public static int[] stringToInt(String cadena) {
        return Arrays.stream(cadena.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
