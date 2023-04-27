import java.util.ArrayList;

public class MyHashTable<K,V> {
    private ArrayList<HashNode<K, V>> myArr;
    private int index;
    private int size;
    private class HashNode<K, V>{
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }
    private HashNode<K, V>[] chainArray; // or Object[]
    public MyHashTable() {
        myArr = new ArrayList<>();
        size = 0;
        index = 0;
    }
    public MyHashTable(int M) {}
    private int hash(K key) {}
    public void put(K key, V value) {}
    public V get(K key) {return }
    public boolean contains(V value) {}
    public K getKey(V value) {}
}