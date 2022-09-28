package com.devsuperior.dscatalog.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalog.dto.PersonDTO;
import com.devsuperior.dscatalog.dto.PersonFullDTO;
import com.devsuperior.dscatalog.entities.Department;
import com.devsuperior.dscatalog.entities.Person;
import com.devsuperior.dscatalog.repositories.DepartmentRepository;
import com.devsuperior.dscatalog.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Transactional(readOnly = true)
	public PersonDTO findById(Long id) {
		Optional<Person> result = repository.findById(id);
		Person entity = result.get();
		return new PersonDTO(entity);
	}

	//Com metodo getone, possibilida ir no banco e exibir todas os objetos aninhados
	@Transactional
	public PersonFullDTO insert(PersonDTO dto) {
		
		Person entity = new Person();
		
		entity.setName(dto.getName());
		entity.setSalary(dto.getSalary());
		
		Department dept = departmentRepository.getOne(dto.getDepartmentId());
		
		entity.setDepartment(dept);
		
		entity = repository.save(entity);
		
		/*
		 
		 
		{
		    "id": 6,
		    "name": "Nova Pessoa",
		    "salary": 8000.0,
		    "department": 
		    {
		    	"id": 1,
		    	"name" : "Administrativo"
		    }
		}
		
		
		*/
		
		return new PersonFullDTO(entity);
	}
	
	/*
	 
	 'Nesse formato ele não retorna todo o objeto. 
	 Por exemplo não retorna o nome no departamento na resposta'
	 
	@Transactional
	public PersonDTO insert(PersonDTO dto) {
		
		Person entity = new Person();
		
		entity.setName(dto.getName());
		entity.setSalary(dto.getSalary());
		
		Department dept =  new Department();
		dept.setId(dto.getDepartmentId());
		
		entity.setDepartment(dept);
		
		entity = repository.save(entity);
	
		
		return new PersonDTO(entity);
		
		'Objeto retorndo no JSON'
		
		{
		    "id": 6,
		    "name": "Nova Pessoa",
		    "salary": 8000.0,
		    "departmentId": 1
		}
		
	}
	*/
}
