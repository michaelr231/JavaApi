package restapi.demo.message;
import restapi.demo.Model.City;
import java.util.ArrayList;
import java.util.List;



// *** response messages success or faild fetching or posting ***//
public class ResponseMsg {
    private String message;
    private String url;
    private String error = "";
    private List<City> cities = new ArrayList<>();

    public ResponseMsg(String message, String url, List<City> cities) {
        this.message = message;
        this.url = url;
        this.cities = cities;
    }

    public ResponseMsg(String message, String url, String error) {
        this.message = message;
        this.url = url;
        this.error = error;
    }

    public ResponseMsg(String message, String url) {
        this(message, url, List.of());
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setCustomers(List<City> customers) {
        this.cities = cities;
    }

    public List<City> getCustomers() {
        return this.cities;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return this.error;
    }
}