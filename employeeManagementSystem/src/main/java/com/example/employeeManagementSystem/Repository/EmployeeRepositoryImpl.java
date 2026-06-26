package com.example.employeeManagementSystem.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.example.employeeManagementSystem.Beans.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	DriverManagerDataSource datasource;

	public void setDatasource(DriverManagerDataSource datasource) {
		this.datasource = datasource;
	}

	@Override
	public String add(Employee employee) {
		String status = "";
		try {
			Connection con = datasource.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?,?)");
			ps.setInt(1, employee.getEno());
			ps.setString(2, employee.getEname());
			ps.setFloat(3, employee.getEsal());
			ps.setString(4, employee.getEaddr());

			int rowcount = ps.executeUpdate();
			if (rowcount == 1) {
				status = "success";
			} else {
				status = "failure";
			}
			return status;

		} catch (Exception e) {

		}

		return null;
	}

	@Override
	public Employee search(int eno) {

		Employee employee = null;
		try {
			Connection con = datasource.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from employee where eno=?");
			ps.setInt(1, eno);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				employee = new Employee();
				employee.setEno(rs.getInt("eno"));
				employee.setEname(rs.getString("ename"));
				employee.setEsal(rs.getFloat("esal"));
				employee.setEaddr(rs.getString("eaddr"));

			}

		} catch (Exception e) {

		}

		return employee;
	}

	@Override
	public String update(Employee employee) {
		String status = "";
		try {

			Connection con = datasource.getConnection();
			PreparedStatement ps = con.prepareStatement("update employee set ename=?,esal=?,eaddr=? where eno=?");
			ps.setString(1, employee.getEname());
			ps.setFloat(2, employee.getEsal());
			ps.setString(3, employee.getEaddr());
			ps.setInt(4, employee.getEno());

			int rowcount = ps.executeUpdate();
			if (rowcount == 1) {
				status = "success";
			} else {
				status = "failure";
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return status;
	}

	@Override
	public String delete(int eno) {
		String status = "";
		try {
			Connection con = datasource.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from employee where eno=?");
			ps.setInt(1, eno);
			int rowcount = ps.executeUpdate();
			if (rowcount == 1) {
				status = "success";
			} else {
				status = "failure";
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return status;
	}

}
