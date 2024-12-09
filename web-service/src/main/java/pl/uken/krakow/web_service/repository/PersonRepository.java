package pl.uken.krakow.web_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.uken.krakow.web_service.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
    
}
