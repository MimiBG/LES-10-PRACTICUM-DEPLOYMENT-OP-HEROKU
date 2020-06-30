package nl.hu.v1wac.firstapp.webservices;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import nl.hu.v1wac.firstapp.model.Customer;
import nl.hu.v1wac.firstapp.model.CustomerService;
import nl.hu.v1wac.firstapp.model.ServiceProvider;


@Path("/customers/{customerid}")
public class CustomerResource {
	private CustomerService service = ServiceProvider.getCustomerService();
	
	@GET
	@Produces("application/json")
	public Response getCustomer(@PathParam("customerid") int id) {
		Customer customer = service.getCustomer(id);
		
		if (customer == null) {
			Map<String, String> messages = new HashMap<String, String>();
			messages.put("error", "Customer does not exist!");
			return Response.status(409).entity(messages).build();
		}
		
		return Response.ok(customer).build();
	}

	@PUT
	@Produces("application/json")
	public Response updateCustomer(	@PathParam("customerid") int id, 
									@FormParam("name") String nm,
									@FormParam("email") String em) {

		Customer customer = service.updateCustomer(id, nm, em);

		if (customer == null) {
			Map<String, String> messages = new HashMap<String, String>();
			messages.put("error", "Customer does not exist!");
			return Response.status(409).entity(messages).build();
		}

		return Response.ok(customer).build();
	}
	
	@DELETE
	@Produces("application/json")
	public Response deleteCustomer(@PathParam("customerid") int id) {

		if (!service.deleteCustomer(id)) {
			return Response.status(404).build();
		}

		return Response.ok().build();
	}

}
