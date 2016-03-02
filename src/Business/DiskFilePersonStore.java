package Business;

import Entities.Person;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by patrik on 28.2.16.
 */
public class DiskFilePersonStore implements IAbstractStore<Person> {

    private String location = "/home/patrik/IdeaProjects/WA2-1,2/Persons";

    @Override
    public void saveNew(Person person) throws IOException {
        String id = UUID.randomUUID().toString();

        person.setId(id);
        serialize(person);
    }

    @Override
    public Person getById(String id) throws IOException, ClassNotFoundException {
        return deserialize(id);
    }

    @Override
    public List<Person> getAll() throws IOException {

        ArrayList<Person> result = new ArrayList<>();

        Files.walk(Paths.get(location)).forEach(
                file-> {
                    if(Files.isRegularFile(file)){
                        Person person = null;
                        try {
                            //System.out.println(file.getFileName().toString());
                            person = deserialize(file.getFileName().toString());
                        } catch (IOException e) {
                            Logger.getLogger(DiskFilePersonStore.class.getName()).log(Level.SEVERE, null, e);
                        } catch (ClassNotFoundException e) {
                            Logger.getLogger(DiskFilePersonStore.class.getName()).log(Level.SEVERE, null, e);
                        }
                        result.add(person);
                    }
                }
        );
        return result;
    }

    private void serialize(Person person) throws IOException {

        String path = Paths.get(location, person.getId()).toString();
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(person);

        oos.close();
        fos.close();
    }

    private Person deserialize(String id) throws IOException, ClassNotFoundException {

        String path = Paths.get(location,id).toString();
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Person result = (Person) ois.readObject();

        ois.close();
        fis.close();
        return result;
    }
}
