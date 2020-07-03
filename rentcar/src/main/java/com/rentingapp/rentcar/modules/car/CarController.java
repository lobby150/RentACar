package com.rentingapp.rentcar.modules.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    public CarService carService;
    @PostMapping("/add")
    public Car addCar(@RequestBody Car newCar)
    {
        return carService.addCar(newCar);

    }
    @GetMapping("/getAll")
    public Iterable<Car> getCars()
    {
        return carService.getCars();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable int id)
    {
        return carService.deleteCar(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCar(@PathVariable int id)
    {
        return carService.getCar(id);
    }
}
