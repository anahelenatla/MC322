package Lab02;
import java.util.Random;
public class Sinistro{
		private int id;
		private String data;
		private String endereco;
		private int numeroInteiroAleatorio_0_a_100;
		
		// construtor
		public Sinistro(int id , String data , String endereco) {
			
			this.id = random();
			this.data = data;
			this.endereco = endereco;
		}	
		
		// função geradora de identificadores (inteiro de 0 a 100)
		
		private int random() {
			Random rand = new Random();
			int upperbound = 100;
			int numeroInteiroAleatorio_0_a_100 = rand.nextInt(upperbound);			
			return numeroInteiroAleatorio_0_a_100;					
		}
		@Override
		public String toString() {
			return "Sinistro: id = " + id + "\ndata = " + data + "\nendereco = " + endereco;
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

}
