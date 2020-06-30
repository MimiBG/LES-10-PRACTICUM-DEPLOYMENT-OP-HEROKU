package nl.hu.v1wac.firstapp.model;

import java.sql.SQLException;
import java.util.List;

import domain.Account;
import nl.hu.v1wac.firstapp.persistence.CountryDao;
import nl.hu.v1wac.firstapp.persistence.CountryPostgresDaoImpl;
import persistence.UserDao;
import persistence.UserPostgresDaoImpl;

public class WorldService {
	
	private CountryDao countryDAO = new CountryPostgresDaoImpl();
	private UserDao userDAO = new UserPostgresDaoImpl();

	
	public List<Country> getAllCountries() {
		return countryDAO.findAll();
	}
	
	public List<Country> get10LargestPopulations() {
		return countryDAO.find10LargestPopulations();
	}
	
	public List<Country> find10LargestSurfaces() {
		return countryDAO.find10LargestSurfaces();
	}

	public Country getCountryByCode(String code) {
		Country result = null;
		
		for (Country c : countryDAO.findAll()) {
			if (c.getCode().equals(code)) {
				result = c;
				break;
			}
		}
		
		return result;
	}
	public Country updateCountry(String code, String name, String capital, String region, double surface, int population) throws SQLException {
		Country c = countryDAO.findByCode(code);
			c.setName(name);
			c.setCapital(capital);
			c.setRegion(region);
			c.setSurface(surface);
			c.setPopulation(population);
			if(countryDAO.update(c)) {
				return countryDAO.findByCode(code);
			}
			
		
		return c;
	}
	
	public Account addAccount(String username, String password, String role) throws SQLException {
		System.out.println("TEST1");
		Account a = new Account(username, password, role);
		a.setUsername(username);
		a.setPassword(password);
		a.setRole(role);
		
		if (userDAO.create(a)) {
			return a;
		}
		
		return a;
	}
	
	public Account addCharityAccount(String voorletter, String tussenvoegsel, String achternaam, String geboortedatum,
									String geslacht, String email, int telefoonnummer, String adres, String huisnummer,
									String postcode, String woonplaats, String gebruikersnaam, String wachtwoord) throws SQLException {
		Account x = new Account(voorletter, tussenvoegsel, achternaam, geboortedatum, geslacht, email, telefoonnummer, adres, huisnummer, postcode, woonplaats, gebruikersnaam, wachtwoord);
		x.setVoorletter(voorletter);
		x.setTussenvoegsel(tussenvoegsel);
		x.setAchternaam(achternaam);
		x.setGeboortedatum(geboortedatum);
		x.setGeslacht(geslacht);
		x.setEmail(email);
		x.setTelefoonnummer(telefoonnummer);
		x.setAdres(adres);
		x.setHuisnummer(huisnummer);
		x.setPostcode(postcode);
		x.setWoonplaats(woonplaats);
		x.setGebruikersnaam(gebruikersnaam);
		x.setWachtwoord(wachtwoord);
		
		if (userDAO.createCharityAccount(x)) {
			return x;
		}
		
		return x;
	}
	
	
	public Account addNewAccount(String username, String password, String role, String email, int telefoonnummer, String adres) throws SQLException {
		System.out.println("TEST1");
		Account a = new Account(username, password, role, email, telefoonnummer, adres);
		a.setUsername(username);
		a.setPassword(password);
		a.setRole(role);
		a.setEmail(email);
		a.setTelefoonnummer(telefoonnummer);
		a.setAdres(adres);
		
		if (userDAO.createP5(a)) {
			return a;
		}
		
		return a;
	}
	
	public Country addCountry(String code, String iso3, String name, String continent, String region, 
			double surface, int indepyear, int population, int lifeexpectancy, 
			int gnp, int gnpoid, String localname, String governmentform,
			String headofstate, double latitude, double longitude, String capital) throws SQLException {
		Country c = new Country(code, iso3, name, continent, region, surface, indepyear, population, 
								lifeexpectancy, gnp, gnpoid, localname, governmentform, 
								headofstate, latitude, longitude, capital);
		c.setCode(code);
		c.setIso3(iso3);
		c.setName(name);
		c.setContinent(continent);
		c.setRegion(region);
		c.setSurface(surface);
		c.setIndepyear(indepyear);
		c.setPopulation(population);
		c.setLifeexpectancy(lifeexpectancy);
		c.setGnp(gnpoid);
		c.setGnpoid(gnpoid);
		c.setLocalname(localname);
		c.setGovernment(governmentform);
		c.setHeadofstate(headofstate);
		c.setLatitude(latitude);
		c.setLongitude(longitude);
		c.setCapital(capital);
		
		if(countryDAO.create(c)) {
			return c;
		}
		return c;
	}
	
	
//	public boolean deleteCountry(String code) {
//		for (int i = 0; i < countryDAO.findAll().size(); i++) {
//			if (countryDAO.findAll().get(i).getCode() == code) {
//				countryDAO.findAll().remove(i);
//				return true;
//			}
//		}
//		return false;
//	}
	
	public boolean deleteCountry(String code) {
		boolean resultaat = false;
		Country c = countryDAO.findByCode(code);
		if (c != null) {
			resultaat = countryDAO.delete(c);
		} else {
			throw new IllegalArgumentException("Code bestaat niet!");
		}
		return resultaat;
	}
	
//	public void updateCountry(String code) {
//		System.out.println("I'm inside WorldService updateCountry functie!");
//		Country c = countryDAO.findByCode(code);
//		System.out.println("I'm inside WS 2");
//		if (c != null) {
//			countryDAO.update(c);
//			
//		} else throw new IllegalArgumentException("Code does not exicst!");
//	}
//	
//	public void deleteCountry(String code) {
//		System.out.println("WorldService Functie gestart!");
//		Country c = countryDAO.findByCode(code);
//		
//		if (c != null) {
//			countryDAO.delete(c);
//		} else throw new IllegalArgumentException("Code does not exist!");
//	}

	public Country createCountry(String nm, String em) {
		// TODO Auto-generated method stub
		return null;
	}
}
