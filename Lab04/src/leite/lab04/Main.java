package leite.lab04;
import java.util.Scanner;
import java.util.Date;
public class Main {	
	public static void main(String [] args) {
		Seguradora seguradora = new Seguradora("Seguradora da cidade", "19 11111-1111", "contato@seguradora.com", "Rua da Seguradora");
		Scanner scanner = new Scanner(System.in);
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
	
		// Cadastrando um cliente PF e adicionando um veículo
		Scanner l = new Scanner(System.in);
		System.out.println("Digite o CPF do cliente:");
		String cpfDoClientePF =  l.nextLine();
		ClientePF clientePF = new ClientePF("Ana Helena", "Rua da Ana", cpfDoClientePF, "Feminino", new Date(), "Ensino superior", new Date(), "ClasseB");
		Veiculo veiculoPF = new Veiculo("ANA-1111" , "Audi", "TT", 2017);
		clientePF.adicionarVeiculo(veiculoPF);
		// Validando o CPF
		boolean validarCPF = ClientePF.validarCPF(clientePF.getCpf());
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
		ClientePF clientePF2 = new ClientePF("Fulano", "Rua do fulano", cpfDoClientePF2, "masculino", new Date(), "Ensino médio", new Date(), "Classe A");
		Veiculo veiculoPF2 = new Veiculo("FUL-1111" , "Toyota", "Fielder", 2009);
		if (ClientePF.validarCPF(clientePF2.getCpf())) {
			clientePF2.adicionarVeiculo(veiculoPF2);
			seguradora.cadastrarCliente(clientePF2);
		} else {
			System.out.println("CPF inválido.");
		}
		
		//Cadastrando cliente PJ que não será removido
		ClientePJ clientePJ = new ClientePJ("Empresa A", "Rua da empresa", "12.345.678/0001-90", new Date());
		if (clientePJ.validarCNPJ(clientePJ.getCnpj())) {
			clientePJ.adicionarVeiculo(new Veiculo("ABC-1111" , "Chevrolet", "Onix", 2000));
			seguradora.cadastrarCliente(clientePJ);
		} else {
			System.out.println("CNPJ inválido.");
		}
		
		//gerando um sinistro para o cliente PF e seu veículo cadastrado
		boolean sucesso = seguradora.gerarSinistro(clientePF2, veiculoPF2, "Colisão");
		
		if (sucesso) {
			System.out.println("Sinistro gerado com sucesso.");
			Sinistro ultimoSinistro = seguradora.getUltimoSinistro();
			System.out.println("Informações do sinistro gerado:");
			System.out.println(ultimoSinistro);
		} else {
			System.out.println("Não foi possível gerar o sinistro");
		}
		scanner.close();
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
		


	}
	
}


