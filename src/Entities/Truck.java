package Entities;

import java.io.Serializable;

/**
 * Created by patrik on 27.2.16.
 */
public class Truck extends Vehicle implements Serializable {

     public Truck (){
         this.numberOfSeats = 2;
    }

    @Override
    public void makeNoise() {
        System.out.println("Vrrm");
    }

}
