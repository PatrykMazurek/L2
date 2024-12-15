package pl.krakow.uken.mail_service.controller;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.krakow.uken.mail_service.model.PersonMail;
import pl.krakow.uken.mail_service.repository.EmailRepository;

@RestController
@RequestMapping("/mail")
public class EmailController {
    
    @Autowired
    EmailRepository repository;

    @PostMapping("/add")
    public ResponseEntity<String> addEmailToDB(@RequestBody HashMap<String, Object> pm){
        PersonMail mail = new PersonMail();
        mail.setPersonId(Long.parseLong(pm.get("personId").toString()));
        mail.setEmail(pm.get("email").toString());
        mail.setCreated_at(LocalDateTime.now());
        mail.setUpdated_at(LocalDateTime.now());
        System.out.println(mail.getEmail());
        return ResponseEntity.ok().body("OK");
    }

}
