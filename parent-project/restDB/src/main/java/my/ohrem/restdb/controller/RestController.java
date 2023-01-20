package my.ohrem.restdb.controller;
import my.ohrem.restdb.entity.RestEntity;
import my.ohrem.restdb.repository.RestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Optional;
@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private RestRepository restRepository;

    @GetMapping("/getRestEntity")
    public ResponseEntity<?> getRestEntityController() {
        System.out.println("getRestEntity is working");

        Optional<RestEntity> entity = restRepository.findById(1l);
        if (entity.isPresent()) {
            System.out.println("from repo: " + entity.get());

            return new ResponseEntity<>(entity.get()
                    , HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/getRestEntity")
    public void getPostRequestFromReceiver(@RequestBody RestEntity restEntity) {
        RestEntity save = restRepository.save(restEntity);
        System.out.println("SAVED ENTITY: " + save);
    }
}
