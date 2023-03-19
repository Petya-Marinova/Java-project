package com.example.project.runner;

import com.example.project.entity.Car;
import com.example.project.entity.User;
import com.example.project.repository.CarRepository;
import com.example.project.repository.ReservationRepository;
import com.example.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class CommandRunner implements CommandLineRunner {
    @Autowired
    CarRepository carRepository;
    @Autowired
     ReservationRepository reservationRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        createUser();
        createCar();


    }

    public void createUser() {
        User user1 = new User();
        user1.setFirstName("Daniela");
        user1.setLastName("Nikolova");
        user1.setPassword("Dani123");
        user1.setAddress("Varna,Chayka,26");
        user1.setEmail("dani@abv.bg");
        user1.setPhoneNumber("359882900000");
        userRepository.save(user1);

        User user2 = new User();
        user2.setFirstName("Mira");
        user2.setLastName("Stoycheva");
        user2.setPassword("Mira@123");
        user2.setAddress("Veliko Tarnovo,Kartala,262");
        user2.setEmail("mirast@abv.bg");
        user2.setPhoneNumber("359887666666");
        userRepository.save(user2);
    }

    public void createCar(){
        Car car1= new Car();
        car1.setBrand("Toyota");
        car1.setModel("Corolla");
        car1.setSeats(5);
        car1.setRentalPrice(65.50);
        carRepository.save(car1);

        Car car2= new Car();
        car2.setBrand("Mercedes");
        car2.setModel("A150");
        car2.setSeats(3);
        car2.setRentalPrice(23.00);
        carRepository.save(car2);

        Car car3= new Car();
        car3.setBrand("BMW");
        car3.setModel("M5");
        car3.setSeats(5);
        car3.setRentalPrice(80.00);
        carRepository.save(car3);
    }
}
