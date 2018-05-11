package pris;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Komentar;

/**
 * Servlet implementation class PregledOcenaKomentara2
 */
@WebServlet("/PregledOcenaKomentara2")
public class PregledOcenaKomentara2 extends HttpServlet {
	
	@EJB
	TravelBean tb;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PregledOcenaKomentara2() {
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
		List<Komentar> kom=tb.pregledKomentara();
		String grad;
		for(int i=0;i<kom.size();i++){
			Komentar k=kom.get(i);
			int idPonude=k.getIdPonude();
			grad=tb.nadjiDest(idPonude);
			request.setAttribute("grad", grad);
		}
		
		request.setAttribute("komentari", kom);
		request.getRequestDispatcher("pregledOcenaKomentara2.jsp").forward(request, response);
	}

}
