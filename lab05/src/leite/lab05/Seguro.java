package leite.lab05;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public abstract class Seguro {
	private final int id;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	protected Seguradora seguradora;
	private ArrayList<Sinistro> listaSinistros;
	protected ArrayList<Condutor> listaCondutores;
	private double valorMensal;
	
	public Seguro(Seguradora seguradora, LocalDate dataInicio, LocalDate dataFim, double valorMensal) {
		this.id = gerarId();
		this.seguradora = seguradora;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.valorMensal = valorMensal;
		this.listaSinistros = new ArrayList<>();
		this.listaCondutores = new ArrayList<>();
	}

	public int getId() {
		return id;
	}
	
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public LocalDate getDataFim() {
		return dataFim;
	}
	
	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
	
	public ArrayList<Sinistro> getListaSinistros() {
		return listaSinistros;
	}
	
	public ArrayList<Condutor> getListaCondutores() {
		return listaCondutores;
	}
	
	public double getValorMensal() {
		return valorMensal;
	}
	
	public void setValorMensal(double valorMensal) {
		this.valorMensal = valorMensal;
	}
	
	public abstract boolean autorizarCondutor(Condutor condutor);
	
	public abstract boolean desautorizarCondutor(Condutor condutor);
	
	public abstract double calcularValor();
	
	public abstract boolean gerarSinistro(int id , LocalDate data , String endereco, Seguradora seguradora, Veiculo veiculo, Condutor condutor, Seguro seguro);
	
	public int gerarId() {
		Random random = new Random();
		return random.nextInt(1000);
	}
	
	public Sinistro getUltimoSinistro() {
		if(this.listaSinistros.isEmpty()) {
			return null;
		} else {
			return this.listaSinistros.get(this.listaSinistros.size() - 1);
		}
	}
	
	public String toString() {
		return "Id do seguro: " + this.id +
				"\nData de início do seguro: " + this.dataInicio + 
				"\nData final do seguro: " + this.dataFim + 
				"\nNome da seguradora: " + this.seguradora.getNome() + 
				"\nLista de sinistros do seguro: " + this.listaSinistros.size() + 
				"\nNúmero condutores do seguro: " + this.listaCondutores.size(); 
	}

	protected abstract Cliente getCliente();

}
