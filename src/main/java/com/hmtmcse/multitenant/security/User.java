package com.hmtmcse.multitenant.security;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Entity
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Please enter name.")
    private String name;

    @NotEmpty(message = "Please enter email.")
    @Email(message = "Please enter valid email.")
    @Column(nullable = false, unique = true)
    private String email;

    @NotEmpty(message = "Please enter password.")
    private String password;

}
