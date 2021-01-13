package restapi.demo.service;
import restapi.demo.repository.cityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restapi.demo.Model.City;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public  class CityService {
    @Autowired
    private cityRepository cityRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City addCity(City city) {
        cityRepository.save(city);
        return city;
    }

    public Optional<City> findAllByIdAndSearchContaining(Long id, String search) {
         return cityRepository.findAllByIdAndSearchContaining(id, search);

    }


}