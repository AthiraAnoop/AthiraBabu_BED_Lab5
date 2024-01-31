package com.gl.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gl.demo.model.EmployeeModel;
import com.gl.demo.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;
	
	@GetMapping("/")
	public String list(Model model) {
		model.addAttribute("listEmployees", employeeservice.getAllEmployees());
		return "list-employees";
	}
	
	@GetMapping("/addEmployeeForm")
	public String addEmployeeForm(Model model) {
		EmployeeModel employee=new EmployeeModel();
		model.addAttribute("employee",employee);
		return "add-employee";
	}
	
	@GetMapping("/employeeFormUpdate/{id}")
	public String employeeFormUpdate(@PathVariable(value="id") long id,Model model) {
		EmployeeModel employee=	employeeservice.getEmployeeById(id);
		model.addAttribute("employee",employee);
		return "update-employee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value="id") long id) {
		this.employeeservice.deleteEmployeeById(id);
		return "redirect:/";
	}
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") EmployeeModel employee) {
		employeeservice.saveEmployee(employee);
		return "redirect:/";
	}
}

