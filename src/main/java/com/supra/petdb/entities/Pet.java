package com.supra.petdb.entities;

import lombok.*;

@Data
@NoArgsConstructor
@ToString
public class Pet {
    private String name;
    private String animalType;
    private String breed;
    private int age;
}
