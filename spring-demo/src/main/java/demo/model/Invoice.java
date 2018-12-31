package demo.model;

import java.util.Date;

public class Invoice {

    private Double amount;

    private Date date;

    private Integer invoiceNumber;

    public Invoice() {

    }
    public Invoice(Double amount, Date date, Integer invoiceNumber) {
        this.amount = amount;
        this.date = date;
        this.invoiceNumber = invoiceNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Integer invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
}
