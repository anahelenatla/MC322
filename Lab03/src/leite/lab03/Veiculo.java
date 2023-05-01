package leite.lab03;

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
	public String toString(){
	    return "Placa do veículo: " + this.placa + "\nMarca do veiculo: " + this.marca + "\nModelo do veículo: " + this.modelo + " \nAno de fabricação do veículo: " + this.anoFabricacao;
	}

}
