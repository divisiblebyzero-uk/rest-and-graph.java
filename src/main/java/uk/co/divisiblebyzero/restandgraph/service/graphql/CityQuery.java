package uk.co.divisiblebyzero.restandgraph.service.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import uk.co.divisiblebyzero.restandgraph.entities.City;
import uk.co.divisiblebyzero.restandgraph.service.manualrepository.CityManualRepository;

import javax.annotation.Resource;
import java.util.Optional;

@Component
public class CityQuery implements GraphQLQueryResolver {
    @Resource
    protected CityManualRepository cityManualRepository;

    public Iterable<City> getCities() {
        return cityManualRepository.findAll();
    }

    public Optional<City> getCity(final Long id) {
        return cityManualRepository.findById(id);
    }
}
