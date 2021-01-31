package com.bourimans.employmentmng.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @Column(nullable = false, length = 25)
    @NotEmpty(message = "First name should not be empty")
    private String firstname;
    @NotEmpty(message = "Last name should not be empty")
    @Column(nullable = false, length = 25)
    private String lastname;
    @Column(nullable = false, name = "years_of_experience",length = 20)
    private int exp;
    @Column(unique = true, nullable = false,length = 50)
    @Email(regexp = "^(.+)@(.+)$",message = "Invalid email pattern")
    @NotEmpty(message = "Email should not be empty")
    private String email;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_fk")
    private Departement departement;
}
