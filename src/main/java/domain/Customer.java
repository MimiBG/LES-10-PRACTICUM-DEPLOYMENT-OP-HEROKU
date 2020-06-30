package domain;

public class Customer extends Person {
	private int customerId;
	private String account;
	
	public Customer(String name) {
		super(name);
	}
	
	public Customer(String name, int customerId, String account) {
		super(name);
		
		this.customerId = customerId;
		this.account = account;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public String getAccount() {
		return account;
	}
	
	public void setAddress(String addr) {}
	public void setAccount(int acc) {}
	
	public void setAccount(String account) {
		this.account = account;
	}
}
