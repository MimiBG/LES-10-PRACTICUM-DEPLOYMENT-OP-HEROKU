package nl.hu.v1wac.firstapp.webservices;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/files")
public class FileResource {

	/* OM DIT WERKEND TE KRIJGEN, MOET JE DE VOLGENDE DEPENDENCY AAN JE POM.XML TOEVOEGEN:
	 * 
	 *  <dependency>
	 *      <groupId>org.glassfish.jersey.media</groupId>
	 *      <artifactId>jersey-media-multipart</artifactId>
	 *      <version>2.27</version>
	 *  </dependency>
	 * 
	 * 
	 * DAARNA MOET JE OOK DE VOLGENDE PARAMETER AAN DE JERSEY-SERVLET TOEVOEGEN IN JE WEB.XML
	 * 
	 *  <init-param>
	 *      <param-name>jersey.config.server.provider.classnames</param-name>
	 *      <param-value>org.glassfish.jersey.media.multipart.MultiPartFeature</param-value>
	 *  </init-param>
	 * 
	 * 
	 * Aanvullende informatie kan gevonden worden op https://jersey.github.io/documentation/latest/media.html#multipart
	 * Zie index.html voor de clientside. Deze code vereist geen verdere aanpassingen aan je project. 
	 * 
	 */
	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public void postForm(	@FormDataParam("username") String username,
							@DefaultValue("true") @FormDataParam("enabled") boolean enabled, 
							@FormDataParam("file") InputStream inputstream,
							@FormDataParam("file") FormDataContentDisposition fileDisposition) {

		System.out.println(username);
		System.out.println(fileDisposition.getFileName());
		System.out.println(fileDisposition.getSize());

		try {
			Files.copy(inputstream, new File("c:\\temp\\" + fileDisposition.getFileName()).toPath());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	@GET
	@Path("{filename}")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response getFile(@PathParam("filename") String filename) {
	    try {
	    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    File file = new File("c:\\temp\\" + filename);
		    Files.copy(file.toPath(), baos);
		    
		    ResponseBuilder response = Response.ok(baos.toByteArray());
//		    response.header("Content-Disposition", "attachment; filename="+filename);
		    return response.build();
		    
	    } catch (IOException ioe) { 
	    	ioe.printStackTrace();
	    }
	    
	    return Response.status(404).build();
	}
}
