package com.rentingapp.rentcar.modules.car;

import com.rentingapp.rentcar.modules.car.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>
{

}


