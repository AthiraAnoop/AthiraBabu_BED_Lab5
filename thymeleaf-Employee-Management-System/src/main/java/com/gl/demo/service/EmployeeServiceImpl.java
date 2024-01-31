package com.gl.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.demo.model.EmployeeModel;
import com.gl.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<EmployeeModel> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(EmployeeModel employee) {
		this.employeeRepository.save(employee);
		
	}

	@Override
	public EmployeeModel getEmployeeById(long id) {
		Optional<EmployeeModel> optional =employeeRepository.findById(id);
		EmployeeModel employee =null;
		if(optional.isPresent()) {
			employee =optional.get();
		}
		else {
			throw new RuntimeException("Employee Not Found");
		}
		return employee;
		
	}

	@Override
	public void deleteEmployeeById(long id) {
		this.employeeRepository.deleteById(id);
		
	}

}
