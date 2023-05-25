package leite.lab05;
import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Main {	
	public static void main(String [] args) {
		Seguradora seguradora = new Seguradora("Seguradora da cidade", "19 11111-1111", "contato@seguradora.com", "Rua da Seguradora");
		Scanner scanner = new Scanner(System.in);
		/*
		int opcao;
		do {
			System.out.println("\nSelecione uma opção:\n");
			System.out.println("1- Visualizar lista de clientes\n");
			System.out.println("2- Visualizar lista de sinistros\n");
			System.out.println("3- Sair\n");
			System.out.println("Opção:");
			
			opcao = scanner.nextInt();
			
			switch (opcao) {
			case 1:
				System.out.println("\nLista de clientes PF:");
				System.out.println(seguradora.listarClientesPF());
				System.out.println("\nLista de clientes PJ:");
				System.out.println(seguradora.listarClientesPJ());
				break;
			case 2:
				System.out.println("\nLista de sinistros:");
				System.out.println(seguradora.listarSinistros());
				break;
			case 3:
				System.out.println("\nSaindo...");
				break;
			case 4:
				System.out.println("\nOpção inválida.");
				break;
			}
		} while (opcao != 3);
	//scanner.close();
	*/
		// Cadastrando um cliente PF e adicionando um veículo
		Scanner l = new Scanner(System.in);
		System.out.println("Digite o CPF do cliente:");
		String cpfDoClientePF =  l.nextLine();
		LocalDate dataNasc = LocalDate.of(2002, 2, 19);
		Date dataLic = new Date(2022, 2, 19);
		SimpleDateFormat formatodn = new SimpleDateFormat("dd/mm/yyyy");
		
		ClientePF clientePF = new ClientePF("Ana Helena", "Rua da Ana", cpfDoClientePF, "Feminino", dataLic, "Ensino superior", dataNasc, "ClasseB");
		Veiculo veiculoPF = new Veiculo("ANA-1111" , "Audi", "TT", 2017);
		clientePF.adicionarVeiculo(veiculoPF);
		// Validando o CPF
		boolean validarCPF = Validacao.validarCPF(clientePF.getCpf());
		if (validarCPF) {
			seguradora.cadastrarCliente(clientePF);
		} else {
			System.out.println("CPF inválido.");
		}
		
		// Removendo o cliente
		seguradora.removerCliente(clientePF);
		
		//Cadastrando cliente PF que não será removido
		Scanner m = new Scanner(System.in);
		System.out.println("Digite o CPF do cliente:");
		String cpfDoClientePF2 =  m.nextLine();
		ClientePF clientePF2 = new ClientePF("Fulano", "Rua do fulano", cpfDoClientePF2, "masculino", new Date(), "Ensino médio", LocalDate.of(2004, 2, 21), "Classe A");
		Veiculo veiculoPF2 = new Veiculo("FUL-1111" , "Toyota", "Fielder", 2009);
		if (Validacao.validarCPF(clientePF2.getCpf())) {
			seguradora.cadastrarCliente(clientePF2);
			clientePF2.adicionarVeiculo(veiculoPF2);
			
		} else {
			System.out.println("CPF inválido.");
		}
		
		//Cadastrando cliente PJ que não será removido
		ClientePJ clientePJ = new ClientePJ("Empresa A", "Rua da empresa", "12.345.678/0001-90", new Date(), 50);
		Veiculo veiculoPJ = new Veiculo("ABC-1111" , "Chevrolet", "Onix", 2015);
		if (Validacao.validarCNPJ(clientePJ.getCnpj())) {
			clientePJ.adicionarVeiculo(veiculoPJ);
			seguradora.cadastrarCliente(clientePJ);
		} else {
			System.out.println("CNPJ inválido.");
		}
		
		//gerando um sinistro para cada cliente cadastrado e seu veículo cadastrado
		boolean sucessoPF = seguradora.gerarSinistro(clientePF2, veiculoPF2, "Colisão");
		
		if (sucessoPF) {
			System.out.println("Sinistro gerado com sucesso.");
			Sinistro ultimoSinistro = seguradora.getUltimoSinistro();
			System.out.println("Informações do sinistro gerado:");
			System.out.println(ultimoSinistro);
		} else {
			System.out.println("Não foi possível gerar o sinistro de "+ clientePF2.getNome());
		}
		
		boolean sucessoPJ = seguradora.gerarSinistro(clientePJ, veiculoPJ, "Colisão");
		
		if (sucessoPJ) {
			System.out.println("Sinistro gerado com sucesso.");
			Sinistro ultimoSinistro = seguradora.getUltimoSinistro();
			System.out.println("Informações do sinistro gerado:");
			System.out.println(ultimoSinistro);
		} else {
			System.out.println("Não foi possível gerar o sinistro de "+ clientePJ.getNome());
		}
		//scanner.close();
		// chamando o método listarClientes para visualizar todos os clientes da seguradora
		seguradora.listarClientes("PF");
		seguradora.listarClientes("PJ");
		
		// chamando o método listarClientes para visualizar todos os clientes da seguradora
		seguradora.visualizarSinitro(clientePF2);
		
		// chamando o método listarSinistros para visualizar todos os sinistros da seguradora
		seguradora.listarSinistros();
		
		
		
		
		//chamando o método toString() de cada classe
		System.out.println(clientePF2.toString());
		System.out.println(clientePJ.toString());
		System.out.println(seguradora.toString());
		System.out.println(veiculoPF2.toString());
		
		double receitaTotal = seguradora.calcularReceita();
		System.out.println(receitaTotal);
		
		//executa o menu externo: exibição do menu, leitura da opção e execução da opção
		MenuOperacoes op;
		do {
			exibirMenuExterno();
			op = lerOpcaoMenuExterno();
			executarOpcaoMenuExterno(op);
		}while(op != MenuOperacoes.SAIR);
		System.out.println("Saiu do sistema");


	}
	
	//exibir menu externo
	private static void exibirMenuExterno() {
		MenuOperacoes menuOperacoes[] = MenuOperacoes.values();
		System.out.println("Menu principal");
		for(MenuOperacoes op: menuOperacoes) {
			System.out.println(op.getDescricao());
		}
	}
	
	/* exibir submenus
	 * se a lista de constantes do submenu for percorrida da mesma forma que o meu externo, a opção Voltar
	 * é printada com a posição que está na lista do enum (9 - Voltar). Por isso, a lista é percorrida 
	 * de forma diferente, tendo i como o inteiro correspondente. Assim, para listar o submenu de cadastros,
	 * por exemplo, vai ser printado "3 - Voltar".
	 */
	private static void exibirSubmenu(MenuOperacoes op) {
		SubmenuOpcoes[] submenu = op.getSubmenu();
		System.out.println(op.getDescricao());
		for(int i=0; i<submenu.length; i++) {
			System.out.println(submenu[i].getDescricao());
		}
	}
	
	//ler opções do menu externo
	private static MenuOperacoes lerOpcaoMenuExterno() {
		Scanner scanner2 = new Scanner(System.in);
		
		int opUsuario;
		MenuOperacoes opUsuarioConst;
		do {
			System.out.println("Digite uma opcao: ");
			opUsuario = scanner2.nextInt();
		}while(opUsuario < 0 || opUsuario > MenuOperacoes.values().length);
			if(opUsuario >= 1) {
				opUsuarioConst = MenuOperacoes.values()[opUsuario-1];
			}else {
				System.out.println("Opção inválida.");
				opUsuarioConst = MenuOperacoes.values()[0];
			}
			
			return opUsuarioConst;		
	}
	
	//ler opção dos submenus
	private static SubmenuOpcoes lerOpcaoSubmenu(MenuOperacoes op) {
		Scanner scanner1 = new Scanner(System.in);
		int opUsuario;
		SubmenuOpcoes opUsuarioConst;
		do {
			System.out.println("Digite uma opcao: ");
			opUsuario = scanner1.nextInt();
		}while(opUsuario < 0 || opUsuario > op.getSubmenu().length - 1);
		opUsuarioConst = op.getSubmenu()[opUsuario-1];
		//scanner1.close();
		return opUsuarioConst;
	}
	
	//executar opções do menu externo
	private static void executarOpcaoMenuExterno(MenuOperacoes op) {
		Seguradora seguradora = new Seguradora("Seguradora da cidade", "19 11111-1111", "contato@seguradora.com", "Rua da Seguradora");
		switch(op) {
			case CADASTROS:
			case LISTAR:
			case EXCLUIR:
				executarSubmenu(op);
				break;
			case GERAR_SINISTRO:
				System.out.println("Executar metodo gerar Sinistro");
				System.out.println("Digite o nome do Cliente: ");
				Scanner n = new Scanner(System.in);
				String nome =  n.nextLine();
				for (Cliente cliente : seguradora.listaClientes) {
			        if (cliente.getNome().equals(nome)) {
			        	System.out.println("Digite a placa do carro do Cliente: ");
						Scanner p = new Scanner(System.in);
						String placaSinistro =  p.nextLine();
						for (Veiculo veiculo : cliente.getListaVeiculos()){
							if(veiculo.getPlaca().equals(placaSinistro)) {
								System.out.println("Digite a razão do Sinistro: ");
								Scanner r = new Scanner(System.in);
								String razao = r.nextLine();
								boolean sucesso = seguradora.gerarSinistro(cliente, veiculo, razao);					    		
					    		if (sucesso) {
					    			System.out.println("Sinistro gerado com sucesso.");
					    			
					    		} else {
					    			System.out.println("Não foi possível gerar o sinistro");
					    		}
							}
						}
			        }
			        	
			        }
				break;
			case TRANSFERIR_SEGURO:
				System.out.println("Executar metodo tranferir seguro");
				break;
			case CALCULAR_RECEITA:
				System.out.println("Executar metodo calcular receita");
				seguradora.calcularReceita();
				break;
			case SAIR:
				System.out.println("Saiu do sistema.");
				System.exit(0);
				break;
		}
	}
	
	public static void executarOpcaoSubMenu(SubmenuOpcoes opSubmenu) {
		Seguradora seguradora = new Seguradora("Seguradora da cidade", "19 11111-1111", "contato@seguradora.com", "Rua da Seguradora");
		MenuOperacoes operacoes;
		switch(opSubmenu) {
		case CADASTRAR_CLIENTE:
			
			Cliente cliente = Cliente.criaCliente();
			seguradora.cadastrarCliente(cliente);
			break;
		case CADASTRAR_VEICULO:
			
			System.out.println("Digite o nome do dono (lembre-se que o dono deve estar previamente cadastrado no sistema): ");
			Scanner n = new Scanner(System.in);
			String nome =  n.nextLine();
			for (Cliente cliente1 : seguradora.listaClientes) {
		        if (cliente1.getNome().equals(nome)) {
		        	cliente1.adicionarVeiculo(Veiculo.criaVeiculo());
		        	System.out.println("Veiculo cadastrado com sucesso.");
		        	break;
		        }
		        
			}
			System.out.println("Cliente não cadastrado.");
			break;
		case CADASTRAR_SEGURADORA:
			System.out.println("Chamar metodo cadastrar seguradora");
			break;
		case LISTAR_CLIENTES:			
			seguradora.listarClientes("todos");
			
			break;
		case LISTAR_SINISTROS:			
			seguradora.listarSinistros();
			break;
		case LISTAR_VEICULOS:			
			for (Veiculo veiculo : Cliente.listaVeiculos) {
				System.out.println("\n-" + veiculo.toString());
			}
			break;
		case EXCLUIR_CLIENTE:
			System.out.println("Digite o nome do cliente a ser removido:");
			Scanner n1 = new Scanner(System.in);
			String nomeRemov =  n1.nextLine();
			for (Cliente cliente2 : seguradora.listaClientes) {
				if (cliente2.getNome().equals(nomeRemov)) {
					seguradora.removerCliente(cliente2);
					break;
				}
			}
			System.out.println("Cliente não cadastrado.");
			break;
		case EXCLUIR_VEICULO:
			System.out.println("Digite a placa do veiculo a ser removido:");
			Scanner p1 = new Scanner(System.in);
			String placaRemov =  p1.nextLine();
			for (Veiculo veiculoR : Cliente.listaVeiculos) {
				if (veiculoR.getPlaca().equals(placaRemov)) {
					Cliente.removerVeiculo(veiculoR);
					break;
				}
			}
			System.out.println("Veículo não cadastrado.");
			break;
		case EXCLUIR_SINISTRO:			
			System.out.println("Digite o id do sinistro a ser excluído:");
			Scanner id1 = new Scanner(System.in);
			int idRemov =  id1.nextInt();
			for (Sinistro sinistroR : seguradora.getListaSinistros()) {
				if (sinistroR.getId() == idRemov) {
					Seguradora.removeSinistro(sinistroR);
					break;
				}
			}
			System.out.println("Sinistro inexistente.");
			break;
		case VOLTAR:			
			break;
		}
	}
	
	//executa os submenus: exibição do menu, leitura da opção e execução dos métodos
	private static void executarSubmenu(MenuOperacoes op) {
		SubmenuOpcoes opSubmenu;
		do {
			exibirSubmenu(op);
			opSubmenu = lerOpcaoSubmenu(op);
			executarOpcaoSubMenu(opSubmenu);
		}while(opSubmenu != SubmenuOpcoes.VOLTAR);
	}
	
	
		
	
	
}


