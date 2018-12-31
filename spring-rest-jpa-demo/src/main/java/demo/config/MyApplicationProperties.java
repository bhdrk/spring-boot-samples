package demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "my-application")
public class MyApplicationProperties {

    private String ibbUrl;

    private List<String> errorTypes;

    public String getIbbUrl() {
        return ibbUrl;
    }

    public void setIbbUrl(String ibbUrl) {
        this.ibbUrl = ibbUrl;
    }

    public List<String> getErrorTypes() {
        return errorTypes;
    }

    public void setErrorTypes(List<String> errorTypes) {
        this.errorTypes = errorTypes;
    }
}
