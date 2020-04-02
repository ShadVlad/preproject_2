package hiber.model;

import javax.persistence.*;

@Entity(name = "car")
@Table(name = "car")
public class Car {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "series")
    private String series;
//
//    @OneToOne(mappedBy = "car")
//    private User user;

    public Car() {}

    public Car(String name, String series) {
        this.name = name;
        this.series = series;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "name = " + name + ", series = " + series;
    }

}
