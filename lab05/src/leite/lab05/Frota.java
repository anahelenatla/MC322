package leite.lab05;

import java.util.ArrayList;

public class Frota {
	private String code;
	private ArrayList<Veiculo> listaVeiculos;
	
	public Frota(String code) {
		this.code = code;
		this.listaVeiculos = new ArrayList<>();
	}
	
	public String getCode(){
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public ArrayList<Veiculo> getListaVeiculos(){
		return listaVeiculos;
	}
	
	public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	
	public boolean addVeiculo(Veiculo veiculo) {
		return listaVeiculos.add(veiculo);
	}
	
	public boolean removeVeiculo(Veiculo veiculo) {
		return listaVeiculos.remove(veiculo);
	}
	
	public void imprimeVeiculos() {
		for (Veiculo veiculo : listaVeiculos) {
			System.out.println("\n" + veiculo);
		}
	}
	public String toString() {
        return  "\nTipo da frota: " + this.code + 
        		"\nNúmero de veículos na frota: " + this.listaVeiculos.size();
        		
}
}
