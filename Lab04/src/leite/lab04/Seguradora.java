package leite.lab04;
import java.util.ArrayList;

public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private ArrayList<Cliente> listaClientes;
	private ArrayList<Sinistro> listaSinistros;
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
			System.out.println("CLiente " + cliente.getNome()+ " removido com sucesso.");
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
	public ArrayList<Sinistro> listarSinistros(){
		return listaSinistros;
	}
	public Sinistro getUltimoSinistro() {
		if(this.listaSinistros.isEmpty()) {
			return null;
		} else {
			return this.listaSinistros.get(this.listaSinistros.size() - 1);
		}
	}
	//Cliente c;
	//c instanceof ClientePF
	
}



