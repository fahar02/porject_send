package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dto.Home;
import dto.Material;
import dao.UserManagement;
import dto.Travel;
import dto.User;
@WebServlet("/totalcalculation")
public class TotalReduction extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{
		int id=Integer.parseInt(req.getParameter("id"));
		UserManagement userManagement=new UserManagement();
		User user=userManagement.fingUserId(id);
		List<Travel> travel=user.getTravel();
		List<Material> materail=user.getMaterail();
		List<Home> home=user.getHome();
		float reduction=0f;
		for(Travel t:travel) {
			reduction +=t.getReduce();
		}
		float generation1=0f;
		for(Material m:materail) {
			generation1 +=m.getEmition();
		}
		float generation2=0f;
		for(Home h:home) {
			generation2 +=h.getEmition();
		}
		float totalgeneration=generation1+generation2;
		req.setAttribute("generation", totalgeneration);
		req.setAttribute("reduce",reduction);
		req.setAttribute("user",user);
		RequestDispatcher dispatcher=req.getRequestDispatcher("myHistory.jsp");
		dispatcher.forward(req, res);
	}

}
