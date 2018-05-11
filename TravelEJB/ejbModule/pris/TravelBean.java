package pris;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Destinacija;
import model.Komentar;
import model.Korisnik;
import model.Ocena;
import model.Ponuda;

/**
 * Session Bean implementation class TravelBean
 */
@Stateless
@LocalBean
public class TravelBean implements TravelBeanRemote {

    /** 
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
	
	List<Destinacija> destinacije;
	List<Destinacija> dest;
	List<Ponuda> ponude;
	
    public TravelBean() {
        // TODO Auto-generated constructor stub
    }
    
    public boolean registracija(String ime,String prezime,String email,String brojTelefona,String password,Date datumRodjenja){
    	try{
    		Korisnik k=new Korisnik();
    		k.setIme(ime);
    		k.setPrezime(prezime);
    		k.setEmail(email);
    		k.setBrojTelefona(brojTelefona);
    		k.setPassword(password);
    		k.setDatumRodjenja(datumRodjenja);
    		em.persist(k);
    		return true;
    	}catch(Exception e){
    		e.printStackTrace();
    		return false;
    	}
    }
    
   
    public List<Destinacija> vratiDestinacije() {
		Query q = em.createQuery("SELECT d FROM Destinacija d");
		destinacije = q.getResultList();
		return destinacije;
	}
    
    public List<Destinacija> pretragaDestinacija(String drzava){
    	Query q=em.createQuery("SELECT d FROM Destinacija d WHERE d.drzava=:drzava");
    	q.setParameter("drzava", drzava);
    	dest=q.getResultList();
    	return dest;
    }
    public List<Destinacija> filtrirajPoBrojuPutnika (){
    	Query q=em.createQuery("SELECT d FROM Destinacija d ORDER BY brojPutnika");
    	dest=q.getResultList();
    	return dest;
    }
    public List<Destinacija> filtrirajPoDrzavi (){
    	Query q=em.createQuery("SELECT d FROM Destinacija d ORDER BY drzava");
    	dest=q.getResultList();
    	return dest;
    }
    public List<Destinacija> filtrirajPoGradu (){
    	Query q=em.createQuery("SELECT d FROM Destinacija d ORDER BY grad");
    	dest=q.getResultList();
    	return dest;
    }
    
    public boolean login(String email, String password) {
		try {
			Query q = em.createQuery("select k from Korisnik k where k.email=:email and k.password=:password");
			q.setParameter("email", email);
			q.setParameter("password", password);
			Korisnik user = (Korisnik)q.getSingleResult();
			if(user==null) return false;
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
    public List<Ponuda> getPonude(int id){
		Query q=em.createQuery("SELECT p FROM ponuda p where p.idDestinacije=:id");
		q.setParameter("id", id);
		ponude=q.getResultList();
		return ponude;
    	
    }
    
    
    public List<Destinacija> getId(){
    	Query q=em.createQuery("SELECT d FROM Destinacija d");
    	List<Destinacija> idd=q.getResultList();
    	return idd;
    }
    
    @Override
	public boolean dodajSvojuPonudu(int cena, int trajanje,String opisSmestaja,String nacinPutovanja,int brojSaputnika,int idDestinacije) {
		Ponuda p=new Ponuda();
		 Destinacija de=em.find(Destinacija.class, idDestinacije);
		try{
			p.setCena(cena);
			p.setTrajanje(trajanje);
			p.setBrojSaputnika(brojSaputnika);
			p.setNacinPutovanja(nacinPutovanja);
			p.setOpisSmestaja(opisSmestaja);
			p.setDestinacija(de);
			
			em.setFlushMode(FlushModeType.AUTO);
			em.persist(p);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
    
    @Override
	public List<Ocena> pregledOcena() {
		Query q=em.createQuery("SELECT o FROM Ocena o");
		List<Ocena> lista=q.getResultList();
		if (lista!=null){
			return lista;
		}else{
			return null;
		}
	}
    
    public Komentar ostaviKomentar(String tekst,int id){
    	try{
	    	Komentar k=new Komentar();
	    	k.setTekst(tekst);
	    	k.setIdPonude(id);
	    	em.persist(k);
	    	return k;
    	}catch(Exception e){
    		e.printStackTrace();
    		return null;
    	}
    	
    }
    
  
    
    @Override
	public List<Komentar> pregledKomentara(){
		Query q=em.createQuery("SELECT k FROM Komentar k");
		List<Komentar> lista=q.getResultList();
		if (lista!=null){
			return lista;
		}else{
			return null;
		}
	}
    @Override
    public int idDestinacije(String naziv){
    	Query q=em.createQuery("SELECT d FROM Destinacija d WHERE d.grad=:naziv");
    	q.setParameter("naziv", naziv);
    	Destinacija dest=(Destinacija) q.getSingleResult();
    	return dest.getIdDestinacije();
    }
    
    @Override
    public String nadjiDest(int idPonude){
    	Query q=em.createQuery("SELECT p FROM Ponuda p WHERE idponude=:idPonude");
    	q.setParameter("idPonude", idPonude);
    	Ponuda p=(Ponuda) q.getSingleResult();
    	Destinacija dest=p.getDestinacija();
    	return dest.getGrad();
    }
  
    
    
    @Override
    public String nadjiKor(int id){
    	Query q=em.createQuery("SELECT k FROM Korisnik k WHERE k.idkorisnik=:id");
    	q.setParameter("id", id);
    	Korisnik k=(Korisnik) q.getSingleResult();
    	return k.getIme()+" "+k.getPrezime();
    }

}
