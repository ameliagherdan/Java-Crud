import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CarsDao implements Serializable {

    public static List<Cars> carsTableList = new ArrayList<>();


    public void add(Cars car){
        carsTableList.add(car);
    }


    public boolean update(Cars car){
        return carsTableList.stream().map(storedCar ->
                car.getId() == storedCar.getId() ?  car : storedCar)
                .findAny().isPresent();
    }

    public List<Cars> getCarsTableList() {
        return carsTableList;
    }

    public Cars getById(int id){
        return carsTableList.stream().filter(car -> car.getId() == id).findFirst().orElse(null);
    }



    public static void filter(String value) {

        List<Cars> result2 = CarsDao.carsTableList.stream()
                .filter(c -> c.getFuelType().matches(value))
                .collect(Collectors.toList());
        result2.forEach(p -> System.out.println
                ("Cars{" +
                        "id=" + p.getId() +
                        ", modelCar='" + p.getModelCar() + '\'' +
                        ", fuelType='" + p.getFuelType() + '\'' +
                        ", manModel='" + p.getManModel() + '\'' +
                        ", electricEngine='" + p.getElectricEngine()+ '\''+
                        ", year='" + p.getYear() + '\'' +
                        ", noise='" +p.getNoise() + '\'' +
                        ", pollutionTax='" + p.getPollutionTax() + '\'' +
                        ", price='" + p.getPrice() + '\''+
                        "'}'"));
    }
    public static void export(String value) {
        List<Cars> result3 = CarsDao.carsTableList.stream()
                .filter(c -> c.getFuelType().matches(value))
                .collect(Collectors.toList());
        String textName = ("exportEngines"+value+".txt");

        File f = new File(textName);
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(result3);
            oos.close();
            System.out.println("Data written");
        } catch(FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            //ois.readObject();
            //ois.close();

            ArrayList<Cars> deserializeCar = (ArrayList<Cars>)ois.readObject();

            ois.close();
            PrintStream stream = new PrintStream(f);

            System.setOut(stream);

            Iterator<Cars> iter = deserializeCar.iterator();
            while(iter.hasNext()) {
                Cars c = iter.next();
                System.out.println(
                        "Cars{" +
                                "id=" + c.id +
                                ", modelCar='" + c.modelCar + '\'' +
                                ", fuelType='" + c.fuelType + '\'' +
                                ", manModel='" + c.manModel + '\'' +
                                ", electricEngine='" + c.electricEngine + '\''+
                                ", year='" + c.year + '\'' +
                                ", noise='" + c.noise + '\'' +
                                ", pollutionTax='" + c.pollutionTax + '\'' +
                                ", price='" + c.price + '\''+
                                '}');
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch(IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

