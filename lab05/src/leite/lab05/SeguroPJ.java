package leite.lab05;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class SeguroPJ extends Seguro {
	private Frota frota;
	private ClientePJ cliente;
	private double valorAnual;
	private double valorMensal;
	private Seguradora seguradora;
	
	public SeguroPJ(int id, Seguradora seguradora, LocalDate dataInicio, LocalDate dataFim, Frota frota, ClientePJ cliente, double valorMensal) {
		super(seguradora, dataInicio, dataFim, valorMensal);
		this.frota = frota;
		this.cliente = cliente;
		this.valorAnual = this.calcularValor();
	}
	
	public Frota getFrota() {
		return frota;
	}
	public void setFrota (Frota frota) {
		this.frota = frota;
	}
	public ClientePJ getCliente() {
		return cliente;
	}
	public void setCliente (ClientePJ cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public boolean autorizarCondutor(Condutor condutor) {
		if(!getListaCondutores().contains(condutor)) {
			getListaCondutores().add(condutor);
			return true;
		}
		return false;
		
	}
	@Override
	public boolean desautorizarCondutor(Condutor condutor) {
		if(getListaCondutores().contains(condutor)) {
			getListaCondutores().remove(condutor);
			return true;
		}
		return false;
	}
	
	public int obterQtdeVeiculos() {
		int quantidadeTotal = 0;
		ArrayList<Frota> listaFrotas = cliente.getListaFrota();
		for (Frota frota : listaFrotas) {
			quantidadeTotal += frota.getListaVeiculos().size();
		}
		return quantidadeTotal;
	}
	
	public int calcularAnosPosFundacao() {
		LocalDate dataFund = cliente.getDataFundacao();
		LocalDate dataAtual = LocalDate.now();
		return Period.between(dataFund, dataAtual).getYears();
	}
	
	public int getNumeroSinistrosPorCliente() {
		Seguradora seguradora = this.seguradora;
		ArrayList<Sinistro> sinistrosPorCliente = seguradora.getSinistrosPorCliente(cliente.getNome());
		return sinistrosPorCliente.size();
	}
	public int getNumeroSinistrosPorCondutor() {
		int totalSinistros = 0;
		for (Condutor condutor : listaCondutores) {
			totalSinistros += condutor.getListaSinistros().size();
		}
		return totalSinistros;
	}
	int VALOR_BASE = 10;
	int qtdeFunc = this.cliente.getQtdeFuncionarios();
	int anosPosFundacao = this.calcularAnosPosFundacao();
	int qtdeVeiculos = this.obterQtdeVeiculos();
	int qtdeSinistrosCliente = this.getNumeroSinistrosPorCliente();
	int qtdeSinistrosCondutor = this.getNumeroSinistrosPorCondutor();
	@Override
	public double calcularValor() {
		double valorAnual = (VALOR_BASE * (10 + (qtdeFunc)/10) * 
				(1 + 1/(qtdeVeiculos + 2)) *
				(1 + 1/(anosPosFundacao + 2)) *
				(2 + qtdeSinistrosCliente/10) *
				(5 + qtdeSinistrosCondutor/10));
		System.out.println("O valor anual do seguro é R$" + valorAnual);
		return valorAnual;
	}



	@Override
	public boolean gerarSinistro(int id, LocalDate data, String endereco, Seguradora seguradora, Veiculo veiculo,
			Condutor condutor, Seguro seguro) {
		Sinistro novoSinistro = new Sinistro(0, data , endereco, seguradora, veiculo, condutor, this);

		return this.getListaSinistros().add(novoSinistro);
	}
	public double getValorMensal() {
		return (valorAnual/12);
	}
	public String toString() {
		return "Frota do seguro: " + this.frota.getCode() +
				"\nCliente responsável pelo seguro: " + this.cliente.getNome() + 
				"\nValor anual do seguro: " + this.valorAnual + 
				"\nValor mensal do seguro: " + this.getValorMensal() + 
				"\nNome da seguradora: " + this.seguradora.getNome();
	}
}
