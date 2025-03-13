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
import dto.Material;
import dto.User;
@WebServlet("/materail")
public class MyMaterailSaving extends HttpServlet
{
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{
		HttpSession session=req.getSession();
		 User user=(User)session.getAttribute("user");
		String materials=req.getParameter("materials");
		double duration=Double.parseDouble(req.getParameter("duration"));
		double consumption=Double.parseDouble(req.getParameter("consumption"));
		String note=req.getParameter("note");
		Date date = Calendar.getInstance().getTime();  
	     DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
	     String recordDate= dateFormat.format(date);
	     Material material=new Material();
	     UserManagement userManagement=new UserManagement();
	     material.setName(materials);
	     material.setUnite(consumption);
	     material.setEmition(consumption);
	     material.setNote(note);
	     material.setUser(user);
	     material.setEmition(userManagement.calMaterail(materials,consumption));
	     System.out.println(materials+" "+duration+" "+consumption+" "+recordDate+" "+note);
	     
	     Material m=userManagement.saveMaterail(user, material);
	    
	     if(m!=null)
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
