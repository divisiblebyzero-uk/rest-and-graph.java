package uk.co.divisiblebyzero.restandgraph.service.restrepository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uk.co.divisiblebyzero.restandgraph.entities.Country;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "countries", path = "countries")
public interface CountryRestRepository extends PagingAndSortingRepository<Country, Long> {
    List<Country> findByName(String name);
    List<Country> findByLanguage(String language);
}
