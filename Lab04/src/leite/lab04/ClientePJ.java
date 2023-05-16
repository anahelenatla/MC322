package leite.lab04;

import java.util.InputMismatchException;
import java.util.Date;

public class ClientePJ extends Cliente {
	private final String cnpj;
	private Date dataFundacao;
	private int qtdeFuncionarios;
	
	public ClientePJ(String nome, String endereco, String cnpj, Date dataFundacao, int qtdeFuncionarios) {
		super(nome, endereco);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
		this.qtdeFuncionarios = qtdeFuncionarios;
	}

	public String getCnpj() {
		return cnpj;
	}
	
	public Date getDataFundacao() {
		return dataFundacao;
	}
	
	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao= dataFundacao;
	}
	
	public int getQtdeFuncionarios() {
		return qtdeFuncionarios;
	}
	
	public void setQtdeFuncionarios() {
		this.qtdeFuncionarios = qtdeFuncionarios;
	}
	
	public double calculaScore() {
		double valorBase = CalcSeguro.VALOR_BASE.getValor();
		double fatorFunc = 1 + qtdeFuncionarios / 100.0;
		return valorBase * fatorFunc * quantidadeVeiculos;
	}
	  
	
	  public static String imprimeCNPJ(String CNPJ) {
	// máscara do CNPJ: 99.999.999.9999-99
	    return(CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) + "." +
	      CNPJ.substring(5, 8) + "." + CNPJ.substring(8, 12) + "-" +
	      CNPJ.substring(12, 14));
	  }
	  /*
		 public static double calculaScore(){} 
	   */
	  public String toString() {
	        return super.toString() + "\nCNPJ: " + imprimeCNPJ(cnpj) + "\nData de fundação: " + dataFundacao;
	    }
	
}
