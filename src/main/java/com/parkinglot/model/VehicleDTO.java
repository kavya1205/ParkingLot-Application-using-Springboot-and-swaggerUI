package com.parkinglot.model;
import javax.persistence.*;

import lombok.Data;



@Entity
@Data
public class VehicleDTO {
	
	@Id
private Long id;
private String vehicleNumber;
private String ownerName;



}
