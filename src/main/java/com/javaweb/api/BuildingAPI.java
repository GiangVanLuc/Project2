package com.javaweb.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.BuildingDTO;
import com.javaweb.service.BuildingService;


@RestController
public class BuildingAPI {
	
	@Autowired
	private BuildingService buildingService;
	
	@GetMapping(value ="/api/building/")
	public List<BuildingDTO> getBuilding(@RequestParam Map<String,Object> params,
										@RequestParam(name = "typeCode", required = false) List<String> typeCode) {
										
		
		List<BuildingDTO> result = buildingService.findAll(params, typeCode);
		return result; 
		
	}
//	public void valiDate(BuildingDTO buildingDTO) {
//		if(buildingDTO.getName() == null || buildingDTO.getName().equals("") || buildingDTO.getNumberOfBasement() == null) {
//			throw new FieldRequiredException("name or numberofbasement is null");
//		}
//	}
//	@PostMapping(value = "/api/building/")
//	public void getBuilding2(@RequestBody BuildingDTO buildingDTO) {
//		System.out.println("ok");
//	}
//	
	@DeleteMapping(value ="/api/building/{id}")
	public void deleteBuilding(@PathVariable Integer id) {
		System.out.println("Da xoa toa nha co id la" + id + " roi nhe!");
	}
}