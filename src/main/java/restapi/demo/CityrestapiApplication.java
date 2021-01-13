package restapi.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import restapi.demo.Model.City;
import restapi.demo.repository.cityRepository;

//********** Michael Riversky task for WebTech Innovation
// the routes are: localhost:9191/api/getallcities - to get all cities
// the routes are: localhost:9191/api/id/street - to return all cities with autocomplete street name by cityId
// the routes are: localhost:9191/api/add -  to add city to mysql
// 1. get all cities : done
// 2. get by city Id and substring of street name the cities: done
// 3. add city to database: done
//***********


@SpringBootApplication
public class CityrestapiApplication implements CommandLineRunner {
	@Autowired
	private cityRepository cityRepository;

	public static void main(String[] args) {
		SpringApplication.run(CityrestapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		cityRepository.save(new City('0' ,"Tel-aviv","Herzel"));
		cityRepository.save(new City('1', "Yehud","BenGurion"));
		cityRepository.save(new City('2',"Rishon-Lezion", "LeviAshkol"));
	}

}
