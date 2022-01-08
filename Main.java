import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		/*
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:3000/Electronic_device")).build();
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
		.thenApply(HttpResponse::body)
		.thenApply(Main::parse)
		.join();
		*/
		
		
		System.out.println("Welcome to the Electronic Store Database!");
		
		System.out.println("What action would you like to perform?");
		
		System.out.println("1. Add a device\n2. Update the price of a device\n3. Remove a device");
		int answer = scan.nextInt();
		scan.nextLine();
		
		switch(answer)
		{
			case 1:
			{
				System.out.println("What type of device would you like to add?");
				String type = scan.nextLine();
				
				if(type.toLowerCase().equals("laptop"))
					sqlInsertLaptop(userInsertLaptopInfo());
				
				else if(type.toLowerCase().equals("cellphone"))
					sqlInsertCellphone(userInsertCellphoneInfo());
				
				else
					sqlInsertSmartWatch(userInsertSmartWatchInfo());
				
				break;
			}
				
			case 2:
				{
					System.out.println("What type of device do you want to update?");
					String type = scan.nextLine();
					
					if(type.toLowerCase().equals("laptop"))
						sqlUpdateLaptop(userUpdateInfo());
					
					else if(type.toLowerCase().equals("cellphone"))
						sqlUpdateCellphone(userUpdateInfo());
					
					else
						sqlUpdateSmartWatch(userUpdateInfo());
						
					break;
				}
				
			case 3:
				{
					System.out.println("What type of device do you want to delete?");
					String type = scan.nextLine();
					
					if(type.toLowerCase().equals("laptop"))
					{
						System.out.println("Enter the serial number of the laptop you want to delete:");
						String serialNumber = scan.nextLine();
						
						sqlDeleteLaptop(serialNumber);
					}
						
					else if(type.toLowerCase().equals("cellphone"))
					{
						System.out.println("Enter the serial number of the laptop you want to delete:");
						String serialNumber = scan.nextLine();
						
						sqlDeleteCellphone(serialNumber);
					}
					
					else
					{
						System.out.println("Enter the serial number of the laptop you want to delete:");
						String serialNumber = scan.nextLine();
						
						sqlDeleteSmartWatch(serialNumber);
					}
						
					break;
				}
			
			default:
				System.out.println("Invalid input. Exiting program.");
				System.exit(0);
		}
	}
	

	//Helper methods
	
	//Insert queries for MySQL database
	private static void sqlInsertLaptop(final List answers)
	{
		Connection conn = null;
		Statement stmt = null;
		try 
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
			}
			
			catch (Exception e)
			{
				System.out.println(e);
			}
			
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/electronic_store", "root",
					"password");

			String insertString = "INSERT INTO Laptop VALUES(?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement insertLaptop = conn.prepareStatement(insertString);

			insertLaptop.setString(1, (String) answers.get(0));
			insertLaptop.setString(2, (String) answers.get(1));
			insertLaptop.setString(3, (String) answers.get(2));
			insertLaptop.setDouble(4, (double) answers.get(3));
			insertLaptop.setString(5, (String) answers.get(4));
			insertLaptop.setInt(6, (int) answers.get(5));
			insertLaptop.setBoolean(7, (boolean) answers.get(6));

			insertLaptop.executeUpdate();
		} 
		
		catch (SQLException excep)
		{
			excep.printStackTrace();
		}
		
		catch (Exception excep) {
			excep.printStackTrace();
		} 
		
		finally 
		{
			try 
			{
				if (stmt != null)
					conn.close();
			} 
			
			catch (SQLException se){
			}
			
			try 
			{
				if (conn != null)
					conn.close();
			} 
			
			catch (SQLException se)
			{
				se.printStackTrace();
			}
		}
	}
	private static void sqlInsertCellphone(final List answers)
	{
		Connection conn = null;
		Statement stmt = null;
		try 
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
			}
			
			catch (Exception e)
			{
				System.out.println(e);
			}
			
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/electronic_store", "root",
					"password");

			String insertString = "INSERT INTO Cellphone VALUES(?, ?, ?, ?, ?, ?)";

			PreparedStatement insertCellphone = conn.prepareStatement(insertString);

			insertCellphone.setString(1, (String) answers.get(0));
			insertCellphone.setString(2, (String) answers.get(1));
			insertCellphone.setString(3, (String) answers.get(2));
			insertCellphone.setDouble(4, (double) answers.get(3));
			insertCellphone.setString(5, (String) answers.get(4));
			insertCellphone.setInt(6, (int)answers.get(5));

			insertCellphone.executeUpdate();
		} 
		
		catch (SQLException excep)
		{
			excep.printStackTrace();
		}
		
		catch (Exception excep) {
			excep.printStackTrace();
		} 
		
		finally 
		{
			try 
			{
				if (stmt != null)
					conn.close();
			} 
			
			catch (SQLException se){
			}
			
			try 
			{
				if (conn != null)
					conn.close();
			} 
			
			catch (SQLException se)
			{
				se.printStackTrace();
			}
		}
	}
	private static void sqlInsertSmartWatch(final List answers)
	{

		Connection conn = null;
		Statement stmt = null;
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}

			catch (Exception e) {
				System.out.println(e);
			}

			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/electronic_store", "root",
					"password");

			String insertString = "INSERT INTO SmartWatch VALUES(?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement insertSmartWatch = conn.prepareStatement(insertString);

			insertSmartWatch.setString(1, (String) answers.get(0));
			insertSmartWatch.setString(2, (String) answers.get(1));
			insertSmartWatch.setString(3, (String) answers.get(2));
			insertSmartWatch.setDouble(4, (double) answers.get(3));
			insertSmartWatch.setString(5, (String) answers.get(4));
			insertSmartWatch.setInt(6, (int) answers.get(5));

			insertSmartWatch.executeUpdate();
		}

		catch (SQLException excep) {
			excep.printStackTrace();
		}

		catch (Exception excep) {
			excep.printStackTrace();
		}

		finally {
			try {
				if (stmt != null)
					conn.close();
			}

			catch (SQLException se) {
			}

			try {
				if (conn != null)
					conn.close();
			}

			catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
	
	
	//Update queries for MySQL database
	private static void sqlUpdateLaptop(final List answers)
	{
		Connection conn = null;
		Statement stmt = null;
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}

			catch (Exception e) {
				System.out.println(e);
			}

			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/electronic_store", "root",
					"password");

			String insertString = "UPDATE laptop " + "SET price = ? WHERE Serial_Number = ?";

			PreparedStatement updateLaptop = conn.prepareStatement(insertString);

			updateLaptop.setString(1, (String) answers.get(1));
			updateLaptop.setString(2, (String) answers.get(0));

			updateLaptop.executeUpdate();
		}

		catch (SQLException excep) {
			excep.printStackTrace();
		}

		catch (Exception excep) {
			excep.printStackTrace();
		}

		finally {
			try {
				if (stmt != null)
					conn.close();
			}

			catch (SQLException se) {
			}

			try {
				if (conn != null)
					conn.close();
			}

			catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
	private static void sqlUpdateCellphone(final List answers)
	{
		Connection conn = null;
		Statement stmt = null;
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}

			catch (Exception e) {
				System.out.println(e);
			}

			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/electronic_store", "root",
					"password");

			String insertString = "UPDATE cellphone SET price = ? WHERE Serial_Number = ?";

			PreparedStatement updateCellphone = conn.prepareStatement(insertString);

			updateCellphone.setString(1, (String) answers.get(1));
			updateCellphone.setString(2, (String) answers.get(0));

			updateCellphone.executeUpdate();
		}

		catch (SQLException excep) {
			excep.printStackTrace();
		}

		catch (Exception excep) {
			excep.printStackTrace();
		}

		finally {
			try {
				if (stmt != null)
					conn.close();
			}

			catch (SQLException se) {
			}

			try {
				if (conn != null)
					conn.close();
			}

			catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
	private static void sqlUpdateSmartWatch(final List answers)
	{
		Connection conn = null;
		Statement stmt = null;
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}

			catch (Exception e) {
				System.out.println(e);
			}

			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/electronic_store", "root",
					"password");

			String insertString = "UPDATE smartwatch SET price = ? WHERE Serial_Number = ?";

			PreparedStatement updateSmartWatch = conn.prepareStatement(insertString);

			updateSmartWatch.setString(1, (String) answers.get(1));
			updateSmartWatch.setString(2, (String) answers.get(0));

			updateSmartWatch.executeUpdate();
		}

		catch (SQLException excep) {
			excep.printStackTrace();
		}

		catch (Exception excep) {
			excep.printStackTrace();
		}

		finally {
			try {
				if (stmt != null)
					conn.close();
			}

			catch (SQLException se) {
			}

			try {
				if (conn != null)
					conn.close();
			}

			catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	
	//Delete queries for MySQL database
	private static void sqlDeleteLaptop(final String serialNumber)
	{
		Connection conn = null;
		Statement stmt = null;
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}

			catch (Exception e) {
				System.out.println(e);
			}

			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/electronic_store", "root",
					"password");

			String insertString = "DELETE FROM Laptop WHERE Serial_Number = ?";

			PreparedStatement updateSmartWatch = conn.prepareStatement(insertString);

			updateSmartWatch.setString(1, serialNumber);

			updateSmartWatch.executeUpdate();
		}

		catch (SQLException excep) {
			excep.printStackTrace();
		}

		catch (Exception excep) {
			excep.printStackTrace();
		}

		finally {
			try {
				if (stmt != null)
					conn.close();
			}

			catch (SQLException se) {
			}

			try {
				if (conn != null)
					conn.close();
			}

			catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
	private static void sqlDeleteCellphone(final String serialNumber)
	{
		Connection conn = null;
		Statement stmt = null;
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}

			catch (Exception e) {
				System.out.println(e);
			}

			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/electronic_store", "root",
					"password");

			String insertString = "DELETE FROM Cellphone WHERE Serial_Number = ?";

			PreparedStatement updateSmartWatch = conn.prepareStatement(insertString);

			updateSmartWatch.setString(1, serialNumber);

			updateSmartWatch.executeUpdate();
		}

		catch (SQLException excep) {
			excep.printStackTrace();
		}

		catch (Exception excep) {
			excep.printStackTrace();
		}

		finally {
			try {
				if (stmt != null)
					conn.close();
			}

			catch (SQLException se) {
			}

			try {
				if (conn != null)
					conn.close();
			}

			catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
	private static void sqlDeleteSmartWatch(final String serialNumber)
	{
		Connection conn = null;
		Statement stmt = null;
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}

			catch (Exception e) {
				System.out.println(e);
			}

			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/electronic_store", "root",
					"password");

			String insertString = "DELETE FROM SmartWatch WHERE Serial_Number = ?";

			PreparedStatement updateSmartWatch = conn.prepareStatement(insertString);

			updateSmartWatch.setString(1, serialNumber);

			updateSmartWatch.executeUpdate();
		}

		catch (SQLException excep) {
			excep.printStackTrace();
		}

		catch (Exception excep) {
			excep.printStackTrace();
		}

		finally {
			try {
				if (stmt != null)
					conn.close();
			}

			catch (SQLException se) {
			}

			try {
				if (conn != null)
					conn.close();
			}

			catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
	

	//Methods that gets the necessary information for the insert query
	private static List userInsertLaptopInfo()
	{
		List<Object> answers = new ArrayList<>();
		
		System.out.println("Enter the serial number:");
		answers.add(scan.nextLine());
		
		System.out.println("Enter the brand: ");
		answers.add(scan.nextLine());
		
		System.out.println("Enter the color:");
		answers.add(scan.nextLine());
		
		System.out.println("Enter the price:");
		answers.add(scan.nextDouble());
		scan.nextLine();
		
		System.out.println("Enter the date of purchase:");
		answers.add(scan.nextLine());
		
		System.out.println("Enter the number of cores:");
		answers.add(scan.nextInt());
		scan.nextLine();
		
		System.out.println("Does the device have a touch screen?");
		answers.add(scan.nextLine().toLowerCase().equals("yes") ? true : false);
		
		return answers;
	}
	private static List userInsertCellphoneInfo()
	{
		List answers = new ArrayList<>();
		
		System.out.println("Enter the serial number:");
		answers.add(scan.nextLine());
		
		System.out.println("Enter the brand: ");
		answers.add(scan.nextLine());
		
		System.out.println("Enter the color:");
		answers.add(scan.nextLine());
		
		System.out.println("Enter the price:");
		answers.add(scan.nextDouble());
		scan.nextLine();
		
		System.out.println("Enter the date of purchase:");
		answers.add(scan.nextLine());
		
		System.out.println("Enter the number of cameras:");
		answers.add(scan.nextInt());
		
		return answers;
	}
	private static List userInsertSmartWatchInfo()
	{
		List<Object> answers = new ArrayList<>();
		
		System.out.println("Enter the serial number:");
		answers.add(scan.nextLine());
		
		System.out.println("Enter the brand: ");
		answers.add(scan.nextLine());
		
		System.out.println("Enter the color:");
		answers.add(scan.nextLine());
		
		System.out.println("Enter the price:");
		answers.add(scan.nextDouble());
		scan.nextLine();
		
		System.out.println("Enter the date of purchase:");
		answers.add(scan.nextLine());
		
		System.out.println("Enter the battery life:");
		answers.add(scan.nextInt());
		
		return answers;
	}
	
	//Method that gets the necessary information for the update query
	private static List userUpdateInfo()
	{
		List<Object> answers = new ArrayList<>();
		
		System.out.println("Enter the serial number of the device:");
		answers.add(scan.nextLine());
		
		System.out.println("Enter the updated price:");
		answers.add(scan.nextLine());
		
		return answers;
	}
	
	
	public static String parse(final String response)
	{
		
		ElectronicStore deviceStore = ElectronicStore.getInstance();
		JSONArray devices = new JSONArray(response);
		
		for(int i = 0; i < devices.length(); i++)
		{
			JSONObject device = devices.getJSONObject(i);
			
			switch(device.getString("type"))
			{
				case "laptop":
					deviceStore.addDevice(new laptop(device.getString("brand"),
													 device.getString("serial_number"),
													 device.getString("color"),
													 device.getDouble("price"),
													 device.getString("dateOfPurchase"),
													 device.getInt("nbOfCores"),
													 device.getBoolean("touchScreen")));
					break;
				
				case "cellphone":
					deviceStore.addDevice(new cellphone(device.getString("brand"),
							 device.getString("serial_number"),
							 device.getString("color"),
							 device.getDouble("price"),
							 device.getString("dateOfPurchase"),
							 device.getInt("nbOfCameras")));
					break;
					
				case "smartWatch":
					deviceStore.addDevice(new smartWatch(device.getString("brand"),
							 device.getString("serial_number"),
							 device.getString("color"),
							 device.getDouble("price"),
							 device.getString("dateOfPurchase"),
							 device.getInt("batteryLife")));
					
					break;
			}
		}
		
		deviceStore.printDevices();
		
		return null;
	}

	
}