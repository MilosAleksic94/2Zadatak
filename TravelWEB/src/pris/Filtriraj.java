package pris;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Destinacija;

/**
 * Servlet implementation class Filtriraj
 */
@WebServlet("/Filtriraj")
public class Filtriraj extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB TravelBeanRemote tbr;
    public Filtriraj() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Destinacija> destinacije;
		String filter=request.getParameter("filter");
		if (filter.equals("BrojPutnika")){
			destinacije	=tbr.filtrirajPoBrojuPutnika();
		}else if (filter.equals("Drzava")){
			 destinacije=tbr.filtrirajPoDrzavi();
		}else{
			 destinacije=tbr.filtrirajPoGradu();
		}
		request.getSession().setAttribute("destinacije", destinacije);
		request.getRequestDispatcher("filtriraj.jsp").forward(request, response);
	}

}
