package demo.ecommerce.error.handler;

import demo.ecommerce.error.ErrorDetails;
import demo.ecommerce.error.ErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Primary
@Component
public class DefaultExceptionHandler implements ErrorHandler {

    private List<ErrorHandler> errorHandlers;

    @Autowired
    public DefaultExceptionHandler(List<ErrorHandler> errorHandlers) {
        this.errorHandlers = errorHandlers;
    }

    @Override
    public boolean isSupported(Exception e) {
        for (ErrorHandler errorHandler : errorHandlers) {
            if (errorHandler.isSupported(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ErrorDetails handleException(Exception e) {
        for (ErrorHandler errorHandler : errorHandlers) {
            if (errorHandler.isSupported(e)) {
               return errorHandler.handleException(e);
            }
        }

        return new ErrorDetails(500, "E100", "Internal Server Eror");
    }
}
