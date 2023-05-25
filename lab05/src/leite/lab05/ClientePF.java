package leite.lab05;

import java.time.LocalDate;

import java.util.InputMismatchException;
import java.util.Date;
import java.util.Calendar;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;

import java.util.ArrayList;
public class ClientePF extends Cliente {
	private final String cpf;
	private String genero;
	//private Date dataLicenca;
	private String educacao;
	private LocalDate dataNascimento;
	private ArrayList<Veiculo> listaVeiculos;
	//private String classeEconomica;
	
	//Construtor da classe ClientePF
	public ClientePF(String nome, String telefone, String endereco, String email, String cpf, String genero, String educacao, LocalDate dataNascimento) {
		super(nome, telefone, endereco, email);
		this.cpf = cpf;
		this.genero = genero;
		//this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.dataNascimento = dataNascimento;
		this.listaVeiculos = new ArrayList<>();
		//this.classeEconomica = classeEconomica;
	}
	
	//Getters e Setters
	
	public String getCpf() {
		return cpf;
	}
	

	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	
	public String getEducacao() {
		return educacao;
	}
	
	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public ArrayList<Veiculo> getListaVeiculos(){
		return listaVeiculos;
	}
	
	public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	
	/*
	public Date getDataLicenca() {
		return dataLicenca;
	}
	
	public void setDataLicenca(Date dataLicenca) {
		this.dataLicenca = dataLicenca;
	}
	public String getClasseEconomica() {
		return classeEconomica;
	}
	
	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}
	*/
	public int calcularIdade(LocalDate dataNascimento) {
	    LocalDate dataAtual = LocalDate.now();
	    if(dataNascimento != null) {
	    	Period periodo = Period.between(dataNascimento, dataAtual);
		    System.out.println(dataNascimento);
		    return periodo.getYears();
	    }else {
	    	return 0;
	    }
	    
		
	}
	int idade = calcularIdade(dataNascimento);
	/*
	public double calculaScore() {
	    double fatorIdade = 1.0;
	    
	    if (idade < 18 || idade > 90) {
	        // Pessoas com idade abaixo de 18 ou acima de 90 anos não são elegíveis para seguro
	        return 0.0;
	    } else if (idade < 30) {
	        fatorIdade = CalcSeguro.FATOR_18_30.getValor();
	    } else if (idade < 60) {
	        fatorIdade = CalcSeguro.FATOR_30_60.getValor();
	    } else {
	        fatorIdade = CalcSeguro.FATOR_60_90.getValor();
	    }
	    
	    return CalcSeguro.VALOR_BASE.getValor() * fatorIdade * quantidadeVeiculos;
	}
	*/
	public boolean cadastrarVeiculo(Veiculo veiculo) {
		return listaVeiculos.add(veiculo);
	}
	
	public boolean removerVeiculo(Veiculo veiculo) {
		return listaVeiculos.remove(veiculo);
	}
	
	
	public String toString() {
		return " Informações do cliente (PF):" +
                "\nCPF: " + cpf + 
                ",\nGênero: " + genero +                 
                ",\nEducacao: " + educacao + 
                ",\nData de nascimento: " + dataNascimento;
                /* +
                "\nVeículos do cliente: " ;
			for (Veiculo veiculo : listaVeiculos) {
				System.out.println("\n-" + veiculo.toString());
			}
                */    
   	}
	
}
