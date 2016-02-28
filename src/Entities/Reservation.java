package Entities;

import java.io.Serializable;

/**
 * Created by patrik on 28.2.16.
 */
public class Reservation implements Serializable {

    private static final long serialVersionUID = 6578545643567566L;
    private String id;
    private Car car;
    private Person person;
    private int weeks;

    public Reservation (Car car, Person person, int weeks){
        this.setCar(car);
        this.setPerson(person);
        this.setWeeks(weeks);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reservation : "+"\n");
        sb.append(this.car.toString()+"\n");
        sb.append(this.person.toString()+"\n");
        return String.format(sb.toString());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getWeeks() {
        return weeks;
    }

    public void setWeeks(int weeks) {
        this.weeks = weeks;
    }
}
