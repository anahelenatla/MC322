package leite.lab05;

import java.time.LocalDate;
import java.util.ArrayList;

public class SeguroPF extends Seguro {
	private Veiculo veiculo;
	private ClientePF cliente;
	private double valorAnual;
	private double valorMensal;
	
	public SeguroPF(int id, LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, double valorMensal, ClientePF cliente) {
		super(seguradora, dataInicio, dataFim, valorMensal);
		this.veiculo = veiculo;
		this.cliente = cliente;
		this.valorAnual = calcularValor();
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public ClientePF getCliente() {
		return cliente;
	}
	
	public void setCliente(ClientePF cliente) {
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
	@Override
	public boolean gerarSinistro(int id, LocalDate data, String endereco, Seguradora seguradora, Veiculo veiculo,
			Condutor condutor, Seguro seguro) {
		Sinistro novoSinistro = new Sinistro(0, data , endereco, seguradora, veiculo, condutor, this);

		return this.getListaSinistros().add(novoSinistro);
	}
	
	public int obterQtdeVeiculos() {
		int quantidadeTotal = 0;
		for (Veiculo veiculo : cliente.getListaVeiculos()) {
			quantidadeTotal += cliente.getListaVeiculos().size();
		}
		return quantidadeTotal;
	}
	public int getNumeroSinistrosPorCliente() {
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
	public float retornaFatorIdade() {
		ClientePF cliente = this.cliente;
		int idade = cliente.calcularIdade();
		if(idade < 30) {
			return 1.25f;
		} else if (idade >= 30 && idade <= 60) {
			return 1.0f;
		} else {
			return 1.5f;
		}
	}
	
	

	
	@Override
	public double calcularValor() {
		int VALOR_BASE = 10;
		float FATOR_IDADE = retornaFatorIdade();
		int qtdeVeiculos = obterQtdeVeiculos();
		int qtdeSinistrosCliente = getNumeroSinistrosPorCliente();
		int qtdeSinistrosCondutor = getNumeroSinistrosPorCondutor();
		
		double valorAnual = (VALOR_BASE * FATOR_IDADE * (1 + 1/(qtdeVeiculos + 2)) * 
				(2 + qtdeSinistrosCliente/10) *
				(5 + qtdeSinistrosCondutor/10));
		System.out.println("O valor anual do seguro é R$" + valorAnual);
		return valorAnual;
	}
	public double getValorMensal() {
		return (valorAnual/12);
	}
	public String toString() {
		return 	"\nCliente responsável pelo seguro: " + cliente.getNome() + 
				"\nValor anual do seguro: " + valorAnual + 
				"\nValor mensal do seguro: " + getValorMensal() + 
				"\nNome da seguradora: " + seguradora.getNome();
	}
}
