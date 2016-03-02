package Business;

import Entities.Person;

import java.io.IOException;
import java.util.List;

/**
 * Created by patrik on 2.3.16.
 */
public interface IAbstractStore<T> {

        void saveNew(T object) throws IOException;
        T getById(String id) throws IOException, ClassNotFoundException;
        List<T> getAll() throws IOException;

}
