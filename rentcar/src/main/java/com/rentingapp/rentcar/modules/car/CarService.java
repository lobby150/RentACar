package com.rentingapp.rentcar.modules.car;

import com.rentingapp.rentcar.modules.car.entity.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
@RequiredArgsConstructor
@Service
public class CarService {

    private final CarRepository carRepository;
    Iterable<Car> getCars()
    {
     return  carRepository.findAll();
    }
    Car addCar(Car car)
    {
        return carRepository.save(car);
    }
    ResponseEntity<String> deleteCar(int id){
       try{
           Car car = carRepository.findById(id).orElseThrow();
           if(car.isRented())
           {
               return new ResponseEntity<>("This car is currently rented!",HttpStatus.OK);
           }
           carRepository.deleteById(id);
           return new ResponseEntity<>("Car with this ID was deleted", HttpStatus.OK);
       } catch (EmptyResultDataAccessException e)
       {
           return new ResponseEntity<>("Car with this ID doesn't exist", HttpStatus.OK);
       }
    }
    ResponseEntity<?> getCar(int id)
    {
        try{
            Car car = carRepository.findById(id).orElseThrow();
            return new ResponseEntity<>(car,HttpStatus.OK);
        }
        catch(NoSuchElementException e)
        {
            return new ResponseEntity<>("Car with this ID doesn't exist",HttpStatus.NOT_FOUND);
        }
    }
}
