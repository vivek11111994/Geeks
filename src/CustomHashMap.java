public class CustomHashMap {
        public static void main (String[] args) {
                MyHashMap<String, String> myHashMap = new MyHashMap<> ();

                myHashMap.put ("Vivek", "Awasthi");
                myHashMap.put ("Shivam", "Yadav");
                myHashMap.put ("Shambhavi", "Pandey");

                //myHashMap.display ();

                myHashMap.remove ("Shivam");

                //myHashMap.display ();

                System.out.println (myHashMap.get (null));
        }
}

class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry (K key, V value, Entry<K, V> next) {
                this.key = key;
                this.value = value;
                this.next = next;
        }

        public K getKey () {
                return key;
        }

        public void setKey (K key) {
                this.key = key;
        }

        public V getValue () {
                return value;
        }

        public void setValue (V value) {
                this.value = value;
        }

        public Entry<K, V> getNext () {
                return next;
        }

        public void setNext (Entry<K, V> next) {
                this.next = next;
        }
}

class MyHashMap<K, V> {
        private final Entry<K, V>[] table;
        private int capacity = 16;

        public MyHashMap (int capacity) {
                this.capacity = capacity;
                table = new Entry[capacity];
        }

        public MyHashMap () {
                table = new Entry[capacity];
        }

        public void put (K key, V value) {
                int index = index (key);
                Entry newEntry = new Entry (key, value, null);

                if (table[index] == null) {
                        table[index] = newEntry;
                } else {
                        Entry<K, V> previousNode = null;
                        Entry<K, V> currentNode = table[index];

                        while (currentNode != null) {
                                if (currentNode.getKey ().equals (key)) {
                                        currentNode.setValue (value);
                                        break;
                                }

                                previousNode = currentNode;
                                currentNode = currentNode.getNext ();
                        }

                        if (previousNode != null) {
                                previousNode.setNext (newEntry);
                        }
                }
        }

        public V get (K key) {
                V value = null;
                int index = index (key);
                Entry<K, V> entry = table[index];

                while (entry != null) {
                        if (entry.getKey ().equals (key)) {
                                value = entry.getValue ();
                                break;
                        }

                        entry = entry.getNext ();
                }

                return value;
        }

        public void remove (K key) {
                int index = index (key);
                Entry previous = null;
                Entry entry = table[index];

                while (entry != null) {
                        if (entry.getKey ().equals (key)) {
                                if (previous == null) {
                                        entry = entry.getNext ();
                                        table[index] = entry;
                                        return;
                                } else {
                                        previous.setNext (entry.getNext ());
                                        return;
                                }
                        }

                        previous = entry;
                        entry = entry.getNext ();
                }
        }

        public void display () {
                for (int i = 0; i < capacity; i++) {
                        if (table[i] != null) {
                                Entry<K, V> currentNode = table[i];
                                while (currentNode != null) {
                                        System.out.println (currentNode.getKey () + " : " + currentNode.getValue ());
                                        currentNode = currentNode.getNext ();
                                }
                        }
                }
        }

        private int index (K key) {
                if (key == null) {
                        return 0;
                }

                return Math.abs (key.hashCode () % capacity);
        }
}


