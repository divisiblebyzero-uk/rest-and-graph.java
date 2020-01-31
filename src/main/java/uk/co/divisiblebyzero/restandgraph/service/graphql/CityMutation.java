package uk.co.divisiblebyzero.restandgraph.service.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import uk.co.divisiblebyzero.restandgraph.entities.City;
import uk.co.divisiblebyzero.restandgraph.entities.Country;
import uk.co.divisiblebyzero.restandgraph.service.manualrepository.CityManualRepository;
import uk.co.divisiblebyzero.restandgraph.service.manualrepository.CountryManualRepository;

import javax.annotation.Resource;
import java.util.List;

@Component
public class CityMutation implements GraphQLMutationResolver {
    @Resource
    protected CityManualRepository cityManualRepository;
    @Resource
    protected CountryManualRepository countryManualRepository;

    public City createCity(final String name, final String countryName, final String size) {
        List<Country> countries  = countryManualRepository.findByName(countryName);
        if (countries.isEmpty()) {
            throw new RuntimeException("Country not found");
        } else if (countries.size() > 1) {
            throw new RuntimeException("Multiple / duplicate countries found");
        }
        return cityManualRepository.save(new City(countries.get(0), name, size));
    }
}
