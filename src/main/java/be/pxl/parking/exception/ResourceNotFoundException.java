package be.pxl.parking.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resource, String field, String value) {
        super("No " + resource + " found with [" + field + "=" + value + "]");
    }
}
