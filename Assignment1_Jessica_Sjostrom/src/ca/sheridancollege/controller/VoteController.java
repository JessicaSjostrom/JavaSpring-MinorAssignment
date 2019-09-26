package ca.sheridancollege.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sheridancollege.dao.Dao;

/**
 * Servlet implementation class VoteController
 */
@WebServlet("/VoteController")
public class VoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("Vote.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao dao = new Dao();
	
		if (request.getParameter("vote") != null) {		
			int sin = Integer.parseInt(request.getParameter("sin"));
			if (dao.uniqueSIN(sin)) {
				String s = "The sin " + sin + " has not been registered";
				request.setAttribute("voteResult", s);
			} else if (dao.hasVoted(sin)) {
				String s = "The SIN " + sin + " has already voted";
				request.setAttribute("voteResult", s);
			} else {
				String s = "<a href='AddVote.jsp?sin="+sin+"'>Go Vote</a>";
				request.setAttribute("voteResult", s);
			}
		} 

		request.getRequestDispatcher("Vote.jsp").forward(request,response);
	}
}
