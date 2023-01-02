package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Data {

	public static void main(String[] args) {
		int i;

		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate hoje = LocalDate.now();
		System.out.println("Today is " + hoje.format(f));
		System.out.println();

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter with the date (DD MM YYYY): ");
		int dia = sc.nextInt();
		int mes = sc.nextInt();
		int ano = sc.nextInt();

		LocalDate dataParaBuscar = LocalDate.of(ano, mes, dia);

		// trabalho
		for (i = 0; i < 365; i = i + 2) {
			LocalDate inicioDaContagem = LocalDate.parse("2022-12-26");
			inicioDaContagem = inicioDaContagem.plusDays(i);

			String trab = inicioDaContagem.format(f);
			String buscar = dataParaBuscar.format(f);

			if (buscar.contentEquals(trab) == true) {
				if (buscar.contentEquals("01/01/2023") || buscar.contentEquals("25/12/2023")) {
					System.out.print("folga".toUpperCase());
					break;
				} else {
					System.out.print("trabalho".toUpperCase());
					break;
				}
			}

		}

		for (i = 1; i < 365; i = i + 2) {
			LocalDate inicioDaContagem = LocalDate.parse("2022-12-26");
			inicioDaContagem = inicioDaContagem.plusDays(i);

			String folga = inicioDaContagem.format(f);
			String buscar = dataParaBuscar.format(f);

			if (buscar.contentEquals(folga) == true) {
				System.out.print("folga".toUpperCase());
				break;
			}
		}
		sc.close();
	}
}
