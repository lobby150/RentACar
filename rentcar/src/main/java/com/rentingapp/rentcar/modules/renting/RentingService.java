package com.rentingapp.rentcar.modules.renting;

import com.rentingapp.rentcar.modules.car.entity.Car;
import com.rentingapp.rentcar.modules.car.CarRepository;
import com.rentingapp.rentcar.modules.client.entity.Client;
import com.rentingapp.rentcar.modules.client.ClientRepository;
import com.rentingapp.rentcar.modules.renting.entity.Renting;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RentingService {

    private final RentingRepository rentingRepository;

    private final ClientRepository clientRepository;

    private final CarRepository carRepository;

    ResponseEntity<String> addRenting(Map<String, String> rent) {
        int idCar = Integer.parseInt(rent.get("car"));
        Car car = carRepository.findById(idCar).orElseThrow();
        int idClient = Integer.parseInt(rent.get("client"));
        Client client = clientRepository.findById(idClient).orElseThrow();
        if (car.isRented() || client.isRenting()) {
            return new ResponseEntity<>("Car is rent or the client is already renting a car", HttpStatus.OK);
        } else {
            car.setRented(true);
            client.setRenting(true);
            rentingRepository.save(new Renting(car, client));

            return new ResponseEntity<>("Client " + client.getFirstName() + " successfully rented " + car.brand, HttpStatus.OK);
        }
    }

    ResponseEntity<?> getRenting(int id) {
        try {
            Renting renting = rentingRepository.findById(id).orElseThrow();
            return new ResponseEntity<>(renting, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("There is no such renting with ID: " + id, HttpStatus.NOT_FOUND);
        }
    }
    Iterable<Renting> getAllRentings(){
        return rentingRepository.findAll();
    }


    ResponseEntity<String> deleteRenting(int id){
        try{
            Renting renting = rentingRepository.findById(id).orElseThrow();
            renting.car.setRented(false);
            renting.client.setRenting(false);
            rentingRepository.deleteById(id);
            return new ResponseEntity<>("Renting with ID: " + id + " was deleted", HttpStatus.OK);
        } catch (NoSuchElementException e)
        {
            return new ResponseEntity<>("Renting with ID: " + id + " doesn't exist", HttpStatus.OK);
        }
    }
}
