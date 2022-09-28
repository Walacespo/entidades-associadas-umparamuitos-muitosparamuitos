package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.Department;

public class DepartmentDTO {
	
	private Long id;
	private String name;
	
	public DepartmentDTO() {
		
	}

	public DepartmentDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public DepartmentDTO(Department entity) {
		super();
		this.id =entity.getId();
		this.name = entity.getName();
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
	
	

}
