package be.pxl.parking.util;

import be.pxl.parking.domain.Parking;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ParkingSessionPriceCalculator {

    public static double calculatePrice(LocalDateTime start, LocalDateTime end, Parking parking) {
        long days = ChronoUnit.DAYS.between(start, end);
            if (days > 1) {
                return days * parking.getDailyRate();
            } else {
                long hours = ChronoUnit.HOURS.between(start, end);
                if (start.query(new IsWeekendQuery()) || end.query(new IsWeekendQuery())) {
                    return hours * parking.getWeekendHourlyRate();
                } else {
                    return hours * parking.getWeekdayHourlyRate();
            }
        }
    }
}
