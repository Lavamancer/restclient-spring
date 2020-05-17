package com.lavamancer.workshop;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class RestTemplateTool {

    private RestTemplate restTemplate = new RestTemplate();
    private ObjectMapper objectMapper = new ObjectMapper();
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";


    public <T> List<T> requestList(String endpoint) {
        ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL + endpoint, String.class);
        List<T> list = null;
        try {
            list = objectMapper.readValue(response.getBody(), new TypeReference<List<T>>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public <T> T requestItem(String endpoint, Long id, Class<T> clazz) {
        ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL + endpoint + "/" + id, String.class);
        T item = null;
        try {
            item = objectMapper.readValue(response.getBody(), clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

}
