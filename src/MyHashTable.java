public class MyHashTable<K,V> {
    // Inner class for linked list node
    private static class ListNode {
        String key;
        String value;
        ListNode next;
    }

    // Array of linked lists
    private ListNode[] chainArray;
    private int M = 11; // Default number of chains
    private int size; // size of pair key & value

    // Default constructor initializes table with size 11
    public MyHashTable() {
        chainArray = new ListNode[M];
    }

    // Constructor with initial size parameter
    public MyHashTable(int initialSize) {
        if (initialSize <= 0)
            throw new IllegalArgumentException("Illegal table size");
        chainArray = new ListNode[initialSize];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % chainArray.length);
    }
    public void put(K key, V value) {


        size++;
    }

    // Returns the value associated with the given key
    public String get(String key) {
        // Determine which bucket to look in
        int bucket = hash((K) key);

        // Traverse the linked list at the bucket location to find the key-value pair
        ListNode list = chainArray[bucket];  // For traversing the list.
        while (list != null) {
            if (list.key.equals(key))
                return list.value;
            list = list.next;  // Move on to next node in the list.
        }
        return null; // If key not found, return null
    }
    public boolean containsKey(String key) {

        int bucket = hash((K) key);

        ListNode list = chainArray[bucket];
        while (list != null) {
            if (list.key.equals(key))
                return true;
            list = list.next;
        }

        return false;
    }

    public K getKey(V value) {}
    public int size() {
        return size;
    }
}