package Business;

import Entities.Car;
import Entities.Person;
import Entities.Reservation;

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
public class DiskFileReservationStore implements IAbstractStore<Reservation>{

    private String location = "/home/patrik/IdeaProjects/WA2-1,2/Reservations";

    @Override
    public void saveNew(Reservation reservation) throws IOException {
        String id = UUID.randomUUID().toString();
        reservation.setId(id);
        serialize(reservation);
    }

    @Override
    public List<Reservation> getAll() throws IOException {

        ArrayList<Reservation> result = new ArrayList<>();

        Files.walk(Paths.get(location)).forEach(
                file-> {
                    if(Files.isRegularFile(file)){
                        Reservation reservation = null;
                        try {
                            //System.out.println(file.getFileName().toString());
                            reservation = deserialize(file.getFileName().toString());
                        } catch (IOException e) {
                            Logger.getLogger(DiskFileReservationStore.class.getName()).log(Level.SEVERE, null, e);
                        } catch (ClassNotFoundException e) {
                            Logger.getLogger(DiskFileReservationStore   .class.getName()).log(Level.SEVERE, null, e);
                        }
                        result.add(reservation);
                    }
                }
        );
        return result;
    }

    @Override
    public Reservation getById(String id) throws IOException, ClassNotFoundException {
        return deserialize(id);
    }

    private void serialize(Reservation reservation) throws IOException {
        String path = Paths.get(location, reservation.getId()).toString();
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(reservation);

        oos.close();
        fos.close();
    }

    private Reservation deserialize(String id) throws IOException, ClassNotFoundException{

        String path = Paths.get(location,id).toString();
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Reservation result = (Reservation) ois.readObject();

        ois.close();
        fis.close();
        return result;
    }

}
