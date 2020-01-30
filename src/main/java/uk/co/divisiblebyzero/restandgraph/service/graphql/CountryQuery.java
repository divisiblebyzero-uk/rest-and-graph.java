package uk.co.divisiblebyzero.restandgraph.service.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import uk.co.divisiblebyzero.restandgraph.entities.Country;
import uk.co.divisiblebyzero.restandgraph.service.manualrepository.CountryManualRepository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Component
public class CountryQuery implements GraphQLQueryResolver {
    @Resource
    protected CountryManualRepository countryManualRepository;

    public Iterable<Country> getCountries() {
        return countryManualRepository.findAll();
    }

    public Optional<Country> getCountry(final Long id) {
        return countryManualRepository.findById(id);
    }
}
