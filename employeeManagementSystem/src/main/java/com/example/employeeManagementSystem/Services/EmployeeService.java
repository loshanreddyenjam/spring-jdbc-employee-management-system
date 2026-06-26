package com.example.employeeManagementSystem.Services;

import com.example.employeeManagementSystem.Beans.Employee;

public interface EmployeeService {
	public String addEmployee(Employee employee);
	public Employee searchEmployee(int eno);
	public String updateEmployee(Employee employee);
	public String deleteEmployee(int eno);

}
