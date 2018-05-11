package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the destinacija database table.
 * 
 */
@Entity
@NamedQuery(name="Destinacija.findAll", query="SELECT d FROM Destinacija d")
public class Destinacija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSlike;

	private int brojPutnika;

	private String drzava;

	private String grad;

	private int idDestinacije;

	@Lob
	private byte[] slika;

	public Destinacija() {
	}

	public int getIdSlike() {
		return this.idSlike;
	}

	public void setIdSlike(int idSlike) {
		this.idSlike = idSlike;
	}

	public int getBrojPutnika() {
		return this.brojPutnika;
	}

	public void setBrojPutnika(int brojPutnika) {
		this.brojPutnika = brojPutnika;
	}

	public String getDrzava() {
		return this.drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getGrad() {
		return this.grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public int getIdDestinacije() {
		return this.idDestinacije;
	}

	public void setIdDestinacije(int idDestinacije) {
		this.idDestinacije = idDestinacije;
	}

	public byte[] getSlika() {
		return this.slika;
	}

	public void setSlika(byte[] slika) {
		this.slika = slika;
	}

}