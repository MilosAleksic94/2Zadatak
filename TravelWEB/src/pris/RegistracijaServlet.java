package pris;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistracijaServlet
 */
@WebServlet("/RegistracijaServlet")
public class RegistracijaServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
	@EJB TravelBeanRemote tbr;
    /**  
     * @see HttpServlet#HttpServlet()
     */
    public RegistracijaServlet() {
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
		String ime=request.getParameter("ime");
		String prezime=request.getParameter("prezime");
		String email=request.getParameter("email");
		String brTelefona=request.getParameter("brTelefona");
		String password=request.getParameter("password");
		String datumRodjenjaS=request.getParameter("datumRodjenja");
		Date datumRodjenja=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			datumRodjenja=sdf.parse(datumRodjenjaS);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean registracija=tbr.registracija(ime, prezime, email, brTelefona,password,datumRodjenja);
		String poruka="";
		if(registracija){
			poruka="Success";
			request.setAttribute("poruka",poruka);
			request.getRequestDispatcher("registracija.jsp").forward(request, response);
			
			
			
		}
	}

}
