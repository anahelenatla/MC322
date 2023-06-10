package leite.lab05;

public enum MenuOperacoes {
	CADASTROS("1 - Cadastros", new SubmenuOpcoes[]{
		SubmenuOpcoes.CADASTRAR_CLIENTE,
		SubmenuOpcoes.CADASTRAR_VEICULO,
		SubmenuOpcoes.VOLTAR
	}),
	LISTAR("2 - Listar", new SubmenuOpcoes[] {
			SubmenuOpcoes.LISTAR_CLIENTES,
			SubmenuOpcoes.LISTAR_SINISTROS,
			SubmenuOpcoes.LISTAR_VEICULOS,
			SubmenuOpcoes.VOLTAR
	
	}),
	EXCLUIR("3 - Excluir",  new SubmenuOpcoes[] {
			SubmenuOpcoes.EXCLUIR_CLIENTE,
			SubmenuOpcoes.EXCLUIR_VEICULO,
			SubmenuOpcoes.VOLTAR
	}),
	GERAR_SEGURO("4 - Gerar Seguro", new SubmenuOpcoes[] {SubmenuOpcoes.VOLTAR}),
	CALCULAR_RECEITA("5 - Calcular Receita", new SubmenuOpcoes[] {SubmenuOpcoes.VOLTAR}),
	SAIR("7 - Sair", new SubmenuOpcoes[] {});

	// atributos
	private final String descricao;
	private final SubmenuOpcoes[] submenu;
	
	// construtor
	MenuOperacoes(String descricao, SubmenuOpcoes[] submenu){
		this.descricao = descricao;
		this.submenu = submenu;
	}
	
	// gets
	public String getDescricao() {
		return descricao;
	}
	
	public SubmenuOpcoes[] getSubmenu() {
		return submenu;
	}
}
