import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.*;

public class ATest {
    private static void put(Map<Key, Value> map, Key key, Value value) {
        map.remove(key);
        map.put(key, value);
    }
    private static void printMap(Map<Key, Value> map) {
        System.out.println("=========================================================================================================");
        Set<Map.Entry<Key, Value>> entrySet = map.entrySet();
        entrySet.stream().sorted(((o1, o2) -> o1.getKey().getInsertedIx() - o2.getKey().getInsertedIx())).map(Map.Entry::getKey).forEach(System.out::println);
    }
    // Store key and value
    // PUT K, V store the entries
    // GET K, return V
    // low latency to be ensured
    // GET Keys() return the list of keys in the insertion order
    // PUT (K1, V1), PUT (K2, V2), PUT (K3, V3); GET keys() -> K1, K2, K3
    // PUT (K2, V4) new value V4;
    // GET keys() K1, K3, K2
    public static void main(String[] args) {
        Map<Key, Value> map = new HashMap<>();
        int ix = 0;
        put(map, Key.builder().key("K1").insertedIx(ix++).build(), Value.builder().text("V1").build());
        put(map, Key.builder().key("K2").insertedIx(ix++).build(), Value.builder().text("V2").build());
        put(map, Key.builder().key("K3").insertedIx(ix++).build(), Value.builder().text("V3").build());
        printMap(map);
        put(map, Key.builder().key("K2").insertedIx(ix++).build(), Value.builder().text("V4").build());
        printMap(map);

    }

}

@Data
@AllArgsConstructor
@Builder
class Key {
    private String key;
    private int insertedIx;
    public static int INSERT_ORDER_SEQUENCE = 0;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key1 = (Key) o;
        return Objects.equals(key, key1.key);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key);
    }
}

@Data
@AllArgsConstructor
@Builder
class Value {
    private String text;
}
