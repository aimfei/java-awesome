package com.enkeshu.enkeshukafka.client;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author mukang
 */
@Slf4j
public class MessageProducer {
    public static void main(String[] args) {
        try {
            Properties kaftans = new Properties();
            kaftans.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.11.151:9092,192.168.11.152:9092,192.168.11.153:9092");
            kaftans.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
            kaftans.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
            Producer<String, String> producer = new KafkaProducer<String, String>(kaftans);
            final CountDownLatch countDownLatch = new CountDownLatch(1000);
            for (int i = 0; i < 1000; i++) {
                Map map = new HashMap();
                map.put("username", UUID.randomUUID().toString());

                ProducerRecord<String, String> message = new ProducerRecord<>("account_info", JSON.toJSONString(map));
                producer.send(message, new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata metadata, Exception exception) {
                        if (exception != null) {
                            System.err.println("发送消息失败：" + exception.getStackTrace());

                        }
                        if (metadata != null) {
                            System.out.println("异步方式发送消息结果：" + "topic-" + metadata.topic() + "|partition-"
                                    + metadata.partition() + "|offset-" + metadata.offset());
                        }
                        countDownLatch.countDown();
                    }
                });
            }

            countDownLatch.await(5, TimeUnit.SECONDS);
        } catch (Exception e1) {
            log.error("",e1);

        }

    }
}
