package leite.lab05;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public abstract class Seguro {
	private final int id;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private Seguradora seguradora;
	private ArrayList<Sinistro> listaSinistros;
	private ArrayList<Condutor> listaCondutores;
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
	
	public void autorizarCondutor(Condutor condutor) {
		return listaCondutores.add(condutor);
	}
	
	public void desautorizarCondutor(Condutor condutor) {
		return listaCondutores.remove(condutor);
	}
	
	public abstract boolean calcularValor();
	
	public abstract boolean gerarSinistro(Sinistro sinistro);
	
	public int gerarId() {
		Random random = new Random();
		return random.nextInt(1000);
	}
	
}
