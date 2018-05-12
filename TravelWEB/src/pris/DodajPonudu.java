package pris;

import java.io.IOException;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DodajPonudu
 */
@WebServlet("/DodajPonudu")
public class DodajPonudu extends HttpServlet {

	@EJB
	TravelBean tb;

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DodajPonudu() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cijena=request.getParameter("cena");
		int cena=Integer.parseInt(cijena);
		String trajanjeS=request.getParameter("trajanje");
		int trajanje=Integer.parseInt(trajanjeS);
		String brojSaputnika=request.getParameter("brojSaputnika");
		int brSap=Integer.parseInt(brojSaputnika);
		String nacinPutovanja=request.getParameter("nacinPutovanja");
		String opisSmestaja=request.getParameter("opisSmjestaja");
		String naziv=request.getParameter("naziv");
		int id=tb.idDestinacije(naziv);
		
		if (cijena.equals("")||trajanjeS.equals("")||brojSaputnika.equals("")||nacinPutovanja.equals("")||opisSmestaja.equals("")||nacinPutovanja.equals("")||naziv.equals("")){
			String poruka="Niste unijeli sva polja";
			request.setAttribute("poruka", poruka);
			request.getRequestDispatcher("dodajPonudu.jsp").forward(request, response);
		}else{
			tb.dodajSvojuPonudu(cena, trajanje,opisSmestaja,nacinPutovanja,brSap,id);
			String poruka="Uspjesno dodata ponuda";
			request.setAttribute("poruka", poruka);
			request.getRequestDispatcher("dodajPonudu.jsp").forward(request, response);
		}
	}

}
