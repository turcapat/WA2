package Business;

import Entities.Car;
import Entities.Person;
import Entities.Reservation;

import java.io.IOException;
import java.util.List;

/**
 * Created by patrik on 28.2.16.
 */
public interface IReservationStore {

    void makeReservation(Reservation reservation) throws IOException;
    List<Reservation> getAll() throws IOException;
    Reservation getById(String id) throws IOException, ClassNotFoundException;
}
