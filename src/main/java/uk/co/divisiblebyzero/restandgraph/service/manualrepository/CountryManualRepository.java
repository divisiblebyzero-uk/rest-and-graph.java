package uk.co.divisiblebyzero.restandgraph.service.manualrepository;

import org.springframework.data.repository.CrudRepository;
import uk.co.divisiblebyzero.restandgraph.entities.Country;

import java.util.List;

public interface CountryManualRepository extends CrudRepository<Country, Long> {

    List<Country> findByName(String name);
    List<Country> findByLanguage(String language);

}
