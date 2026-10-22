import java.util.LinkedHashMap;
import java.util.Map;

public class Optional03LruCache {
    private static class LruCache {
        private final LinkedHashMap<Integer, String> entries;

        LruCache(int capacity) {
            if (capacity <= 0) {
                throw new IllegalArgumentException("Capacity must be positive");
            }
            entries = new LinkedHashMap<Integer, String>(capacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
                    return size() > capacity;
                }
            };
        }

        void put(int key, String value) {
            entries.put(key, value);
        }

        // The exercise mixes String values with an integer -1 for missing keys.
        // Object permits both return types exactly as described in the prompt.
        Object get(int key) {
            String value = entries.get(key); // Successful access moves entry to the end.
            return value == null ? -1 : value;
        }

        @Override
        public String toString() {
            return entries.toString(); // Least recently used appears first.
        }
    }

    public static void main(String[] args) {
        LruCache cache = new LruCache(3);
        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        System.out.println("Initial: " + cache);
        System.out.println("get(1): " + cache.get(1));
        System.out.println("After get(1): " + cache);
        cache.put(4, "D"); // 2 is the least recently used; it is evicted.
        System.out.println("After put(4, D): " + cache);
        System.out.println("get(2): " + cache.get(2)); // -1
    }
}
