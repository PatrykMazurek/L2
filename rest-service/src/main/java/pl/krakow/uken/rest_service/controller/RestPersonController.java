package pl.krakow.uken.rest_service.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import pl.krakow.uken.rest_service.model.Person;
import pl.krakow.uken.rest_service.repository.RestPersonRepository;

@RestController
@RequestMapping("/api/v1")
public class RestPersonController {
 
    @Autowired
    RestPersonRepository repository;

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllPerson(){
        return ResponseEntity.ok().body(
                repository.findAll()   
        );
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable("id") Long id){
        return ResponseEntity.ok()
                    .body(repository.findById(id).orElse(null));
    }

    @PostMapping("/add")
    public ResponseEntity<String> addPerson(@RequestBody Person p,
                @RequestHeader("key")String key ){
        p.setCreated_at(LocalDateTime.now());
        p.setUpdated_at(LocalDateTime.now());
        String url = "http://localhost:8090/add";
        RestTemplate rest = new RestTemplate();
        Person savePerson = repository.save(p);
        savePerson.getId();
        HashMap<String, Object> obj = new HashMap<>();
        obj.put("personId", savePerson.getId());
        obj.put("email", p.getEmail());
        rest.postForObject(url, obj, String.class);
        if (savePerson != null){
            return ResponseEntity.ok().body("dodano rekord");
        }else{
            return ResponseEntity.ok().body("nie dodano rekord");
        }
    }
    
    // public ResponseEntity<String> deletePerson()
    
    // public ResponseEntity<String> updatePerson()


}
