package demo.ecommerce.error.handler;

import demo.ecommerce.error.ErrorDetails;
import demo.ecommerce.error.ErrorHandler;
import org.springframework.stereotype.Component;

@Component
public class MyCustomExceptionHandler implements ErrorHandler {
    @Override
    public boolean isSupported(Exception e) {
        return e instanceof RuntimeException;
    }

    @Override
    public ErrorDetails handleException(Exception e) {
        return new ErrorDetails("E106", "Security Exception");
    }
}
