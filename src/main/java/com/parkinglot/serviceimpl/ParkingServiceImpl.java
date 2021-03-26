package com.parkinglot.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkinglot.model.VehicleDTO;
import com.parkinglot.repository.ParkingRepository;
import com.parkinglot.service.ParkingService;

@Service
public class ParkingServiceImpl implements ParkingService{
	
	@Autowired
	ParkingRepository parkingRepository;

	@Override
	public List<VehicleDTO> getAllVehicles() {
		// TODO Auto-generated method stub
		return parkingRepository.findAll();
	}

	@Override
	public String park(VehicleDTO vehicleDTO) {
		// TODO Auto-generated method stub
		
		if(vehicleDTO.getId()>0 && vehicleDTO.getId()<=10) {
			List<VehicleDTO> dtos= parkingRepository.findAll();
			for(VehicleDTO dto : dtos) {
				if(dto.getId()!=vehicleDTO.getId()) {
					parkingRepository.save(vehicleDTO);
				}
				else {
					throw new RuntimeException(vehicleDTO.getId()+"slot is not vacant");
				}
			}
		}
		else {
			throw new RuntimeException("Provide a new id");
		}
		
		return "Parked" ;
	}

	@Override
	public String unpark(Long id) {
		// TODO Auto-generated method stub
		if(id>0 && id<=10) {
			parkingRepository.deleteById(id);
		}
		else {
			throw new RuntimeException("Kindly provide id between 1 to 10");
		}
		
		return "Unparked Vehicle is at slot number"+id;
	}
}
