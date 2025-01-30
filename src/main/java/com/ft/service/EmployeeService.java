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
	
	public Employee updateEmployee(Long id, Employee updatedEmployee) {
	    Optional<Employee> currentEmployeeData = employeeRepository.findById(id);
	    
	    if (currentEmployeeData.isPresent()) {
	        Employee employee = currentEmployeeData.get();
	        employee.setName(updatedEmployee.getName());
	        employee.setEmail(updatedEmployee.getEmail());
	        employee.setDepartment(updatedEmployee.getDepartment());
	        
	        return employeeRepository.save(employee);
	    }
		return updatedEmployee;
	}
	
	public void deleteEmployee(long id)
	{
		employeeRepository.deleteById(id);
	}
}
