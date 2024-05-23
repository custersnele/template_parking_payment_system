package be.pxl.parking.api.input;

import java.util.UUID;

public record ParkingSessionStartCommand(String licensePlate, UUID parking) {
}
