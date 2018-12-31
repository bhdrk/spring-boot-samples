package demo.ecommerce;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("PTT")
public class PttCargoService implements CargoService {

    @Override
    public void sendCargo(int orderCode) {
        System.out.println("Cargo Service: PTT");
    }
}
