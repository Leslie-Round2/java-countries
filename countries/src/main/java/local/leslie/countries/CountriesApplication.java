package local.leslie.countries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountriesApplication
{

	//static field of countrylist to be able to access the countries in our controller
	static CountryList ourCountryList;

	public static void main(String[] args)
	{
		//instantiate the field
		ourCountryList = new CountryList();
		SpringApplication.run(CountriesApplication.class, args);
	}

}
