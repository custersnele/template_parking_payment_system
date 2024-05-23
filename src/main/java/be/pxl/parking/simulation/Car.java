package be.pxl.parking.simulation;

import java.util.List;
import java.util.Random;

public class Car {
    private static final Random RANDOM = new Random();
    private final String licensePlate;
    private final List<String> possibleParkings;
    private final ApiHelper apiHelper;

    public Car(String licensePlate, List<String> possibleGarages, ApiHelper apiHelper) {
        this.licensePlate = licensePlate;
        this.possibleParkings = possibleGarages;
        this.apiHelper = apiHelper;
    }


    // TODO This class must be a Thread
    // Each car: 1. takes a random parking (uuid)
    //           2. starts a parking session using the apihelper
    //           3. sleeps for a random time between 1000 and 8000 milliseconds
    //           4. stops the parking session using the api helper
    //           5. sleeps for a random time between 10000 and 60000 millisenconds
    //           repeat step 1 - 5 forever
}
