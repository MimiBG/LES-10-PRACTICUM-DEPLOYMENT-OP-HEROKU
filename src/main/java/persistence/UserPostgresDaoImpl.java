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
			ResultSet rs = stmt.executeQuery("SELECT ROL FROM KLANT WHERE GEBRUIKERSNAAM ='" + gebruikersnaam
					+ "' AND WACHTWOORD='" + wachtwoord + "'");
			while (rs.next()) {
				String rol1 = rs.getString("ROL");
				rol = rol1;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(rol);
		return rol;
	}

	@Override
	public boolean create(Account account) throws SQLException {
		System.out.println("Binnen de functie createAccount");
		boolean resultaat = false;

		String query = "INSERT INTO USERACCOUNT VALUES (?, ?, ?)";
		try (Connection con = super.getConnection()) {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, account.getUsername());
			pstmt.setString(2, account.getPassword());
			pstmt.setString(3, account.getRole());
			int result = pstmt.executeUpdate();
			pstmt.close();

			if (result == 0)
				return false;
			else
				resultaat = true;
		}

		return resultaat;
	}

	@Override
	public boolean createCharityAccount(Account account) throws SQLException {
		System.out.println("ENTERED createCharAcc DaoImpl");
		boolean resultaat = false;
		String query = "INSERT INTO KLANT (voorletter, tussenvoegsel, achternaam, geboortedatum, geslacht, adres, huisnummer, postcode, woonplaats, email, telefoonnummer, "
				+ "gebruikersnaam, wachtwoord) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection con = super.getConnection()) {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, account.getVoorletter());
			pstmt.setString(2, account.getTussenvoegsel());
			pstmt.setString(3, account.getAchternaam());
			pstmt.setString(4, account.getGeboortedatum());
			pstmt.setString(5, account.getGeslacht());
			pstmt.setString(6, account.getAdres());
			pstmt.setString(7, account.getHuisnummer());
			pstmt.setString(8, account.getPostcode());
			pstmt.setString(9, account.getWoonplaats());
			pstmt.setString(10, account.getEmail());
			pstmt.setInt(11, account.getTelefoonnummer());
			pstmt.setString(12, account.getGebruikersnaam());
			pstmt.setString(13, account.getWachtwoord());
			int result = pstmt.executeUpdate();
			pstmt.close();

			if (result == 0)
				return false;
			else
				resultaat = true;
		}
		return resultaat;
	}

	@Override
	public boolean createP5(Account account) throws SQLException {
		System.out.println("Binnen de functie createAccount");
		boolean resultaat = false;

		String query = "INSERT INTO USERACCOUNT VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection con = super.getConnection()) {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, account.getUsername());
			pstmt.setString(2, account.getPassword());
			pstmt.setString(3, account.getRole());
			pstmt.setString(4, account.getEmail());
			pstmt.setInt(5, account.getTelefoonnummer());
			pstmt.setString(6, account.getAdres());
			int result = pstmt.executeUpdate();
			pstmt.close();

			if (result == 0)
				return false;
			else
				resultaat = true;
		}

		return resultaat;
	}

}
