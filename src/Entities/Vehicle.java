package Entities;

import java.io.Serializable;

/**
 * Created by patrik on 27.2.16.
 */
public abstract class Vehicle implements Serializable {

    private static final long serialVersionUID = 6578545643567568L;
    private String name;
    private String id;
    protected int numberOfSeats;

    public abstract void makeNoise();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-15s %-15s %-20s", this.getName(),this.numberOfSeats,this.getId()));
        return String.format(sb.toString());
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
