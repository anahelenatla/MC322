package leite.lab05;
import java.util.Random;
import java.time.LocalDate;

public class Sinistro {	
	private final int id;
	private LocalDate data;
	private String endereco;
	private int numeroInteiroAleatorio_0_a_100;
	private Condutor condutor;
	private Seguro seguro;
	
	// construtor
	public Sinistro(int id , LocalDate data , String endereco, Seguradora seguradora, Veiculo veiculo, Condutor condutor, Seguro seguro) {
		
		this.id = random();
		this.data = data;
		this.endereco = endereco;
		this.condutor = condutor;
		this.seguro = seguro;
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
	
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	public Condutor getCondutor() {
		return condutor;
	}
	
	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}
	
	public Seguro getSeguro() {
		return seguro;
	}
	
	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}
	public String toString() {
		return "Sinistro: id = " + id + "\nData = " + data + "\nEndereço = " + endereco + "\nSeguro = " + seguro;
	}

}


