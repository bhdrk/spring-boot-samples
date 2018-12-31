package demo.basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrinterService {

    private MessageService messageService;

    @Autowired
    public PrinterService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void print() {
        System.out.println(messageService.getMessage());
    }
}
