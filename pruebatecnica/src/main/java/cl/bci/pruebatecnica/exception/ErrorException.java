package cl.bci.pruebatecnica.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ToString
@ResponseStatus
public class ErrorException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String description;
    public ErrorException (String message, String description){
        super(message);
        this.description = description;
    }
}
