package leite.lab05;

import java.util.InputMismatchException;

import java.util.Date;
import java.util.ArrayList;
import java.time.LocalDate;

public class ClientePJ extends Cliente {
	private final String cnpj;
	private LocalDate dataFundacao;
	private int qtdeFuncionarios;
	private ArrayList<Frota> listaFrota;
	
	public ClientePJ(String nome, String endereco, String email, String cnpj, LocalDate dataFundacao, int qtdeFuncionarios, String telefone) {
		super(nome, telefone, endereco, email);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
		this.qtdeFuncionarios = qtdeFuncionarios;
		this.listaFrota = new ArrayList<>();	
	}

	public String getCnpj() {
		return cnpj;
	}
	
	public LocalDate getDataFundacao() {
		return dataFundacao;
	}
	
	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao= dataFundacao;
	}
	
	public int getQtdeFuncionarios() {
		return qtdeFuncionarios;
	}
	
	public void setQtdeFuncionarios(int qtdeFuncionarios) {
		this.qtdeFuncionarios = qtdeFuncionarios;
	}
	
	public ArrayList<Frota> getListaFrota(){
		return listaFrota;
	}
	public boolean cadastrarFrota(Frota frota) {
		return listaFrota.add(frota);
	}
	public boolean atualizarFrota(Frota frota, Veiculo veiculo, int adicionar, int deletarFrota) {
		if (adicionar == 1) {
			if (listaFrota.contains(frota)){
				frota.addVeiculo(veiculo);
				return true;
			} else {
				System.out.println("A frota não está cadastrada no sistema.");
				return false;
			}
		} else{
			if (deletarFrota == 1) {
				listaFrota.remove(frota);
				return true;
			} 
			frota.removeVeiculo(veiculo);
			return true;
		}
	}
	
	public ArrayList<Veiculo> getVeiculosPorFrota(String codeFrota){
		for (Frota frota: listaFrota) {
			if(frota.getCode().equals(codeFrota)) {
				return frota.getListaVeiculos();
			}
		}
		return new ArrayList<>(); // retorna lista vazia se a frota não for encontrada
	}
	
	  public static String imprimeCNPJ(String CNPJ) {
	// máscara do CNPJ: 99.999.999.9999-99
	    return(CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) + "." +
	      CNPJ.substring(5, 8) + "." + CNPJ.substring(8, 12) + "-" +
	      CNPJ.substring(12, 14));
	  }

	  public String toString() {
	        return super.toString() + "\nCNPJ: " + imprimeCNPJ(cnpj) + "\nData de fundação: " + dataFundacao;
	    }
	
}
