package demo.basic.runner;

import demo.basic.service.PrinterService;
import org.springframework.boot.CommandLineRunner;

public class Runner implements CommandLineRunner {

    private PrinterService printerService;

    @Override
    public void run(String... args) throws Exception {
        printerService.print();
    }

    public void setPrinterService(PrinterService printerService) {
        this.printerService = printerService;
    }
}
