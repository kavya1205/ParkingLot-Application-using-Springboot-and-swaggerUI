package com.parkinglot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.parkinglot.model.VehicleDTO;

@Repository
public interface ParkingRepository extends JpaRepository<VehicleDTO, Long> {

}
