package nl.hu.v1wac.firstapp.webservices;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import domain.Account;
import nl.hu.v1wac.firstapp.model.ServiceProvider;
import nl.hu.v1wac.firstapp.model.WorldService;

@Path("/accounts")
public class UserResource {
	private WorldService service = ServiceProvider.getWorldService();
	
	@POST
	@RolesAllowed("user")
	@Produces("application/json")
	public Response addAccount( @Context SecurityContext sc,
								@FormParam("username") String username,
								@FormParam("password") String password,
								@FormParam("role") String rol) throws SQLException {
		boolean role = sc.isUserInRole("user");
		System.out.println("HEEFT ROL USER: " + role + " (in UserResource @POST)");
		if (role) {
			Account account = service.addAccount(username, password, rol);
			
			if (account == null) {
				Map<String, String> messages = new HashMap<String, String>();
				messages.put("error", "Account does not exist!");
				return Response.status(409).entity(messages).build();
			}
			return Response.ok().build();
		}
		Map<String, String> messages = new HashMap<String, String>();
		messages.put("error", "ACCOUNT IS NIET GEMACHTIGD TAAK UIT TE VOEREN!");
		System.out.println("ACCOUNT IS NIET GEMACHTIGD TAAK UIT TE VOEREN!");
		return Response.status(409).entity(messages).build();
	}
}
