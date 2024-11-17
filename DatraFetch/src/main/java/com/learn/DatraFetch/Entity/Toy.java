package com.learn.DatraFetch.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Toy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "name" ,nullable = false)
    private String name;

    @Column(name = "age" , nullable = false)
    private String age;
}
