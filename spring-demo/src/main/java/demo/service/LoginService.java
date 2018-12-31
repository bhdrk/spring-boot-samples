package demo.service;

import demo.model.LoginRequest;
import demo.model.LoginResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class LoginService {

    private Map<String, String> loginCache = new HashMap<>();

    public LoginResponse login(LoginRequest request) {
        LoginResponse response = new LoginResponse();
        if ("admin".equals(request.getUsername())
                && "123".equals(request.getPassword())) {
            String token = String.valueOf(new Random().nextDouble());
            loginCache.put(token, request.getUsername());
            response.setToken(token);
            response.setSuccess(true);
        } else {
            response.setSuccess(false);
        }
        return response;
    }
}
