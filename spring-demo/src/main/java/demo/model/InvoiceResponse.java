package demo.model;

public class InvoiceResponse {

    private boolean success;

    private Invoice invoice;

    public InvoiceResponse(boolean success) {
        this.success = success;
    }

    public InvoiceResponse(boolean success, Invoice invoice) {
        this.success = success;
        this.invoice = invoice;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
