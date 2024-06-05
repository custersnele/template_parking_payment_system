package be.pxl.parking.servlet;

import be.pxl.parking.api.output.ParkingSessionDto;
import be.pxl.parking.domain.ParkingSessionStatus;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;

public class ParkingSessionsServlet {

	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");


	private static PageRequest createPageble(HttpServletRequest request) {
		int page = request.getParameter("page") == null? 0 : Integer.parseInt(request.getParameter("page"));
		int size = request.getParameter("size") == null? 100 : Integer.parseInt(request.getParameter("size"));
		return PageRequest.of(page, size, Sort.by("start").descending());
	}

	private static void writeParkingSessionDetails(PrintWriter writer, Page<ParkingSessionDto> sessions) {
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<table>");
		for (ParkingSessionDto parkingSession : sessions.getContent()) {
			writer.println("<tr><td>" + parkingSession.parking() + "</td><td>" + parkingSession.licensePlate() + "</td><td>" + DATE_TIME_FORMATTER.format(parkingSession.start()) + "</td><td>" + (parkingSession.end() != null? TIME_FORMATTER.format(parkingSession.end()) : "") + "</td><td>" + parkingSession.price() + "</td><td>" + parkingSession.status() + "</td></tr>");
		}

		writer.println("</table>");

		writer.println("</body>");
		writer.println("</html>");
	}

}
