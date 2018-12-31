package demo.service;

import demo.exception.EntityNotFoundException;
import demo.model.Invoice;
import demo.model.InvoiceRequest;
import demo.model.InvoiceResponse;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class InvoiceService {

    private Map<String, Invoice> invoices = new HashMap<>();

    @PostConstruct
    public void init() {
        invoices.put("101", new Invoice(1500.50, new Date(), 101));
        invoices.put("102", new Invoice(3700.50, new Date(), 102));
    }

    public InvoiceResponse getInvoice(InvoiceRequest request) {

        Invoice invoice = invoices.get(request.getInvoiceNumber());

        if (invoice == null) {
            throw new EntityNotFoundException("Invoice");
        }

        return new InvoiceResponse(true, invoice);
    }
}
