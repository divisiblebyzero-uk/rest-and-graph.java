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
        countryManualRepository.save(new Country("UK", "English"));
        countryManualRepository.save(new Country("France", "French"));
        countryManualRepository.save(new Country("USA", "Not English"));

        cityManualRepository.save(new City("UK", "London", "Huge"));
        cityManualRepository.save(new City("UK", "St Asaph's", "Tiny"));
        cityManualRepository.save(new City("UK", "Canterbury", "Medium"));
        cityManualRepository.save(new City("France", "Paris", "Huge"));
        cityManualRepository.save(new City("USA", "Paris, Tx", "Unknown"));

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
