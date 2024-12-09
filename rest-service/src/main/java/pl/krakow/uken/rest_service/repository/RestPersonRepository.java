package pl.krakow.uken.rest_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.krakow.uken.rest_service.model.Person;

@Repository
public interface RestPersonRepository extends JpaRepository<Person, Long>{

    
} 
