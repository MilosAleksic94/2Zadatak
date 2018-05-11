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
 * Servlet implementation class PretragaRegistrovani
 */
@WebServlet("/PretragaRegistrovani")
public class PretragaRegistrovani extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB TravelBeanRemote tbr;
    public PretragaRegistrovani() {
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
		String drzava=request.getParameter("drzava");
		List<Destinacija> destinacije=tbr.pretragaDestinacija(drzava);
		request.getSession().setAttribute("destinacije", destinacije);
		request.getRequestDispatcher("pretragaDestinacija.jsp").forward(request, response);
	}

}
