//package com.javaweb.repository.entity;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//
//
//@Entity
//@Table(name = "user_role")
//public class UserRoleEntity {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	
//	@ManyToOne
//	@JoinColumn(name = "userid")
//	private RoleEntity user;
//	
//	@ManyToOne
//	@JoinColumn(name = "roleid")
//	private UserEntity role;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public RoleEntity getUser() {
//		return user;
//	}
//
//	public void setUser(RoleEntity user) {
//		this.user = user;
//	}
//
//	public UserEntity getRole() {
//		return role;
//	}
//
//	public void setRole(UserEntity role) {
//		this.role = role;
//	}
//	
//	
//}
