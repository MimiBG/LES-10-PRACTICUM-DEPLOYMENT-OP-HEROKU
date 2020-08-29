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
		
		for (Country country : countryDAO.findAll()) {
			if (country.getCode().equals(code)) {
				result = country;
				break;
			}
		}
		
		return result;
	}
	public Country updateCountry(String code, String name, String capital, String region, double surface, int population) throws SQLException {
		Country country = countryDAO.findByCode(code);
			country.setName(name);
			country.setCapital(capital);
			country.setRegion(region);
			country.setSurface(surface);
			country.setPopulation(population);
			if(countryDAO.update(country)) {
				return countryDAO.findByCode(code);
			}
			
		
		return country;
	}
	

	public Country addCountry(String code, String iso3, String name, String continent, String region,
			double surface, int indepyear, int population, int lifeexpectancy,
			int gnp, int gnpoid, String localname, String governmentform,
			String headofstate, double latitude, double longitude, String capital) throws SQLException {
		Country country = new Country(code, iso3, name, continent, region, surface, indepyear, population, 
								lifeexpectancy, gnp, gnpoid, localname, governmentform, 
								headofstate, latitude, longitude, capital);
		country.setCode(code);
		country.setIso3(iso3);
		country.setName(name);
		country.setContinent(continent);
		country.setRegion(region);
		country.setSurface(surface);
		country.setIndepyear(indepyear);
		country.setPopulation(population);
		country.setLifeexpectancy(lifeexpectancy);
		country.setGnp(gnpoid);
		country.setGnpoid(gnpoid);
		country.setLocalname(localname);
		country.setGovernment(governmentform);
		country.setHeadofstate(headofstate);
		country.setLatitude(latitude);
		country.setLongitude(longitude);
		country.setCapital(capital);
		
		if(countryDAO.create(country)) {
			return country;
		}
		return country;
	}
	

	
	public boolean deleteCountry(String code) {
		boolean resultaat = false;
		Country c = countryDAO.findByCode(code);
		if (country != null) {
			resultaat = countryDAO.delete(country);
		} else {
			throw new IllegalArgumentException("Deze code bestaat niet!");
		}
		return resultaat;
	}


	public Country createCountry(String nm, String em) {
		// TODO Auto-generated method stub
		return null;
	}
}
