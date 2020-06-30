package nl.hu.v1wac.firstapp.model;

public class Customer {
	private static int nextId = 1;
	
	private int id;
	private String name;
	private String email;
	
	public Customer() {}
	
	public Customer(String nm, String em) {
		id = nextId++;
		name = nm;
		email = em;
	}
	
	public String getEmail() {
		return email;
	}
	
	public int getId() {
		return id;
	}
	
	public void setEmail(String em) {
		email = em;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String nm) {
		name = nm;
	}
}
