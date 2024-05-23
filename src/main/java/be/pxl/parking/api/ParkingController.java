package be.pxl.parking.api;

import be.pxl.parking.api.input.ParkingSessionStartCommand;
import be.pxl.parking.api.input.ParkingSessionStopCommand;
import be.pxl.parking.service.ParkingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkingController {

    private final ParkingService parkingService;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }


    @PostMapping("/parking/start")
    public void startParkingSession(@RequestBody ParkingSessionStartCommand command) {
        parkingService.startParkingSession(command);
    }

    @PostMapping("/parking/stop")
    public void stopParkingSession(@RequestBody ParkingSessionStopCommand command) {
        parkingService.stopParkingSession(command);
    }
}
