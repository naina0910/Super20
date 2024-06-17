package hibernate.hibernatetask.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hiberbate.hibernatetask.entity.Department;
import hiberbate.hibernatetask.entity.Employee;
import hibernate.hibernatetask.dao.Dao;

public class Service {

	private Dao dao = new Dao();
	
	public String insertDepartment(String name ,String location) {
		if(dao.insertDepartment(name, location)==true) {
			return "Department inserted successfully";
		}
		else {
			return "department not inserted....";
		}
	}
	
	public String insertEmployee(String firstName , String lastName , String email,double salary,Department department){
		if(dao.insertEmployee(firstName, lastName, email, salary, department)  ==true) {
			return "Employee inserted successfully";
		}
		else {
			return "Employee not inserted....";
		}
	}

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return dao.getAllEmployees();
	}
	
	public List<Employee> getEmployeeswithsalarygreaterthan() {
		return dao.getEmployeeswithsalarygreaterthan();
	}
	
	public List<Employee> getEmployeeswithorder() {
		return dao.getEmployeeswithorder();
	}
	
	public List<Department> getDepartmentsWithPagination(int pageNumber, int pageSize) {
		return dao.getDepartmentsWithPagination(pageNumber, pageSize);
	}
	
	public List<Object[]> getEmployeecolumns2() {
		return dao.getEmployeecolumns2();
	}
	
	public Long getEmployeeCount() {
		return dao.getEmployeeCount();
	}
	
	public Double getEmployeeMaxSalary() {
		return dao.getEmployeeMaxSalary();
	}
	
	public Double getSumSalary() {
		return dao.getSumSalary();
	}
	
	public Double getAvgSalary() {
		return dao.getAvgSalary();
	}
	
	public Long getDistinctDepartments() {
		return dao.getDistinctDepartments();
	}
	
	public List<Object[]> getFirstAndLastNames() {
		return dao.getFirstAndLastNames();
	}
	
	public List<Object[]> getEmployeeIdAndNames() {
		return dao.getEmployeeIdAndNames();
	}
	
	public Map<String, Long> getEmployeeCountByDep() {
		return dao.getEmployeeCountByDep();
	}
	
	 public List<Object[]> getEmployeeDepNames() {
		 return dao.getEmployeeDepNames();
	 }
	 
	  public List<Employee> getEmployeeDepNames2() {
		  return dao.getEmployeeDepNames2();
	  }
	  
	  public List<Department> getDep() {
		  return dao.getDep();
	  }
	  
	  public List<Employee> getEmployees() {
		  return dao.getEmployees();
	  }
	  
	  public List<Employee> joinEntities() {
		  return dao.joinEntities();
	  }
	  
	  public List<Employee> employeeWithLocation() {
		  return dao.employeeWithLocation();
	  }
}
