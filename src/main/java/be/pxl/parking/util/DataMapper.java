package be.pxl.parking.util;

import be.pxl.parking.domain.*;

import java.util.UUID;

public class DataMapper {

    public static Parking mapToParking(String line) {
        String[] split = line.split(";");
        Parking parking = new Parking(UUID.fromString(split[0]), split[1], split[2], Integer.parseInt(split[3]), split[4]);
        parking.setWeekendHourlyRate(Double.parseDouble(split[5]));
        parking.setWeekdayHourlyRate(Double.parseDouble(split[6]));
        parking.setDailyRate(Double.parseDouble(split[7]));
        return parking;
    }

    public static User mapToUser(String line) {
        String[] split = line.split(";");
        User user = new User(split[0], split[1], new ContactInfo(split[2], split[3]));
        user.setBankAccountDetails(new BankAccountDetails(Bank.valueOf(split[4]), split[5]));
        for (int i = 6; i < split.length; i++) {
            user.addLicensePlate(split[i]);
        }
        return user;
    }
}
