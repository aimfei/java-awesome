package com.enkeshu.enkeshukafka;

import com.alibaba.fastjson.JSON;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mukang
 */
@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Resource
    private KafkaTemplate kafkaTemplate;

    @PostMapping("/send")
    public Object send(@RequestParam("username") String username) {
        Map<String, String> requestData = new HashMap<>();
        requestData.put("username", username);
        String data="{\n" +
                "  \"event\": \"customer_agreement_remind\",\n" +
                "  \"extEventParam\": {\n" +
                "    \"recommendId\": \"1268067415833972736\"\n" +
                " },\n" +
                "  \"messageParam\": {\n" +
                "    \"IMAIL\": {\n" +
                "      \"var1\": \"123\"\n" +
                " },\n" +
                "    \"PUSH\": {\n" +
                "      \"var1\": \"123\"\n" +
                " },\n" +
                "    \"SMS\": {\n" +
                "      \"var2\": \"银超123\",\n" +
                "      \"var1\": \"9238\"\n" +
                " }\n" +
                "  },\n" +
                "  \"receiver\": [\n" +
                "    {\n" +
                "      \"uid\": \"1265556854533263360\",\n" +
                "      \"phone\": \"13926526232\"\n" +
                " }\n" +
                "  ]\n" +
                "}";
        kafkaTemplate.send("TRIGGER_EVENTSYSTEM-TOPIC", JSON.toJSONString(data));
        return 1;
    }
}

