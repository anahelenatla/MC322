package leite.lab05;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Cliente{
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	
	
	// construtor
	public Cliente(String nome, String telefone, String endereco, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
	}
	
	// getters e setters
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
	
	public String toString() {
		return "Nome do cliente: " + this.nome +
				"\nTelefone do cliente: " + this.telefone + 
               "\nEndereco do cliente: " + this.endereco +                 
               "\nE-mail do cliente: " + this.email;

	}
	
	public static Cliente criaCliente() {
		System.out.println("Cadastrar cliente PF ou PJ?");
		Scanner c = new Scanner(System.in);
		String tipoCliente =  c.nextLine();
		System.out.println("Voce escolheu cliente do tipo " + tipoCliente + ".");
		System.out.println("Digite o nome do cliente");
		Scanner nc = new Scanner(System.in);
		String nomeCliente =  nc.nextLine();
		System.out.println("Digite o endereco do cliente");
		Scanner e = new Scanner(System.in);
		String enderecoCliente =  e.nextLine();		
		System.out.println("Digite o email do cliente");
		Scanner em = new Scanner(System.in);
		String emailCliente =  em.nextLine();
		System.out.println("Digite o telefone do cliente");
		Scanner t = new Scanner(System.in);
		String telefoneCliente =  t.nextLine();			
		if (tipoCliente == "PF") {
			
			System.out.println("Digite o CPF do cliente:");
			Scanner cpf = new Scanner(System.in);
			String cpfDoCliente =  cpf.nextLine();
			System.out.println("Digite o genero do cliente:");
			Scanner g = new Scanner(System.in);
			String generoDoCliente =  g.nextLine();			
			System.out.println("Digite a escolaridade do cliente:");
			Scanner es = new Scanner(System.in);
			String escolaridadeDoCliente =  es.nextLine();
			System.out.println("Digite a data de nascimento do cliente (dd/mm/yyyy):");
			Scanner dn = new Scanner(System.in);
			String dataNascDoCliente =  dn.nextLine();
			
			DateTimeFormatter formatodn = DateTimeFormatter.ofPattern("dd/mm/yyyy");
			LocalDate dataN = LocalDate.parse(dataNascDoCliente, formatodn);
			ClientePF clientePF = new ClientePF(nomeCliente, telefoneCliente, enderecoCliente, emailCliente,  cpfDoCliente, generoDoCliente, escolaridadeDoCliente, dataN);
			
			if (Validacao.validarCPF(clientePF.getCpf())) {
				
				return clientePF;
			} else {
				System.out.println("CPF inválido.");
				return null;
			}
			
		}else {		
			System.out.println("Digite o CNPJ do cliente:");
			Scanner cnpj = new Scanner(System.in);
			String cnpjDoCliente =  cnpj.nextLine();
			System.out.println("Digite a data de fundacao do cliente (dd/mm/yyyy):");
			Scanner df = new Scanner(System.in);
			String dataFundDoCliente =  df.nextLine();
			DateTimeFormatter formatopj = DateTimeFormatter.ofPattern("dd/mm/yyyy");
			LocalDate dataF = LocalDate.parse(dataFundDoCliente, formatopj);
			
			System.out.println("Digite o numero de funcionarios do cliente:");
			Scanner func = new Scanner(System.in);
			int funcDoCliente =  func.nextInt();
			ClientePJ clientePJ = new ClientePJ(nomeCliente, enderecoCliente, emailCliente, cnpjDoCliente, dataF, funcDoCliente, telefoneCliente);
			if (Validacao.validarCNPJ(clientePJ.getCnpj())) {				
				return clientePJ;
			} else {
				System.out.println("CNPJ inválido.");
				return null;
			}
			
		}
	}
	
}
