package be.pxl.parking.service;

import be.pxl.parking.api.input.ParkingSessionStartCommand;
import be.pxl.parking.api.input.ParkingSessionStopCommand;
import be.pxl.parking.util.SystemClock;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ParkingService {
    private final SystemClock systemClock;


    public ParkingService(SystemClock systemClock) {
        this.systemClock = systemClock;
    }

    public void startParkingSession(ParkingSessionStartCommand command) {
        LocalDateTime now = systemClock.getCurrentTime();
        // TODO uncomment the following lines when the repositories and the entity-class ParkingSession are ready
//        LicensePlate licensePlate = licensePlateRepository.findLicensePlateByPlateNumber(command.licensePlate()).orElseThrow(() -> new ResourceNotFoundException("LicensePlate", "licensePlate", command.licensePlate()));
//        Parking parking = parkingRepository.findById(command.parking()).orElseThrow(() -> new ResourceNotFoundException("Parking", "uuid", command.parking().toString()));
//        ParkingSession parkingSession = new ParkingSession(licensePlate, parking, now);
//        parkingSessionRepository.save(parkingSession);
    }

    public void stopParkingSession(ParkingSessionStopCommand command) {
        LocalDateTime now = systemClock.getCurrentTime();
        // ParkingSession parkingSession = TODO retrieve the parkingSession with the given licensePlate and status STARTED from the database
        // TODO set the end time of the parkingSession
        // TODO use ParkingSessionPriceCalculator to calculate the price of the parkingSession
        // TODO use PaymentRequestService to send the payment request
        // TODO set status PAYMENT_REQUESTED for the parkingSession
        // TODO save all changes to the database
    }
}
