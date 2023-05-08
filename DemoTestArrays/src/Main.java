import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[][] queries = {
        {"ADD", "1"},
        {"ADD", "2"},
        {"ADD", "2"},
        {"ADD", "4"},
        {"EXISTS", "4"},
        {"GET_NEXT", "1"},
        {"GET_NEXT", "2"},
        {"GET_NEXT", "3"},
        {"GET_NEXT", "4"},
        {"REMOVE", "2"},
        {"GET_NEXT", "1"},
        {"GET_NEXT", "2"},
        {"GET_NEXT", "3"},
        {"GET_NEXT", "4"}
        };

        String[] buscarSolucion = solution(queries);

        System.out.println(String.join(", ", buscarSolucion));
    }

    static String[] solution(String[][] queries) {

        String[] result = new String[queries.length];
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<queries.length; i++) {
            if(queries[i][0].trim().equals("ADD")) {
                list.add(Integer.parseInt(queries[i][1]));
                result[i] = "";
            }
            if(queries[i][0].trim().equals("REMOVE")) {
                result[i] = list.remove(Integer.valueOf(queries[i][1])) ? "true" : "false";
            }
            if(queries[i][0].trim().equals("EXISTS")) {
                int queryValue = Integer.parseInt(queries[i][1]);
                result[i] = list.contains(queryValue) ? "true" : "false";
            }
            if(queries[i][0].trim().equals("GET_NEXT")) {
                int queryValue = Integer.parseInt(queries[i][1]);
                result[i] = list.parallelStream().sorted().filter(f -> f > queryValue)
                        .findFirst().map(Object::toString).orElse("");
            }
        }

        return result;
    }

}
