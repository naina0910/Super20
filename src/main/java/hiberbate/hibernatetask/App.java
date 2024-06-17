package hiberbate.hibernatetask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hiberbate.hibernatetask.entity.Department;
import hiberbate.hibernatetask.entity.Employee;
import hibernate.hibernatetask.controller.Controller;

/**
 * Hello world!
 *
 */

public class App 
{
	
	
    public static void main( String[] args )
    {
//    	 Department department = new Department();
//         department.setId(5);
//         
//        Controller controller = new Controller();
//        controller.insertEmployee("Shubham", "Khatte", "KhatteS@gmail.com", 25000.0, department);
    	
//    	Controller controller = new Controller();
//    	List<Employee> list =controller.getEmployeeswithorder();
//    	System.out.println(list);
    	
    	
    	
//        // Fetch departments with pagination
//        int pageNumber = 1; // Example: page 1
//        int pageSize = 4; // Example: 10 departments per page
//        List<Department> departments = controller.getDepartmentsWithPagination(pageNumber, pageSize);
//
//        // Print the paginated list of departments
//        System.out.println("Departments (Page " + pageNumber + ", Page Size " + pageSize + "):");
//        for (Department department : departments) {
//            System.out.println(department.getName());
//        }
    	
    	
    	
//    	List<Object[]> list =controller.getEmployeecolumns2();
//    	for (Object[] row : list) {
//            String firstName = (String) row[0];
//            String lastName = (String) row[1];
//            System.out.println("First Name: " + firstName + ", Last Name: " + lastName);
//        }/
    	
    	
//    	long results =controller.getEmployeeCount();
//    	
//    	System.out.println(results);
    	
    	Controller controller = new Controller();
//    	Double results = controller.getEmployeeMaxSalary();
//    	System.out.println(results);
    	
//    	double results = controller.getSumSalary();
//    	System.out.println(results);
    	
//    	double results = controller.getAvgSalary();
//    	System.out.println(results);
//    	Long  results =controller.getDistinctDepartments();
//    	System.out.println(results);
    	
    	//List<Object[]> d = controller.getFirstAndLastNames();
    	
//    	 for (Object[] name : d) {
//             String firstName = (String) name[0];
//             String lastName = (String) name[1];
//             System.out.println("First Name: " + firstName + ", Last Name: " + lastName);
//         }
    	
//    	List<Object[]> d=controller.getEmployeeIdAndNames();
//    	
//    	for (Object[] objects : d) {
//			long id = (long) objects[0];
//			String firstName = (String) objects[1];
//			
//			System.out.println("id: " + id + ", first Name: " + firstName);
//		}
////    	
//    	Map<String, Long> result=controller.getEmployeeCountByDep();
//    	System.out.println(result);
    	
//    	List<Object[]> list =controller.getEmployeeDepNames();
//    	for (Object[] objects : list) {
//    		String firstName = (String) objects[0];
//    		String lastName = (String) objects[1];
//    		String name = (String)objects[2];
//    		System.out.println("First Name: " + firstName + ", Last Name: " + lastName+",department name:"+name);
//		}
    	
//    	List<Employee> list = controller.getEmployeeDepNames2();
//    	System.out.println(list);
    	
//    	List<Department> list = controller.getDep();
//    	System.out.println(list);
//    	
//    	List<Employee> list = controller.getEmployees();
//           System.out.println(list);
//           
//           List<Employee> list = controller.joinEntities();
//           System.out.println(list);
    	
    	List<Employee> list = controller.employeeWithLocation();
           System.out.println(list);
    }
    
}
