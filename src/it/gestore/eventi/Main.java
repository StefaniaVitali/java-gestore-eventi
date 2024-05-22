package it.gestore.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	
	public static void main(String [] args) {
		
		//inizializzazione scanner
		Scanner input = new Scanner(System.in);
		
		System.out.println("GESTORE DI EVENTI");
		System.out.println("Inserisci il tuo nome");
		String nomeUtente = input.nextLine();
		System.out.println("Ciao " + nomeUtente + " crea il tuo primo evento!");
		
		
		//CREAZIONE EVENTO NUOVO evento chiedere il nome
		System.out.println("Scegli il nome dell'evento");
		String nomeEvento1 = input.nextLine();
		
		//CREAZIONE evento chiedere giorno mese e anno + creazione nuova data
		System.out.println("Scegli il giorno");
		int giornoEvento = input.nextInt();
		System.out.println("Scegli il mese");
		int meseEvento = input.nextInt();
		System.out.println("Scegli l'anno");
		int annoEvento = input.nextInt();
		
		LocalDate dataEvento1 = LocalDate.of(annoEvento, meseEvento, giornoEvento);
		
		//CREAZIONE posti in totali
		System.out.println("Quanti sono i posti totali?");
		int numeroPostiTotali = input.nextInt();
		
		//ISTANZIARE  IL NUOVO EVENTO
		Evento evento1 = new Evento(nomeEvento1, dataEvento1, numeroPostiTotali);
		evento1.isCorretta(dataEvento1);
		
		//PROVA METODO toString
		System.out.println(evento1.toString());
		
		
		//EVENTI CREATI IN PRECEDENZA:
		//EVENTO: COMICON
		LocalDate dataEvento2 = LocalDate.of(2025,10,10);
		Evento comicon = new Evento("Comicon", dataEvento2, 500);
		//EVENTO: FILMFESTIVAL
	    LocalDate dataEvento3 = LocalDate.of(2024,6,30);
	    Evento filmfestival = new Evento("Filmfestival", dataEvento3, 500);
	    //EVENTO: MOSTRA ARTE CONTEMPORANEA
	  	LocalDate dataEvento4 = LocalDate.of(2025,2,20);
	  	Evento mostraArteContemporanea = new Evento("Mostra arte contemporanea", dataEvento4, 500);
	  	
	  	
	  	//SCEGLIERE UN EVENTO ED EFFETTUARE UNA PRENOTAZIONE
	  	System.out.println(nomeUtente + " Vuoi prenotare un evento? ");
	  	System.out.println(" Scegli 1 per " + evento1.getTitolo() + " in data " + dataEvento1.getDayOfMonth() + " " + dataEvento1.getMonth() + " "+ dataEvento1.getYear());
	  	System.out.println(" Scegli 2 per " + comicon.getTitolo() + " in data " + dataEvento2.getDayOfMonth() + " " + dataEvento2.getMonth() + " "+ dataEvento2.getYear());
	  	System.out.println(" Scegli 3 per " + filmfestival.getTitolo() + " in data " + dataEvento3.getDayOfMonth() + " " + dataEvento3.getMonth() + " "+ dataEvento3.getYear());
	  	System.out.println(" Scegli 4 per " + mostraArteContemporanea.getTitolo() + " in data " + dataEvento4.getDayOfMonth() + " " + dataEvento4.getMonth() + " "+ dataEvento4.getYear());
		
//		
//     //	System.out.println("posti prima di disdette e prenotazioni " + evento1.getNumPostiPreno());
//	//	evento1.prenotaEvento(numeroPostiTotali, dataEvento1);
//		evento1.prenotaEvento(numeroPostiTotali, dataEvento1);
//		evento1.prenotaEvento(numeroPostiTotali, dataEvento1);
//		
//	//	System.out.println("evento prentotato posti prenotati " + evento1.prenotaEvento(numeroPostiTotali, dataEvento1));
//		System.out.println("posti dopo le prenotazioni " + evento1.getNumPostiPreno());
//		
//		evento1.disdiciEvento(numeroPostiTotali, dataEvento1);
//		System.out.println("posti dopo le prima disdetta " + evento1.getNumPostiPreno());
//		evento1.disdiciEvento(numeroPostiTotali, dataEvento1);
//		System.out.println(evento1.getNumPostiPreno());
//		evento1.disdiciEvento(numeroPostiTotali, dataEvento1);
//		System.out.println(evento1.getNumPostiPreno());
//		
	//	Evento evento2 = new Evento("Musica", dataEvento2,10);
	//	System.out.println(evento2.isCorretta(dataEvento2));
		
	//	Evento evento3 = new Evento("Madre", dataEvento3,20);
	//	System.out.println(evento3.isCorretta(dataEvento3));
		
		
		
		
		//chiusura scanner
		input.close();
	}

}
