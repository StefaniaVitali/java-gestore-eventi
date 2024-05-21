package it.gestore.eventi;

import java.time.LocalDate;

public class Evento {
	
	//PROPRIETA': titolo, data, n' posti totali, n'posti prenotati
	private String titolo;
	private LocalDate data;
	int numPostiTot;
	int numPostiPreno;	
	
	//COSTRUTTORE
	public Evento(String titolo, LocalDate data, int postiTot) {
		this.titolo = titolo;
		this.data = data;
		this.numPostiTot = postiTot;
		numPostiPreno = 0;
		
	}
	
	//GETTER SETTER (solo titolo e data in lettura e scrittura)

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(int anno, int mese, int giorno) {
		this.data = LocalDate.of(anno, mese, giorno); 
	}

	public int getNumPostiTot() {
		return numPostiTot;
	}

	public int getNumPostiPreno() {
		return numPostiPreno;
	}
	
	
	
	//METODI PUBLIC : PRENOTA, DISDICI + to.STRING (override)
	//PRENOTA
	//DISDICI
	//METODO TOSTRING
	
	@Override
	public String toString() {
		return "Hai prenotato per il giorno " 
	             + this.data.getDayOfMonth() + "-" + this.data.getMonthValue() + "-"  + this.data.getYear()
	             + " " + this.getTitolo();
	}
	
	
	//METODI EVENTUALI PUBLIC E PRIVATE PER FARE FUNZIONARE TUTTO
	

}
