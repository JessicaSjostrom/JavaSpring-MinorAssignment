package ca.sheridancollege.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sheridancollege.bean.Voter;
import ca.sheridancollege.dao.Dao;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("Register.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Dao dao = new Dao();
		
		if (request.getParameter("register") != null){
			int sin = Integer.parseInt(request.getParameter("sin"));
			String sin2 = request.getParameter("sin");
			String firstname = request.getParameter("fName"); 
			String lastname = request.getParameter("lName");
			String byear = request.getParameter("birthyear");
			String bmonth = request.getParameter("birthmon");
			String bdate = request.getParameter("birthdate");
			String birth = byear + bmonth + bdate;
			int bday = Integer.parseInt(birth);
			String address = request.getParameter("address");
			Voter v = new Voter(sin, firstname, lastname, bday, address, "NO");
			if (!dao.uniqueSIN(sin)) {
				String s = "This SIN is already registered";
				request.setAttribute("registerResult", s);
				request.setAttribute("registerSin", sin);
			} else if (sin2.length() != 9) {
				String s = "SIN must be 9 digits long";
				request.setAttribute("registerResult", s);
			} else if (!dao.validateAge(birth)) {
				String s = "You must be 18+ years old to vote";
				request.setAttribute("registerResult", s);
			} else {
				String s = "Registration successful";
				request.setAttribute("registerResult", s);
				dao.getVoterList().add(v);
				dao.addVoterObject(v);
			}
		} 
		
		request.getRequestDispatcher("Register.jsp").forward(request,response);
	}

}
