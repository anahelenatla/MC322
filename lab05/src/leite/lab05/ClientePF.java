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
	private String educacao;
	private LocalDate dataNascimento;
	ArrayList<Veiculo> listaVeiculos;
	
	//Construtor da classe ClientePF
	public ClientePF(String nome, String telefone, String endereco, String email, String cpf, String genero, String educacao, LocalDate dataNascimento) {
		super(nome, telefone, endereco, email);
		this.cpf = cpf;
		this.genero = genero;
		this.educacao = educacao;
		this.dataNascimento = dataNascimento;
		this.listaVeiculos = new ArrayList<>();
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
	
	public int calcularIdade() {
		LocalDate dataNascimento = this.dataNascimento;
		if (dataNascimento == null){
			return 0;
		}
	    LocalDate dataAtual = LocalDate.now();
	    if(dataNascimento != null) {
	    	Period periodo = Period.between(dataNascimento, dataAtual);
		    System.out.println(dataNascimento);
		    return periodo.getYears();
	    }else {
	    	return 0;
	    }
	    
		
	}
	int idade = calcularIdade();
	public int getIdade() {
		return idade;
	}
	
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

   	}
	
}
