package nl.hu.v1wac.firstapp.webservices;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import domain.Account;
import nl.hu.v1wac.firstapp.model.ServiceProvider;
import nl.hu.v1wac.firstapp.model.WorldService;

@Path("/register")
public class RegistratieResource {
	private WorldService service = ServiceProvider.getWorldService();

	@POST
	@Produces("application/json")
	public Response registerAccount( 
			@FormParam("voorletter") String voorletter,
			@FormParam("tussenvoegsel") String tussenvoegsel, 
			@FormParam("achternaam") String achternaam,
			@FormParam("geboortedatum") String geboortedatum,
			@FormParam("geslacht") String geslacht,
			@FormParam("email") String email,
			@FormParam("telefoonnummer") int telefoonnummer,
			@FormParam("adres") String adres,
			@FormParam("huisnummer") String huisnummer,
			@FormParam("postcode") String postcode,
			@FormParam("plaats") String woonplaats,
			@FormParam("gebruikersnaam") String gebruikersnaam,
			@FormParam("wachtwoord") String wachtwoord) throws SQLException {
		System.out.println("INSIDE IPASSRegResource!");
		
		Account account = service.addCharityAccount(voorletter, tussenvoegsel, achternaam, geboortedatum, geslacht, email,
											telefoonnummer, adres, huisnummer, postcode, woonplaats, gebruikersnaam, wachtwoord);

		if (account == null) {
			Map<String, String> messages = new HashMap<String, String>();
			messages.put("error", "Somthing went wrong, account = null");
			return Response.status(409).entity(messages).build();
		}
		
		
		Map<String, String> messages = new HashMap<String, String>();
		messages.put("VOLTOOID", "ACCOUNT IS ZONDER PROBLEMEN TOEGEVOEGD AAN DATABASE!");
		System.out.println("ACCOUNT IS TOEGEVOEGD AAN DATABASE!");
		return Response.ok().entity(messages).build();
	}

}
