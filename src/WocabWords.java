import java.util.HashMap;
import java.util.Map;

public class WocabWords {
    private HashMap  <String, Integer>  map;
    private String[] arr;

    WocabWords(String[] arr) {
        this.arr = arr;
        map = new HashMap<String, Integer>();
    }

    public void doWocabulery(){
        int l = arr.length; // количество слов в массиве
        String tempKey;
        for(int i = 0; i<l; i++) {
            tempKey = arr[i];
            if (map.containsKey(tempKey)) {
                map.replace(tempKey, (map.get(tempKey)+1));
            } else map.put(tempKey, 1);
        }
    }

    public HashMap<String, Integer> getWocabulery() {
        return map;
    }

}
