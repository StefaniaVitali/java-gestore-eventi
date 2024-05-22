package it.gestore.eventi;

import java.time.LocalDate;
import java.time.LocalTime;

public class Concerto extends Evento {

	private LocalTime ora;
	private float prezzo;

	public Concerto(String titolo, LocalDate data, int postiTot, LocalTime ora, float prezzo) {
		super(titolo, data, postiTot);
		this.ora = ora;
		this.prezzo = prezzo;

	}


	//GETTER SETTER 
	public LocalTime getOra() {
		return ora;
	}

	public void setOra(int ora, int min) {
		this.ora = LocalTime.of(ora, min);
	}


	public float getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	//METODO TOSTRING
	@Override
	public String toString() {
		return super.toString() + " orario: " + this.getOra() + " prezzo: " + this.getPrezzo()+ String.format("%.2f", this.getPrezzo());

	}

}
