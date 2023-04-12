import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        // Creamos un HashMap vacío
        HashMap<String, Integer> hm = new HashMap<>();

        // Agregamos elementos al HashMap
        hm.put("Juan", 25);
        hm.put("María", 30);
        hm.put("Pedro", 20);

        // Accedemos a un elemento del HashMap
        System.out.println("Edad de Juan: " + hm.get("Juan"));

        recorrerHashMap(hm);

        System.out.println("Se va a eliminar a Pedro");

        // Eliminamos un elemento del HashMap
        hm.remove("Pedro");

        System.out.println("Pedro ha sido eliminado");
        recorrerHashMap(hm);

        // Verificamos si un elemento existe en el HashMap
        System.out.println("¿Existe Pedro en el HashMap? " + hm.containsKey("Pedro"));
    }

    public static void recorrerHashMap(HashMap<String, Integer> hm) {
        // Recorremos el HashMap
        for (String nombre : hm.keySet()) {
            System.out.println(nombre + " tiene " + hm.get(nombre) + " años.");
        }
    }
}