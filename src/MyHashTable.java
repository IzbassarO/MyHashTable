public class MyHashTable<K,V> {
    // Inner class for linked list node
    private static class ListNode<K,V> {
        K key;
        V value;
        ListNode<K,V> next;
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
            throw new IllegalArgumentException("Illegal array size");
        chainArray = new ListNode[initialSize];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % chainArray.length);
    }

    private void expandTable() {
        ListNode<K,V>[] newtable = new ListNode[chainArray.length*2];
        for (int i = 0; i < chainArray.length; i++) {
            ListNode<K,V> list = chainArray[i];
            while (list != null) {
                ListNode<K,V> next = list.next;
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
    }

    // Returns the value associated with the given key
    public V get(K key) {
        // Determine which bucket to look in
        int bucket = hash(key);

        // Traverse the linked list at the bucket location to find the key-value pair
        ListNode<K,V> list = chainArray[bucket];  // For traversing the list.
        while (list != null) {
            if (list.key.equals(key))
                return list.value;
            list = list.next;  // Move on to next node in the list.
        }
        return null; // If key not found, return null
    }

    public boolean containsKey(K key) {

        int bucket = hash(key);

        ListNode<K,V> list = chainArray[bucket];
        while (list != null) {
            if (list.key.equals(key))
                return true;
            list = list.next;
        }

        return false;
    }

    public K getKey(V value) {
        for (ListNode<K,V> node : chainArray) {
            ListNode<K,V> current = node;
            while (current != null) {
                if (current.value.equals(value)) {
                    return current.key;
                }
                current = current.next;
            }
        }
        return null;
    }
    public int size() {
        return size;
    }
}