package com.javaweb.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.converter.BuildingRequestDTO;
import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.service.BuildingService;


@RestController
public class BuildingAPI {
	@Autowired
	private BuildingRepository buildingRepository;
	
	@Autowired
	private BuildingService buildingService;
	
	@GetMapping(value ="/api/building/")
	public List<BuildingDTO> getBuilding(@RequestParam Map<String,Object> params,
										@RequestParam(name = "typeCode", required = false) List<String> typeCode) {
		List<BuildingDTO> result = buildingService.findAll(params, typeCode);
		return result; 
	}
	
//	@GetMapping(value ="/api/building/{name}")
//	public BuildingDTO getBuildingById(@PathVariable String name) {
//										
//		BuildingDTO result = new BuildingDTO();
//		List<BuildingEntity> building = buildingRepository.findByNameContaining(name);
//		return result;
//	}
	
	

//	@PostMapping(value = "/api/building/")
//	public void getBuilding2(@RequestBody BuildingDTO buildingDTO) {
//		System.out.println("ok");
//	}
//	
	
//	@PutMapping(value = "/api/building/")
//	public void updateBuilding(@RequestBody BuildingRequestDTO buildingRequestDTO) {
//		BuildingEntity buildEntity = buildingRepository.findById(buildingRequestDTO.getId()).get();
//		buildEntity.setName(buildingRequestDTO.getName());
//		buildEntity.setStreet(buildingRequestDTO.getStreet());
//		buildEntity.setWard(buildingRequestDTO.getWard());
//		DistrictEntity districtEntity = new DistrictEntity();
//		districtEntity.setId(buildingRequestDTO.getDistrictId());
//		buildEntity.setDistrict(districtEntity);
//		buildingRepository.save(buildEntity);
//		
//	}
	@DeleteMapping(value ="/api/building/{ids}")
	public void deleteBuilding(@PathVariable Long[] ids) {
		buildingRepository.deleteByIdIn(ids);
	}
}