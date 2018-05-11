package pris;

import java.io.IOException;
//import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import model.Komentar;
//import model.Korisnik;
import model.Ocena;

/**
 * Servlet implementation class PregledOcenaKomentara
 */
@WebServlet("/PregledOcenaKomentara1")
public class PregledOcenaKomentara1 extends HttpServlet {
	
	@EJB
	TravelBean tb;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PregledOcenaKomentara1() {
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
		List<Ocena> ocene=tb.pregledOcena();
		/*List<Korisnik> listaKor1=new ArrayList<>();
		List<Korisnik> listaKor2=new ArrayList<>();
		for (int i=0;i<ocene.size();i++){
			Ocena o=ocene.get(i);
			Korisnik kor1=o.getKorisnik1();
			Korisnik kor2=o.getKorisnik2();
			
			listaKor1.add(kor1);
			listaKor2.add(kor2);
			
		}
		request.setAttribute("listaKor", listaKor1);
		request.setAttribute("listaKor", listaKor2);*/
		request.setAttribute("ocene", ocene);
		request.getRequestDispatcher("pregledOcenaKomentara3.jsp").forward(request, response);
	}

}
