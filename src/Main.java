import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public void display_menu() {
        System.out.println("----------Car-Shop----------");
        System.out.println("1) List of all cars\n2) Add a new car\n3) Update a car\n4) Remove a car\n5) Export Cars \n6) Price of all engines \n7) Filter Cars by fuelType\n8) Import cars from text file \n9) Export cars by fuelType\n10) Quit");
        System.out.println("-------iRems Crud App-------");
        System.out.print("Selection: ");
    }

    CarsDao carDao = new CarsDao();


    public Main() throws IOException {
        carDao.add(new Cars(1, "Passat", "Diesel", "VW", "No", 2003, 150, 150, 550));
        carDao.add(new Cars(2, "Phaeton", "Diesel", "VW", "No", 2005, 200, 300, 700));
        carDao.add(new Cars(3, "Bora", "Gas", "VW", "Yes", 2002, 100, 0, 500));
        carDao.add(new Cars(4, "Passat", "Gas", "VW", "No", 2001, 100, 0, 350));
        Scanner in = new Scanner(System.in);

        display_menu();
        boolean quit = false;

        int menuItem;

        do {
            menuItem = in.nextInt();
            switch (menuItem) {

                case 1:
                    System.out.println("List of Cars: ");
                    carDao.getCarsTableList().forEach(System.out::println);
                    display_menu();
                    break;
                case 2:
                    System.out.println("Enter id of car: ");
                    int input2 = in.nextInt();
                    System.out.println("Enter the modelCar: ");
                    String input3 = in.next();
                    System.out.println("Enter the fuelType: (Diesel/Gas) ");
                    String input4 = in.next();
                    String input5 = "Yes";
                    String input6 = "No";
                    int inputforprice;
                    int pollutiontax = 0;
                    if (input4.equals("Gas")) {
                        inputforprice = 350;
                        System.out.println("Do you want electric engine for extra 150$?: (Yes/No)");
                        input6 = in.next();
                        if (input6.equals("Yes")) {
                            inputforprice = +150;
                            String input10 = "Yes";
                        }
                    } else {
                        inputforprice = 400;
                        System.out.println("Please enter value for Pollution Tax:");
                        pollutiontax = +in.nextInt();
                        inputforprice = +pollutiontax;
                    }

                    System.out.println("Enter the manModel: ");
                    String input7 = in.next();

                    System.out.println("Enter the year of the car: ");
                    int input9 = in.nextInt();

                    System.out.println("Enter the noise level of the car: ");
                    int input10 = in.nextInt();

                    carDao.add(new Cars(input2, input3, input4, input7, input6, input9, input10, pollutiontax, inputforprice));
                    carDao.getCarsTableList().forEach(System.out::println);
                    System.out.println("Car added!");
                    carDao.getCarsTableList().forEach(System.out::println);
                    System.out.println("Return to menu? Press any key");
                    String next2 = in.next();
                    display_menu();
                    break;


                case 3:
                    carDao.getCarsTableList().forEach(System.out::println);
                    System.out.println("Enter the ID to update Car: ");
                    int input1 = in.nextInt();
                    Cars car = carDao.getById(input1);
                    System.out.println("Enter the new Model Car: ");

                    String model = in.next();
                    car.setmodelCar(model);


                    System.out.println("Enter the new fuelType: ");
                    String fuelType = in.next();
                    car.setFuelType(fuelType);


                    System.out.println("Enter the new Manufacter Model: ");
                    String manModel = in.next();
                    car.setManModel(manModel);

                    System.out.println("Additional Electric Engine ? ( Yes/No ): ");
                    String electricEngine = in.next();
                    car.setElectricEngine(electricEngine);

                    System.out.println("Enter the new prod year of car: ");
                    int year = in.nextInt();
                    car.setYear(year);

                    System.out.println("Enter the new noise level: ");
                    int noise = in.nextInt();
                    car.setNoise(noise);

                    System.out.println("Enter the new taxPollution: ");
                    int taxPollution = in.nextInt();
                    car.setPollutiontax(taxPollution);

                    System.out.println("Enter the new price: ");
                    int price = in.nextInt();
                    car.setPrice(price);

                    carDao.update(car);
                    System.out.println("Car updated successfully");
                    System.out.println("List of cars after Update: ");
                    carDao.getCarsTableList().forEach(System.out::println);
                    System.out.println("Return to menu? Press any key");
                    String next5 = in.next();
                    display_menu();

                    break;

                case 4:
                    carDao.getCarsTableList().forEach(System.out::println);
                    System.out.println("Enter ID to remove a car: ");
                    int input11 = in.nextInt();
                    CarsDao.carsTableList.removeIf((Cars c) -> c.getId() == input11);
                    carDao.getCarsTableList().forEach(System.out::println);
                    System.out.println("Car Removed");
                    System.out.println("Return to menu? Press any key");
                    String next4 = in.next();
                    display_menu();
                    break;

                case 5:
                    FileWriter writer = new FileWriter("AllEngines.txt");
                    for (Cars cr : carDao.getCarsTableList()) {
                        writer.write(cr + System.lineSeparator());
                    }
                    writer.close();
                    System.out.println("All engines exported to AllEngines.txt");
                    System.out.println("Return to menu? Press any key");
                    String next3 = in.next();
                    display_menu();
                    break;


                case 6:

                    int totalSum = CarsDao.carsTableList.stream().mapToInt(Cars -> Cars.getPrice()).sum();
                    System.out.println("Sum of all engines is: " + totalSum);
                    String next = in.next();
                    System.out.println("Return to menu? Press any key");
                    String next1 = in.next();
                    display_menu();
                    break;

                case 7:
                    System.out.println("Filter cars: (Diesel/Gas)");
                    String inputfilter = in.next();
                    CarsDao.filter(inputfilter);
                    System.out.println("Return to menu? Press any key");
                    String next0 = in.next();
                    display_menu();
                    break;


                case 8:
                    Collection<Cars> items = new ArrayList<Cars>();
                    int lineNumber = 0;
                    String nextValue = "";
                    try {

                        ClassLoader classLoader = getClass().getClassLoader();
                        File file = new File(Objects.requireNonNull(classLoader.getResource("importEngines.txt")).getFile());
                        Scanner input = new Scanner(file)
                                .useDelimiter(",|\\R");


                        while (input.hasNext()) {
                            lineNumber++;
                            nextValue = input.next().replace("\"", "");
                            int id = Integer.parseInt(nextValue);

                            nextValue = input.next().replace("\"", "");
                            String modelCar = nextValue;

                            nextValue = input.next().replace("\"", "");
                            String fuelType2 = nextValue;

                            nextValue = input.next().replace("\"", "");
                            String manModel2 = nextValue;

                            nextValue = input.next().replace("\"", "");
                            String electricEngine2 = nextValue;

                            nextValue = input.next().replace("\"", "");
                            int year2 = Integer.parseInt(nextValue);

                            nextValue = input.next().replace("\"", "");
                            int noise2 = Integer.valueOf(nextValue);

                            nextValue = input.next().replace("\"", "");
                            int pollutionTax = Integer.valueOf(nextValue);

                            nextValue = input.next().replace("\"", "");
                            int price2 = Integer.valueOf(nextValue);
                            carDao.add(new Cars(id, modelCar, fuelType2, manModel2, electricEngine2, year2, noise2, pollutionTax, price2));
                        }
                    } catch (Exception ex) {
                        throw new RuntimeException(String.format("Line number '%s, nextValue '%s''", lineNumber, nextValue), ex);
                    }


                    break;

                case 9:
                    System.out.println("Export cars to text file: (Diesel/Gas)");
                    String input30 = in.next();
                    CarsDao.export(input30);


                    break;

                case 10:
                    quit = true;

                    break;


                default:
                    System.err.println("Unrecognized option");
                    break;

            }


        } while (!quit);

        System.out.println("CarShop-App Closed!");

    }

    public static void main(String[] args) throws IOException {

        new Main();
    }
}



