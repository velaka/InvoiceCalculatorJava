package com.invoiceCalculator.consoleApp.Invoice;

import java.util.*;

public class InvoiceCalculator {
    public static Map<String, Double> invoiceSum(List<Invoice> invoices, Map<String, Double> exchangeRates) {
        Map<String,Double> result = new HashMap<>();
        for (Invoice i : invoices) {
            List<Invoice> invoicesFromSingleVendor = new ArrayList<>();
            for(Invoice in : invoices) {
                if(Objects.equals(i.getVatNumber(), in.getVatNumber()))
                {
                    invoicesFromSingleVendor.add(in);
                }
            }

            double sum = 0;
            for (Invoice is : invoicesFromSingleVendor) {
                switch(is.getType()) {
                    case 1:
                    case 3:
                        sum += currencyExchange(is.getTotal(), exchangeRates.get(is.getCurrency()));
                        break;
                    case 2:
                        sum -= currencyExchange(is.getTotal(), exchangeRates.get(is.getCurrency()));
                        break;
                }
            }
            result.put(i.getCustomer(), sum);
        }

        return result;
    }

    private static double currencyExchange(int sum, double exchangeRate) {
         return sum / exchangeRate;
    }
}
