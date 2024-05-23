package it.gestore.eventi;

import java.util.ArrayList;

public class ProgrammaEventi {
	
	String titolo;
	ArrayList <Evento> eventi;
	
	
	//COSTRUTTORE
	public ProgrammaEventi (String titolo) {
		this.eventi = new ArrayList<Evento>();
	}
	
	
    //GETTERE E SETTER
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public ArrayList<Evento> getEventi() {
		return eventi;
	}

	public void setEventi(ArrayList<Evento> eventi) {
		this.eventi = eventi;
	}
	
	
	/*
	 * METODI - FUNZIONI DI PROGRAMMA EVENTI:
	 */  
	
	
	//METODO PER AGGIUNGERE ALLA LISTA UN EVENTO
	public void addEvento (Evento evento) {
	   this.eventi.add(evento);
	}
	
	//METODO PER RESTITUIRE UNA LISTA CON TUTTI GLI EVENTI IN UNA CERTA DATA
	
	//METODO CHE RESTITUISCE  QUANTI EVENTI SONO PRESENTI NEL PROGRAMMA
	public int numeroEventi() {
		return eventi.size();
	}
	
	//METODO CHE SVUOTA LA LISTA DI EVENTI
	
	//METODO CHE RESTITUISCE  UNA STRINGA CHE MOSTRA EVENTI ORDINATI PER DATA - TITOLO

}
