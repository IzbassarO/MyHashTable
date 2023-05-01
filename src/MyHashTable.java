public class MyHashTable<K,V> {
    // Inner class for linked list node

    HashNode<K,V>[] chainArray;
    // Array of linked lists
    private final int M = 11; // Default number of chains
    private int size; // size of pair key & value

    // Default constructor initializes table with size 11
    public MyHashTable() {
        chainArray = new HashNode[M];
        size = 0;
    }

    // Constructor with initial size parameter
    public MyHashTable(int initialSize) {
        if (initialSize <= 0)
            throw new IllegalArgumentException("Illegal array size");
        chainArray = new HashNode[initialSize];
        size = 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % chainArray.length);
    }

    public void put(K key, V value) {
        int hash = hash(key);
        HashNode<K, V> head = chainArray[hash];
        HashNode<K, V> node = head;

        while (node != null) {
            if (node.getKey().equals(key)) {
                node.setValue(value);
                return;
            }
            node = node.getNext();
        }

        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.setNext(head);
        chainArray[hash] = newNode;
        size++;
    }

    // Returns the value associated with the given key
    public V get(K key) {
        int hash = hash(key);
        HashNode<K, V> node = chainArray[hash];
        while (node != null) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
            node = node.getNext();
        }

        return null; // If key not found, return null
    }
    // Returns true / false if the given value is in chainArray
    public boolean containsKey(V value) {
        for (HashNode<K, V> node : chainArray) {
            while (node != null) {
                if (node.getValue().equals(value)) {
                    return true;
                }
                node = node.getNext();
            }
        }
        return false;
    }

    // Returns the key of the given value
    public K getKey(V value) {
        for (HashNode<K, V> node : chainArray) {
            while (node != null) {
                if (node.getValue().equals(value)) {
                    return node.getKey();
                }
                node = node.getNext();
            }
        }
        return null;
    }

    // Return the current size of a chainArray
    public int size() {
        return size;
    }

    public HashNode<K,V>[] getChainArray() {
        return chainArray;
    }
    // Clears all the key-value pairs from the table
    public void clear() {
        for (int i = 0; i < chainArray.length; i++) {
            chainArray[i] = null;
        }
        size = 0;
    }
    // Removes the key-value pair associated with the given key
    public void remove(K key) {
        int hash = hash(key);
        HashNode<K, V> head = chainArray[hash];
        HashNode<K, V> prev = null;
        HashNode<K, V> node = head;

        while (node != null) {
            if (node.getKey().equals(key)) {
                if (prev == null) {
                    chainArray[hash] = node.getNext();
                } else {
                    prev.setNext(node.getNext());
                }
                size--;
                return;
            }
            prev = node;
            node = node.getNext();
        }
    }
    public int[] getBucketSizes() {
        int[] bucketSizes = new int[chainArray.length];
        for (int i = 0; i < chainArray.length; i++) {
            HashNode<K, V> node = chainArray[i];
            int size = 0;
            while (node != null) {
                size++;
                node = node.getNext();
            }
            bucketSizes[i] = size;
        }
        return bucketSizes;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}