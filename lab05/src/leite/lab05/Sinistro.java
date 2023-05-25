package leite.lab05;
import java.util.Random;
public class Sinistro {	
	private int id;
	private String data;
	private String endereco;
	private int numeroInteiroAleatorio_0_a_100;
	private Seguradora seguradora;
	private Veiculo veiculo;
	private Cliente cliente;
	
	// construtor
	public Sinistro(int id , String data , String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
		
		this.id = random();
		this.data = data;
		this.endereco = endereco;
		this.seguradora = seguradora;
		this.veiculo = veiculo;
		this.cliente = cliente;
	}	
		
		// função geradora de identificadores (inteiro de 0 a 100)
		
	private int random() {
		Random rand = new Random();
		int upperbound = 100;
		int numeroInteiroAleatorio_0_a_100 = rand.nextInt(upperbound);			
		return numeroInteiroAleatorio_0_a_100;					
	}
	
		
		// getters e setters
	public int getId() {
			return id;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Seguradora getSeguradora() {
		return seguradora;
	}
	
	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente veiculo) {
		this.cliente = cliente;
	}
	
	public String toString() {
		return "Sinistro: id = " + id + "\nData = " + data + "\nEndereço = " + endereco;
	}

}


