package ca.sheridancollege.controller;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sheridancollege.dao.Dao;

/**
 * Servlet implementation class VoterController
 */
@WebServlet("/VoterController")
public class VoterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("Index.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Dao dao = new Dao();
		if (request.getParameter("loadDummy") != null) {			
			dao.addDummyRecords();
		} 
		
		if (request.getParameter("loadDummyVotes") != null) {			
			dao.addDummyVotes();
		} 

		request.getRequestDispatcher("Index.jsp").forward(request,response);
	}

}
