package my.ohrem.restreceiver.service;

import my.ohrem.restreceiver.mapper.RestMapperFromServer;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Objects;

@Service
public class RestReceiveService {
    public void receiveListFromService() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RestMapperFromServer> products = restTemplate.getForEntity(
                "http://localhost:8081/getRestEntity",
                RestMapperFromServer.class);

        RestMapperFromServer entity = products.getBody();

        if (entity != null) {
            System.out.println("NAME: " + entity.getName());
            System.out.println("SURNAME: " + entity.getSurname());
            System.out.println("EMAIL: " + entity.getEmail());
            System.out.println("PASSWORD: " + entity.getPassword());
        }

        entity.setName("AAAAAAAAAAAAA");
        entity.setSurname("BBBBBBBBBBBBBB");

        restTemplate.postForEntity("http://localhost:8081/getRestEntity", entity, RestMapperFromServer.class);
    }
}
