package leite.lab04;
import java.util.ArrayList;

public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	protected ArrayList<Cliente> listaClientes; 
	private static ArrayList<Sinistro> listaSinistros;
	// construtor
	public Seguradora(String nome , String telefone , String email , String endereco) {
		this.nome = nome ;
		this.telefone = telefone ;
		this.email = email ;
		this.endereco = endereco ;
		this.listaClientes = new ArrayList<>();
		this.listaSinistros = new ArrayList<>();
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
	
	public ArrayList<Sinistro> getListaSinistros() {
		return listaSinistros;
	}
	public boolean cadastrarCliente(Cliente cliente) {
		boolean sucesso = listaClientes.add(cliente);
		if (sucesso) {
			System.out.println("Cliente "+ cliente.getNome()+" cadastrado com sucesso!");
			
		} else {
			System.out.println("Erro ao cadastrar cliente" + cliente.getNome());
		}
		return sucesso;
	}
	public boolean removerCliente(Cliente cliente) {
		boolean sucesso = listaClientes.remove(cliente);
		if(sucesso) {
			System.out.println("Cliente " + cliente.getNome()+ " removido com sucesso.");
		} else {
			System.out.println("Erro ao remover cliente " + cliente.getNome());
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
	public ArrayList<? extends Cliente> listarClientes(String tipoCliente){
		if(tipoCliente.equals("PF")) {
			return listarClientesPF();
		} else if(tipoCliente.equals("PJ")) {
			return listarClientesPJ();
		}else if(tipoCliente.equals("todos")) {
			return listaClientes;
		}else {
			return null;
		}
	}
	public boolean gerarSinistro(Cliente cliente, Veiculo veiculo, String tipoSinistro) {
		if (!this.listaClientes.contains(cliente) || !cliente.getListaVeiculos().contains(veiculo)) {
			return false;
		}
		Sinistro novoSinistro = new Sinistro(0, "11/12/2023", "lugar do sinistro", this, veiculo, cliente);
		this.listaSinistros.add(novoSinistro);
		return true;
	}
	public boolean visualizarSinitro(Cliente cliente) {
		for(Sinistro sinistro : listaSinistros) {
			if(sinistro.getCliente().equals(cliente)) {
				System.out.println("Sinisro encontrado: "+ sinistro.getId());
				return true;
			}
		}
		System.out.println("CLiente "+ cliente.getNome() + " não possui sinistros.");
		return false;
	}
	public static boolean removeSinistro(Sinistro sinistro) {
		for(Sinistro sinistro1: listaSinistros) {
			if(sinistro1.equals(sinistro)) {
				listaSinistros.remove(sinistro);
				System.out.println("Sinisro removido com sucesso.");
				return true;
			}
		}
		System.out.println("Erro ao remover o sinistro.");
		return false;
	}
	public ArrayList<Sinistro> listarSinistros(){
		return listaSinistros;
	}
	
	public int quantSinistrosCliente(Cliente cliente) {
	    int count = 0;
	    for (Sinistro sinistro : this.listaSinistros) {
	        if (sinistro.getCliente().equals(cliente)) {
	            count++;
	        }
	    }
	    return count;
	}

	public double calcularPrecoSeguroCliente(Cliente cliente) {
		int quantidadeSinistros = quantSinistrosCliente(cliente);
		double score = cliente.calculaScore();
		double preco = score * (1 + quantidadeSinistros);
		return preco;
	}
	
	public double calcularReceita() {
		double receitaTotal = 0.0;
		if(this.listaClientes != null) {
			for(Cliente cliente : this.listaClientes) {
				double precoSeguro = this.calcularPrecoSeguroCliente(cliente);
				receitaTotal += precoSeguro;
			}
		}
		System.out.println("A receita é de " + receitaTotal + "reais");
		return receitaTotal;
	}
	double receitaTotal = calcularReceita();
	
	public Sinistro getUltimoSinistro() {
		if(this.listaSinistros.isEmpty()) {
			return null;
		} else {
			return this.listaSinistros.get(this.listaSinistros.size() - 1);
		}
	}
	
	
	public String toString() {
		return "Receita da Seguradora: " + receitaTotal;
	}
	
}



