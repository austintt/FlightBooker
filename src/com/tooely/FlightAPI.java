package com.tooely;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class FlightAPI
 */
public class FlightAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out =  response.getWriter();
		String req = request.getParameter("type");
	
		//get cmd parameter
		String cmd = request.getParameter("command");
		System.out.println("We got a post request!");
		System.out.println(System.getProperty("user.dir"));

		//flight dump
		if (cmd.equals("getAllFlights")) 
		{
			DataInteract interact = new DataInteract();
			List<Flight> flights = interact.flightDumpQuery();
			out.println(new Gson().toJson(flights));
			//out.println("YAY!");
		}
		else if (cmd.equals("purchase")) 
		{
			DataInteract interact = new DataInteract();
			String first_name = request.getParameter("first_name");
			String last_name = request.getParameter("last_name");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
//			String flight_num = request.getParameter("flight_num");
			String cc_name = request.getParameter("cc_name");
			int cc_number = Integer.parseInt(request.getParameter("cc_number"));
			String cc_month = request.getParameter("cc_month");
			String cc_year = request.getParameter("cc_year");
			String cvv = request.getParameter("cvv");
			System.out.println("Attempting to make purchase order");
			
			interact.insertOrder(first_name, last_name, email, address, cc_name, cc_number, cc_month, cc_year, cvv);
		}
//		else if (cmd.equals("delete"))
//		{
//			DataInteract interact = new DataInteract();
//			int id = Integer.parseInt(request.getParameter("id"));
//			interact.deletePiano(id);
//		}
//		else if (cmd.equals("addEvent"))
//		{			
//			DataInteract interact = new DataInteract();
//			int id 		 	 = Integer.parseInt(request.getParameter("id"));
//			String service 	 = request.getParameter("service");
//			String date 	 = request.getParameter("date");
//			String user 	 = request.getParameter("user");
//			int temp 		 = Integer.parseInt(request.getParameter("temp"));
//			int humidity  	 = Integer.parseInt(request.getParameter("hum"));
//			String notes 	 = request.getParameter("notes");
//			returnData.println("event!!");
//			
//			interact.insertPianoServiceHistoryAbbreviated(id, date, service, notes, user, humidity, temp);
//		}
		else
		{
			out.println("Boo");
		}
	
	}

}
