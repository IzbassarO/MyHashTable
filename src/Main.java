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


    }
}
