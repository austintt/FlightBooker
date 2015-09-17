package com.tooely;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataInteract {
	String dataSource = "jdbc:sqlite:/Users/Austin/Documents/workspace/FlightBooker/resource/db.db";
	
	public DataInteract()
	{
		//Place holder constructor, there are no actual member variables. 
		//This is basically a database adaptor containing functions for interacting with
		//the piano table
	}
	
	public List<Flight> flightDumpQuery()
	{
		Connection c = null;
		Statement stmt = null;
		try 
		{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection(dataSource);
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			List<Flight> flightData = new ArrayList<Flight>();

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM flights");
			
			while (rs.next()) 
			{
				int id     				= rs.getInt("id");
				int flight_num			= rs.getInt("flight_num");
				String flight_date		= rs.getString("flight_date");
				String departure_time   = rs.getString("departure_time");
				String arrival_time		= rs.getString("arrival_time");
				String origin			= rs.getString("origin");
				String destination		= rs.getString("destination");
				int seatsTotal			= rs.getInt("seats_total");
//				int numCustomers;
//				String remarks;

				System.out.println( "id = " + id );
				System.out.println( "flight_num = " + flight_num );
				System.out.println( "flight_date = " + flight_date );
				System.out.println( "depart = " + departure_time );
				System.out.println( "arrive = " + arrival_time );
				System.out.println( "origin = " + origin );
				System.out.println( "destination = " + destination );
				System.out.println( "seats = " + seatsTotal );
				      
				System.out.println();
				
				flightData.add(new Flight(id, flight_num, flight_date, departure_time,arrival_time,  origin, destination, seatsTotal));

			
			}
			rs.close();
			stmt.close();
			c.close();
			
			return flightData;
		} 
		catch (Exception e) 
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		System.out.println("Operation done successfully");
		return null;
	}
//	public static void main(String[] args) {
//		new DataInteract().flightDumpQuery();
//	} 
}
