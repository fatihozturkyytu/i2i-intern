import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class Main {
    public static void main(String[] args) {
        // Hazelcast Client başlat
        HazelcastInstance client = HazelcastClient.newHazelcastClient();

        // Map oluştur veya eriş
        IMap<Integer, Person> map = client.getMap("persons");

        // 10.000 adet dummy Person nesnesi ekle
        for (int i = 0; i < 10000; i++) {
            Person p = new Person("Person-" + i, 20 + (i % 30));
            map.put(i, p);
        }

        System.out.println("10.000 Person nesnesi Hazelcast'e eklendi.");

        // Map'ten verileri çek ve ilk 10 tanesini yazdır
        for (int i = 0; i < 10; i++) {
            Person p = map.get(i);
            System.out.println("ID: " + i + ", Value: " + p);
        }

        // Client kapat
        client.shutdown();
    }
}
