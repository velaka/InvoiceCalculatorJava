package com.invoiceCalculator.consoleApp;

import com.invoiceCalculator.consoleApp.Invoice.Invoice;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.invoiceCalculator.consoleApp.Invoice.InvoiceBuilder.readInvoicesFromCSV;
import static com.invoiceCalculator.consoleApp.Invoice.InvoiceCalculator.invoiceSum;

@SpringBootApplication
public class ConsoleAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsoleAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter currencies with their exchange rates:");
		String input = in.nextLine();
		Map<String, Double> exchangeRates = consoleInputHandler(input);
		List<Invoice> invoices = readInvoicesFromCSV("/Users/velkogenchev/IdeaProjects/consoleApp/src/main/java/com/invoiceCalculator/consoleApp/data.csv");
		Map<String, Double> result = invoiceSum(invoices, exchangeRates);
		System.out.println("Sum of Invoices for each vendor: " + result);
	}

	private static Map<String, Double> consoleInputHandler(String input) {
		Scanner scanner = new Scanner(input);
		scanner.useDelimiter(",");
		Map<String,Double> exchangeRateArray = new HashMap<>();
		while (scanner.hasNext()) {
			String exchangeRates = scanner.next();
			String[] temp = exchangeRates.split(":");
			exchangeRateArray.put(temp[0], Double.parseDouble(temp[1]));
		}

		return exchangeRateArray;
	}
}
//EUR:1,USD:0.987,GBP:0.878
//EUR:0.888,USD:1,GBP:0.983
//EUR:0.992,USD:0.786,GBP:1
