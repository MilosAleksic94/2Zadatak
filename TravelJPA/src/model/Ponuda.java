package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ponuda database table.
 * 
 */
@Entity
@NamedQuery(name="Ponuda.findAll", query="SELECT p FROM Ponuda p")
public class Ponuda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idponude;

	private int brojSaputnika;

	private int cena;

	private String nacinPutovanja;

	private String opisSmestaja;

	private int trajanje;

	//bi-directional many-to-one association to Destinacija
	@ManyToOne
	@JoinColumn(name="idDestinacije")
	private Destinacija destinacija;

	public Ponuda() {
	}

	public int getIdponude() {
		return this.idponude;
	}

	public void setIdponude(int idponude) {
		this.idponude = idponude;
	}

	public int getBrojSaputnika() {
		return this.brojSaputnika;
	}

	public void setBrojSaputnika(int brojSaputnika) {
		this.brojSaputnika = brojSaputnika;
	}

	public int getCena() {
		return this.cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public String getNacinPutovanja() {
		return this.nacinPutovanja;
	}

	public void setNacinPutovanja(String nacinPutovanja) {
		this.nacinPutovanja = nacinPutovanja;
	}

	public String getOpisSmestaja() {
		return this.opisSmestaja;
	}

	public void setOpisSmestaja(String opisSmestaja) {
		this.opisSmestaja = opisSmestaja;
	}

	public int getTrajanje() {
		return this.trajanje;
	}

	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}

	public Destinacija getDestinacija() {
		return this.destinacija;
	}

	public void setDestinacija(Destinacija destinacija) {
		this.destinacija = destinacija;
	}

}