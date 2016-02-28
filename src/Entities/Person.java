package Entities;

import java.io.Serializable;

/**
 * Created by patrik on 27.2.16.
 */
public class Person implements Serializable {

    private static final long serialVersionUID = 6578545643567569L;
    private String forename;
    private String surname;
    private String id;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-15s %-15s %-20s", this.getForename(),this.getSurname(),this.getId()));
        return String.format(sb.toString());
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}

