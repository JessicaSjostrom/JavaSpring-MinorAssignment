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
 * Servlet implementation class StatsController
 */
@WebServlet("/StatsController")
public class StatsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("ViewStats.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao dao = new Dao();
		if (request.getParameter("stats") != null) {	
			DecimalFormat df = new DecimalFormat("###.#");
			double total = dao.getVoteList().size();
			double libs = dao.countL();
			double libsPer = (libs/total) * 100;
			request.setAttribute("libs", df.format(libsPer));
			double cons = dao.countC();
			double consPer = (cons/total) * 100;
			request.setAttribute("cons", df.format(consPer));
			double ndps = dao.countN();
			double ndpsPer = (ndps/total) * 100;
			request.setAttribute("ndps", df.format(ndpsPer));
			double greens = dao.countG();
			double greensPer = (greens/total) * 100;
			request.setAttribute("greens", df.format(greensPer));
			double blocs = dao.countB();
			double blocsPer = (blocs/total) * 100;
			request.setAttribute("blocs", df.format(blocsPer));
			
			double percentVoted = dao.percentVoted();
			request.setAttribute("percentVoted", df.format(percentVoted));
			
			int age18 = dao.getAge18();
			double age18Per = age18/total *100;
			int age30 = dao.getAge30();
			double age30Per = age30/total *100;
			int age45 = dao.getAge45();
			double age45Per = age45/total *100;
			int age60 = dao.getAge60();
			double age60Per = age60/total *100;
			request.setAttribute("yrs18", df.format(age18Per));
			request.setAttribute("yrs30", df.format(age30Per));
			request.setAttribute("yrs45", df.format(age45Per));
			request.setAttribute("yrs60", df.format(age60Per));
		} 

		request.getRequestDispatcher("ViewStats.jsp").forward(request,response);
	}

}
