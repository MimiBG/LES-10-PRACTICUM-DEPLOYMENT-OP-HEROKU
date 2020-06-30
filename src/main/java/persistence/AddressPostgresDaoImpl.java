package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Address;
import nl.hu.v1wac.firstapp.persistence.PostgresBaseDao;

public class AddressPostgresDaoImpl extends PostgresBaseDao implements AddressDao {
	private List<Address> selectAddresses(String query) {
		List<Address> results = new ArrayList<Address>();
		
		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
			
			while (dbResultSet.next()) {
				int addressId = dbResultSet.getInt("addressId");
				String street = dbResultSet.getString("street");
				
				results.add(new Address(addressId, street));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return results;
	}
	
	public Address findById(int addressId) {
		return selectAddresses("SELECT addressId, street FROM address WHERE addressid = " +addressId).get(0);
	}
	
	public boolean delete(Address address) {
		boolean result = false;
		boolean addressExists = findById(address.getAddressId()) != null;
		
		if (addressExists) {
			String query = "DELETE FROM address WHERE addressid = " +address.getAddressId(); 
					
			try (Connection con = super.getConnection()) {
				
				Statement stmt = con.createStatement();
				if (stmt.executeUpdate(query) == 1) { // 1 row updated!
					result = true;
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		
		return result;
	}
}
