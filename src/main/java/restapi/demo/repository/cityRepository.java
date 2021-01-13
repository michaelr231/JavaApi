package restapi.demo.repository;

import org.springframework.stereotype.Repository;
import restapi.demo.Model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

@Repository
public interface cityRepository extends JpaRepository<City, Long> {
  //*** find allstreets by cityId and city start name for example :
  // if you write localhost:9191/api/1/Ben
  // it will fetching CityId = 1 and Full BenGurion street, otherwise error ***//
  Optional<City> findAllByIdAndSearchContaining(Long id, String street);

}
