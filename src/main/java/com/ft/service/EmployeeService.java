package com.ft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ft.entity.Employee;
import com.ft.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployee()
	{
		return employeeRepository.findAll();
	}

	public Employee addEmployee(Employee employee)
	{
		return employeeRepository.save(employee);
	}
	
	public Employee updateEmployee(Long id , Employee employee)
	{
		Employee employeeRef = new Employee();
		Optional<Employee> existingEmp = employeeRepository.findById(id);
		
		if(existingEmp.isPresent())
		{
			
			
		}
		
		
		return employee;
		
		
	}
	
	public void deleteEmployee(long id)
	{
		employeeRepository.deleteById(id);
	}
}
