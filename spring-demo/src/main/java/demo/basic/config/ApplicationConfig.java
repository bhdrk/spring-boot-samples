package demo.basic.config;

import demo.basic.runner.Runner;
import demo.basic.service.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public Runner myRunner(PrinterService printerService) {
        Runner runner = new Runner();
        runner.setPrinterService(printerService);
        return runner;
    }
}