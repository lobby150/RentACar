package com.rentingapp.rentcar.modules.car.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Getter
@Setter
public class Car
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) public int carId;

    public String brand;
    public String model;
    @GeneratedValue(strategy = GenerationType.AUTO)
    public boolean rented = false;
}
