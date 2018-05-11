package pris;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UlogovaniKorisnikServlet
 */
@WebServlet("/UlogovaniKorisnikServlet")
public class UlogovaniKorisnikServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB TravelBeanRemote tbr;
    public UlogovaniKorisnikServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tip = request.getParameter("tip");
		if(tip.equals("pretraga")){ 
			request.getServletContext().getRequestDispatcher("pretragaDestinacija.jsp").forward(request, response);
			
		}else request.getServletContext().getRequestDispatcher("filtriraj.jsp").forward(request, response);
			
		}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
