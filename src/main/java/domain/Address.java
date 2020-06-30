package domain;

public class Address {
	private int addressId;
	private String street;
	
	public Address(int addressId, String street) {
		this.addressId = addressId;
		this.street = street;
	}
	
	public int getAddressId() {
		return addressId;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
}
