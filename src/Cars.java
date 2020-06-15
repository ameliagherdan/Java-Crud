import java.io.Serializable;

public class Cars implements Serializable{

    public int id;
    public String modelCar;
    public String fuelType;
    public String manModel;
    public String electricEngine;
    public int year;
    public int noise;
    public int pollutionTax;
    public int price;


    public Cars(int id, String modelCar, String fuelType, String manModel, String electricEngine, int year, int noise, int pollutionTax, int price)
    {
        this.id = id;
        this.modelCar = modelCar;
        this.fuelType = fuelType;
        this.manModel = manModel;
        this.electricEngine = electricEngine;
        this.year = year;
        this.noise = noise;
        this.pollutionTax = pollutionTax;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setmodelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getManModel() {
        return manModel;
    }

    public void setManModel(String manModel) {
        this.manModel = manModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNoise() {
        return noise;
    }

    public void setNoise(int noise) {
        this.noise = noise;
    }

    public int getPollutionTax() {
        return pollutionTax;
    }

    public void setPollutiontax(int pollutionTax) {
        this.pollutionTax = pollutionTax;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getElectricEngine() {
        return electricEngine;
    }

    public void setElectricEngine(String electricEngine) {
        this.electricEngine = electricEngine;
    }


    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", modelCar='" + modelCar + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", manModel='" + manModel + '\'' +
                ", electricEngine='" + electricEngine + '\''+
                ", year='" + year + '\'' +
                ", noise='" + noise + '\'' +
                ", pollutionTax='" + pollutionTax + '\'' +
                ", price='" + price + '\''+
                '}';
    }




}
