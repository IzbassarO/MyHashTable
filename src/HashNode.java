import java.util.Objects;

public class HashNode<K,V> {
    private K key;
    private V value;
    private HashNode<K,V> next;
    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    // mutators and accessors for key,value and next
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public HashNode<K, V> getNext() {
        return next;
    }

    public void setNext(HashNode<K, V> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Key: " + key + ", Value: " + value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HashNode<?, ?> hashNode = (HashNode<?, ?>) obj;
        return Objects.equals(key, hashNode.key) &&
                Objects.equals(value, hashNode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}