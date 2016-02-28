package Business;

import Entities.Vehicle;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by patrik on 27.2.16.
 */
public class DiskFileCarStore implements ICarStore {

    private String location = "/home/patrik/IdeaProjects/WA2-1,2/Cars";

    @Override
    public void saveNew(Vehicle car) throws IOException {
        String id = UUID.randomUUID().toString();
        car.setId(id);
        serialize(car);
    }

    @Override
    public Vehicle getById(String id) throws IOException, ClassNotFoundException {
        return deserialize(id);
    }

    @Override
    public List<Vehicle> getAll() throws IOException {

        ArrayList<Vehicle> result = new ArrayList<>();

        Files.walk(Paths.get(location)).forEach(
                file-> {
                    if(Files.isRegularFile(file)){
                        Vehicle car = null;
                        try {
                            //System.out.println(file.getFileName().toString());
                            car = deserialize(file.getFileName().toString());
                        } catch (IOException e) {
                            Logger.getLogger(DiskFileCarStore.class.getName()).log(Level.SEVERE, null, e);
                        } catch (ClassNotFoundException e) {
                            Logger.getLogger(DiskFileCarStore.class.getName()).log(Level.SEVERE, null, e);
                        }
                        result.add(car);
                    }
                }
        );
        return result;
    }
    private void serialize(Vehicle car) throws IOException {

        String path = Paths.get(location,car.getId()).toString();
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(car);

        oos.close();
        fos.close();
    }

    private Vehicle deserialize(String id) throws IOException, ClassNotFoundException {

        String path = Paths.get(location,id).toString();
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);

        Vehicle result = (Vehicle) ois.readObject();

        ois.close();
        fis.close();

        return result;
    }
}
