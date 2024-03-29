package Lab02;
import java.util.InputMismatchException;
public class Cliente{
		private String nome;
		private String cpf;
		private String dataNascimento;
		private int idade;
		private String endereco;
		
		// construtor
		public Cliente(String nome , String cpf , String dataNascimento , int idade, String endereco ) {
			this.nome = nome;
			this.cpf = cpf;
			this.dataNascimento = dataNascimento;
			this.endereco = endereco;
			this.idade = idade;
		}
	
	// getters e setters
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String toString(){
        return "Nome do cliente: " + this.nome + "\nCPF do cliente: " + this.cpf + "\nIdade do cliente: " + this.idade + " \nEndereco do cliente: " + this.endereco;
    }
    
	public boolean validarCPF(String cpf) {
		cpf = cpf.replaceAll("\\D","");
		System.out.println(cpf);
		if(cpf.length() != 11) {
			return false;
		}
		if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") ||
				cpf.equals("44444444444") || cpf.equals("55555555555") ||
				cpf.equals("66666666666") || cpf.equals("77777777777") ||cpf.equals("88888888888") || cpf.equals("99999999999") ) {
			return(false);
		}
		char dig10, dig11;
        int sm, i, r, num, peso;
		try {
	        // Calculo do 1o. Digito Verificador
	            sm = 0;
	            peso = 10;
	            for (i=0; i<9; i++) {
	        // converte o i-esimo caractere do CPF em um numero:
	        // por exemplo, transforma o caractere '0' no inteiro 0
	        // (48 eh a posicao de '0' na tabela ASCII)
	            num = (int)(cpf.charAt(i) - 48);
	            sm = sm + (num * peso);
	            peso = peso - 1;
	            }

	            r = 11 - (sm % 11);
	            if ((r == 10) || (r == 11))
	                dig10 = '0';
	            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

	        // Calculo do 2o. Digito Verificador
	            sm = 0;
	            peso = 11;
	            for(i=0; i<10; i++) {
	            num = (int)(cpf.charAt(i) - 48);
	            sm = sm + (num * peso);
	            peso = peso - 1;
	            }

	            r = 11 - (sm % 11);
	            if ((r == 10) || (r == 11))
	                 dig11 = '0';
	            else dig11 = (char)(r + 48);

	        // Verifica se os digitos calculados conferem com os digitos informados.
	            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
	                 return(true);
	            else return(false);
	                } catch (InputMismatchException erro) {
	                return(false);
	            }
		
	        }
	          
	            
}

