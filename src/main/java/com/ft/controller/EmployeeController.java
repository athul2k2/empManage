package com.ft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ft.entity.Employee;

import com.ft.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/all")
	public List<Employee> getAllEmployee()
	{
		return employeeService.getAllEmployee(); 
		
	}
	
	@GetMapping("/hi")
	public String showString()
	{
		return "hi this is spring";
	}
	
	
	@PostMapping("/addEmp")
	public Employee addEmployee(@RequestBody Employee employee )
	{
		System.out.println(employee);
		return employeeService.addEmployee(employee);
		
	}

	
}
