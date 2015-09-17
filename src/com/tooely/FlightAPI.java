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
		DataInteract interact = new DataInteract();
		PrintWriter out =  response.getWriter();
		String req = request.getParameter("type");
	
		//get cmd parameter
		String cmd = request.getParameter("command");
	

		//flight dump
		if (cmd.equals("getAllFlights")) 
		{
			List<Flight> flights = interact.flightDumpQuery();
			out.println(new Gson().toJson(flights));
			//out.println("YAY!");
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
