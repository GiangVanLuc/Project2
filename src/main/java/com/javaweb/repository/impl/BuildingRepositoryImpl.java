package com.javaweb.repository.impl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.utils.StringUtil;
@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	static final String USER = "root";
	static final String PASS = "123456";
	
	public static void joinTable(Map<String, Object> params, List<String> typeCode, StringBuilder sql) {
		String staffId = (String)params.get("staffId");
		if(StringUtil.checkString(staffId)) {
			sql.append(" INNER JOIN assigmentbuilding ON b.id = assignmentbuilding.buildingid ");
		}
		if(typeCode != null && typeCode.size() != 0) {
			sql.append(" INNER JOIN buildingrenttype ON b.id = buildingrenttype.buildingid ");
			sql.append(" INNER JOIN buildingrenttype ON renttype.id = buildingrenttype.renttypedid ");
		}
		String rentAreaTo = (String)params.get("areaTo");
		String rentAreaFrom = (String)params.get("areaFrom");
		if(StringUtil.checkString(rentAreaTo)|| StringUtil.checkString(rentAreaFrom)) {
			sql.append(" INNER JOIN rentarea ON rentarea.buildingid = b.id");
		}
	}
	
	public static void queryNomal(Map<String, Object> params, StringBuilder where) {
		for(Map.Entry<String, Object> it: params.entrySet()) {
			if(!it.getKey().equals("staffId") && !it.getKey().equals("typeCode") && !it.getKey().startsWith("area") && !it.getKey().startsWith("rentPrice")) {
				String value = it.getValue().toString();
			}
		}
	}
	
	public static void querySpecial(Map<String, Object> params, List<String> typeCode) {
		
	}
	
	@Override
	public List<BuildingEntity> findAll(Map<String, Object> params, List<String> typeCode) {
		StringBuilder sql = new StringBuilder("SELECT b.id, b.name, b.districtId, b.street, b.ward, b.numberofbasement, b.floorarea, b.rentprice, b.managername, b.managerphonenumber, b.service, b.brokeragefee From building b");
		joinTable(params, typeCode, sql);
		System.out.println(sql);
		StringBuilder where = new StringBuilder("WHERE 1 = 1");
		List<BuildingEntity> result = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());){
			
			while(rs.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setName(rs.getString("name"));
				building.setStreet(rs.getString("street"));
				building.setWard(rs.getString("ward"));
				building.setNumberOfBasement(rs.getInt("numberofbasement"));
				result.add(building);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public void DeleteById(Long id) {
		// TODO Auto-generated method stub
		
	}
	
}
