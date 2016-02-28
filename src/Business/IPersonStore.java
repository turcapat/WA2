package Business;

import Entities.Person;

import java.io.IOException;
import java.util.List;

/**
 * Created by patrik on 27.2.16.
 */
public interface IPersonStore {

    void saveNew(Person person) throws IOException;
    Person getById(String id) throws IOException, ClassNotFoundException;
    List<Person> getAll() throws IOException;
}
