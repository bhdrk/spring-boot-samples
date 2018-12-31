package demo.exception;


import demo.ecommerce.error.ErrorDetails;
import demo.ecommerce.error.ErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @Autowired
    private ErrorHandler errorHandler;

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {

        if (errorHandler.isSupported(e)) {
            ErrorDetails errorDetails = errorHandler.handleException(e);
            return ResponseEntity.status(errorDetails.getStatusCode())
                    .body(errorDetails);
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorDetails(500, "E100", "Internal Server Eror"));
    }
}
