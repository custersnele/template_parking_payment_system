package be.pxl.parking.builder;

import be.pxl.parking.domain.Parking;

import java.util.UUID;

public final class ParkingBuilder {
    private double weekendHourlyRate;
    private double weekdayHourlyRate;
    private double dailyRate;
    private UUID uuid;
    private String name;

    private ParkingBuilder() {
    }

    public static ParkingBuilder aParking() {
        return new ParkingBuilder();
    }

    public ParkingBuilder withWeekendHourlyRate(double weekendHourlyRate) {
        this.weekendHourlyRate = weekendHourlyRate;
        return this;
    }

    public ParkingBuilder withWeekdayHourlyRate(double weekdayHourlyRate) {
        this.weekdayHourlyRate = weekdayHourlyRate;
        return this;
    }

    public ParkingBuilder withDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
        return this;
    }

    public ParkingBuilder withUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public ParkingBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public Parking build() {
        Parking parking = new Parking(uuid, name, null, 0, null);
        parking.setWeekendHourlyRate(weekendHourlyRate);
        parking.setWeekdayHourlyRate(weekdayHourlyRate);
        parking.setDailyRate(dailyRate);
        return parking;
    }
}
