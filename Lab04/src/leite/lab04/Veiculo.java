package leite.lab04;

import java.util.Scanner;

public class Veiculo {
	private String placa;
	private String marca;
	private String modelo;
	private int anoFabricacao;
	// construtor
	public Veiculo(String placa , String marca , String modelo, int anoFabricacao ) {
		this.placa = placa ;
		this.marca = marca ;
		this.modelo = modelo ;
		this.anoFabricacao = anoFabricacao;
	}

		// getters e setters
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getMarca() {
		return marca;
	}
	

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public int getAno() {
		return anoFabricacao;
	}
	
	public void setAno(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	
	public static Veiculo criaVeiculo() {
		System.out.println("Digite a placa do veiculo");
		Scanner p = new Scanner(System.in);
		String placa =  p.nextLine();
		p.close();
		System.out.println("Digite a marca do veiculo");
		Scanner mv = new Scanner(System.in);
		String marca =  mv.nextLine();
		mv.close();
		System.out.println("Digite o modelo do veiculo");
		Scanner mo = new Scanner(System.in);
		String modelo =  mo.nextLine();
		mo.close();
		System.out.println("Digite o ano de fabricacao do veiculo");
		Scanner af = new Scanner(System.in);
		int anoF =  af.nextInt();
		Veiculo veiculoCriado = new Veiculo(placa, marca, modelo, anoF);
		af.close();
		return veiculoCriado;
	}
	public String toString(){
	    return "Placa do veículo: " + this.placa + "\nMarca do veiculo: " + this.marca + "\nModelo do veículo: " + this.modelo + " \nAno de fabricação do veículo: " + this.anoFabricacao;
	}
	
}
