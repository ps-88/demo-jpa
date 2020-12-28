package com.example.demojpa.repo;

import com.example.demojpa.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepo extends JpaRepository<Person, Integer> {


    List<Person> findByAgeGreaterThan(int age);

    List<Person> findByAgeBetween(int min, int max);

    default List<Person> onlyVasyaPerson (){
        return findByAddressesCity("Vasya");
    }

    List<Person> findByAddressesCity(String name);
}
