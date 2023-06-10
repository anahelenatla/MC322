package leite.lab05;

import java.time.LocalDate;
import java.util.ArrayList;

public class Condutor {
	private final String cpf;
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	private LocalDate dataNasc;
	private ArrayList<Sinistro> listaSinistros;
	
	public Condutor(String cpf, String nome, String telefone, String endereco, String email, LocalDate dataNasc) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		this.dataNasc = dataNasc;
		this.listaSinistros = new ArrayList<>();		

	}
	
	public String getCpf() {
		return cpf;
	}
		
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	

	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public LocalDate getDataNasc() {
		return dataNasc;
	}
	
	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	public ArrayList<Sinistro> getListaSinistros(){
		return listaSinistros;
	}
	
	public void adicionarSinistro(Sinistro sinistro) {
		listaSinistros.add(sinistro);
	}
	public String toString() {
	        return  "\nCPF do condutor: " + this.cpf + 
	        		"\nNome do condutor: " + this.nome + 
	        		"\nTelefone do condutor: " + this.telefone + 
	        		"\nEndereco do condutor: " + this.endereco + 
	        		"\nEmail do condutor: " + this.email + 
	        		"\nData de nascimento do condutor: " + this.dataNasc + 
	        		"\nNúmero de sinistros do condutor: " + this.listaSinistros.size();
	        		
	}
}
