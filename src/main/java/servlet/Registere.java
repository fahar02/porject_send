package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserManagement;
import dto.User;
@WebServlet("/register")
public class Registere extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{

		String name=req.getParameter("fname");
		long number=Long.parseLong(req.getParameter("pnumber"));
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		User user=new User();
		user.setName(name);
		user.setNumber(number);
		user.setEmail(email);
		user.setPassword(password);
		System.out.println(user.toString());
		UserManagement um=new UserManagement();
		User  userdb=um.saveUser(user);
		HttpSession session;
		if(userdb!=null)
		{
			 session=req.getSession();
			session.setAttribute("register","register successfully");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, res);
		}
		else 
		{
			session=req.getSession();
			session.setAttribute("register-fail","register fail successfully");
			RequestDispatcher dispatcher=req.getRequestDispatcher("register.jsp");
			dispatcher.include(req, res);
		}
		
	}

}
