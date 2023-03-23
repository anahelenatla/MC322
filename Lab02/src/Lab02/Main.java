package Lab02;
import java.util.Scanner;
public class Main {
	private static final String String = null;

	public static void main(String []args) {
		Scanner l = new Scanner(System.in);
		Cliente cliente;
		Seguradora seguradora;
		Sinistro sinistro1;
		Sinistro sinistro2;
		Veiculo veiculo;

		System.out.println("Digite o CPF do cliente:");
		String cpf =  l.nextLine();
		
		cliente = new Cliente("Jorge", cpf, "11/11/2002", 20, "Rua da Alegria");
		System.out.println(cliente.validarCPF(cpf));
		
		String dataSinis = "01/01/2022"; 
		String enderecoSinis = "Rua da Tristeza";
		sinistro1 = new Sinistro(0, dataSinis, enderecoSinis);
		sinistro2 = new Sinistro(0, "01/04/2023", "Rua do segundo sinistro");
	
		String placa =  "AAA-1919";
	
		String marca =  "Audi";

		String modelo =  "TT";
		veiculo = new Veiculo(placa, marca, modelo);
		
		String nomeSeg =  "SEGURA VEICULOS";
		
		String teleSeg =  "1999999999";
		
		String email =  "seguraesseveiculo@gmail.com";
		
		String endSeg =  "Rua da seguradora";
		seguradora = new Seguradora(nomeSeg, teleSeg, email, endSeg);
		
		System.out.println(cliente);
		System.out.println(sinistro1);
		System.out.println(sinistro2);
		
	}
	
}