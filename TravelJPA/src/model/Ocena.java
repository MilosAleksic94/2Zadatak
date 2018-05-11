package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ocena database table.
 * 
 */
@Entity
@NamedQuery(name="Ocena.findAll", query="SELECT o FROM Ocena o")
public class Ocena implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idocene;

	private int ocena;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="idKor1")
	private Korisnik korisnik1;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="idKor2")
	private Korisnik korisnik2;

	public Ocena() {
	}

	public int getIdocene() {
		return this.idocene;
	}

	public void setIdocene(int idocene) {
		this.idocene = idocene;
	}

	public int getOcena() {
		return this.ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public Korisnik getKorisnik1() {
		return this.korisnik1;
	}

	public void setKorisnik1(Korisnik korisnik1) {
		this.korisnik1 = korisnik1;
	}

	public Korisnik getKorisnik2() {
		return this.korisnik2;
	}

	public void setKorisnik2(Korisnik korisnik2) {
		this.korisnik2 = korisnik2;
	}

}