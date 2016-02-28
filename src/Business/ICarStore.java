package Business;

import Entities.Vehicle;

import java.io.IOException;
import java.util.List;

/**
 * Created by patrik on 27.2.16.
 */
public interface ICarStore {

    void saveNew(Vehicle vehicle) throws IOException;
    Vehicle getById(String id) throws IOException, ClassNotFoundException;
    List<Vehicle> getAll() throws IOException;
}
