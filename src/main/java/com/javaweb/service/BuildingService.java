package com.javaweb.service;

import java.util.List;

import com.javaweb.model.BuildingDTO;

public interface BuildingService {
	// abstract method
	List<BuildingDTO> findAll(String name, Long districtId);
}
