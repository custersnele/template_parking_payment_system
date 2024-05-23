package be.pxl.parking.init;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ParkingDataLoader implements CommandLineRunner {
    private static final Logger LOGGER = LogManager.getLogger(ParkingDataLoader.class);

    // TODO add ParkingRepository

    @Override
    public void run(String... args) throws Exception {
        // TODO check if there is data in the Parking-table
        LOGGER.info("parkings already loaded...");
        // TODO load data from file ./src/main/resources/data/parkings.csv and save in the database
        // HINT use DataMapper to map a line to a Parking entity object
        LOGGER.info("loading parkings...");

    }
}
