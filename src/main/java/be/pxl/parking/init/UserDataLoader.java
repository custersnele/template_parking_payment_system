package be.pxl.parking.init;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDataLoader implements CommandLineRunner {
    private static final Logger LOGGER = LogManager.getLogger(UserDataLoader.class);

    // TODO create and add UserRepository

    @Override
    public void run(String... args) throws Exception {
        // TODO check if there is data in the Parking-table
        LOGGER.info("users already loaded...");
        // TODO if no data, load data from file ./src/main/resources/data/users.csv and save in the database
        // HINT use DataMapper to map a line to a User entity object
        LOGGER.info("loading users...");
    }


}