package services;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import domain.CompanyService;
import domain.Customer;
import domain.ServiceProvider;

@Path("/customers")
public class CustomerResource {
	
	@GET
	@Produces("application/json")
	public String getCustomers() {
		CompanyService service = ServiceProvider.getCompanyService();
		JsonArray customerArray = buildJsonCountryArray(service.getAllCustomers());
		
		return customerArray.toString();
	}
	
	@GET
	@Produces("text/html")
	@Path("delete/{id}")
	public String deleteCustomer(@PathParam("id") int id) {
		CompanyService service = ServiceProvider.getCompanyService();
		service.deleteCustomer(id);
		return "customer with id " +id+ "deleted!";
	}

	private JsonArray buildJsonCountryArray(List<Customer> customers) {
		JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
		
		for (Customer c : customers) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			
			job.add("id", c.getCustomerId());
			job.add("name", c.getName());
			job.add("account", c.getAccount());
			job.add("street", c.getAddress().getStreet());
			
			jsonArrayBuilder.add(job);
		}
		
		return jsonArrayBuilder.build();
	}
}
