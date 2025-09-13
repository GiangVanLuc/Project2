package com.javaweb.service;

import java.util.List;
import java.util.Map;

import com.javaweb.model.BuildingDTO;

public interface BuildingService {
	// abstract method
	List<BuildingDTO> findAll(Map<String, Object> params, List<String> typeCode);
}
