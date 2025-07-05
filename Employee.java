package elevatelab_intern;

public class Employee {
	private int id;
	private String name ;
	private String department;
	private double salary;
	
	
	public Employee(String name , String department , double salary) {
		this.name = name ;
		this.department = department;
		this.salary =salary;
		
	}
	
	public Employee(int id , String name , String department, double salary) {
		this(name,department, salary);
		this.id = id;
		
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public String getDepartment() {
		return department;
	}
	public double getSalary() {
		return salary;
	}
	public void setId(int id) {
		this.id = id;}
	}


