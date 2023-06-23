package client.app;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import model.Customer;

/**
 * This is a TCP client class that process primitive (customer id) and complex
 * (Customer) data using different streams.
 * 
 * @author hanis sorhana
 *
 */
public class TCPCustomerClientApp {
	
	public static void main (String[] args) {
		
		try {
			
			System.out.println("\tExecuting TCPCustomerClientApp");
		
			// Server information
			int serverPortNo = 8088;
			InetAddress serverAddress = InetAddress.getLocalHost();
			
			// 1. Connect to remote machine
			Socket clientSocket = new Socket(serverAddress, serverPortNo);
			
			// Create stream to send request
			OutputStream os = clientSocket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			// 2. Send request to the server
			String customerName = "Ng wei hen";
			dos.writeUTF(customerName);
			System.out.println("\tRequesting Customer name " + customerName + "\n");
			
			
			// Create stream to receive response from the server
			InputStream is = clientSocket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			
			
			// 3. Read respond from the server - cast object
			Customer customer = (Customer) ois.readObject();
			
			// 4. Process response - display the object
			System.out.println("\tCustomer Information (From the server)");
			System.out.println("\tCustomer Id: " + customer.getCustomerId());
			System.out.println("\tName: " + customer.getName());
			
			
		} catch (Exception ex) {

		}
		
	}

}
