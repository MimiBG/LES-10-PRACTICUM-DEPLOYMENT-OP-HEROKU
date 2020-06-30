package nl.hu.v1wac.firstapp.webservices;

import java.util.AbstractMap.SimpleEntry;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/calculator")
public class CalculatorResource {
	
	@POST
	@Path("/telop")
	@Produces("Application/json")
	public Response getCalculationInfo(@FormParam("getal1") int getal1,
									@FormParam("getal2") int getal2) {
		
		System.out.println(getal1 + " " + getal2);
		int resultaat = getal1 + getal2;
		
		String result = Integer.toString(resultaat);
		
		
		SimpleEntry<String, String> JSON = new SimpleEntry<String, String>("Resultaat", result);
		System.out.println(JSON);
		return Response.ok(JSON).build();
	}
}
