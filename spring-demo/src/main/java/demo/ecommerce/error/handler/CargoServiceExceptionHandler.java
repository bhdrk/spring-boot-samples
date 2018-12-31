package demo.ecommerce.error.handler;

import demo.ecommerce.error.ErrorDetails;
import demo.ecommerce.error.ErrorHandler;
import org.springframework.stereotype.Component;

@Component
public class CargoServiceExceptionHandler implements ErrorHandler {
    @Override
    public boolean isSupported(Exception e) {
        return e instanceof IllegalAccessException;
    }

    @Override
    public ErrorDetails handleException(Exception e) {
        return new ErrorDetails("E107", "Security Exception");
    }
}
