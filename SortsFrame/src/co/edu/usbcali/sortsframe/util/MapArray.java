/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
