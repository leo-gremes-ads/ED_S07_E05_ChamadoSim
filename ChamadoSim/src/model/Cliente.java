package model;

public class Cliente
{
	private int numero;
	private String nome;

	public Cliente(String nome, int numero)
	{
		super();
		this.nome = nome;
		this.numero = numero;
	}

	@Override
	public String toString()
	{
		return this.nome + "(" + String.format("%03d", this.numero) +")";
	}
}