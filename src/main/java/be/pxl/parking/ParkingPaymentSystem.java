package be.pxl.parking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class ParkingPaymentSystem {

    public static void main(String[] args) {
        SpringApplication.run(ParkingPaymentSystem.class, args);
    }

}
