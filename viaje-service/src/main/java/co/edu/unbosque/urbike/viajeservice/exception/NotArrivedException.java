package co.edu.unbosque.urbike.viajeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotArrivedException extends RuntimeException {
    public NotArrivedException(String message) {
        super(message);
    }
}
