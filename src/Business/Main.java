package Business;

import Entities.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by patrik on 27.2.16.
 */
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Car car1 = new Car();
        car1.setName("Osobni auto");

        Truck truck1 = new Truck();
        truck1.setName("Nakladni auto");

        ICarStore carStore = new DiskFileCarStore();
        carStore.saveNew(car1);
        carStore.saveNew(truck1);

//        Vehicle car2 = carStore.getById("5f93dbce-902c-48e4-b058-819ab36b90d3");
//        System.out.println("Deserialized");
//        System.out.println(car2);

        List<Vehicle> cars = carStore.getAll();
        System.out.println("-------------Cars---------------");
        System.out.println("--------------------------------");
        System.out.println(String.format("%-15s %-15s %-20s", "Type","Seats","ID"));
        System.out.println("--------------------------------");
        for (Vehicle car : cars) {
            System.out.println(car);
        }

        Person person = new Person();
        person.setForename("Jan");
        person.setSurname("Novak");

        IPersonStore personStore = new DiskFilePersonStore();
        personStore.saveNew(person);

        List<Person> customers = personStore.getAll();
        System.out.println();
        System.out.println("-----------Customers------------");
        System.out.println("--------------------------------");
        System.out.println(String.format("%-15s %-15s %-20s", "Forename","Surname","ID"));
        System.out.println("--------------------------------");
        for (Person per : customers) {
            System.out.println(per);
        }

        Reservation reservation = new Reservation(car1,person,2);
        IReservationStore reservationStore = new DiskFileReservationStore();
        reservationStore.makeReservation(reservation);

        List<Reservation> reservations = reservationStore.getAll();
        System.out.println();
        System.out.println("----------Reservations----------");
        System.out.println("--------------------------------");
        for (Reservation res : reservations) {
            System.out.println(res);
        }
    }
}
