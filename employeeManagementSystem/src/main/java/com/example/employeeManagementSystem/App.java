package com.example.employeeManagementSystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.employeeManagementSystem.Controller.EmployeeController;
import org.springframework.context.ApplicationContext;


public class App {

	public static void main(String[] args) {

		System.out.println("EMPLOYEE MANAGEMENT SYSTEM ");
		System.out.println("==============================");

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {

			ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
			EmployeeController employeecontroller=(EmployeeController) context.getBean("employeeControler");
			while (true) {
				System.out.println();
				//System.out.println();
				System.out.println("1. ADD EMPLOYEE DETAILS ");
				System.out.println("2. SEARCH EMPLOYEE DETAILS");
				System.out.println("3. UPDATE EMPLOYEE DETAILS");
				System.out.println("4. DELETE EMPLOYEE DETAILS");
				System.out.println("5. EXIT");
				
				System.out.println();

				System.out.println("ENTER YOUR OPTION :");
				int option = Integer.parseInt(br.readLine());
				switch (option) {

				case 1:
					System.out.println("ADD EMPLOYEE DETAILS");
					System.out.println("-----------------------");
					employeecontroller.addEmployee();
					break;

				case 2:
					System.out.println("SEARCH EMPLOYEE DETAILS");
					System.out.println("--------------------------");
					employeecontroller.searchEmployee();
					break;

				case 3:
					System.out.println("UPDATE EMPLOYEE DETAILS");
					System.out.println("--------------------------");
					employeecontroller.updateEmployee();
					break;
				case 4:
					System.out.println("DELETE EMPLOYEE DETAILS");
					System.out.println("--------------------------");
					employeecontroller.deleteEmployee();
					break;
				case 5:
					System.out.println("THANKS FOR USING EMPLOYEE SERVICES...");
					System.exit(0);
					break;
				default:
					System.out.println("INVALID OPTION ,PLEASE SELECT VALID OPTION FROM 1 TO 5 ONLY");
					break;

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
