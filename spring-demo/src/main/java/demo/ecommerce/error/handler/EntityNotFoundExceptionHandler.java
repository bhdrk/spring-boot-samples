package demo.ecommerce.error.handler;

import demo.ecommerce.error.ErrorDetails;
import demo.ecommerce.error.ErrorHandler;
import demo.exception.EntityNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class EntityNotFoundExceptionHandler implements ErrorHandler {
    @Override
    public boolean isSupported(Exception e) {
        return e instanceof EntityNotFoundException;
    }

    @Override
    public ErrorDetails handleException(Exception e) {
        EntityNotFoundException enfe = (EntityNotFoundException) e;
        ErrorDetails details = new ErrorDetails("E201", enfe.getMessage());
        details.getParams().put("type", enfe.getType());
        return details;
    }
}
