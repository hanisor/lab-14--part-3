package client.view;


import java.util.List;

import model.Customer;

public class CustomerViewer {
	
	
	public void displayCustomers(List<Customer> customers) {
		
		// Some information about the record
		System.out.println("\tNumber of record: " + customers.size()+ "/n");
		System.out.println("\tCustomer Information");
		
		// Print all products on console
		for (Customer customer:customers) {
			
			System.out.println("\n\tCustomer Id: " + customer.getCustomerId());
			System.out.println("\tName: " + customer.getName());
		}
		
	}

}
