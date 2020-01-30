package uk.co.divisiblebyzero.restandgraph.service.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import uk.co.divisiblebyzero.restandgraph.entities.Country;
import uk.co.divisiblebyzero.restandgraph.service.manualrepository.CountryManualRepository;

import javax.annotation.Resource;

@Component
public class CountryMutation implements GraphQLMutationResolver {
    @Resource
    protected CountryManualRepository countryManualRepository;

    public Country createCountry(final String name, final String language) {
        return countryManualRepository.save(new Country(name, language));
    }
}
