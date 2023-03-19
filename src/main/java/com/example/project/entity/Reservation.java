package com.example.project.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="reservations")
public class Reservation {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date reservationDateTime;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date rentDate;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date endDate;

    @ManyToOne
    @JsonManagedReference
    private User client;

    @ManyToMany
    @JoinTable (
            name="car_reservation",
            joinColumns ={@JoinColumn(name="car_id")},
            inverseJoinColumns = {@JoinColumn(name="reservation_id")})
    @JoinColumn(name = "car_id")
    private Set<Car> car;


    Format dateFormatted = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    Calendar c = Calendar.getInstance();
    String formatDate = dateFormatted.format(c.getTime());
}
