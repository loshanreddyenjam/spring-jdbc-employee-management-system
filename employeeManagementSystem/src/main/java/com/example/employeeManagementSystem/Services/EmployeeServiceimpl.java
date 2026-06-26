package com.example.employeeManagementSystem.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeeManagementSystem.Beans.Employee;
import com.example.employeeManagementSystem.Repository.EmployeeRepository;

@Service
public class EmployeeServiceimpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeerepository;

	public void setEmployeerepository(EmployeeRepository employeerepository) {
		this.employeerepository = employeerepository;
	}

	@Override
	public String addEmployee(Employee employee) {
		String status = employeerepository.add(employee);

		return status;
	}

	@Override
	public Employee searchEmployee(int eno) {
		Employee employee = employeerepository.search(eno);

		return employee;
	}

	@Override
	public String updateEmployee(Employee employee) {
		String status = employeerepository.update(employee);

		return status;
	}

	@Override
	public String deleteEmployee(int eno) {
		String status=employeerepository.delete(eno);
		

		return  status;
	}

}
