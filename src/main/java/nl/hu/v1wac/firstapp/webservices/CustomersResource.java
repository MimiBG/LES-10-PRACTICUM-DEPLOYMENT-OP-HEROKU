package nl.hu.v1wac.firstapp.webservices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import nl.hu.v1wac.firstapp.model.Customer;
import nl.hu.v1wac.firstapp.model.CustomerService;
import nl.hu.v1wac.firstapp.model.ServiceProvider;

@Path("/customers")
public class CustomersResource {
	private CustomerService service = ServiceProvider.getCustomerService();

	@GET
	@Produces("application/json")
	public Response getCustomers() {
		List<Customer> customers = service.getAllCustomers();
		
		if (customers.isEmpty()) {
			Map<String, String> messages = new HashMap<String, String>();
			messages.put("error", "No customers found!");
			return Response.status(404).entity(messages).build();
		}
		
		return Response.ok(customers).build();
	}

	@POST
	@Produces("application/json")
	public Response createCustomer(@FormParam("name") String nm, @FormParam("email") String em) {

		Customer newCustomer = service.createCustomer(nm, em);
		return Response.ok(newCustomer).build();
	}

}
