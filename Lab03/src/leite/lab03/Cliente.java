package leite.lab03;

import java.util.ArrayList;

public class Cliente{
	private String nome;
	private String endereco;		
	private ArrayList<Veiculo> listaVeiculos;
	
	
	
	
	// construtor
	public Cliente(String nome ,String endereco) {
		this.nome = nome;		
		this.endereco = endereco;		
		this.listaVeiculos = new ArrayList<>();
	}
	
	// getters e setters
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public ArrayList<Veiculo> getListaVeiculos(){
		return listaVeiculos;
	}
	
	public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	
	public void adicionarVeiculo(Veiculo veiculo) {
		listaVeiculos.add(veiculo);
	}
	public void printCliente() {
		System.out.println("Nome do cliente: " + this.nome);
		System.out.println("\nEndereco do cliente: " + this.endereco);
		System.out.println("\nVeículos do cliente: ");
		for (Veiculo veiculo : listaVeiculos) {
			System.out.println("\n-" + veiculo.toString());
		}
	}
	

}
