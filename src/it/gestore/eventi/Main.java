package it.gestore.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	
	public static void main(String [] args) {
		
		System.out.println("Creaiamo un nuovo evento!");
		
		//inizializzazione scanner
		Scanner input = new Scanner(System.in);
		
		System.out.println("Scegli il nome dell'evento");
		String nomeEvento1 = input.nextLine();
		
		System.out.println("Scegli il giorno");
		int giornoEvento = input.nextInt();
		System.out.println("Scegli il mese");
		int meseEvento = input.nextInt();
		System.out.println("Scegli il giorno");
		int annoEvento = input.nextInt();
		
		LocalDate dataEvento1 = LocalDate.of(annoEvento, meseEvento, giornoEvento);
		
		System.out.println("Quanti sono i posti totali?");
		int numeroPostiTotali = input.nextInt();
		//input.nextLine();
		
		Evento evento1 = new Evento(nomeEvento1, dataEvento1, numeroPostiTotali);
		
		
		System.out.println(evento1.toString());
		
		
		//chiusura scanner
		input.close();
	}

}
