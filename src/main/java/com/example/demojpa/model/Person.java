package com.example.demojpa.model;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@NamedQuery(name = "allPerson", query = "from Person")


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int age;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @Singular
    private List<Address> addresses;

}
