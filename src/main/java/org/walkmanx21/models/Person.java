package org.walkmanx21.models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "persons")
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "name")
    String name;

    public Person(String name) {
        this.name = name;
    }
}
