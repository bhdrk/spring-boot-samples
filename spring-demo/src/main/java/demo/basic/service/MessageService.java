package demo.basic.service;

import org.springframework.stereotype.Component;

@Component
public class MessageService {

    private String message;

    public MessageService() {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
