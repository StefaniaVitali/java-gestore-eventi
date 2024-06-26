package it.gestore.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ProgrammaEventi {

	private String titolo;
	private List <Evento> eventi;


	//COSTRUTTORE
	public ProgrammaEventi (String titolo) {
		this.titolo= titolo;
		this.eventi = new ArrayList<Evento>();
	}


	//GETTERE E SETTER
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Evento> getEventi() {
		return eventi;
	}


	public void setEventi(List<Evento> eventi) {
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
	public void eventiPerData(LocalDate data) {

		boolean trovato = true;

		for(int i = 0; i < this.eventi.size(); i++) {			
			String nomeEvento = this.eventi.get(i).getTitolo();
			LocalDate data1 = this.eventi.get(i).getData();
			if(data1.isEqual(data)) {
				trovato = true;
				System.out.println(nomeEvento);
			}          			
		}	

		if(!trovato) {
			System.out.println("Non abbiamo trovato nessun evento presente in questa data");			
		}

	}
	//METODO CHE RESTITUISCE  QUANTI EVENTI SONO PRESENTI NEL PROGRAMMA
	public int numeroEventi() {
		return this.eventi.size();
	}

	//METODO CHE SVUOTA LA LISTA DI EVENTI
	public void svuotaLista() {
		this.eventi.clear();
	}

	//METODO CHE RESTITUISCE  UNA STRINGA CHE MOSTRA EVENTI ORDINATI PER DATA - TITOLO
	public void mostraListaPerData () {
		Collections.sort(eventi);
		Iterator<Evento> it = this.eventi.iterator();
		while(it.hasNext()) {
			Evento current = it.next();
			System.out.println(current.dataFormattata() +" - "+ current.getTitolo());
		}
		

	}
	






}
