package solutions.autorun.invoicemanager.web.rest.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class FileManagerException extends RuntimeException {
    public FileManagerException(String message) {
        super(message);
    }
}
