package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserManagement;
import dto.Home;
import dto.Material;
import dto.Travel;
import dto.User;
@WebServlet("/userhistory")
public class History extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{
		int id=Integer.parseInt(req.getParameter("id"));
		UserManagement userManagement=new UserManagement();
		User user=userManagement.fingUserId(id);
		req.setAttribute("user",user);
		   RequestDispatcher dispatcher=req.getRequestDispatcher("/myHistory.jsp");
		   dispatcher.forward(req, res);
		
		
	}

}
