package pris;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import model.Destinacija;
import model.Komentar;
import model.Ocena;
import model.Ponuda;

@Remote
public interface TravelBeanRemote {
	public boolean registracija(String ime,String prezime,String email,String brojTelefona,String password,Date datumRodjenja);
	 public List<Destinacija> vratiDestinacije();
     public List<Destinacija> pretragaDestinacija(String drzava);
     public List<Destinacija> filtrirajPoBrojuPutnika ();
     public List<Destinacija> filtrirajPoDrzavi ();
     public List<Destinacija> filtrirajPoGradu ();
     public boolean login(String email, String password);
     public List<Ponuda> getPonude(int id);
     public List<Ocena> pregledOcena();
     public List<Komentar> pregledKomentara();
     public int idDestinacije(String naziv);
     public String nadjiKor(int id);
     public String nadjiDest(int idPonude);
    public List<Destinacija> getId();
    public Komentar ostaviKomentar(String tekst,int id);
 	public boolean dodajSvojuPonudu(int cena, int trajanje,String opisSmestaja,String nacinPutovanja,int brojSaputnika,int idDestinacije);
}
