package com.invoiceCalculator.consoleApp.Invoice;

public class Invoice {
    private String customer;
    private String vatNumber;
    private String documentNumber;
    private Integer type;
    private String parentDocument;
    private String currency;
    private Integer total;

    public Invoice(
            String customer,
            String vatNumber,
            String documentNumber,
            Integer type,
            String parentDocument,
            String currency,
            Integer total
    ) {
        this.customer = customer;
        this.vatNumber = vatNumber;
        this.documentNumber = documentNumber;
        this.type = type;
        this.parentDocument = parentDocument;
        this.currency = currency;
        this.total = total;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getParentDocument() {
        return parentDocument;
    }

    public void setParentDocument(String parentDocument) {
        this.parentDocument = parentDocument;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
