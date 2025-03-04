package com.project.david.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	
	public User(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
