package demo.controller;

import demo.model.InvoiceRequest;
import demo.model.InvoiceResponse;
import demo.model.LoginRequest;
import demo.model.LoginResponse;
import demo.service.InvoiceService;
import demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    LoginService loginService;

    @Autowired
    InvoiceService ınvoiceService;

    @PostMapping(value = "/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return loginService.login(request);
    }

    @PostMapping("/invoices")
    public InvoiceResponse getInvoice(@RequestBody InvoiceRequest request) {
        String token = request.getToken();

//        if (!loginCache.containsKey(token)) {
//            return ResponseEntity.status(HttpStatus.FORBIDDEN)
//                    .body(new InvoiceResponse(false));
//        }
        return ınvoiceService.getInvoice(request);
    }
}
