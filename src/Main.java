import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<Testing, MobilePhone> table = new MyHashTable<>();
        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            Testing key = new Testing(rand.nextInt(10000));
            MobilePhone value = new MobilePhone(rand.nextInt(100), rand.nextInt(100));
            table.put(key, value);
        }

        // Print the number of elements in each bucket
        for (int i = 0; i < table.getChainArray().length; i++) {
            MyHashTable.ListNode<Testing, MobilePhone> list = table.getChainArray()[i];
            int count = 0;
            while (list != null) {
                count++;
                list = list.next;
            }
            System.out.println("Bucket " + i + ": " + count + " elements");
        }
        // Remove all elements from the hash table
        for (int i = 0; i < 10000; i++) {
            Testing key = new Testing(i);
            table.remove(key);
        }

        // for checking if all elements are removed
//        for (int i = 0; i < table.getChainArray().length; i++) {
//            MyHashTable.ListNode<Testing, MobilePhone> list = table.getChainArray()[i];
//            int count = 0;
//            while (list != null) {
//                count++;
//                list = list.next;
//            }
//            System.out.println("Bucket " + i + ": " + count + " elements");
//        }
    }
}