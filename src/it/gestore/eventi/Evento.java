package it.gestore.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento  implements Comparable<Evento>{

	//PROPRIETA': titolo, data, n' posti totali, n'posti prenotati
	private String titolo;
	private LocalDate data;
	private int numPostiTot;
	private int numPostiPreno;	

	//	private LocalDate localdate1 = LocalDate.now();

	//COSTRUTTORE
	public Evento(String titolo, LocalDate data, int postiTot) {

		this.titolo = titolo;	
		this.data = this.dataCorretta(data);  
		this.numPostiTot = this.numeroPostPositivo(postiTot);		
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

		if(data.isBefore(oggi)) {
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

		if(data.isBefore(oggi)) {
			System.out.println("Non è più possibile disdire la prenotazione");
		} else if (postiLiberi == numPostiTot) {   //controllare bene
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
		return "Hai creato un evento per il giorno " + this.dataFormattata() + " - " + this.getTitolo();
	}

	//IMPLEMENTARE IL METODO DELL'INTERFACCIA COMPARABLE
	@Override
	public int compareTo(Evento o) {
		return this.data.compareTo(o.data);
	}


	//METODI EVENTUALI	

	public int numeroPostPositivo (int num) {	

		if (num > 0) {
			return num;
		} else if(num < 0) {
			System.out.println("Il numero inserito è negativo!\nVerrà inserito il numero con valore positivo");
			return -(num);
		} System.out.println("Il numero inserito è pari a 0!\nVerrà inserito un numero di defaul di min 2 persone");
		return 2;

	}	


	public LocalDate dataCorretta (LocalDate data) {

		LocalDate oggi = LocalDate.now();
		if (!data.isBefore(oggi)) {
			return data;
		}	else {
			System.out.println("La data inserita non è corretta!\nVerrà inserita in automatico la data di domani");
			return data = LocalDate.now().plusDays(1);
		}


	}

	//creare metodo che restituisca una stringa formattata!
	public String dataFormattata () {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String dataFormattata = this.data.format(dateFormat);	
		return dataFormattata;
	}




	public void numeroPrenotazioni(int num) {  //=> considerare che un utente prenota + posti di quelli liberi disponibili

		System.out.println("\nAttendi un attimo...\nStiamo procedendo con la prenotazione...\n3...\n2...\n1...");
		int a = this.postiLiberi();
		if (num <= a) {
			for (int i = 0; i < num; i++) {
				this.prenotaEvento(this.getNumPostiPreno(), this.getData());
			} 
			System.out.println( "hai prenotato: " + num +" posti e restano ancora: "+ this.postiLiberi());	
		} else if (num > a) {
			System.out.println("Non è possibile procede con la prenotazione!\nI posti che vuole prenotare sono superiori ai posti liberi per l'evento");
		} else 
			System.out.println("Hai prenotato 0 posti.\nNon è possibile procedere con la prenotazione");	


	} 

	public void numeroDisdette(int num) {  

		System.out.println("\nAttendi un attimo...\nStiamo procedendo con la disdetta...\n3...\n2...\n1...");
		if (num <= this.numPostiPreno) {
			for (int i = 0; i < num; i++) {
				this.disdiciEvento(this.getNumPostiPreno(), this.getData());
			}  
			System.out.println( "hai disdetto: " + num +" posti e restano ancora: "+ this.postiLiberi());	
		} else if (num <= 0) { //minore zero
			System.out.println("Non è possibile procede con la disdetta!");
		} else 
			System.out.println("Non è possibile procede con la disdetta!");	

	} 

	public int postiLiberi() {
		int postiRimanenti = this.getNumPostiTot() - this.getNumPostiPreno();
		return postiRimanenti;
	}


	//fine classe
}
