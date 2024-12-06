package com.supra.petdb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "appusers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    @Id
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String county;
    private String role;
    private boolean enabled = true;
}
