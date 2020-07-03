package com.rentingapp.rentcar.modules.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;
    @PostMapping("/add")
    private Car addCar(@RequestBody Car newCar)
    {
        return carService.addCar(newCar);

    }
    @GetMapping("/getAll")
    private Iterable<Car> getCars()
    {
        return carService.getCars();
    }
    @DeleteMapping("/delete/{id}")
    private ResponseEntity<?> deleteCar(@PathVariable int id)
    {
        return carService.deleteCar(id);
    }
    @GetMapping("/{id}")
    private ResponseEntity<?> getCar(@PathVariable int id)
    {
        return carService.getCar(id);
    }
}
