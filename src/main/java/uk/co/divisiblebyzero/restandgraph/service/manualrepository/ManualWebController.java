package uk.co.divisiblebyzero.restandgraph.service.manualrepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.divisiblebyzero.restandgraph.entities.City;
import uk.co.divisiblebyzero.restandgraph.entities.Country;

import javax.annotation.Resource;

@RestController
public class ManualWebController {

    @Resource
    protected CountryManualRepository countryManualRepository;

    @Resource
    protected CityManualRepository cityManualRepository;

    @RequestMapping("/manual/")
    public String helloWorld() {
        return "Hello, World!";
    }

    /**
     * Creates some test data
     * @return
     */
    @RequestMapping("/manual/insertData")
    public String insertData() {
        Country uk = countryManualRepository.save(new Country("UK", "English"));
        Country france = countryManualRepository.save(new Country("France", "French"));
        Country usa = countryManualRepository.save(new Country("USA", "Not English"));

        cityManualRepository.save(new City(uk, "London", "Huge"));
        cityManualRepository.save(new City(uk, "St Asaph's", "Tiny"));
        cityManualRepository.save(new City(uk, "Canterbury", "Medium"));
        cityManualRepository.save(new City(france, "Paris", "Huge"));
        cityManualRepository.save(new City(usa, "Paris, Tx", "Unknown"));

        return "done";
    }

    @RequestMapping("/manual/listAllCountries")
    public Iterable<Country> listAllCountries() {
        return countryManualRepository.findAll();
    }

    @RequestMapping("/manual/listAllCities")
    public Iterable<City> listAllCities() {
        return cityManualRepository.findAll();
    }
}
