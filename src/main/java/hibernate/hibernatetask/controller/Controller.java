package hibernate.hibernatetask.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hiberbate.hibernatetask.entity.Department;
import hiberbate.hibernatetask.entity.Employee;
import hibernate.hibernatetask.service.Service;

public class Controller {
	
  private Service service = new Service();
	
  public String insertDepartment(String name ,String location) {
	  return service.insertDepartment(name, location);
  }
  
  public String insertEmployee(String firstName , String lastName , String email,double salary,Department department){
	  return service.insertEmployee(firstName, lastName, email, salary, department);
  }

public List<Employee> getAllEmployees() {
	return service.getAllEmployees();
	
}

public List<Employee> getEmployeeswithsalarygreaterthan() {
	return service.getEmployeeswithsalarygreaterthan();
}

public List<Employee> getEmployeeswithorder() {
	return service.getEmployeeswithorder();
}

public List<Department> getDepartmentsWithPagination(int pageNumber, int pageSize) {
	return service.getDepartmentsWithPagination(pageNumber, pageSize);
}

public List<Object[]> getEmployeecolumns2() {
	return service.getEmployeecolumns2();
}

public Long getEmployeeCount() {
	return service.getEmployeeCount();
}

public Double getEmployeeMaxSalary() {
	return service.getEmployeeMaxSalary();
}

public Double getSumSalary() {
	return service.getSumSalary();
}

public Double getAvgSalary() {
	return service.getAvgSalary();
}

public Long getDistinctDepartments() {
	return service.getDistinctDepartments();
}

public List<Object[]> getFirstAndLastNames() {
	return service.getFirstAndLastNames();
}

public List<Object[]> getEmployeeIdAndNames() {
	return service.getEmployeeIdAndNames();
}

public Map<String, Long> getEmployeeCountByDep() {
	return service.getEmployeeCountByDep();
}

public List<Object[]> getEmployeeDepNames() {
	 return service.getEmployeeDepNames();
}

public List<Employee> getEmployeeDepNames2() {
	  return service.getEmployeeDepNames2();
}

public List<Department> getDep() {
	  return service.getDep();
}

public List<Employee> getEmployees() {
	  return service.getEmployees();
}

public List<Employee> joinEntities() {
	  return service.joinEntities();
}

public List<Employee> employeeWithLocation() {
	  return service.employeeWithLocation();
}
}