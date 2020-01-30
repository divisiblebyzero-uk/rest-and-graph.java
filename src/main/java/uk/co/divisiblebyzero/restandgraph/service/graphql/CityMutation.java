package uk.co.divisiblebyzero.restandgraph.service.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import uk.co.divisiblebyzero.restandgraph.entities.City;
import uk.co.divisiblebyzero.restandgraph.service.manualrepository.CityManualRepository;

import javax.annotation.Resource;

@Component
public class CityMutation implements GraphQLMutationResolver {
    @Resource
    protected CityManualRepository cityManualRepository;

    public City createCity(final String name, final String country, final String size) {
        return cityManualRepository.save(new City(name, country, size));
    }
}
