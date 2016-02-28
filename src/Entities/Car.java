package Entities;

import java.io.Serializable;

/**
 * Created by patrik on 27.2.16.
 */
public class Car extends Vehicle implements Serializable  {

    public Car(){
        this.numberOfSeats = 5;
    }

    @Override
    public void makeNoise() {
        System.out.println("Brrm");
    }

}
