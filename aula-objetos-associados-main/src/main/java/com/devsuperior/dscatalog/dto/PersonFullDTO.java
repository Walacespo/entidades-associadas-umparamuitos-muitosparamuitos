package com.devsuperior.dscatalog.dto;

import java.io.Serializable;

import com.devsuperior.dscatalog.entities.Person;

public class PersonFullDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Double salary;
	private DepartmentDTO department;
	
	public PersonFullDTO() {
	}

	public PersonFullDTO(Person entity) {
		super();
		this.id = entity.getId();
		this.name = entity.getName();
		this.salary = entity.getSalary();
		this.department = new DepartmentDTO(entity.getDepartment());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public DepartmentDTO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}

	
	
}
