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
import dto.User;
@WebServlet("/loginUser")
public class Login extends HttpServlet
{
protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
{

	String email=req.getParameter("email");
	String password=req.getParameter("password");
	System.out.println(email+" "+password);
	UserManagement um=new UserManagement();
	List<User> users=um.fingUser();
	User u=null;
	boolean flag=false;
	HttpSession session;
	for(User user:users)
	{
		if(user.getEmail()!=null && user.getEmail().equals(email))
		{
			flag=true;
			u=user;
			break;
		}
	}
	if(flag)
	{
		if( u.getPassword().equals(password))
		{
			 session=req.getSession();
			session.setAttribute("user",u);
			RequestDispatcher dispatcher=req.getRequestDispatcher("home.jsp");
			dispatcher.forward(req, res);
		}
	}
	else {

	     session=req.getSession();
		session.setAttribute("login-fail","invalid email or password");
		RequestDispatcher dispatcher=req.getRequestDispatcher("registration.jsp");
		dispatcher.include(req, res);
	}
}
}
