package com.paypal.bfs.test.employeeserv.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.repository.EmployeeRepository;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public ResponseEntity<Employee> employeeGetById(String id) {
		Employee employee = null;
		if(id!=null)
			 employee = employeeRepository.findById(Integer.parseInt(id)).orElse(null); 
		
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Employee> createOrUpdateEmployee(Employee employee) {
		Employee employeeRecord = employeeRepository.findById(employee.getId()).orElse(null);
		if (employeeRecord != null) {
			employeeRecord.setFirstName(employee.getFirstName());
			employeeRecord.setLastName(employee.getLastName());
			employeeRecord.setDateOfBirth(employee.getDateOfBirth());			
			employeeRecord.setAddress(employee.getAddress());
			
			return new ResponseEntity<>(employeeRepository.save(employeeRecord), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.OK);
		}
	}

}
