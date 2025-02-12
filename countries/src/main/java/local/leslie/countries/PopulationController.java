package local.leslie.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class PopulationController
{
	//	/population/size/{people}
	//	return the countries that have a population equal to or greater than the given population
	@GetMapping(value = "/size/{people}",
				produces = {"application/json"})
	public ResponseEntity<?> getByPopulation(@PathVariable long people)
	{
		ArrayList<Country> rtnCountries = CountriesApplication.ourCountryList.getCountryList(c -> c.getPopulation() >= people);
		return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
	}

	// population/min
	@GetMapping(value = "/min",
				produces = {"application/json"})
	public ResponseEntity<?> getMinPop()
	{
		CountriesApplication.ourCountryList.countryList.sort((c1, c2) -> (int)(c1.getPopulation() - c2.getPopulation()));
		Country rtnCountry = CountriesApplication.ourCountryList.countryList.get(0);
		return new ResponseEntity<>(rtnCountry, HttpStatus.OK);

	}

	// population/max
	@GetMapping(value = "/max",
			produces = {"application/json"})
	public ResponseEntity<?> getMaxPop()
	{
		CountriesApplication.ourCountryList.countryList.sort((c1, c2) -> (int)(c2.getPopulation() - c1.getPopulation()));
		Country rtnCountry = CountriesApplication.ourCountryList.countryList.get(0);
		return new ResponseEntity<>(rtnCountry, HttpStatus.OK);

	}




}
