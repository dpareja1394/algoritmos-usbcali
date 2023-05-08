import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        String[][] queries = {
        {"ADD_FILE", "/dir/file.txt","10"},
        {"FIND_FILE", "/dir", "file.txt"}
        };

        String[] buscarSolucion = solution(queries);

        System.out.println(String.join(", ", buscarSolucion));
    }

    static String[] solution(String[][] queries) {

        Map<String, Integer> files = new HashMap<>();
        String[] result = new String[queries.length];

        for(int i = 0; i<queries.length; i++) {
            if(queries[i][0].trim().equals("ADD_FILE")) {
                if(files.containsKey(queries[i][1])) {
                    result[i] = "false";
                }else {
                    files.put(queries[i][1], Integer.valueOf(queries[i][2]));
                    result[i] = "true";
                }
            }
            if(queries[i][0].trim().equals("COPY_FILE")) {
                if(!files.containsKey(queries[i][1])) {
                    result[i] = "false";
                }else {
                    if(files.containsKey(queries[i][2])) {
                        result[i] = "false";
                    } else {
                        Integer size = files.get(queries[i][1]);
                        files.put(queries[i][2], size);
                        result[i] = "true";
                    }
                }
            }
            if(queries[i][0].trim().equals("GET_FILE_SIZE")) {
                if(!files.containsKey(queries[i][1])) {
                    result[i] = "";
                }else {
                    result[i] = files.get(queries[i][1]).toString();
                }
            }
            if(queries[i][0].trim().equals("FIND_FILE")) {

                files = filesSorted(files);
                List<String> filesFound = new ArrayList<>();
                result[i] = "";
                for(String key : files.keySet()) {
                    if(key.contains(queries[i][1]) && key.contains(queries[i][2])) {
                        filesFound.add(key+"("+files.get(key)+")");
                    }
                }
                result[i] = filesFound.isEmpty() ? "" : String.join(", ", filesFound);
            }
        }

        return result;
    }

    static Map<String, Integer> filesSorted(Map<String, Integer> files) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(files.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for(Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    class User {
        Integer capacity;
        Map<String, Integer> files;
    }

}
