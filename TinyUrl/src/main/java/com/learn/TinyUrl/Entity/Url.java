package com.learn.TinyUrl.Entity;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "urls")
@Getter
@Setter
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @Column(nullable = false ,name = "ORIGINAL_URL")
    private String originalUrl;

    @Column(unique = true ,nullable = false ,name = "SHORT_URL")
    private String shortUrl;

//    Getters and Setters here
//    Used Annotation to create

}
