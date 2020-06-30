package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import domain.Account;
import nl.hu.v1wac.firstapp.persistence.PostgresBaseDao;

public class UserPostgresDaoImpl extends PostgresBaseDao implements UserDao {

	public String findRoleForUser(String username, String password) throws SQLException {
		System.out.println("Binnen Functie findRoleForUser DaoImpl");
		String rol = null;
		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(
					"SELECT ROLE FROM USERACCOUNT WHERE USERNAME ='" + username + "' AND PASSWORD ='" + password + "'");
			while (dbResultSet.next()) {
				String dbRol = dbResultSet.getString("ROLE");

				rol = dbRol;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(rol);
		return rol;
	}

	public String zoekRolGebruiker(String gebruikersnaam, String wachtwoord) throws SQLException {
		System.out.println("INSIDE FUNC zoekRolGebruiker DaoImpl");
		System.out.println(gebruikersnaam + " " + wachtwoord);
		String rol = null;

		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			String query = "SELECT ROLE FROM USERACCOUNT WHERE USERNAME ='" + gebruikersnaam + "' AND PASSWORD='" + wachtwoord + "'";

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String rol1 = rs.getString("ROLE");
				rol = rol1;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(rol);
		return rol;
	}

}