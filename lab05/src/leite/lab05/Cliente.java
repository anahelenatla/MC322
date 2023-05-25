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
	//protected static ArrayList<Veiculo> listaVeiculos;
	//private double valorSeguro;
	
	
	
	
	// construtor
	public Cliente(String nome, String telefone, String endereco, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		//this.listaVeiculos = new ArrayList<>();
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
	
	
	
	
	/*
	public ArrayList<Veiculo> getListaVeiculos(){
		return listaVeiculos;
	}
	
	public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	
	public double getValorSeguro() {
		return valorSeguro;
	}
	
	public void setValorSeguro(double valorSeguro) {
		this.valorSeguro = valorSeguro;
	}
	
	public void adicionarVeiculo(Veiculo veiculo) {
		this.listaVeiculos.add(veiculo);
		System.out.println("Veículo adicionado.");
	}
	public static void removerVeiculo(Veiculo veiculo) {
		listaVeiculos.remove(veiculo);
	}
	public int calculaQuantidadeVeiculos(ArrayList<Veiculo> listaVeiculos) {
		if(listaVeiculos != null) {
			return listaVeiculos.size();
		}
		return 0;
	}
	int quantidadeVeiculos = calculaQuantidadeVeiculos(listaVeiculos);
	
	public double calculaScore() {
		double valorBase = CalcSeguro.VALOR_BASE.getValor();
		return valorBase * quantidadeVeiculos;
	}
	public static Cliente criaCliente() {
		System.out.println("Cadastrar cliente PF ou PJ?");
		Scanner c = new Scanner(System.in);
		String tipoCliente =  c.nextLine();
		System.out.println("Voce escolheu cliente do tipo " + tipoCliente + ".");
		if (tipoCliente == "PF") {
			System.out.println("Digite o nome do cliente");
			Scanner nc = new Scanner(System.in);
			String nomeCliente =  nc.nextLine();
			System.out.println("Digite o endereco do cliente");
			Scanner e = new Scanner(System.in);
			String enderecoCliente =  e.nextLine();			
			System.out.println("Digite o CPF do cliente:");
			Scanner cpf = new Scanner(System.in);
			String cpfDoCliente =  cpf.nextLine();
			System.out.println("Digite o genero do cliente:");
			Scanner g = new Scanner(System.in);
			String generoDoCliente =  g.nextLine();
			System.out.println("Digite a data de licença do cliente (dd/mm/yyyy):");
			Scanner dl = new Scanner(System.in);
			String dataLicencaDoCliente =  dl.nextLine();
			SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
			Date dataL = null;
			try {
				dataL = formato.parse(dataLicencaDoCliente);				
			} catch (Exception e1) {
				System.out.println("Data inválida.");

			}
			
			
			System.out.println("Digite a escolaridade do cliente:");
			Scanner es = new Scanner(System.in);
			String escolaridadeDoCliente =  es.nextLine();
			System.out.println("Digite a data de nascimento do cliente (dd/mm/yyyy):");
			Scanner dn = new Scanner(System.in);
			String dataNascDoCliente =  dn.nextLine();
			
			DateTimeFormatter formatodn = DateTimeFormatter.ofPattern("dd/mm/yyyy");
			LocalDate dataN = LocalDate.parse(dataNascDoCliente, formatodn);
			
			
			System.out.println("Digite a classe economica do cliente:");
			Scanner ce = new Scanner(System.in);
			String classeEcDoCliente =  ce.nextLine();
			ClientePF clientePF = new ClientePF(nomeCliente, enderecoCliente, cpfDoCliente, generoDoCliente, dataL, escolaridadeDoCliente, dataN, classeEcDoCliente);
			
			if (Validacao.validarCPF(clientePF.getCpf())) {
				
				return clientePF;
			} else {
				System.out.println("CPF inválido.");
				return null;
			}
			
		}else {
			System.out.println("Digite o nome do cliente");
			Scanner ncpj = new Scanner(System.in);
			String nomeClientePJ =  ncpj.nextLine();
			System.out.println("Digite o endereco do cliente");
			Scanner epj = new Scanner(System.in);
			String enderecoClientePJ =  epj.nextLine();			
			System.out.println("Digite o CNPJ do cliente:");
			Scanner cnpj = new Scanner(System.in);
			String cnpjDoCliente =  cnpj.nextLine();
			System.out.println("Digite a data de fundacao do cliente (dd/mm/yyyy):");
			Scanner df = new Scanner(System.in);
			String dataFundDoCliente =  df.nextLine();
			SimpleDateFormat formatopj = new SimpleDateFormat("dd/mm/yyyy");
			Date dataF = null;
			try {
				dataF = formatopj.parse(dataFundDoCliente);			
			} catch (Exception e3) {
				System.out.println("Data inválida.");

			}
			
			System.out.println("Digite o numero de funcionarios do cliente:");
			Scanner func = new Scanner(System.in);
			int funcDoCliente =  func.nextInt();
			ClientePJ clientePJ = new ClientePJ(nomeClientePJ, enderecoClientePJ,cnpjDoCliente, dataF,funcDoCliente );
			if (Validacao.validarCNPJ(clientePJ.getCnpj())) {				
				return clientePJ;
			} else {
				System.out.println("CNPJ inválido.");
				return null;
			}
			
		}
		
	}
	*/
	public void printCliente() {
		System.out.println("Nome do cliente: " + this.nome);
		System.out.println("\nTelefone do cliente: " + this.telefone);
		System.out.println("\nEndereco do cliente: " + this.endereco);
		System.out.println("\nE-mail do cliente: " + this.email);
		
		/*
	 	System.out.println("\nVeículos do cliente: ");
		for (Veiculo veiculo : listaVeiculos) {
			System.out.println("\n-" + veiculo.toString());
		}
		*/
	}
	

}
