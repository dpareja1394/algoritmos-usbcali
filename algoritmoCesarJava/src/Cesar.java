public class Cesar {

    // Método para cifrar el mensaje
    public static String cifrar(String mensaje, int desplazamiento) {
        String resultado = "";

        for(int i = 0; i < mensaje.length(); i++) {
            char letra = mensaje.charAt(i);

            // Si la letra es una letra minúscula
            if(Character.isLowerCase(letra)) {
                letra = (char) (((letra - 'a') + desplazamiento) % 26 + 'a');
            }
            // Si la letra es una letra mayúscula
            else if(Character.isUpperCase(letra)) {
                letra = (char) (((letra - 'A') + desplazamiento) % 26 + 'A');
            }

            resultado += letra;
        }

        return resultado;
    }

    // Método para descifrar el mensaje
    public static String descifrar(String mensaje, int desplazamiento) {
        return cifrar(mensaje, 26 - desplazamiento);
    }

    // Método main para probar la implementación
    public static void main(String[] args) {
        String mensaje = "Hola mundo!";
        int desplazamiento = 3;

        String mensajeCifrado = cifrar(mensaje, desplazamiento);
        System.out.println("Mensaje cifrado: " + mensajeCifrado);

        String mensajeDescifrado = descifrar(mensajeCifrado, desplazamiento);
        System.out.println("Mensaje descifrado: " + mensajeDescifrado);
    }
}
