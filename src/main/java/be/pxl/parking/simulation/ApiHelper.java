package be.pxl.parking.simulation;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class ApiHelper {

    private final WebClient webClient;
    private static final int PORT = 8080;

    public ApiHelper() {
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:" + PORT)
                .build();
    }

    public Boolean startParkingSession(String licensePlate, String parkingUuid) {
        String jsonBody = "{\"licensePlate\": \"" + licensePlate + "\", " +
                "\"parking\" : \"" + parkingUuid + "\"}";
        return createRequest("start", jsonBody);
    }

    public Boolean endParkingSession(String licensePlate) {
        String jsonBody = "{\"licensePlate\": \"" + licensePlate + "\"}";
        return createRequest("stop", jsonBody);
    }

    private Boolean createRequest(String action, String jsonBody) {
        System.out.println("Sending result!");
        System.out.println(jsonBody);

        return  webClient.post()
                .uri("/parking/" + action)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(jsonBody)
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().is2xxSuccessful()) {
                        return Mono.just(true);
                    } else {
                        System.out.println("An error occurred while sending the result.");
                        return Mono.just(false);
                    }
                }).block();
    }
}
