package domain;

public class Employee extends Person {
	private int employeeId;
	private double salary;
	
	public Employee(String name, int employeeId, double salary) {
		super(name);
		
		this.employeeId = employeeId;
		this.salary = salary;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
