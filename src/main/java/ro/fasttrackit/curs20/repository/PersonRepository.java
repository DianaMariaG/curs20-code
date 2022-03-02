package ro.fasttrackit.curs20.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.curs20.entity.Person;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByName(String name); //transforma in Select * From Person
    List<Person> findByNameAndCity(String name, String city);
}
