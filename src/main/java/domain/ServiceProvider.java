package domain;

public class ServiceProvider {
	private static CompanyService companyService = new CompanyService();
	
	public static CompanyService getCompanyService() {
		return companyService;
	}
}
