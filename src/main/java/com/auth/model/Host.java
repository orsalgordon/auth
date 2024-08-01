package com.auth.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int hostId;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private Date dateOfBirth;
    @Column
    private String email;
    @Column
    private String password;
}
