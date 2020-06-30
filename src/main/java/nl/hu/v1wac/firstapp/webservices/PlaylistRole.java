package nl.hu.v1wac.firstapp.webservices;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

@Path("/test")
public class PlaylistRole {

	@GET
	@Path("{listname}")
	@RolesAllowed("user")
	@Produces("application/json")
	public String getMyPlaylist(@Context SecurityContext sc, 
								@PathParam("listname") String playlistName) {
		String name = sc.getUserPrincipal().getName();
		System.out.println(name);
		System.out.println(playlistName);
		/* Implementation to get playlist with specified name for the user */
		return name;
	}

}
