package kafkaexample;

import org.apache.kafka.clients.consumer.*;
import java.util.*;
import com.google.gson.Gson;

public class StudentConsumer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "student-group");
        props.put("auto.offset.reset", "earliest");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList("students"));

        Gson gson = new Gson();

        System.out.println("Waiting for student messages...");

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(java.time.Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> record : records) {
                Student student = gson.fromJson(record.value(), Student.class);
                System.out.println("Received student: " + student);
            }
        }
    }
}
