
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		int i;

		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fComHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		LocalDateTime hoje = LocalDateTime.now();
		System.out.println("Today is " + hoje.format(fComHora) + "h");
		System.out.println();

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter with the date (DD/MM/YYYY): ");
		String diaCompleto = sc.next();

		int dia = Integer.parseInt(diaCompleto.substring(0, 2));
		int mes = Integer.parseInt(diaCompleto.substring(3, 5));
		int ano = Integer.parseInt(diaCompleto.substring(6));

		LocalDate dataParaBuscar = LocalDate.of(ano, mes, dia);
		LocalDateTime dataParaBuscarComHora = LocalDateTime.of(ano, mes, dia, 9, 0);

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
					Duration inter = Duration.between(hoje, dataParaBuscarComHora);
					System.out.print("Voce Trabalha em ");
					conversaoDeTempo((int) inter.toSeconds());
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

	public static void conversaoDeTempo(int s) {
		int d, h, m, sg;
		d = (s / 86400);
		h = (s % 86400) / 3600;
		m = ((s % 86400) % 3600) / 60;
		sg = ((s % 86400) % 3600) % 60;
		System.out.println(d + " dia(s) " + h + " hora(s) " + m + " minuto(s) " + sg + " segundo(s)");
	}
}
