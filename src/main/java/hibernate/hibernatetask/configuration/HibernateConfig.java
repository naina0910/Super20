package hibernate.hibernatetask.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hiberbate.hibernatetask.entity.Department;
import hiberbate.hibernatetask.entity.Employee;
import hiberbate.hibernatetask.entity.Project;


public class HibernateConfig {
	public static final SessionFactory getSessionFactory() {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);
		cfg.addAnnotatedClass(Department.class);
		cfg.addAnnotatedClass(Project.class);
		cfg.addAnnotatedClass(hiberbate.hibernatetask.entity.EmployeeNameDto.class);
		SessionFactory factory = cfg.buildSessionFactory();

		return factory;
	}
}
