package com.rentingapp.rentcar.modules.car;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Getter
public class Car
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) public int carId;

    public String brand;
    public String model;
    @GeneratedValue(strategy = GenerationType.AUTO)
    public boolean rented = false;
}
