package view;

import lib.model.Fila;
import model.Cliente;
import controller.*;
import java.util.Scanner;

public class Principal
{
	public static void main(String[] args)
	{
		Fila<Cliente> fila = new Fila<>();
		Fila<Cliente> filaPrioritarios = new Fila<>();
		FilaController fc = new FilaController();
		Scanner s = new Scanner(System.in);
		String nome;
		int opt;

		while (true) {
			opt = menu(s);
			if (opt == 1) {
				System.out.println("Informe o nome do cliente: ");
				nome = s.nextLine();
				fc.inserirSenhaComum(fila, nome);
			}
			else if (opt == 2) {
				System.out.println("Informe o nome do cliente: ");
				nome = s.nextLine();
				fc.inserirSenhaPrioritaria(filaPrioritarios, nome);
			}
			else if (opt == 3) fc.chamarSenha(fila, filaPrioritarios);
			else if (opt == 4) fc.mostrarFilas(fila, filaPrioritarios);
			else if (opt == 9) break;
			else System.out.println("Opção inválida!");
		}
		System.out.println("Aplicação Encerrada!");
		s.close();
	}

	private static int menu(Scanner s)
	{
		String txt;
		int opt;

		System.out.print(
			"------------------------------------------------\n" +
			"Escolha uma opção:\n\n" +
			"1 - Inserir senha comum\n" + 
			"2 - Inserir senha prioritária\n" +
			"3 - Atender uma senha\n" +
			"4 - Listar Filas\n" +
			"9 - Sair\n\n" +
			"Opção desejada: "
		);
		txt = s.nextLine();
		System.out.println();
		try {
			opt = Integer.parseInt(txt);
		} catch (Exception e) {
			return 5;
		}
		return opt;

	}
}
