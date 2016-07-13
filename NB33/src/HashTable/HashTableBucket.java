package HashTable;
import SingleLinkedList.*;

import java.util.Iterator;


public class HashTableBucket<K,V> {
    private static class Entry<K, V> {
        public K key;
        public V value;

        public Entry(K k, V v) {
            key = k;
            value = v;
        }

        public String toString(){
            return "Key: " + key + " Value: " + value;
        }
    }

    private SingleLinkedList<Entry<K, V>>[] table;

    @SuppressWarnings("unchecked")
    public HashTableBucket(int size) {
        table = new SingleLinkedList[size];
    }

    public V put(K key, V value) {
        int index = key.hashCode() % table.length;
        if (index < 0) index += table.length;
        if (table[index] == null) {
            table[index] = new SingleLinkedList<Entry<K, V>>();
            table[index].add(new Entry<K, V>(key, value));
            return null;
        } else {
            V oldValue;
            Iterator<Entry<K, V>> itr = table[index].iterator();
            while(itr.hasNext() ) {
                Entry<K, V> e = itr.next();
                if (e.key.equals(key)) {
                    oldValue = e.value;
                    e.value = value;
                    return oldValue;
                }
            }
            table[index].add(new Entry<K, V>(key, value));
            return null;
        }
    }

    public V get(K key) {
        int index = key.hashCode() % table.length;
        if (index < 0) index += table.length;
        if (table[index] == null) return null;
        Iterator<Entry<K, V>> itr = table[index].iterator();
        while(itr.hasNext()) {
            Entry<K, V> e = itr.next();
            if (e.key.equals(key)) {
                return e.value;
            }
        }
        return null;
    }

    public V remove(K key){
        int index = key.hashCode() % table.length;
        if (index < 0) index += table.length;
        if (table[index] == null) return null;
        Iterator<Entry<K, V>> itr = table[index].iterator();
        while(itr.hasNext()) {
            Entry<K, V> e = itr.next();
            if (e.key.equals(key)) {
                itr.remove();
                return e.value;
            }
        }
        return null;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i = 0; i < table.length; i++) {
            sb.append("Bucket #" + i + " = " + table[i].toString() + "\n");
        }
        return sb.toString();
    }
}
