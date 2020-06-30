package domain;

public class Account {
	private String Username;
	private String Password;
	private String role;
	private String email;
	private int telefoonnummer;
	private String adres;
	
	private String voorletter;
	private String tussenvoegsel;
	private String achternaam;
	private String geboortedatum;
	private String geslacht;
	
	private String huisnummer;
	private String postcode;
	private String woonplaats;
	private String gebruikersnaam;
	private String wachtwoord;
	
	public String getVoorletter() {
		return voorletter;
	}

	public void setVoorletter(String voorletter) {
		this.voorletter = voorletter;
	}

	public String getTussenvoegsel() {
		return tussenvoegsel;
	}

	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public String getGeboortedatum() {
		return geboortedatum;
	}

	public void setGeboortedatum(String geboortedatum) {
		this.geboortedatum = geboortedatum;
	}

	public String getGeslacht() {
		return geslacht;
	}

	public void setGeslacht(String geslacht) {
		this.geslacht = geslacht;
	}

	public String getHuisnummer() {
		return huisnummer;
	}

	public void setHuisnummer(String huisnummer) {
		this.huisnummer = huisnummer;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getWoonplaats() {
		return woonplaats;
	}

	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}

	public String getGebruikersnaam() {
		return gebruikersnaam;
	}

	public void setGebruikersnaam(String gebruikersnaam) {
		this.gebruikersnaam = gebruikersnaam;
	}

	public String getWachtwoord() {
		return wachtwoord;
	}

	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}

	public Account() {};
	
	
	public Account(String voorletter, String tussenvoegsel, String achternaam, String geboortedatum, String geslacht,
					String email, int telefoonnummer, String adres, String huisnummer, String postcode, String woonplaats,
					String gebruikersnaam, String wachtwoord) {
		this.voorletter = voorletter;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.geboortedatum = geboortedatum;
		this.geslacht = geslacht;
		this.email = email;
		this.telefoonnummer = telefoonnummer;
		this.adres = adres;
		this.huisnummer = huisnummer;
		this.postcode = postcode;
		this.woonplaats = woonplaats;
		this.gebruikersnaam = gebruikersnaam;
		this.wachtwoord = wachtwoord;
	}
	
	public Account(String Username, String Password, String role) {
		this.Username = Username;
		this.Password = Password;
		this.role = role;
	}
	
	public Account(String Username, String Password, String role, String email, int telefoonnummer, String adres) {
		this.Username = Username;
		this.Password = Password;
		this.role = role;
		this.email = email;
		this.telefoonnummer = telefoonnummer;
		this.adres = adres;
	}

	public String getUsername() {
		return Username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefoonnummer() {
		return telefoonnummer;
	}

	public void setTelefoonnummer(int telefoonnummer) {
		this.telefoonnummer = telefoonnummer;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

}
