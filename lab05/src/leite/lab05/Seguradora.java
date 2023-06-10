package leite.lab05;
import java.util.ArrayList;
import java.time.LocalDate;

public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private String cnpj;
	private ArrayList<Seguro> listaSeguros;
	protected ArrayList<Cliente> listaClientes; 
	// construtor
	public Seguradora(String nome , String telefone , String email , String endereco, String cnpj) {
		this.nome = nome ;
		this.telefone = telefone ;
		this.email = email ;
		this.endereco = endereco ;
		this.cnpj = cnpj;
		this.listaClientes = new ArrayList<>();
		this.listaSeguros = new ArrayList<>();
}

		// getters e setters
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public ArrayList<Seguro> getListaSeguros() {
		return listaSeguros;
	}
	public boolean cadastrarCliente(Cliente cliente) {
		boolean sucesso = listaClientes.add(cliente);
		if (sucesso) {
			System.out.println("Cliente "+ cliente.getNome()+" cadastrado com sucesso!");
			
		} else {
			System.out.println("Erro ao cadastrar cliente " + cliente.getNome() + ".");
		}
		return sucesso;
	}
	public boolean removerCliente(Cliente cliente) {
		boolean sucesso = listaClientes.remove(cliente);
		if(sucesso) {
			System.out.println("Cliente " + cliente.getNome()+ " removido com sucesso.");
		} else {
			System.out.println("Erro ao remover cliente " + cliente.getNome() + ".");
		}
		return sucesso;
	}
	public ArrayList<ClientePF> listarClientesPF(){
		ArrayList<ClientePF> clientesPF = new ArrayList<ClientePF>();
		for (Cliente cliente : listaClientes) {
			if (cliente instanceof ClientePF) {
				clientesPF.add((ClientePF) cliente);
			}
		}
		return clientesPF;
	}
	public ArrayList<ClientePJ> listarClientesPJ(){
		ArrayList<ClientePJ> clientesPJ = new ArrayList<ClientePJ>();
		for (Cliente cliente : listaClientes) {
			if(cliente instanceof ClientePJ) {
				clientesPJ.add((ClientePJ) cliente);
						
			}
		}
		return clientesPJ;
	}
	public void listarClientes(){
		System.out.println("\nClientes do tipo PF: ");
		for (ClientePF cliente : listarClientesPF()) {
			System.out.println("\n-" + cliente.toString());
		}
		System.out.println("\nClientes do tipo PJ: ");
		for (ClientePJ cliente : listarClientesPJ()) {
			System.out.println("\n-" + cliente.toString());
		}
	}
	

	public ArrayList<Sinistro> getSinistrosPorCliente(String cliente){
		ArrayList<Sinistro> sinistrosPorCliente = new ArrayList<>();
		for (Seguro seguro : listaSeguros) {
			if (seguro instanceof SeguroPF) {
				SeguroPF seguroPF = (SeguroPF) seguro;
				if (seguroPF.getCliente().getNome().equals(cliente)) {
					sinistrosPorCliente.addAll(seguroPF.getListaSinistros());
				}
			} else if (seguro instanceof SeguroPJ) {
				SeguroPJ seguroPJ = (SeguroPJ) seguro;
				if (seguroPJ.getCliente().getNome().equals(cliente)) {
					sinistrosPorCliente.addAll(seguroPJ.getListaSinistros());
				}
			}
		}
		if(sinistrosPorCliente.size() == 0) {
			System.out.println("O(A) cliente " + cliente + " não possui sinistros.");
		} else {
			System.out.println("O(A) cliente " + cliente + " possui o(s) seguinte(s) sinistro(s): \n");
			for(Sinistro sinistro : sinistrosPorCliente) {
				sinistro.toString();
			}
		}
		
		return sinistrosPorCliente;
	}
	
	public boolean gerarSeguro(LocalDate dataInicio, LocalDate dataFim, double valorMensal, Cliente cliente, Frota frota) {
		if(cliente instanceof ClientePF) {
			SeguroPF seguroPF = new SeguroPF(0, dataInicio, dataFim, this, valorMensal, (ClientePF) cliente);
			listaSeguros.add(seguroPF);
			return true;
		} else if(cliente instanceof ClientePJ) {
			SeguroPJ seguroPJ = new SeguroPJ(0, this, dataInicio, dataFim, frota, (ClientePJ) cliente, valorMensal);
			listaSeguros.add(seguroPJ);
			return true;
		}
		return false;
	}
	
	public boolean cancelarSeguro(Seguro seguro) {
		return listaSeguros.remove(seguro);
	}
	
	public ArrayList<Seguro> getSegurosPorCliente(Cliente cliente){
		ArrayList<Seguro> segurosPorCliente = new ArrayList<>();
		for (Seguro seguro : listaSeguros) {
			if (seguro instanceof SeguroPF) {
				if (seguro.getCliente().equals(cliente)) {
					segurosPorCliente.add(seguro);
				}
			} else if (seguro instanceof SeguroPJ) {
				if (seguro.getCliente().equals(cliente)) {
					segurosPorCliente.add(seguro);
				}			
			}
		}
		return segurosPorCliente;
	}
	
	public double calcularReceita() {
		double receitaTotal = 0.0;
		if(this.listaSeguros != null) {
			for(Seguro seguro : this.listaSeguros) {
				double precoSeguro = seguro.getValorMensal();
				receitaTotal += precoSeguro;
			}
		}
		System.out.println("A receita é de " + receitaTotal + " reais.");
		return receitaTotal;
	}
	double receitaTotal = calcularReceita();
	
	
	
	
	public static String imprimeCNPJ(String CNPJ) {
		// máscara do CNPJ: 99.999.999.9999-99
		    return(CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) + "." +
		      CNPJ.substring(5, 8) + "." + CNPJ.substring(8, 12) + "-" +
		      CNPJ.substring(12, 14));
	}
	public String toString() {

	        return  "\nNome da Seguradora: " + this.nome + 
	        		"\nTelefone da Seguradora: " + this.telefone + 
	        		"\nEmail da Seguradora: " + this.email + 
	        		"\nEndereço da Seguradora: " + this.endereco + 
	        		"\nCNPJ da Seguradora: " + imprimeCNPJ(this.cnpj) + 
	        		"\nNúmero de seguros da Seguradora: " + this.listaSeguros.size() + 
	        		"\nNúmero de clientes da Seguradora: " + this.listaClientes.size() + 
	        		"\nReceita da Seguradora: " + this.receitaTotal;

	        		
	}

	
}



