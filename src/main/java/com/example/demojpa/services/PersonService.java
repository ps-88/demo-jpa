package com.example.demojpa.services;

import com.example.demojpa.model.Address;
import com.example.demojpa.model.Person;
import com.example.demojpa.repo.PersonRepo;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PersonService {

    @Autowired
    private PersonRepo personRepo;
    @Autowired
    private Faker faker;



    @Transactional
    public void save10Person() {
        List<Person> people = Stream.iterate(1, integer -> ++integer)
                .limit(10)
                .map(this::createRandomPerson)
                .collect(Collectors.toList());

        for (Person person : people) {
            personRepo.save(person);
        }

        for (Person person : people) {
            person.setName(person.getName().toUpperCase());
        }
    }


    @Transactional
    public void printAllYoungPersons() {
        personRepo.findByAgeGreaterThan(18).forEach(System.out::println);
    }

    public Person createRandomPerson(int i) {
        return Person.builder().age(i * 5).name(faker.gameOfThrones().character())
                .address(Address.builder().city(faker.address().city()).street(faker.address().streetName()).build())
                .address(Address.builder().city(faker.address().city()).street(faker.address().streetName()).build())
                .build();
    }
}
