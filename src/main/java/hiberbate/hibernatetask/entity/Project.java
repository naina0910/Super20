package hiberbate.hibernatetask.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String deescription;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeescription() {
		return deescription;
	}
	public void setDeescription(String deescription) {
		this.deescription = deescription;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", deescription=" + deescription + "]";
	}
	
	
	
	
}
