package it.gestore.eventi;

import java.time.LocalDate;

public class Evento {
	
	//PROPRIETA': titolo, data, n' posti totali, n'posti prenotati
	private String titolo;
	private LocalDate data;
	private int numPostiTot;
	private int numPostiPreno;	
	
//	private LocalDate localdate1 = LocalDate.now();
	
	//COSTRUTTORE
	public Evento(String titolo, LocalDate data, int postiTot) {
		this.titolo = titolo;
		if(!this.isCorretta(data)) {
			this.data = data;	
		   } else System.out.println("non è possibile creare correttamente l'evento: la data è passata, \n "
		   		                     + "la data inserita di default sarà quella di oggi ");
		   this.data = LocalDate.now();//inizializzare una data tipo oggi di default
		if(!this.isPositivo(this.numPostiTot)) {
			this.numPostiTot = postiTot;	
		   } else System.out.println("non è possibile creare correttamente l'evento: il numero inserito è negativo");
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
	public int prenotaEvento(int postiPrenotati , LocalDate data ) {
		
		LocalDate oggi = LocalDate.now();			
		postiPrenotati = this.numPostiPreno;
		int  postiLiberi = this.numPostiTot - postiPrenotati;
		
		if(oggi.isBefore(data)) {
			System.out.println("La data che hai scelto non è corretta");
		} else if (postiLiberi == 0) {
		    System.out.println("non ci sono più posti disponibili");
		} else			
		   postiPrenotati = postiPrenotati + 1;
		   postiLiberi = this.numPostiTot - postiPrenotati;
		  this.numPostiPreno = postiPrenotati;
		  return postiPrenotati;
	}
	//DISDICI
	
	public int disdiciEvento(int postiPrenotati , LocalDate data ) {
		
		LocalDate oggi = LocalDate.now();			
		postiPrenotati = this.numPostiPreno;
		int  postiLiberi = this.numPostiTot - postiPrenotati;
		
		if(oggi.isBefore(data)) {
			System.out.println("Non è più possibile disdire la prenotazione");
		} else if (postiLiberi == this.numPostiTot || postiPrenotati == 0) {
		    System.out.println("non è possibile disdire");
		} else			
		   postiPrenotati = postiPrenotati - 1;
		   postiLiberi = this.numPostiTot + postiPrenotati;
		  this.numPostiPreno = postiPrenotati;
		  return postiPrenotati;
	}

	
	//METODO TOSTRING
	@Override
	public String toString() {
		return "Hai creato un evento per il giorno " 
	             + this.data.getDayOfMonth() + "-" + this.data.getMonthValue() + "-"  + this.data.getYear()
	             + " - " + this.getTitolo();
	}
	
	
	//METODI EVENTUALI	
	
	//METODO NUMERO POSITIVO
	public boolean isPositivo (int num) {	
		
		if (num <= 0) {
			return false;
		} 		
		return true;		
	}	
	
	public boolean isCorretta (LocalDate data) {
		
		LocalDate oggi = LocalDate.now();
		if (oggi.isBefore(data)) {
			return false;
		}		
		return true;
				
	}
	
	public void numeroPrenotazioni(int num) {
		for (int i = 0; i < num; i++) {
			this.prenotaEvento(this.getNumPostiPreno(), this.getData());
		}
	} 
	
	public void numeroDisdette(int num) {
		for (int i = 0; i < num; i++) {
			this.disdiciEvento(this.getNumPostiPreno(), this.getData());
		}
	} 
	
	public int postiLiberi() {
		int postiRimanenti = this.getNumPostiTot() - this.getNumPostiPreno();
		return postiRimanenti;
	}
	

//fine classe
}
