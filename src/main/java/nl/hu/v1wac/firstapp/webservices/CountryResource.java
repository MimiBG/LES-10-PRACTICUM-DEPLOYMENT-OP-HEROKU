package nl.hu.v1wac.firstapp.webservices;

import java.security.Principal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import nl.hu.v1wac.firstapp.model.Country;
import nl.hu.v1wac.firstapp.model.ServiceProvider;
import nl.hu.v1wac.firstapp.model.WorldService;

@Path("/countries/{countrycode}")
public class CountryResource {
	private WorldService service = ServiceProvider.getWorldService();

	@GET
	@Produces("application/json")
	public Response getCountry(@PathParam("countrycode") String code) {
		Country country = service.getCountryByCode(code);

		if (country == null) {
			Map<String, String> messages = new HashMap<String, String>();
			messages.put("error", "Country bestaat niet!");
			return Response.status(409).entity(messages).build();
		}

		return Response.ok(country).build();
	}

	@PUT
	@RolesAllowed("user")
	@Produces("application/json")
	public Response updateCountry(@Context SecurityContext sc, 
			@PathParam("countrycode") String code, 
			@FormParam("name") String name,
			@FormParam("capital") String capital, 
			@FormParam("region") String region,
			@FormParam("surface") double surface, 
			@FormParam("population") int population) throws SQLException {
		boolean role = sc.isUserInRole("user");
		String naam = sc.getUserPrincipal().getName();
		System.out.println(naam);
		System.out.println("HEEFT ROL USER: " + role + " (in countryresource @put)");
		if (role) {
			Country country = service.updateCountry(code, name, capital, region, surface, population);
		
			if (country == null) {
				Map<String, String> messages = new HashMap<String, String>();
				messages.put("error", "Country bestaat niet!");
				return Response.status(409).entity(messages).build();
			}
			return Response.ok().build();
		}
		Map<String, String> messages = new HashMap<String, String>();
		messages.put("error", "ACCOUNT IS NIET GEMACHTIGD TAAK UIT TE VOEREN!");
		System.out.println("ACCOUNT IS NIET GEMACHTIGD TAAK UIT TE VOEREN!");
		return Response.status(409).entity(messages).build();
	}

	@DELETE
	@RolesAllowed("user")
	@Produces("application/json")
	public Response deleteCountry(@Context SecurityContext sc, @PathParam("countrycode") String code) {
		boolean role = sc.isUserInRole("user");
		System.out.println("HEEFT ROL USER: " + role + " (in countryresource @delete)");
		if (role) {
			if (service.deleteCountry(code)) {
				Map<String, String> bericht = new HashMap<String, String>();
				bericht.put("resultaat", "Country succesvol verwijdert!");
				return Response.status(200).entity(bericht).build();
			} 
		} 
		Map<String, String> messages = new HashMap<String, String>();
		messages.put("error", "ACCOUNT IS NIET GEMACHTIGD TAAK UIT TE VOEREN!");
		return Response.status(403).entity(messages).build();
	}

}

