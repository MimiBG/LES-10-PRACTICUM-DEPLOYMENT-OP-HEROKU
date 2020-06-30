package persistence;

import domain.Address;

public interface AddressDao {
	public Address findById(int addressId);
	public boolean delete(Address address);
}
