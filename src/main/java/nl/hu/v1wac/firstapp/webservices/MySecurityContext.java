package nl.hu.v1wac.firstapp.webservices;

import java.security.Principal;
import javax.ws.rs.core.SecurityContext;

public class MySecurityContext implements SecurityContext {
	private String name;
	private String role;
	private boolean isSecure;
	private String email;

	public MySecurityContext(String name, String role, boolean isSecure) {
		this.name = name;
		this.role = role;
	}
	
	public MySecurityContext(String name, String role, boolean isSecure, String email) {
		this.name = name;
		this.role = role;
		this.email = email;
	}

	public Principal getUserPrincipal() {
		return new Principal() {
			public String getName() {
				return name;
			}
		};
	}
	

	public String getEmail() {
		return email;
	}
	
	public String getRole() {
		return role;
	}
	
	public boolean isUserInRole(String role) {
		return role.equals(this.role);
	}

	public boolean isSecure() {
		return isSecure;
	}

	public String getAuthenticationScheme() {
		return "Bearer";
	}
}