package com.example.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="user_first_name",length = 30, nullable = false)
    private String firstName;

    @Column(name="user_last_name",length = 50,nullable = false)
    private String lastName;

    @Column(name="user_address",length = 150)
    private String address;

    private String password;
    @Column(unique = true)
    private String email;

    @Min(11)
    @Max(12)
    @Column(name="user_phone_number")
    private String phoneNumber;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    @JsonBackReference
    private Set<Reservation> reservations;

}
