package com.rentingapp.rentcar.modules.car;

import com.rentingapp.rentcar.modules.car.entity.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

    private final CarService carService;
    @PostMapping("/add")
    Car addCar(@RequestBody Car newCar)
    {
        return carService.addCar(newCar);

    }
    @GetMapping("/get-all")
    Iterable<Car> getCars()
    {
        return carService.getCars();
    }
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteCar(@PathVariable int id)
    {
        return carService.deleteCar(id);
    }
    @GetMapping("/{id}")
    ResponseEntity<?> getCar(@PathVariable int id)
    {
        return carService.getCar(id);
    }
}
