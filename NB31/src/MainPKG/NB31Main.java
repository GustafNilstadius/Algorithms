package MainPKG;
import HashTable.*;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by hipernx on 2015-02-18.
 */
public class NB31Main {
    public static void main(String[] args) {
        HashTableBucket<String, Integer> hb = new HashTableBucket<String, Integer>(13);
        Random rnd = new Random();
        for (int i = 0; i < 100; i++) {
            hb.put("String" +i, i*i*i);
        }

        for (int i = 1; i < 13; i++) {
            System.out.println("Find item with key " + "String" + i + "\t result (if null, not found): " + hb.get("String" + i));
        }
        System.out.println("\tPrinting nonexisting:");
        System.out.println("Find item with key " + "String" + 111 + "\t result (if null, not found): " + hb.get("String" + 111) + "\n");
        System.out.println("Find item with key " + "String" + 33 + "\t result (if null, not found): " + hb.get("String" + 33));
        System.out.println("\tReplacing key: String33, new value: 1");
        hb.put("String" + 33, 1);
        System.out.println("Find item with key " + "String" + 33 + "\t result (if null, not found): " + hb.get("String" + 33));

    }


}
