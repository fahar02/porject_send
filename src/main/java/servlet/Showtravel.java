package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import dto.Travel;
import dao.UserManagement;
import dto.User;
@WebServlet("/showtravel")
public class Showtravel extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{
		int id=Integer.parseInt(req.getParameter("id"));
		UserManagement userManagement=new UserManagement();
		User user=userManagement.fingUserId(id);
		req.setAttribute("user",user);
		RequestDispatcher dispatcher=req.getRequestDispatcher("travelSave.jsp");
		dispatcher.forward(req, res);
	}

}
