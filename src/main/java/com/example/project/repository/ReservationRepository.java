package com.example.project.repository;

import com.example.project.entity.Reservation;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    static void updateDates(Date date, Date endDate) {
    }
    //тук много е важно след findBy, да бъде името на пропърти което го има в Reservation, понеже hibernate трябва да генерира sql заявката
    Optional<Reservation> findByClient (String client);
    Optional<Reservation> findByCar (Long id);
    Optional<Reservation> findByRentDate (Date rentDate);
    Optional<Reservation> findById (Long id);

    @Transactional
    @Modifying
    @Query("Update Reservation Set reservationDateTime = :resDT, rentDate = :pUDT, endDate = :rDT Where reservationId = :id")
    static void updateDates(@Param("resDT") Date resDateTime, @Param("pUDT") Date date, @Param("rDT") Date date2, @Param("id") int reservationId) {

    }

}
