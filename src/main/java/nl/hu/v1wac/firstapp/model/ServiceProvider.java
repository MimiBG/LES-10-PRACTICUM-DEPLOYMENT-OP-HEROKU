package nl.hu.v1wac.firstapp.model;

public class ServiceProvider {
	private static WorldService worldService = new WorldService();
	private static CustomerService customerService = new CustomerService();

	public static WorldService getWorldService() {
		return worldService;
	}
	
	public static CustomerService getCustomerService() {
		return customerService;
	}
}