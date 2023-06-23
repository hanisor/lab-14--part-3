package server.controller;

import java.util.ArrayList;
import java.util.List;

import model.Customer;

public class CustomerDataManager {
	
private List<Customer> customers;
	
	/**
	 * Constructor
	 */
	public CustomerDataManager() {
		
		// Load customers
		this.customers = new ArrayList<Customer>();
		this.loadCustomers();
		
	}
	
	public List<Customer> getCustomers() {
		
		return customers;
	}
	

	public Customer getCustomerByName(String name)
	{
		for (Customer customer : customers) {
	        String customerName = customer.getName();
	        // Check if the customer name partially matches the search name
	        if (customerName.length() >= name.length() && customerName.startsWith(name)) {
	            return customer;
	        }
		}
		
		// Return customer not found
		Customer unFoundCustomer = new Customer();
		unFoundCustomer.setName("Customer not found");
		
		return unFoundCustomer;
	}
	
	public Customer getCustomerById(int id) {
		
		// Find a product
		for (Customer customer:customers) {
			
			if (customer.getCustomerId() == id)
				return customer;
		}
		
		// Return product not found
		Customer noCustomer = new Customer();
		noCustomer.setName("Customer not found");
		return noCustomer;
		
	}
	
	/**
	 * This method loads a list of customer into a list
	 */
	private void loadCustomers() {
		
		// Sample data
		int ids[] = {1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 1010};
		String names[] = {"Hanis sorhana", "Shaufy Yana", "Irdina Izzati", "Muhammad Izzat", 
				"Aina Syazwani", "Ng wei hen", "Auni Afiqah", "Adib Adliyana", "Rose Asnariza", "Hafiz Suhaizal"};
		
		// Load data into list
		for (int index=0; index < ids.length; index++) {
			
			// Create customer
			Customer customer = new Customer();
			customer.setCustomerId(ids[index]);
			customer.setName(names[index]);
			
			// Add to list
			customers.add(customer);
			
		}
		
		
		
		
	}

}
