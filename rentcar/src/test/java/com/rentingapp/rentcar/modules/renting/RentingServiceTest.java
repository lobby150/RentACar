package com.rentingapp.rentcar.modules.renting;

import com.rentingapp.rentcar.modules.car.CarRepository;
import com.rentingapp.rentcar.modules.car.CarService;
import com.rentingapp.rentcar.modules.car.entity.Car;
import com.rentingapp.rentcar.modules.client.ClientRepository;
import com.rentingapp.rentcar.modules.client.ClientService;
import com.rentingapp.rentcar.modules.client.entity.Client;
import com.rentingapp.rentcar.modules.renting.entity.Renting;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RentingServiceTest {

    private static RentingService rentingService;
    private static ClientService clientService;
    private static CarService carService;

    private static RentingRepository rentingRepository;
    private static ClientRepository clientRepository;
    private static CarRepository carRepository;

    private final static List<Renting> rentings = new ArrayList<>();
    @BeforeAll
    public static void init()
    {
        rentingRepository = Mockito.mock(RentingRepository.class);
        clientRepository = Mockito.mock(ClientRepository.class);
        carRepository = Mockito.mock(CarRepository.class);
        rentingService = new RentingService(rentingRepository,clientRepository,carRepository);
        carService = new CarService(carRepository);
        clientService = new ClientService(clientRepository);
        Client firstClient = new Client();
        firstClient.setClientId(1);
        firstClient.setFirstName("Marcin");
        firstClient.setSurname("Kubiak");
        firstClient.setRenting(false);

        Client secondClient = new Client();
        secondClient.setClientId(2);
        secondClient.setFirstName("Katarzyna");
        secondClient.setSurname("Nowak");
        secondClient.setRenting(false);

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

        Renting firstRenting = new Renting(car,firstClient);
        firstRenting.setRentingId(1);

        Renting secondRenting = new Renting(auto,secondClient);
        secondRenting.setRentingId(2);

        rentings.add(firstRenting);
        rentings.add(secondRenting);

        Mockito.when(rentingRepository.findAll()).thenReturn(rentings);
        Mockito.when(rentingRepository.getOne(1)).thenReturn(firstRenting);
        Mockito.when(rentingRepository.getOne(2)).thenReturn(secondRenting);
        Mockito.when(rentingRepository.save(firstRenting)).thenReturn(firstRenting);
        Mockito.when(rentingRepository.save(secondRenting)).thenReturn(secondRenting);

    }

    @Test
    public void whenFindAllRentingsThenSizeCorrect()
    {
        int count = 0;
        Iterable<Renting> rentings = rentingService.getAllRentings();
        for (Renting r : rentings)
        {
            count ++;
        }
        assertNotNull(rentings);
        assertEquals(2,count);
    }
    @Test
    public void whenFindById1ThenReturnFirstRenting()
    {
        Renting found = rentingRepository.getOne(1);
        assertNotNull(found);
        assertEquals("Toyota",found.getCar().getBrand());
    }
}