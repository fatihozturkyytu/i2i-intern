import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class HazelcastServer {
    public static void main(String[] args) {
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        System.out.println("Hazelcast Server started...");
    }
}
