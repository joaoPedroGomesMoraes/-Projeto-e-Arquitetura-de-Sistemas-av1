package petCare;

public class PetFactory {
	 public static Pet criarPet(String nome, String raca, int idade, String porte, String sexo) {
	        return new Pet(nome, raca, idade, porte, sexo);
	    }
	
}
