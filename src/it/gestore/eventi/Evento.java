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

	public void setData(LocalDate data) {
		this.data = data; 
	}

	public int getNumPostiTot() {
		return numPostiTot;
	}

	public int getNumPostiPreno() {
		return numPostiPreno;
	}
	
	
	
	//METODI PUBLIC : PRENOTA, DISDICI + TOSTRING (override)
	
	//METODI EVENTUALI PUBLIC E PRIVATE PER FARE FUNZIONARE TUTTO
	

}
