package restapi.demo.Controller;
import restapi.demo.Model.City;
import restapi.demo.message.ResponseMsg;
import restapi.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CityController {
    @Autowired
    private CityService cityService;

    //*** localhost:9191/api/getallcities -> to recive all cities list ***//
    @GetMapping("/getallcities")
    public ResponseEntity<ResponseMsg> list(HttpServletRequest request) {
        try {
            // get all documents from mySQL database
            List<City> cities = cityService.getAllCities();

            String message = "Retrieve all cities successfully!";
            return new ResponseEntity<>(new ResponseMsg(message,
                    request.getRequestURI(), cities), HttpStatus.OK);
            //error message
        }catch(Exception e) {
            String message = "Can NOT retrieve all data from mySQL database";
            return new ResponseEntity<>(new ResponseMsg(message, request.getRequestURI(),
                    e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //*** to get street by cityId and street autoComplete
    // localhost:9191/api/(id number)/(start of the street name)
    //***
    @GetMapping("{id}/{query}")
    public ResponseEntity<ResponseMsg> get(@PathVariable("id") Long id, HttpServletRequest request,
                                           @PathVariable("query") String query) {
        try {
           Optional<City> streets = cityService.findAllByIdAndSearchContaining(id, query);
            if(streets.isPresent()) {
                String message = "Successfully get a all streets in the city by city id= " + id  + "and street name" + query;
                return new ResponseEntity<>(new ResponseMsg(message, request.getRequestURI(),
                        List.of(streets.get())), HttpStatus.OK);
            } else {
                // error handling
                String message = "Fail! Not FOUND a City by id from MySQL db with id = " + id;
                return new ResponseEntity<>(new ResponseMsg(message, request.getRequestURI(),
                        "NOT FOUND"), HttpStatus.NOT_FOUND);
            }
            // error handling
        }catch(Exception e) {
            String message = "Can NOT get a city by id from MySQL with id = " + id;
            return new ResponseEntity<>(new ResponseMsg(message, request.getRequestURI(),
                    e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    //*** to add city to database use -> localhost:9191/api/add ***//
    @PostMapping("/add")
    public ResponseEntity<ResponseMsg> add(@RequestBody City city, HttpServletRequest request) {
        try {
            // save to mysqldb
            City _city = cityService.addCity(city);
            String message = "Upload Successfully a City to mysql with id = " + _city.getId();
            return new ResponseEntity<>(new ResponseMsg(message, request.getRequestURI(),
                    List.of(city)), HttpStatus.OK);
            // error handling
        }catch(Exception e) {
            String message = "Can NOT upload  a cityname to database";
            return new ResponseEntity<>(new ResponseMsg(message, request.getRequestURI(),
                    e.getMessage()), HttpStatus.OK);
        }
    }

}