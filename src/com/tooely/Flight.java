package com.tooely;

public class Flight {
	int id;
	int flight_num;
	String flight_date;
	String departure_time;
	String arrival_time;
	String origin;
	String destination;
	int seats_total;
//	int numCustomers;
//	String remarks;
	
	
	public Flight(int id, int flight_num, String flight_date,
			String departure_time, String arrival_time, String origin,
			String destination, int seats_total) {
		super();
		this.id = id;
		this.flight_num = flight_num;
		this.flight_date = flight_date;
		this.departure_time = departure_time;
		this.arrival_time = arrival_time;
		this.origin = origin;
		this.destination = destination;
		this.seats_total = seats_total;
//		this.numCustomers = numCustomers;
//		this.remarks = remarks;
	}
	
	
}
