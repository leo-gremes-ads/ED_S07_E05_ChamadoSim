package controller;

import lib.model.Fila;
import model.Cliente;

public class FilaController
{
	private int cont;
	private int senhaComum;
	private int senhaPrioritaria;
	
	public FilaController()
	{
		super();
		this.cont = 0;
		this.senhaComum = 0;
		this.senhaPrioritaria = 0;
	}

	public void inserirSenhaComum(Fila<Cliente> comum, String nome)
	{
		if (this.senhaComum == 99) this.senhaComum = 0;
		else this.senhaComum++;
		Cliente cl = new Cliente(nome, this.senhaComum);
		comum.insert(cl);
		System.out.println("Inserido cliente " + cl.toString() + " na fila comum!");
		// try { 
		// 	comum.list();
		// } catch (Exception e) {
		// 	System.out.println("Fila comum vazia!");
		// }
	}

	public void inserirSenhaPrioritaria(Fila<Cliente> prior, String nome)
	{
		if (this.senhaPrioritaria == 99) this.senhaPrioritaria = 0;
		else this.senhaPrioritaria++;
		Cliente cl = new Cliente(nome, this.senhaPrioritaria);
		prior.insert(cl);
		System.out.println("Inserido cliente " + cl.toString() + " na fila prioritária!");
		// try { 
		// 	prior.list();
		// } catch (Exception e) {
		// 	System.out.println("Fila prior vazia!");
		// }
	}

	public void chamarSenha(Fila<Cliente> com, Fila<Cliente> pri)
	{
		try {
			if (!pri.isEmpty() && cont < 3) {
				cont++;
				Cliente cl = pri.remove();
				System.out.println("Chamando cliente Prioritário " + cl.toString());
			} else if (!com.isEmpty()) {
				cont = 0;
				Cliente cl = com.remove();
				System.out.println("Chamando cliente " + cl.toString());
			} else {
				System.out.println("Não há clientes na fila!");
			}
		} catch (Exception e) {
			System.out.println("Não há clientes na fila!");
		}
	}

	public void mostrarFilas(Fila<Cliente> com, Fila<Cliente> pri)
	{
		Fila<Cliente> aux = new Fila<>();
		Fila<Cliente> aux2 = new Fila<>();
		Cliente cl;
		
		try {
			while (!com.isEmpty()) {
				cl = com.remove();
				aux.insert(cl);
				aux2.insert(cl);
			}
			while (!aux.isEmpty())
				com.insert(aux.remove());
			System.out.print("Fila comum: ");
			while (!aux2.isEmpty())
				System.out.print(aux2.remove().toString() + " -> ");
			System.out.println("Fim!");
			while (!pri.isEmpty()) {
				cl = pri.remove();
				aux.insert(cl);
				aux2.insert(cl);
			}
			while (!aux.isEmpty())
				pri.insert(aux.remove());
			System.out.print("Fila Prioritária: ");
			while (!aux2.isEmpty())
				System.out.print(aux2.remove().toString() + " -> ");
			System.out.println("Fim!");
		} catch (Exception e) {
			System.out.println("Não há ninguém na fila!");
		}
	}
}