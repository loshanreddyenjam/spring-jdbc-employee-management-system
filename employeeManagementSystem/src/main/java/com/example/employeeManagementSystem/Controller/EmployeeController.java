package com.example.employeeManagementSystem.Controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.employeeManagementSystem.Beans.Employee;
import com.example.employeeManagementSystem.Services.EmployeeService;

@Controller
public class EmployeeController {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	@Autowired
	EmployeeService employeeservice;

	public void setEmployeeservice(EmployeeService employeeservice) {
		this.employeeservice = employeeservice;
	}

	public void addEmployee() {

		try {
			System.out.println("ENTER EMPLOYEE NUMBER :");
			int eno = Integer.parseInt(br.readLine());
			Employee emp = employeeservice.searchEmployee(eno);
			if (emp == null) {
				System.out.println("ENTER EMPLOYEE NAME :");
				String ename = br.readLine();
				System.out.println("ENTER EMPLOYEE SALARY :");
				float esal = Float.parseFloat(br.readLine());
				System.out.println("ENTER EMPLOYEE ADDRESS :");
				String eaddr = br.readLine();
				emp = new Employee();
				emp.setEno(eno);
				emp.setEname(ename);
				emp.setEsal(esal);
				emp.setEaddr(eaddr);

				String status = employeeservice.addEmployee(emp);
				if (status.equalsIgnoreCase("success")) {
					System.out.println("Employee added successfully");
				} else {
					System.out.println("Employee insertion failure");
				}

			} else {
				System.out.println();
				System.out.println("EMPLOYEE ALREADY EXIST");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void searchEmployee() {
		try {
			System.out.println("ENTER EMPLOYEE NUMBER :");
			int eno = Integer.parseInt(br.readLine());
			Employee emp = employeeservice.searchEmployee(eno);
			if (emp == null) {
				System.out.println("EMOPLOYEE NOT FOUND");
			} else {
				System.out.println();
				System.out.println("EMPLOYEE DETAILS");
				System.out.println("---------------------");
				System.out.println("EMPLOYEE NUMBER :" + emp.getEno());
				System.out.println("EMPLOYEE NAME :" + emp.getEname());
				System.out.println("EMPLOYEE SALARY :" + emp.getEsal());
				System.out.println("EMPLOYEE ADDRESS :" + emp.getEaddr());
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void updateEmployee() {

		try {
			System.out.println("ENTER EMPLOYEE NUMBER :");
			int eno = Integer.parseInt(br.readLine());
			Employee emp = employeeservice.searchEmployee(eno);
			if (emp == null) {
				System.out.println("EMPLOYEE NOT FOUND");
			} else {
				System.out.println("ENTER EMPLOYEE NAME : OLD :" + emp.getEname() + "  NEW :");
				String ename = br.readLine();
				if (ename == null || ename.equals("".trim())) {
					ename = emp.getEname();
				}

				System.out.println("ENTER EMPLOYEE SALARY : OLD :" + emp.getEsal() + " NEW :");
				String salary = br.readLine();
				float esal = 0.0f;
				if (salary == null || salary.equals("".trim())) {
					esal = emp.getEsal();

				} else {
					esal = Float.parseFloat(salary);
				}

				System.out.println("ENTER EMPLOYEE ADDRESS : OLD :" + emp.getEaddr() + " NEW :");
				String eaddr = br.readLine();
				if (eaddr == null || eaddr.equals("".trim())) {
					eaddr = emp.getEaddr();
				}

				Employee employee = new Employee();
				employee.setEno(eno);
				employee.setEname(ename);
				employee.setEsal(esal);
				employee.setEaddr(eaddr);

				String status = employeeservice.updateEmployee(employee);
				if (status.equalsIgnoreCase("success")) {
					System.out.println("EMPLOYEE UPDATED SUCCESSFULLY");
				} else {
					System.out.println("EMPLOYEE UPDATION FAILURE");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteEmployee() {

		try {

			System.out.println("ENTER EMPLOYEE NUMBER :");
			int eno = Integer.parseInt(br.readLine());
			Employee emp = employeeservice.searchEmployee(eno);
			if (emp == null) {
				System.out.println("EMPLOYEE IS NOT FOUND");
			} else {
				String status = employeeservice.deleteEmployee(eno);
				if (status.equalsIgnoreCase("success")) {
					System.out.println("EMPLOYEE DELETED SUCCESSFULLY");
				} else {
					System.out.println("EMPLOYEE DELITION FAILURE");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
