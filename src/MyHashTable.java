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

    private void expandTable() {
        ListNode[] newtable = new ListNode[chainArray.length*2];
        for (int i = 0; i < chainArray.length; i++) {

            ListNode list = chainArray[i];
            while (list != null) {
                ListNode next = list.next;
                int hash = (Math.abs(list.key.hashCode())) % newtable.length;
                list.next = newtable[hash];
                newtable[hash] = list;
                list = next;
            }
        }
        chainArray = newtable;
    }

    public void put(K key, V value) {
        // Check for null key
        assert key != null : "The key must be non-null";

        // Determine which bucket to put the key-value pair in
        int bucket = hash(key);

        // Traverse the linked list at the bucket location to see if key already exists
        ListNode list = chainArray[bucket];
        while (list != null) {
            if (list.key.equals(key))
                break;
            list = list.next;
        }

        // If the key already exists, update the value
        if (list != null) {
            list.value = (String) value;
        } else { // Otherwise, add the new key-value pair to the table
            // Check if the table needs to be resized
            if (size >= 0.75* chainArray.length) {
                expandTable();
                bucket = hash(key);
            }
            ListNode newNode = new ListNode();
            newNode.key = (String) key;
            newNode.value = (String) value;
            newNode.next = chainArray[bucket];
            chainArray[bucket] = newNode;
            size++;  // Count the newly added key.
        }
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

    public K getKey(V value) {
        for (ListNode node : chainArray) {
            while (node != null) {
                if (node.value.equals(value)) {
                    return (K) node.key;
                }
                node = node.next;
            }
        }
        return null;
    }
    public int size() {
        return size;
    }
}