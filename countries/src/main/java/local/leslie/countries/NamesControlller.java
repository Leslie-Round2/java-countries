package local.leslie.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class NamesControlller
{
	//localhost:8080/names/all
	@GetMapping(value = "/all",
				produces = {"application/json"})
	public ResponseEntity<?> getAllCountries()
	{
		//return what needs to be returned and also a response
		CountriesApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
		return new ResponseEntity<>(CountriesApplication.ourCountryList.countryList, HttpStatus.OK);
	}

	//	localhost:8080/names/start/{letter}
	//	return the countries alphabetically that begin with the given letter
	@GetMapping(value = "/start/{letter}",
				produces = {"application/json"})
	public ResponseEntity<?> getCountryByFirstLetter(@PathVariable char letter)
	{
		//make a temp array
		ArrayList<Country> rtnCountries = CountriesApplication.ourCountryList.getCountryList(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
		rtnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
		return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
	}

	//	/names/size/{number}
	//	return the countries alphabetically that have a name equal to or longer than the given length
	@GetMapping(value = "/size/{number}",
				produces = {"application/json"})
	public ResponseEntity<?> getByNameSize(@PathVariable int number)
	{
		ArrayList<Country> rtnCountries = CountriesApplication.ourCountryList.getCountryList(c -> c.getName().length() >= number);
		rtnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
		return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
	}


}
