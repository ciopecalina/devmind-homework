package main;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class RentedCars implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    
    private final ArrayList<String> cars;

    public RentedCars() {
        this.cars = new ArrayList<>();
    }

    public void add(String plateNo) {
        cars.add(plateNo);
    }

    public void remove(String plateNo) {
        cars.remove(plateNo);
    }

    public int size() {
        return cars.size();
    }

    public String showCars() {
        return cars.toString();
    }
}
