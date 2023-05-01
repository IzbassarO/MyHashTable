import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<Testing, MobilePhone> table = new MyHashTable<>();
        Random rand = new Random();
        // adding 10000 random elements to the hash table
        for (int i = 0; i < 10000; i++) {
            Testing key = new Testing(rand.nextInt(10000));
            MobilePhone phone = new MobilePhone(rand.nextInt(100), rand.nextInt(100));
            table.put(key, phone);
        }

        // bucket size and its results with containing elements
        System.out.println("Bucket Sizes:");
        int[] bucketSizes = table.getBucketSizes();
        for (int i = 0; i < bucketSizes.length; i++) {
            System.out.println("Bucket " + i + ": " + bucketSizes[i] + " elements");
        }

        System.out.println("The number of key-value in table: " + table.size());

        // Remove certain elements from the hash table
        for (int i = 0; i < 100; i++) {
            Testing key = new Testing(i);
            table.remove(key);
        }

        System.out.println("Is current table empty? " + table.isEmpty());
        System.out.println("After clearing table:");
        // Remove all elements from the hash table
        table.clear();

        System.out.println("Is current table empty? " + table.isEmpty());
    }
}