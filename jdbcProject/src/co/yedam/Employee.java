package co.yedam;

import java.util.*;

public class Employee {
	private String empName;
	private String phone;
	private String email;
	private int salary;
	private String hiredate;
	private int empno;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	@Override
	public String toString() {
		return String.format("%4d %8s %-12s %5d ",empno,empName,email,salary);
	}
	public String showInfo() {
		return String.format("%4d %8s %-12s %5d ",empno,empName,phone,salary);
	}

}
