package my.ohrem.restreceiver;

import my.ohrem.restreceiver.service.RestReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class RestReceiverApplication {
    @Autowired
    private RestReceiveService restReceiveService;

    public static void main(String[] args) {
        SpringApplication.run(RestReceiverApplication.class, args);
    }

    @Bean
    public void callService() {
        restReceiveService.receiveListFromService();
    }

}
