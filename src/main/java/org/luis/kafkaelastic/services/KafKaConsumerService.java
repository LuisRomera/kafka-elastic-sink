package org.luis.kafkaelastic.services;

import com.sun.deploy.association.utility.AppConstants;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafKaConsumerService {

    @Value("${spring.kafka.topic}")
    private String topic;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private Environment env;


    @KafkaListener(topics = "${spring.kafka.topic}")
    private void listener(String json){
        try {
            elasticsearchRestTemplate.save(new JSONObject(json), IndexCoordinates.of(env.getProperty("spring.data.elasticsearch.index")));
        }catch (Exception e){
            System.out.println(json);

        }

    }
}
