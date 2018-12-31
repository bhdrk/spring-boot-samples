package demo.ecommerce.error;

import java.util.HashMap;
import java.util.Map;

public class ErrorDetails {

    private Integer statusCode;
    private String errorCode;
    private String errorMessage;
    private Map<String, String> params = new HashMap<>();

    public ErrorDetails(String errorCode, String errorMessage) {
        this(400, errorCode, errorMessage);
    }

    public ErrorDetails(Integer statusCode, String errorCode, String errorMessage) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}
