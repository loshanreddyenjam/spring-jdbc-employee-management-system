package com.example.employeeManagementSystem.Repository;

import com.example.employeeManagementSystem.Beans.Employee;

public interface EmployeeRepository {
	
	public String add(Employee employee);
	public Employee search(int eno);
	public String update(Employee employee);
	public String delete(int eno);

}
