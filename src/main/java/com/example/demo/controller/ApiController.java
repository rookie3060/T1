package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.EmployeeRequest;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repository.DepartmentRepo;
import com.example.demo.repository.EmployeeRepo;

@RestController
public class ApiController {
	@Autowired
	DepartmentRepo dRepository;
	@Autowired
	EmployeeRepo eRepository;
	@GetMapping("/getemployee")
	public List<Employee> getEmployees(){
		return eRepository.findAll();
	}
	@PostMapping("/employee1")
	public Employee saveEmployee(@Validated @RequestBody EmployeeRequest eRequest) {
		Department department = new Department();
		department.setName(eRequest.getDepartment());
department = dRepository.save(department);		
Employee employee = new Employee();
	employee.setName(eRequest.getName());
		employee.setDepartment(department);
		eRepository.save(employee);
		return employee;
	}
	

}
