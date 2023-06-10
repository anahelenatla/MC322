package leite.lab05;

public enum SubmenuOpcoes {
	CADASTRAR_CLIENTE("1 - Cadastrar cliente"),
	CADASTRAR_VEICULO("2 - Cadastrar veiculo"),
	LISTAR_CLIENTES("1 - Listar clientes"),
	LISTAR_SINISTROS("2 - Listar sinistros"),
	LISTAR_VEICULOS("3 - Listar veículos"),
	EXCLUIR_CLIENTE("1 - Excluir cliente"),
	EXCLUIR_VEICULO("2 - Excluir veículo"),
	VOLTAR("4 - Voltar");
	
	//atributo
	private final String descricao;
	
	//construtor
	SubmenuOpcoes(String descricao){
		this.descricao = descricao;
	}
	
	//get
	public String getDescricao() {
		return descricao;
	}
	
}

