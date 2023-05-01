package leite.lab03;

import java.util.InputMismatchException;
import java.util.Date;

public class ClientePF extends Cliente {
	private final String cpf;
	private String genero;
	private Date dataLicenca;
	private String educacao;
	private Date dataNascimento;
	private String classeEconomica;
	
	//Construtor da classe ClientePF
	public ClientePF(String nome, String endereco, String cpf, String genero,
            Date dataLicenca, String educacao, Date dataNascimento, String classeEconomica) {
		super(nome, endereco);
		this.cpf = cpf;
		this.genero = genero;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.dataNascimento = dataNascimento;
		this.classeEconomica = classeEconomica;
	}
	
	//Getters e Setters
	
	public String getCpf() {
		return cpf;
	}
	

	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public Date getDataLicenca() {
		return dataLicenca;
	}
	
	public void setDataLicenca(Date dataLicenca) {
		this.dataLicenca = dataLicenca;
	}
	
	public String getEducacao() {
		return educacao;
	}
	
	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getClasseEconomica() {
		return classeEconomica;
	}
	
	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}
	
	
	public static boolean validarCPF(String cpf) {
		
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
	
	public String toString() {
		return " Informações do cliente (PF):" +
                "\nCPF: " + cpf + 
                ",\nGênero: " + genero + 
                ",\nData de licença: " + dataLicenca +
                ",\nEducacao: " + educacao + 
                ",\nData de nascimento: " + dataNascimento +
                ",\nClasse econômica: " + classeEconomica;              
   	}
	
}
