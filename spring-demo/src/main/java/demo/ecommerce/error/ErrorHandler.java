package demo.ecommerce.error;

public interface ErrorHandler {

    boolean isSupported(Exception e);

    ErrorDetails handleException(Exception e);
}
