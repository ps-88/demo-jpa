package com.example.demojpa.repo;

import com.example.demojpa.model.Address;
import com.example.demojpa.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
class PersonRepoTest {

    @Autowired
    private PersonRepo personRepo;

    @BeforeEach
    @Transactional
    @Rollback(value = false)
    public void setUp() {
        personRepo.save(Person.builder().address(Address.builder().city("Vasya").build()).build());

    }

    @Test
    @Transactional
    public void onlyVasyaPerson() {
        List<Person> list = personRepo.onlyVasyaPerson();
        Assert.assertEquals(1,list.size());
    }
}