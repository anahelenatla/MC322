package leite.lab05;
import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Main {	
	public static void main(String [] args) {

		Seguradora seguradora = new Seguradora("Seguradora da cidade", "19 11111-1111", "contato@seguradora.com", "Rua da Seguradora", "13.905.486/0001-59");

		// Cadastrando um cliente PF e adicionando um veículo
		Scanner l = new Scanner(System.in);
		System.out.println("Digite o CPF do cliente:");
		String cpfDoClientePF =  l.nextLine();
		LocalDate dataNasc = LocalDate.of(2002, 2, 19);
		ClientePF clientePF = new ClientePF("Ana Helena","(19) 91234-5678", "Rua da Ana", "anahelena@email.com", cpfDoClientePF, "Feminino", "Ensino superior", dataNasc);
		
		// Validando o CPF
		boolean validarCPF = Validacao.validarCPF(clientePF.getCpf());
		if (validarCPF) {
			seguradora.cadastrarCliente(clientePF);
			Veiculo veiculoPF = new Veiculo("ANA-1111" , "Audi", "TT", 2017);
			boolean cadastroVeiculo = clientePF.cadastrarVeiculo(veiculoPF);
			if (cadastroVeiculo) {
				System.out.println("Veículo " + veiculoPF.getModelo() + " cadastrado em nome de " + clientePF.getNome()+ ".");
			} else {
				System.out.println("Falha ao cadastrar o veículo.");
			}
		} else {
			System.out.println("CPF inválido.");
		}
		
		// Removendo o cliente
		seguradora.removerCliente(clientePF);
		
		//Cadastrando cliente PF que não será removido
		Scanner m = new Scanner(System.in);
		System.out.println("Digite o CPF do cliente:");
		String cpfDoClientePF2 =  m.nextLine();
		LocalDate dataNasc2 = LocalDate.of(2001, 2, 14);
		ClientePF clientePF2 = new ClientePF("Fulano","(19) 91111-5222", "Rua do Fulano", "fulano@email.com", cpfDoClientePF2, "Masculino", "Ensino superior", dataNasc2);		
		// Validando o CPF
		boolean validarCPF2 = Validacao.validarCPF(clientePF2.getCpf());
		if (validarCPF2) {
			seguradora.cadastrarCliente(clientePF2);
			Veiculo veiculoPF2 = new Veiculo("FUL-1111" , "Toyota", "Fielder", 2009);
			boolean cadastroVeiculo2 = clientePF2.cadastrarVeiculo(veiculoPF2);
			if (cadastroVeiculo2) {
				System.out.println("Veículo " + veiculoPF2.getModelo() + " cadastrado em nome de " + clientePF2.getNome()+ ".");
			} else {
				System.out.println("Falha ao cadastrar o veículo.");
			}
			
		} else {
			System.out.println("CPF inválido.");
		}
		
		//Cadastrando cliente PJ
		LocalDate dataFund = LocalDate.of(1993, 7, 11);		
		ClientePJ clientePJ = new ClientePJ("Empresa A", "Rua da empresa", "empresa@email.com", "43.489.373/0001-80", dataFund, 50, "(19) 11111-2222");
		
		boolean validarCNPJ = Validacao.validarCNPJ(clientePJ.getCnpj());
		if (validarCNPJ) {
			seguradora.cadastrarCliente(clientePJ);	
			Frota frota = new Frota("carro");
			boolean cadastrarFrotaNaEmpresa = clientePJ.cadastrarFrota(frota);
			if(cadastrarFrotaNaEmpresa) {
				System.out.println("Frota " + frota.getCode() + " cadastrada na empresa " + clientePJ.getNome() + " com sucesso.");
				Veiculo veiculoPJ = new Veiculo("ABC-1111" , "Chevrolet", "Onix", 2015);
				boolean cadastroVeiculoNaFrota = clientePJ.atualizarFrota(frota, veiculoPJ, 1, 0);
				if(cadastroVeiculoNaFrota) {
					System.out.println("Veículo " + veiculoPJ.getModelo() + " cadastrado na frota de " + frota.getCode() + "em nome de " + clientePJ.getNome()+ ".");
					System.out.println("Veículo(s) na frota: " + clientePJ.getVeiculosPorFrota(frota.getCode())); 
					frota.imprimeVeiculos();
					System.out.println(frota);
				} else {
					System.out.println("Falha ao cadastrar o veículo na frota.");
				}			
				
			}else {
				System.out.println("Falha ao cadastrar frota.");
			}
			
		} else {
			System.out.println("CNPJ inválido.");
		}
		
		// gerando um seguro para cada cliente 
		LocalDate dataIni = LocalDate.of(2023, 6, 6);	
		LocalDate dataFim = LocalDate.of(2024, 6, 6);	
		
		SeguroPF seguropf1 = new SeguroPF(0, dataIni, dataFim, seguradora, 0.0 , clientePF2);

		boolean seguroPF = seguradora.gerarSeguro(dataIni, dataFim, 0, clientePF2, null);
		if (seguroPF) {
			System.out.println("Seguro de Pessoa Física para "+ clientePF2.getNome() +" criado com sucesso.");
			
		} else {
			System.out.println("Falha ao criar o seguro.");
		}
		LocalDate dataIni1 = LocalDate.of(2023, 5, 6);	
		LocalDate dataFim1 = LocalDate.of(2024, 7, 6);	
		if(!clientePJ.getListaFrota().isEmpty()) {
			boolean seguroPJ = seguradora.gerarSeguro(dataIni1, dataFim1, 0, clientePJ, clientePJ.getListaFrota().get(0));
			if (seguroPJ) {
				System.out.println("Seguro de Pessoa Jurídica para "+ clientePJ.getNome() +" criado com sucesso.");
			} else {
				System.out.println("Falha ao criar o seguro.");
			}
		}else {
			System.out.println("Para criar um seguro de Pessoa Jurídica, deve-se cadastrar uma frota antes.");
		}
		
		//adicionando um condutor para cada cliente - Condutor(String cpf, String nome, String telefone, String endereco, String email, LocalDate dataNasc)
		
		LocalDate dataNascCondutor1 = LocalDate.of(1980, 5, 6);	
		Condutor condutor1 = new Condutor("781.076.810-70", "Tina", "(19) 12345-6789","Rua da Tina", "tina@email.com", dataNascCondutor1);
		boolean validarCPFCondutor1 = Validacao.validarCPF(condutor1.getCpf());
		Seguro seguropf = seguradora.getSegurosPorCliente(clientePF2).get(0);
		
		System.out.println(seguropf);
		if (validarCPFCondutor1) {			
			boolean autorizar = seguropf.autorizarCondutor(condutor1);
			if(autorizar) {
				System.out.println("Condutor(a) " + condutor1.getNome()+" autorizado(a).");
			} else {
				System.out.println("Falha ao autorizar o(a) condutor(a).");
			}			
		} else {
			System.out.println("CPF inválido.");
		}
		
		
		LocalDate dataNascCondutor2 = LocalDate.of(1990, 5, 6);	
		Condutor condutor2 = new Condutor("701.084.990-06", "Theo", "(19) 12345-9999","Rua do Theo", "theo@email.com", dataNascCondutor2);
		boolean validarCPFCondutor2 = Validacao.validarCPF(condutor2.getCpf());
		if(!seguradora.getSegurosPorCliente(clientePJ).isEmpty()) {
			Seguro seguropj = seguradora.getSegurosPorCliente(clientePJ).get(0);
			System.out.println(seguropj);

			if (validarCPFCondutor2) {
				boolean autorizar2 = seguropj.autorizarCondutor(condutor2);
				if(autorizar2) {
					System.out.println("Condutor(a) " + condutor2.getNome()+" autorizado(a).");
				} else {
					System.out.println("Falha ao autorizar o(a) condutor(a).");
				}			
			} else {
				System.out.println("CPF inválido.");
			}
			
		}
		
		
		//gerando um sinistro para cada cliente cadastrado 
		LocalDate dataSinistro1 = LocalDate.of(2023, 6, 7);
		boolean sucessoSinistroPF = seguropf.gerarSinistro(0, dataSinistro1, "Rua dos Acidentes", seguradora, clientePF2.getListaVeiculos().get(0), condutor1, seguropf);
		if (sucessoSinistroPF) {
			System.out.println("Sinistro gerado com sucesso.");
			Sinistro ultimoSinistro = seguropf.getUltimoSinistro();
			System.out.println("Informações do sinistro gerado:");
			System.out.println(ultimoSinistro);
			condutor1.adicionarSinistro(ultimoSinistro);
			System.out.println(condutor1);
		} else {
			System.out.println("Não foi possível gerar o sinistro de "+ clientePF2.getNome() + ".");
		}
		LocalDate dataSinistro2 = LocalDate.of(2023, 7, 7);
		if(!seguradora.getSegurosPorCliente(clientePJ).isEmpty()) {
			Seguro seguropj = seguradora.getSegurosPorCliente(clientePJ).get(0);
			boolean sucessoSinistroPJ = seguropj.gerarSinistro(0, dataSinistro2, "Rua de Outros Acidentes", seguradora, clientePJ.getListaFrota().get(0).getListaVeiculos().get(0), condutor2, seguropj);
			if (sucessoSinistroPJ) {
				System.out.println("Sinistro gerado com sucesso.");
				Sinistro ultimoSinistroPJ = seguropj.getUltimoSinistro();
				System.out.println("Informações do sinistro gerado:");
				System.out.println(ultimoSinistroPJ);
				condutor2.adicionarSinistro(ultimoSinistroPJ);
				System.out.println(condutor2);
			} else {
				System.out.println("Não foi possível gerar o sinistro de "+ clientePJ.getNome() + ".");
			}
			seguropj.calcularValor();
			// cancelando um seguro 
			seguradora.cancelarSeguro(seguropj);
		}
			
		
		// chamando o método listarClientes para visualizar todos os clientes da seguradora
		seguradora.listarClientes();
		
		// observando sinistros por cliente
		seguradora.getSinistrosPorCliente(clientePF2.getNome());
		seguradora.getSinistrosPorCliente(clientePJ.getNome());
		
		// calculando o valor do seguro e receita até o momento
		seguropf.calcularValor();
		
		seguradora.calcularReceita();
		

		
		// removendo veículo do cliente pf
		clientePF2.removerVeiculo(clientePF2.getListaVeiculos().get(0));
		
		// desautorizando condutores
		seguropf.desautorizarCondutor(seguropf.listaCondutores.get(0));
		
		//chamando os métodos toString() dos objetos de cada classe que ainda não foram chamados
		System.out.println(seguradora);
		System.out.println(clientePF2);
		System.out.println(clientePJ);

		
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
		Seguradora seguradora = new Seguradora("Seguradora da cidade", "19 11111-1111", "contato@seguradora.com", "Rua da Seguradora", "13.905.486/0001-59");
		switch(op) {
			case CADASTROS:
			case LISTAR:
			case EXCLUIR:
				executarSubmenu(op);
				break;
			case GERAR_SEGURO:
				System.out.println("Executar metodo gerar Seguro");
				System.out.println("Deseja gerar seguro para cliente PF ou PJ?");
				Scanner t = new Scanner(System.in);
				String tipo =  t.nextLine();
				if(tipo == "PF") {
					SeguroPF seguropf = new SeguroPF(0, LocalDate.now(), LocalDate.now().plusYears(1), seguradora, 0, seguradora.listarClientesPF().get(0));
					System.out.println("Um seguro foi gerado com data de validade para daqui 1 ano.");
				}else {
					SeguroPJ seguropj = new SeguroPJ(0, seguradora, LocalDate.now(), LocalDate.now().plusYears(1),seguradora.listarClientesPJ().get(0).getListaFrota().get(0) , seguradora.listarClientesPJ().get(0), 0.0);
					System.out.println("Um seguro foi gerado com data de validade para daqui 1 ano.");
				}
				break;
			case CALCULAR_RECEITA:
				System.out.println("Executar metodo calcular receita.");
				seguradora.calcularReceita();
				break;
			case SAIR:
				System.out.println("Saiu do sistema.");
				System.exit(0);
				break;
		}
	}
	
	public static void executarOpcaoSubMenu(SubmenuOpcoes opSubmenu) {
		Seguradora seguradora = new Seguradora("Seguradora da cidade", "19 11111-1111", "contato@seguradora.com", "Rua da Seguradora", "13.905.486/0001-59");
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
			for (ClientePF cliente1 : seguradora.listarClientesPF()) {
		        if (cliente1.getNome().equals(nome)) {
		        	cliente1.cadastrarVeiculo(Veiculo.criaVeiculo());
		        	System.out.println("Veiculo cadastrado com sucesso.");
		        	break;
		        }
		        
			}
			System.out.println("Cliente não cadastrado.");
			
			break;
		case LISTAR_CLIENTES:			
			seguradora.listarClientes();
			
			break;
		case LISTAR_SINISTROS:			
			for (Cliente cliente2 : seguradora.listaClientes) {
				seguradora.getSinistrosPorCliente(cliente2.getNome());		        
			}
			
			break;
		case LISTAR_VEICULOS:	
			for (ClientePF cliente1 : seguradora.listarClientesPF()) {
				for (Veiculo veiculo : cliente1.listaVeiculos) {
					System.out.println("\n-" + veiculo.toString());
				}
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
			for (ClientePF cliente1 : seguradora.listarClientesPF()) {
				for (Veiculo veiculoR : cliente1.listaVeiculos) {
					if (veiculoR.getPlaca().equals(placaRemov)) {
						cliente1.removerVeiculo(veiculoR);
						break;
					}
				}
			}
			
			System.out.println("Veículo não cadastrado.");
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


