package demo.ecommerce;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("UDP")
public class UdpCargoService implements CargoService {

    @Override
    public void sendCargo(int orderCode) {

    }
}
