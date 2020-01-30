package uk.co.divisiblebyzero.restandgraph.service.manualrepository;

import org.springframework.data.repository.CrudRepository;
import uk.co.divisiblebyzero.restandgraph.entities.City;
import uk.co.divisiblebyzero.restandgraph.entities.Country;

import java.util.List;

public interface CityManualRepository extends CrudRepository<City, Long> {

    List<City> findByName(String name);
    List<City> findByCountry(String country);

}
