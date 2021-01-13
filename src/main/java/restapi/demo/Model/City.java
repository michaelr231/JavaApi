package restapi.demo.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "new_table")
public class City {

    @Id
    @Column(name = "id", unique = true)
    private long id;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "street")
    private String search;

    public long getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }


    public void setId(int id) {
        this.id = id;
    }
}