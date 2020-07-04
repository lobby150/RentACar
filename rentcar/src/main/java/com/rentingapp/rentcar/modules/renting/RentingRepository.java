package com.rentingapp.rentcar.modules.renting;

import com.rentingapp.rentcar.modules.renting.entity.Renting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentingRepository extends JpaRepository<Renting,Integer> {

}
