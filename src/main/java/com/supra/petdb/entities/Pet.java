package com.supra.petdb.entities;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pet {
    private int id;
    private String name;
    private String animalType;
    private String breed;
    private int age;
}
