package com.rentingapp.rentcar.modules.renting;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Renting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) public int rentingId;


}
