package it.gestore.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	
	public static void main(String [] args) {
		
		System.out.println("Creaiamo un nuovo evento!");
		
		//inizializzazione scanner
		Scanner input = new Scanner(System.in);
		
		//creazione evento
		System.out.println("Scegli il nome dell'evento");
		String nomeEvento1 = input.nextLine();
		
		System.out.println("Scegli il giorno");
		int giornoEvento = input.nextInt();
		System.out.println("Scegli il mese");
		int meseEvento = input.nextInt();
		System.out.println("Scegli l'anno");
		int annoEvento = input.nextInt();
		
		LocalDate dataEvento1 = LocalDate.of(annoEvento, meseEvento, giornoEvento);
		
		System.out.println("Quanti sono i posti totali?");
		int numeroPostiTotali = input.nextInt();
		//input.nextLine();
		
		Evento evento1 = new Evento(nomeEvento1, dataEvento1, numeroPostiTotali);
		
		System.out.println("posti prima di disdette e prenotazioni " + evento1.getNumPostiPreno());
		System.out.println(evento1.toString());
	//	evento1.prenotaEvento(numeroPostiTotali, dataEvento1);
		evento1.prenotaEvento(numeroPostiTotali, dataEvento1);
		evento1.prenotaEvento(numeroPostiTotali, dataEvento1);
		
	//	System.out.println("evento prentotato posti prenotati " + evento1.prenotaEvento(numeroPostiTotali, dataEvento1));
		System.out.println("posti dopo le prenotazioni " + evento1.getNumPostiPreno());
		
		evento1.disdiciEvento(numeroPostiTotali, dataEvento1);
		System.out.println("posti dopo le prima disdetta " + evento1.getNumPostiPreno());
		evento1.disdiciEvento(numeroPostiTotali, dataEvento1);
		System.out.println(evento1.getNumPostiPreno());
		evento1.disdiciEvento(numeroPostiTotali, dataEvento1);
		System.out.println(evento1.getNumPostiPreno());
		
		//chiusura scanner
		input.close();
	}

}
