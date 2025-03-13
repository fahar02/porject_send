package servlet;

import java.io.IOException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.UserManagement;
import dto.Travel;
import dto.User;
@WebServlet("/mySavings")
public class MyGHGsaving extends HttpServlet
{
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{
 		HttpSession session=req.getSession();
		 User user=(User)session.getAttribute("user");
		double distance=Double.parseDouble(req.getParameter("distance"));
		String travelby=req.getParameter("travelMode");
		String insteadof=req.getParameter("travelInstead");
		Date date = Calendar.getInstance().getTime();  
	     DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
	     String recordDate= dateFormat.format(date);
	     String note=req.getParameter("note");
	     System.out.println(distance+" "+travelby+" "+insteadof+" "+recordDate+" "+note);
	     Travel travel=new Travel();
	     UserManagement userManagement=new UserManagement();
	     User u=userManagement.fingUserId(user.getUserId());
	     travel.setName("travel");
	     travel.setDistance(distance);
	     travel.setInsteadMode(insteadof);
	     travel.setPrefferedMode(travelby);
	     travel.setNote(note);
	     travel.setUser(user);
	     travel.setReduce(userManagement.calTravel(insteadof,travelby,distance));
	     Travel t=userManagement.saveTravle(u, travel);
	     if(t!=null)
	     {
	    	  req.setAttribute("user",user);
			   RequestDispatcher dispatcher=req.getRequestDispatcher("/home.jsp");
			   dispatcher.forward(req, res);
	     }
	     else 
		   {
			   RequestDispatcher dispatcher=req.getRequestDispatcher("myGHGSaving.jsp");
			   dispatcher.include(req, res);
			}
	}
}
