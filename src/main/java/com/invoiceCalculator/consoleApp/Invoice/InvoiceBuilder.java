package com.invoiceCalculator.consoleApp.Invoice;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InvoiceBuilder {

    public static List<Invoice> readInvoicesFromCSV(String fileName) {
        List<Invoice> invoices = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                Invoice invoice = createInvoice(attributes);
                invoices.add(invoice);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return invoices;
    }

    public static Invoice createInvoice(String[] data) {
        String customer = data[0];
        String vatNumber = data[1];
        String documentNumber = data[2];
        int type = Integer.parseInt(data[3]);
        String parentDocument = data[4];
        String currency = data[5];
        int total = Integer.parseInt(data[6]);

        return new Invoice(customer, vatNumber, documentNumber, type, parentDocument, currency, total);
    }
}
