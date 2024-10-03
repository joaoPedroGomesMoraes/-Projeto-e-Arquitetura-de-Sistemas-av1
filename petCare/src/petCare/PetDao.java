package petCare;

import java.util.ArrayList;
import java.util.List;

public class PetDao {
	 private List<Pet> pets = new ArrayList<>();

	    // Create
	    public void adicionarPet(Pet pet) {
	        pets.add(pet);
	        System.out.println("Pet adicionado: " + pet);
	    }

	    // Read (Consultar um Pet)
	    public Pet buscarPetPorNome(String nome) {
	        for (Pet pet : pets) {
	            if (pet.getNome().equalsIgnoreCase(nome)) {
	                return pet;
	            }
	        }
	        System.out.println("Pet não encontrado.");
	        return null;
	    }

	    // Update
	    public void atualizarPet(String nome, Pet novosDados) {
	        Pet pet = buscarPetPorNome(nome);
	        if (pet != null) {
	            pet.setNome(novosDados.getNome());
	            pet.setRaca(novosDados.getRaca());
	            pet.setIdade(novosDados.getIdade());
	            pet.setPorte(novosDados.getPorte());
	            pet.setSexo(novosDados.getSexo());
	            System.out.println("Pet atualizado: " + pet);
	        }
	    }

	    // Delete
	    public void removerPet(String nome) {
	        Pet pet = buscarPetPorNome(nome);
	        if (pet != null) {
	            pets.remove(pet);
	            System.out.println("Pet removido: " + pet);
	        }
	    }

	    // Listar todos os Pets
	    public void listarPets() {
	        if (pets.isEmpty()) {
	            System.out.println("Nenhum pet cadastrado.");
	        } else {
	            for (Pet pet : pets) {
	                System.out.println(pet);
	            }
	        }
	    }

}
