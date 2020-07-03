package com.rentingapp.rentcar.modules.car;

import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.NoSuchElementException;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    public Iterable<Car> getCars()
    {
     return  carRepository.findAll();
    }
    public Car addCar(Car car)
    {
        return carRepository.save(car);
    }
    public ResponseEntity<?> deleteCar(int id){
       try{
           carRepository.deleteById(id);
           return new ResponseEntity<String>("Car with this ID was deleted", HttpStatus.OK);
       } catch (EmptyResultDataAccessException e)
       {
           return new ResponseEntity<String>("Car with this ID doesn't exist", HttpStatus.OK);
       }
    }
    public ResponseEntity<?> getCar(int id)
    {
        try{
            Car car = carRepository.findById(id).get();
            return new ResponseEntity<Car>(car,HttpStatus.OK);
        }
        catch(NoSuchElementException e)
        {
            return new ResponseEntity<String>("Car with this ID doesn't exist",HttpStatus.NOT_FOUND);
        }
    }
}
