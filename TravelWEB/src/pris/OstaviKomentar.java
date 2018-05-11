package pris;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Komentar;

/**
 * Servlet implementation class OstaviKomentar
 */

	
@WebServlet("/OstaviKomentar")
public class OstaviKomentar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB TravelBeanRemote tbr;
    public OstaviKomentar() {
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
		String tekst=request.getParameter("tekst");
		String idS=request.getParameter("id");
		int id=Integer.parseInt(idS);
		
		
		Komentar postavi=tbr.ostaviKomentar(tekst, id);
		String poruka="";
		if(postavi!=null){
			poruka="Uspesno";
		}else{
			poruka="Greska";
		}
		
		request.getSession().setAttribute("poruka", poruka);
		request.getRequestDispatcher("komentar.jsp").forward(request, response);
	}

}
