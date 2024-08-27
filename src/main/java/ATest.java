import lombok.AllArgsConstructor;
import lombok.Data;

public class ATest {
    // Store key and value
    // PUT K, V store the entries
    // GET K, return V
    // low latency to be ensured
    // GET Keys() return the list of keys in the insertion order
    // PUT (K1, V1), PUT (K2, V2), PUT (K3, V3); GET keys() -> K1, K2, K3
    // PUT (K2, V4) new value V4;
    // GET keys() K1, K3, K2
    public static void main(String[] args) {

    }

}

@Data
@AllArgsConstructor
class Key {
    private String key;
    private int insertedIx;
    public static int INSERT_ORDER_SEQUENCE = 0;
}

@Data
@AllArgsConstructor
class Value {
    private String text;
}
