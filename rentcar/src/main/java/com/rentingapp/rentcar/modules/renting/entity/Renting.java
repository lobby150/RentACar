package com.rentingapp.rentcar.modules.renting.entity;

import com.rentingapp.rentcar.modules.car.entity.Car;
import com.rentingapp.rentcar.modules.client.entity.Client;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Renting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) public int rentingId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "carId")
    public Car car;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clientId")
    public Client client;


    public Renting(Car car, Client client) {
        this.car = car;
        this.client = client;
    }
    public Renting(){}
}
