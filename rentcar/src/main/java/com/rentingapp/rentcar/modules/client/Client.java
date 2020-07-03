package com.rentingapp.rentcar.modules.client;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Getter
@Setter
public class Client
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) public int clientId;

    public String firstName;
    public String surname;
    @GeneratedValue(strategy = GenerationType.AUTO)
    public boolean renting = false; //one client can rent only one car
}
