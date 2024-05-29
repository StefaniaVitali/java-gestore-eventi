package it.gestore.eventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

	public static void main(String [] args) {

		//inizializzazione scanner
		Scanner input = new Scanner(System.in);

		System.out.println("GESTORE DI EVENTI");
		System.out.println("Inserisci il tuo nome");
		String nomeUtente = input.nextLine();
		System.out.println("Ciao " + nomeUtente + "! Crea il tuo primo evento!");


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
		input.nextLine(); //=>devo mettere un input vuoto o non funziona il prossimo input.nextLine per le stringhe

		//ISTANZIARE  IL NUOVO EVENTO
		System.out.println("Attendi qualche secondo\nStiamo creando il tuo evento...\n3...\n2...\n1...");
		Evento evento1 = new Evento(nomeEvento1, dataEvento1, numeroPostiTotali);
		

		//PROVA METODO toString
		System.out.println(evento1.toString() + " num posti totali "+ evento1.getNumPostiTot());	

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
		System.out.println(nomeUtente +", cosa vuoi fare adesso?");
		System.out.println("Vuoi prenotare un evento?\n Scegli si o no");  

		String scelta = input.nextLine();

		if (scelta.equalsIgnoreCase("si")) {

			System.out.println("Per quale evento vuoi effettuare la prenotazione? ");
			System.out.println(" Scegli 1 per " + evento1.getTitolo() + " in data " + evento1.dataFormattata());
			System.out.println(" Scegli 2 per " + comicon.getTitolo() + " in data " + comicon.dataFormattata());
			System.out.println(" Scegli 3 per " + filmfestival.getTitolo() + " in data " + filmfestival.dataFormattata());
			System.out.println(" Scegli 4 per " + mostraArteContemporanea.getTitolo() + " in data " + mostraArteContemporanea.dataFormattata());

			String sceltaPreno = input.nextLine();	

			//la stampa dei posti prenotati e quelli disponibili è nel metodo numeroPrenotazioni
			switch (sceltaPreno) {
			case "1": 
				System.out.println("Quanti posti vuoi prenotare?");
				int numPreno = input.nextInt();		       	 
				evento1.numeroPrenotazioni(numPreno);
				evento1.postiLiberi();
				input.nextLine();		    	
				break;

			case "2": 
				System.out.println("Quanti posti vuoi prenotare?");
				int numPreno2 = input.nextInt();		       	 
				comicon.numeroPrenotazioni(numPreno2);
				comicon.postiLiberi();
				input.nextLine();		    	
				break;
			case "3": 
				System.out.println("Quanti posti vuoi prenotare?");
				int numPreno3 = input.nextInt();		       	 
				filmfestival.numeroPrenotazioni(numPreno3);
				filmfestival.postiLiberi();
				input.nextLine();	    	
				break;
			case "4": 
				System.out.println("Quanti posti vuoi prenotare?");
				int numPreno4 = input.nextInt();		       	 
				mostraArteContemporanea.numeroPrenotazioni(numPreno4);
				mostraArteContemporanea.postiLiberi();
				input.nextLine();
				break;
			default:  System.out.println("La scelta effettuata non è corretta!"); 
			}

		} else 
			System.out.println("non è possibile procedere con la prenotazione");


		//SCEGLIERE UN EVENTO ED EFFETTUARE UNA DISDETTA
		System.out.println(nomeUtente + " Vuoi disdire una prenotazione per un evento?\n Scegli si o no");  
		String scelta2 = input.nextLine();

		if (scelta2.equalsIgnoreCase("si")) {

			System.out.println("Per quale evento vuoi effettuare la disdetta? ");
			System.out.println(" Scegli 1 per " + evento1.getTitolo() + " in data " + evento1.dataFormattata());
			System.out.println(" Scegli 2 per " + comicon.getTitolo() + " in data " + comicon.dataFormattata());
			System.out.println(" Scegli 3 per " + filmfestival.getTitolo() + " in data " + filmfestival.dataFormattata());
			System.out.println(" Scegli 4 per " + mostraArteContemporanea.getTitolo() + " in data " + mostraArteContemporanea.dataFormattata());

			String sceltaDisdetta = input.nextLine();			

			//la stampa dei posti disdetti e quelli disponibili è nel metodo numeroDisdette
			switch (sceltaDisdetta) {
			case "1": 
				System.out.println("Quanti posti vuoi disdire?");
				int numDis = input.nextInt();		       	 
				evento1.numeroDisdette(numDis);
				evento1.postiLiberi();
				input.nextLine();	    	
				break;

			case "2": 
				System.out.println("Quanti posti vuoi disdire?");
				int numDis2 = input.nextInt();		       	 
				comicon.numeroDisdette(numDis2);
				comicon.postiLiberi();
				input.nextLine();		    	
				break;
			case "3": 
				System.out.println("Quanti posti vuoi disdire?");
				int numDis3 = input.nextInt();		       	 
				filmfestival.numeroDisdette(numDis3);
				filmfestival.postiLiberi();
				input.nextLine();	    	
				break;
			case "4": 
				System.out.println("Quanti posti vuoi disdire?");
				int numDis4 = input.nextInt();		       	 
				mostraArteContemporanea.numeroDisdette(numDis4);
				mostraArteContemporanea.postiLiberi();
				input.nextLine();
				break;
			default:  System.out.println("La scelta effettuata non è corretta!"); 
			}

		} else 
			System.out.println("Nessuna disdetta effettuata ");

		//CREARE EVENTO CONCERTO
		System.out.println("Stiamo creando un evento di tipo concerto...\nAttendi qualche secondo...\n3...\n2...\n1...");
		LocalDate dataEvento5 = LocalDate.of(2025, 7, 13);
		LocalTime orario = LocalTime.of(20, 30);
		Concerto FirenzeRockFestival = new Concerto("FirenzeRockFestival", dataEvento5, 3000, orario, 75.554f);

		//toString();
		System.out.println(FirenzeRockFestival.toString());


		/*
		 * ARRAYLIST PROGRAMMAEVENTI
		 */         

		System.out.println("\nPROGRAMMA EVENTI\n");
		//INIZIALIZZARE UN NUOVO PROGRAMMA EVENTI
		//Creazione di nuovi eventi:
		Evento nutellaParty = new Evento("NutellaParty", dataEvento4, 60);
		Evento spaghettataDiMezzanotte = new Evento("Spaghettata di Mezzanotte", dataEvento4, 20);
		Evento radunoMotociclisti = new Evento("Raduno Motociclisti", dataEvento2, 500);		
		ProgrammaEventi calendario2425= new ProgrammaEventi("Calendario2425"); 

		//TEST METODO ADDEVENTO
		calendario2425.addEvento(evento1);
		calendario2425.addEvento(comicon);
		calendario2425.addEvento(filmfestival);
		calendario2425.addEvento(mostraArteContemporanea);
		calendario2425.addEvento(FirenzeRockFestival);
		calendario2425.addEvento(nutellaParty);
		calendario2425.addEvento(spaghettataDiMezzanotte);
		calendario2425.addEvento(radunoMotociclisti);

		//    System.out.println(calendario2425.toString());


		//TEST METODO NUMEROEVENTI
		System.out.println("Quanti sono gli eventi in programma?");
		System.out.println("Il numero di eventi presenti nel programma "+ calendario2425.getTitolo() +" è di " + calendario2425.numeroEventi() + " eventi");

		//TEST METODO EVENTIPERDATA
		System.out.println("\nQuanti sono gli eventi in programma in data specifica(20/02/2025)?\n...");
		calendario2425.eventiPerData(dataEvento4);

		//TEST METODO EVENTIORDINATI PER DATA
		System.out.println("\nAttendi un attimo...\nStiamo compilando la lista degli eventi disponibili per data...\n3...\n2...\n1...");
		calendario2425.mostraListaPerData();

		//TEST METODO SVUOTALISTA
		System.out.println("\nAttendi un attimo...\nStiamo eliminando tutti gli eventi presenti nel programma...\n3...\n2...\n1...");
		calendario2425.svuotaLista();
		System.out.println("Il numero di eventi presenti nel programma "+ calendario2425.getTitolo() +" è di " + calendario2425.numeroEventi() + " eventi");




		//chiusura scanner
		input.close(); 
	}
}
