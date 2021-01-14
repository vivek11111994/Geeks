import java.util.*;

public class StringPool {
        public static void main (String[] args) {
                Map<MapKey, MapValue> map = new HashMap<> ();

                map.put (new MapKey ("Vivek"), new MapValue (26));
                map.put (new MapKey ("Aayush"), new MapValue (24));
                map.put (new MapKey ("Rahul"), new MapValue (34));
                map.put (new MapKey ("Suresh"), new MapValue (38));
                map.put (new MapKey ("Chandra"), new MapValue (48));

                List<MapKey> mapKeyList = new ArrayList<> (map.keySet ());
                Collections.sort (mapKeyList, new Comparator<MapKey> () {
                        @Override
                        public int compare (MapKey o1, MapKey o2) {
                                if (o1.getFirstName ().compareTo (o2.getFirstName ()) > 0) {
                                        return 1;
                                }

                                return - 1;
                        }
                });

                for (MapKey mapKey : mapKeyList) {
                        System.out.println (mapKey.toString () + " : " + map.get (mapKey).toString ());
                }
        }
}

class MapKey {
        private String firstName;

        public MapKey (String firstName) {
                this.firstName = firstName;
        }

        public String getFirstName () {
                return firstName;
        }

        public void setFirstName (String firstName) {
                this.firstName = firstName;
        }

        @Override
        public String toString () {
                return "MapKey{" +
                        "firstName='" + firstName + '}';
        }
}

class MapValue {
        private Integer age;

        public MapValue (Integer age) {
                this.age = age;
        }

        public Integer getAge () {
                return age;
        }

        public void setAge (Integer age) {
                this.age = age;
        }

        @Override
        public String toString () {
                return "MapValue{" +
                        "age=" + age +
                        '}';
        }
}
