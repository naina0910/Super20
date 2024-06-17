package hibernate.hibernatetask.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.sql.JoinType;

import hiberbate.hibernatetask.entity.Department;
import hiberbate.hibernatetask.entity.Employee;
import hibernate.hibernatetask.configuration.HibernateConfig;


public class Dao {

	private static SessionFactory factory = HibernateConfig.getSessionFactory();
	
	public boolean insertDepartment(String name ,String location) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
        
		Department department = new Department();
		department.setName(name);
		department.setLocation(location);
		session.save(department);
		transaction.commit();

		session.close();
		return true;
	}
	
	public boolean insertEmployee(String firstName , String lastName , String email,double salary,Department department) {
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
        
		Employee employee = new Employee();
		
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setEmail(email);
		employee.setSalary(salary);
		employee.setDepartment(department);
		session.save(employee);
		transaction.commit();

		session.close();
		return true;
		
		
	}

	public List<Employee> getAllEmployees() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee.class);

		List<Employee> list = criteria.list();


		transaction.commit();
		session.close();
		return list;
	}
	
	public List<Employee> getEmployeeswithsalarygreaterthan() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.gt("salary", 50000.0));
		List<Employee> list = criteria.list();


		transaction.commit();
		session.close();
		return list;
	}
	
	public List<Employee> getEmployeeswithorder() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.addOrder(Order.asc("lastName"));
		List<Employee> list = criteria.list();


		transaction.commit();
		session.close();
		return list;
	}
	
	public List<Department> getDepartmentsWithPagination(int pageNumber, int pageSize) {
        Session session = factory.openSession();
        try {
            // Create Criteria Query
            Query<Department> query = session.createQuery("FROM Department", Department.class);

            // Calculate starting index for pagination
            int firstResult = (pageNumber - 1) * pageSize;

            // Apply pagination
            query.setFirstResult(firstResult);
            query.setMaxResults(pageSize);

            // Execute query and return results
            return query.getResultList();
        } finally {
            session.close();
        }
    }
	
	public List<Department> getEmployeeColumns(int pageNumber, int pageSize) {
        Session session = factory.openSession();
        try {
            // Create Criteria Query
            Query<Department> query = session.createQuery("FROM Department", Department.class);

            // Calculate starting index for pagination
            int firstResult = (pageNumber - 1) * pageSize;

            // Apply pagination
            query.setFirstResult(firstResult);
            query.setMaxResults(pageSize);

            // Execute query and return results
            return query.getResultList();
        } finally {
            session.close();
        }
    }
	
	public List<Object[]> getEmployeecolumns2() {
        Session session = factory.openSession();
 
        Query<Object[]> criteriaQuery =session.createQuery("select firstName,lastName from Employee",Object[].class);
        return criteriaQuery.list();
    }
	
	public Long getEmployeeCount() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.setProjection(Projections.count("id"));
		List<Long> countlist = criteria.list();

		session.close();

		for (Long count : countlist) {

			return count;
		}

		return (long) 0;

	}
	
	
	public Double getEmployeeMaxSalary() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.setProjection(Projections.max("salary"));
		List<Double> maxlist = criteria.list();

		session.close();

		for (Double max : maxlist) {
			 return max;
		}
	

		return null;
	}
	
	public Double getSumSalary() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.setProjection(Projections.sum("salary"));
		List<Double> sumlist = criteria.list();

		session.close();

		for (Double sum : sumlist) {
			 return sum;
		}
	

		return null;
	}
	
	public Double getAvgSalary() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.setProjection(Projections.avg("salary"));
		List<Double> avglist = criteria.list();

		session.close();

		for (Double avg : avglist) {
			 return avg;
		}
	

		return null;
	}
	
	public Long getDistinctDepartments() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Department.class);
		criteria.setProjection(Projections.countDistinct("name"));
		Long count = (Long) criteria.uniqueResult();
		
		transaction.commit();
      session.close();
      
      return count;
      
	}
	
	public List<Object[]> getFirstAndLastNames() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.setProjection(Projections.projectionList().add(Projections.property("firstName")).add(Projections.property("lastName")));
		List<Object[]> list=criteria.list();
		
		transaction.commit();
      session.close();
      
      return list;
	}
	
	public List<Object[]> getEmployeeIdAndNames() {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Employee.class);
		criteria.setProjection(Projections.projectionList().add(Projections.property("id")).add(Projections.property("firstName")));
		List<Object[]> list=criteria.list();
        

        session.close();
        return list;
    }
	
	
	public Map<String, Long> getEmployeeCountByDep() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "SELECT e.department.name, COUNT(e.id) FROM Employee e GROUP BY e.department.name";
        Query<Object[]> query = session.createQuery(hql, Object[].class);

        List<Object[]> results = query.getResultList();
        Map<String, Long> employeeCountMap = new HashMap<>();

        for (Object[] objects : results) {
            String departmentName = (String) objects[0];
            Long count = (Long) objects[1];
            employeeCountMap.put(departmentName, count);
        }
	
		return  employeeCountMap;
	}  
	
	
        public List<Object[]> getEmployeeDepNames() {
        	 Session session = factory.openSession();
             Criteria criteria = session.createCriteria(Employee.class);
             criteria.createAlias("department", "dept");
     		criteria.setProjection(Projections.projectionList().add(Projections.property("firstName")).add(Projections.property("lastName")).add(Projections.property("dept.name")));
     		List<Object[]> list=criteria.list();
             

             session.close();
             return list;
        }
        
        
        public List<Employee> getEmployeeDepNames2() {
        	 Session session = factory.openSession();
             Criteria criteria = session.createCriteria(Employee.class);
             criteria.setFetchMode("department", FetchMode.JOIN);
             List<Employee> list = criteria.list();
             session.close();
             return list;
        }
        
        public List<Department> getDep() {
        	Session session = factory.openSession();
            Criteria criteria = session.createCriteria(Department.class);
            criteria.createAlias("employees", "employees", JoinType.LEFT_OUTER_JOIN);
            List<Department> list = criteria.list();
            session.close();
            return list;
        }
        
        public List<Employee> getEmployees() {
        	 Session session = factory.openSession();
             Criteria criteria = session.createCriteria(Employee.class);
             criteria.setFetchMode("department", FetchMode.JOIN);
             List<Employee> list = criteria.list();
             session.close();
             return list;
        }
        
        public List<Employee> joinEntities() {
        	Session session = factory.openSession();
            Criteria criteria = session.createCriteria(Employee.class);
            criteria.createAlias("department", "dept");
            List<Employee> list = criteria.list();
            session.close();
            return list;
        }
        
        public List<Employee> employeeWithLocation() {
        	Session session = factory.openSession();
            Criteria criteria = session.createCriteria(Employee.class);
            criteria.createAlias("department", "dept");
            criteria.add(Restrictions.eq("dept.location","New York"));
            List<Employee> list = criteria.list();
            session.close();
            return list;
        }
       
	
	
}
