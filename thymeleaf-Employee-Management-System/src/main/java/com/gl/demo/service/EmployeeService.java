package com.gl.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gl.demo.model.EmployeeModel;

@Service
public interface EmployeeService {
List<EmployeeModel> getAllEmployees();
void saveEmployee(EmployeeModel employee);
EmployeeModel getEmployeeById(long id);
void deleteEmployeeById(long id);
}
