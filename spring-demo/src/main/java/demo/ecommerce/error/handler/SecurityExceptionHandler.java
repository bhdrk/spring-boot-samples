package demo.ecommerce.error.handler;

import demo.ecommerce.error.ErrorDetails;
import demo.ecommerce.error.ErrorHandler;
import org.springframework.stereotype.Component;

@Component
public class SecurityExceptionHandler implements ErrorHandler {
    @Override
    public boolean isSupported(Exception e) {
        return e instanceof SecurityException;
    }

    @Override
    public ErrorDetails handleException(Exception e) {
        return new ErrorDetails("E105", "Security Exception");
    }
}
