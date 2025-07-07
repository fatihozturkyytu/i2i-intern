package kafkaexample;

import org.apache.kafka.clients.producer.*;
import java.util.Properties;
import com.google.gson.Gson;

public class StudentProducer {
    public static void main(String[] args) {
        // Kafka yapılandırması
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        // Gönderilecek öğrenci nesnesi
        Student s = new Student(1, "fatih öztürk");
        String json = new Gson().toJson(s);

        ProducerRecord<String, String> record = new ProducerRecord<>("students", json);
        producer.send(record, (metadata, exception) -> {
            if (exception == null) {
                System.out.println("Sent successfully to topic " + metadata.topic());
            } else {
                exception.printStackTrace();
            }
        });

        producer.close();
    }
}
