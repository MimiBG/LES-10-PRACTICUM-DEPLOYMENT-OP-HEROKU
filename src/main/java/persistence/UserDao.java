package persistence;

import java.sql.SQLException;

import domain.Account;


public interface UserDao {
	public String findRoleForUser(String username, String password) throws SQLException;
	public String zoekRolGebruiker(String gebruikersnaam, String wachtwoord) throws SQLException;
	
}
