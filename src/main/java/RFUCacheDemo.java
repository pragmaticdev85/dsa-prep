import java.util.*;

class RFUCache {
    private Map<String, Integer> data = new LinkedHashMap<>();
    private int maxSize;
    public RFUCache(int maxSize) {
        this.maxSize = maxSize;
    }

    public Integer get(final String key) {
        return data.get(key);
    }

    public void put(final String key, final Integer value) {
        data.remove(key);
        data.put(key, value);
        if (data.size() > maxSize) {
            evict();
        }
        System.out.println(key + " added -> " + data);
    }

    private void evict() {
        for (String key: data.keySet()) {
            data.remove(key);
            break;
        }
    }
}
public class RFUCacheDemo {
    public static void main(String[] args) {
        RFUCache  rfuCache = new RFUCache(5);

        rfuCache.put("ONE", 1);
        rfuCache.put("TWO", 2);
        rfuCache.put("THREE", 3);
        rfuCache.put("FOUR", 4);
        rfuCache.put("FIVE", 5);
        rfuCache.put("SIX", 6);
        rfuCache.put("TWO", 2);
        rfuCache.put("ONE", 1);
        rfuCache.put("THREE", 3);
        rfuCache.put("ONE", 1);
        rfuCache.put("FIVE", 5);
        rfuCache.put("TWO", 2);
        rfuCache.put("SEVEN", 7);
        rfuCache.put("EIGHT", 8);
        rfuCache.put("NINE", 9);
    }
}
