package persistence;

import java.util.List;

import domain.Customer;

public interface CustomerDao {
	public List<Customer> findAll();
	public Customer findById(int customerId);
	public boolean delete(Customer customer);
}
