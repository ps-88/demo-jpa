package com.example.demojpa.dao;


import com.example.demojpa.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;
    public void savePerson(Person person) {
    entityManager.persist(person);
    }



    public List<Person> findByAgeGreaterThan (int age) {
        Query query = entityManager.createQuery("from Person where age<:age");
        List<Person> listAge = query.setParameter("age", age).getResultList();
        return listAge;
    }
}


