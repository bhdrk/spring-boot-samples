package demo.ecommerce;

import demo.ecommerce.error.ErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Random;

@Component
public class OrderService {

    private Map<String, CargoService> cargoServices;
    private ErrorHandler errorHandler;

    @Autowired
    public OrderService(Map<String, CargoService> cargoServices, ErrorHandler errorHandler) {
        this.cargoServices = cargoServices;
        this.errorHandler = errorHandler;
    }

    public void createOrder() {
        try {
            int orderId = new Random().nextInt();

            // ....
            CargoService cargoService = cargoServices.get(chooseCargoService(orderId));

            cargoService.sendCargo(orderId);
            // ...
        } catch (Exception e) {
            if (errorHandler.isSupported(e)) {
                errorHandler.handleException(e);
            }
        }
    }

    private String chooseCargoService(int orderId) {
        if (orderId > 1000000) {
            return "PTT";
        } else {
            return "UDP";
        }
    }
}
