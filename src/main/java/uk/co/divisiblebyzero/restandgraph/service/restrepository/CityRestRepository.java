package uk.co.divisiblebyzero.restandgraph.service.restrepository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uk.co.divisiblebyzero.restandgraph.entities.City;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "cities", path = "cities")
public interface CityRestRepository extends PagingAndSortingRepository<City, Long> {
    List<City> findByName(String name);
    List<City> findByCountry(String country);
}
