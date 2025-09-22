package com.javaweb.converter;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.utils.MapUtil;

@Component
public class BuildingSearchBuilderConverter {
	public BuildingSearchBuilder toBuildingSearchBuilder(Map<String, Object> params, List<String> typeCode) {
		BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder()
																			.setName(MapUtil.getObject(params, "name", String.class))
															                .setFloorArea(MapUtil.getObject(params, "floorArea", Long.class))
															                .setWard(MapUtil.getObject(params, "ward", String.class))
															                .setStreet(MapUtil.getObject(params, "street", String.class))
															                .setDistrictId(MapUtil.getObject(params, "districtId", Long.class))
															                .setNumberOfBasement(MapUtil.getObject(params, "numberOfBasement", Integer.class))
															                .setTypeCode(typeCode) 
															                .setManagerName(MapUtil.getObject(params, "managerName", String.class))
															                .setManagerPhoneNumber(MapUtil.getObject(params, "managerPhoneNumber", String.class))
															                .setRentPriceTo(MapUtil.getObject(params, "rentpriceTo", Long.class))
															                .setRentPriceFrom(MapUtil.getObject(params, "rentpriceFrom", Long.class))
															                .setAreaFrom(MapUtil.getObject(params, "areaFrom", Long.class))
															                .setAreaTo(MapUtil.getObject(params, "areaTo", Long.class))
															                .setStaffId(MapUtil.getObject(params, "staffId", Long.class))
															                .setLevel(MapUtil.getObject(params, "level", String.class))
															                .setDirection(MapUtil.getObject(params, "Direction", String.class))
															                .build();
		return buildingSearchBuilder;
	}
}
