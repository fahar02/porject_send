package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserManagement;
import dto.Home;
import dto.User;

@WebServlet("/myHome")
public class MyHomeSaving extends HttpServlet
{
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{
		HttpSession session=req.getSession();
		 User user=(User)session.getAttribute("user");
		String applience=req.getParameter("homeAppliance");
		double duration=Double.parseDouble(req.getParameter("duration"));
		double consumption=Double.parseDouble(req.getParameter("consumption"));
		Date date = Calendar.getInstance().getTime();  
	     DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
	     String recordDate= dateFormat.format(date);
	     String note=req.getParameter("note");
	     Home  home=new Home();
	     UserManagement userManagement=new UserManagement();
	     home.setName(applience);
	     home.setDuration(duration);
	     home.setEmition(consumption);
	     home.setNote(note);
	     home.setUser(user);
	     home.setEmition(userManagement.calHome(applience,duration));
	     System.out.println(applience+" "+duration+" "+consumption+" "+recordDate+" "+note);
		 Home h=userManagement.saveHome(user,home);
		
		 if(h!=null)
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
