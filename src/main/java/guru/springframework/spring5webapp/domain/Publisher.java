package guru.springframework.spring5webapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Publisher {

    private String name;
    private String addr;
    private String city;
    private String region;
    private String zip;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Publisher(String name, String addr, String city, String region, String zip) {
        this.name = name;
        this.addr = addr;
        this.city = city;
        this.region = region;
        this.zip = zip;
    }

    public Publisher() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(name, publisher.name) && Objects.equals(addr, publisher.addr) && Objects.equals(city, publisher.city) && Objects.equals(region, publisher.region) && Objects.equals(zip, publisher.zip) && Objects.equals(id, publisher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, addr, city, region, zip, id);
    }
}
