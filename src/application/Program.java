package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Anuncio;
import entities.Cliente;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		
		List<Anuncio> list = new ArrayList<>();
		
		System.out.println("Entre com os dados do Cliente:");
		System.out.print("Id do Cliente: ");
		Long idCliente = sc.nextLong();
		sc.nextLine();
		System.out.print("Nome do cliente: ");
		String nomeDocliente = sc.nextLine();
		
		Cliente cliente = new Cliente(idCliente, nomeDocliente);
		
		System.out.print("Quantos anuncios vai cadastrar? ");
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			System.out.println();
			System.out.println("Entre com os dados do Anuncio #" + (i+1) + ":");
			Long idAnuncio = (long) (i + 1);
			sc.nextLine();
			System.out.print("Nome do Anuncio: ");
			String nomeDoAnuncio = sc.nextLine();
			System.out.print("Data de Inicio: ");
			Date dataDeInicio = sdf.parse(sc.next());
			System.out.print("Data de Termino: ");
			Date dataDeTermino = sdf.parse(sc.next());
			System.out.print("Valor investimento diário (R$ 0.00): ");
			double valorInvestimentoDiario = sc.nextDouble();
			
			cliente.adicionaAnuncio(new Anuncio(idAnuncio, nomeDoAnuncio, dataDeInicio, dataDeTermino, valorInvestimentoDiario, cliente));
		
		}
		
		System.out.println();
		System.out.println(cliente);
		
		sc.close();

	}

}
