package com.javaweb.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.RentAreaEntity;

@Component
public class BuildingDTOConverter {

//	@Autowired
//	private DistrictRepository districtRepository;
//	
//	@Autowired
//	private RentAreaRepository rentAreaRepository;
	
	
	@Autowired
	private ModelMapper modelMapper;
	public BuildingDTO toBuildingDTO(BuildingEntity item) {
		BuildingDTO building = modelMapper.map(item, BuildingDTO.class);
		
//		DistrictEntity districtEntity = districtRepository.findNameById(item.getDistrictId());

		building.setAddress(item.getStreet() + ", " + item.getWard() + "," + item.getDistrictId().getName());
//		List<RentAreaEntity> rentAreas = rentAreaRepository.getValueByBuildingId(item.getId());
		
		List<RentAreaEntity> rentAreas = item.getRentAreaEntites();
		String areaResult = rentAreas.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(","));
		building.setRentArea(areaResult);
		
//		building.setName(item.getName());
//		building.setNumberOfBasement(item.getNumberofbasement());
//		building.setManagerName(item.getManagerName());
//		building.setManagerPhoneNumber(item.getManagerPhoneNumber());
//		building.setFloorarea(item.getFloorArea());
//		building.setEmptyArea(item.getEmptyArea());
//		building.setRentPrice(item.getRentPrice());
//		building.setServiceFee(item.getServiceFee());
//		building.setBrokerageFee(item.getBrokerageFee());
		return building;
	}
}
