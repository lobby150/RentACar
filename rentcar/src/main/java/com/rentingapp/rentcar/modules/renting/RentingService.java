package com.rentingapp.rentcar.modules.renting;

import com.rentingapp.rentcar.modules.car.Car;
import com.rentingapp.rentcar.modules.car.CarRepository;
import com.rentingapp.rentcar.modules.client.Client;
import com.rentingapp.rentcar.modules.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RentingService {
    @Autowired
    RentingRepository rentingRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    CarRepository carRepository;

    public Renting addRenting(Map<String,String> rent)
    {
        int idCar = Integer.parseInt(rent.get("car"));
        Car car = carRepository.findById(idCar).orElseThrow();
        int idClient = Integer.parseInt(rent.get("client"));
        Client client = clientRepository.findById(idClient).orElseThrow();
        return rentingRepository.save(new Renting(car,client));
    }
    public Renting getRenting(int id)
    {
        return rentingRepository.findById(id).get();
    }
}
