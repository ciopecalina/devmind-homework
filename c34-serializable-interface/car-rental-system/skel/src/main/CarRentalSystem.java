package main;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CarRentalSystem {

    private static final String binaryFileName = "carrentalsystem.dat";

    private HashMap<String, String> rentedCars = new HashMap<>(100, 0.5f);
    private HashMap<String, RentedCars> owners = new HashMap<>(100, 0.5f);

    private static String getPlateNo(Scanner sc) {
        return sc.nextLine();
    }

    private static String getOwnerName(Scanner sc) {
        return sc.nextLine();
    }

    private boolean isCarRent(String plateNo) {
        return rentedCars.containsKey(plateNo);
    }

    private String getCarRent(String plateNo) {
        return rentedCars.get(plateNo);
    }

    private void rentCar(String plateNo, String ownerName) {
        rentedCars.put(plateNo, ownerName);

        RentedCars current = owners.get(ownerName);

        if (current == null) {
            RentedCars carList = new RentedCars();
            carList.add(plateNo);
            owners.put(ownerName, carList);
        } else current.add(plateNo);
    }

    private String returnCar(String plateNo) {
        String currentOwner = "";

        for (Map.Entry<String, String> entry : rentedCars.entrySet())
            if (entry.getKey().equals(plateNo)) currentOwner = entry.getValue();

        owners.get(currentOwner).remove(plateNo);

        return rentedCars.remove(plateNo);
    }

    private int totalCarsRented() {
        return rentedCars.size();
    }

    private void getCarsNo(String ownerName) {
        RentedCars result = owners.get(ownerName);
        if (result == null) System.out.printf("Nu exista masini inchiriate de [%s].%n", ownerName);
        else System.out.println(result.size());
    }

    private void getCarsList(String ownerName) {
        RentedCars result = owners.get(ownerName);
        if (result == null) System.out.printf("Nu exista masini inchiriate de [%s].%n", ownerName);
        else System.out.println(result.showCars());
    }

    private void writeToBinaryFile() throws IOException {
        try (ObjectOutputStream binaryFileOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(binaryFileName)))) {
            binaryFileOut.writeObject(rentedCars);
            binaryFileOut.writeObject(owners);
        }
    }

    private void readFromBinaryFile() {
        try (ObjectInputStream binaryFileIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(binaryFileName)))) {
            rentedCars = (HashMap<String, String>) binaryFileIn.readObject();
            owners = (HashMap<String, RentedCars>) binaryFileIn.readObject();
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("A class not found exception: " + e.getMessage());
        }
    }

    private void resetBinaryFile() {
        try (ObjectOutputStream binaryFileOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(binaryFileName)))) {
            binaryFileOut.writeObject(new HashMap<String, String>());
            binaryFileOut.writeObject(new HashMap<String, RentedCars>());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printCommandsList() {
        System.out.println("help         - Afiseaza aceasta lista de comenzi");
        System.out.println("add          - Adauga o noua pereche (masina, sofer)");
        System.out.println("check        - Verifica daca o masina este deja luata");
        System.out.println("remove       - Sterge o masina existenta din hashtable");
        System.out.println("getOwner     - Afiseaza proprietarul curent al masinii");
        System.out.println("totalRented  - Afiseaza numarul de masini inchiriate");
        System.out.println("getCarsNo    - Afiseaza numarul de masini inchiriate de un anumit proprietar");
        System.out.println("getCarsList  - Afiseaza lista de masini inchiriate de un anumit proprietar");
        System.out.println("quit         - Inchide aplicatia");
    }

    public void run(Scanner sc) throws IOException {
        boolean quit = false;

        while (!quit) {
            String command = sc.nextLine();

            switch (command) {
                case "help" -> printCommandsList();
                case "add" -> {
                    String plateNo = getPlateNo(sc);
                    String ownerName = getOwnerName(sc);
                    if (isCarRent(plateNo)) {
                        String current = getCarRent(plateNo);
                        System.out.printf("Masina %s a fost deja inchiriata de %s.%n", plateNo, current);
                    } else rentCar(plateNo, ownerName);
                }
                case "check" -> {
                    String plateNo = getPlateNo(sc);
                    boolean carRent = isCarRent(plateNo);

                    if (!carRent) System.out.println("Masina cautata nu a fost inchiriata.");
                    else {
                        String current = getCarRent(plateNo);
                        System.out.printf("Masina %s a fost inchiriata de %s.%n", plateNo, current);
                    }
                }
                case "remove" -> {
                    String plateNo = getPlateNo(sc);
                    String removedOwner = returnCar(plateNo);
                }
                case "getOwner" -> {
                    String plateNo = getPlateNo(sc);
                    String owner = getCarRent(plateNo);

                    if (owner == null) System.out.printf("Masina %s nu a fost inchiriata.%n", plateNo);
                    else System.out.println(owner);
                }
                case "save" -> {
                    writeToBinaryFile();
                }
                case "restore" -> {
                    readFromBinaryFile();
                }
                case "reset" -> {
                    resetBinaryFile();
                }
                case "totalRented" -> System.out.println(totalCarsRented());
                case "getCarsNo" -> getCarsNo(getOwnerName(sc));
                case "getCarsList" -> getCarsList(getOwnerName(sc));
                case "quit" -> {
                    System.out.println("Aplicatia se inchide...");
                    quit = true;
                }
                default -> {
                    System.out.println("Comanda necunoscuta. Incearca din nou.");
                    printCommandsList();
                }
            }
        }
    }
}
