package com.rentingapp.rentcar.modules.car;

import com.rentingapp.rentcar.modules.car.entity.Car;
import com.rentingapp.rentcar.modules.client.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RequiredArgsConstructor
class CarServiceTest {
    private static CarService carService;
    private static CarRepository carRepository;
    private final static List<Car> cars = new ArrayList<>();
    @BeforeAll
    public static void init()
    {
        carRepository = Mockito.mock(CarRepository.class);
        carService = new CarService(carRepository);

        Car car = new Car();
        car.setCarId(1);
        car.setBrand("Toyota");
        car.setModel("Avensis");
        car.setRented(false);

        Car auto = new Car();
        auto.setCarId(2);
        auto.setBrand("Ford");
        auto.setModel("Focus");
        auto.setRented(false);

        cars.add(car);
        cars.add(auto);

        when(carRepository.findAll()).thenReturn(cars);
        when(carRepository.getOne(1)).thenReturn(car);
        when(carRepository.getOne(2)).thenReturn(auto);
        when(carRepository.save(car)).thenReturn(car);
        when(carRepository.save(auto)).thenReturn(auto);
    }

    @Test
    public void whenFindAllThenSizeCorrect()
    {
        int count =0;
        Iterable<Car> cars = carService.getCars();
        for (Car i : cars)
        {
            count ++;
        }

        assertNotNull(cars);
        assertEquals(2, count);
    }

    @Test
    public void whenFindById1ThenReturnCar()
    {
        Car found = carRepository.getOne(1);
        assertNotNull(found);
        assertEquals("Toyota",found.getBrand());
        assertEquals(1,found.getCarId());

    }
    @Test
    void whenAddCarOkThenCorrect() {
        Car car = new Car();
        car.setBrand("Opel");
        car.setModel("Astra");
        carService.addCar(car);
        Mockito.verify(carRepository, Mockito.times(1))
                .save(car);


    }
    @Test
    void whenAddCarNotHaveBrandThenCorrect() {
        Car car = new Car();
        car.setModel("Renegade");

        Mockito.verify(carRepository,Mockito.times(1)).save(car);
    }
}