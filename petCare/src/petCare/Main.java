package petCare;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
	    PetDao petDAO = new PetDao();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Sistema de Gerenciamento de Pets ===");
            System.out.println("1. Adicionar Pet");
            System.out.println("2. Buscar Pet");
            System.out.println("3. Atualizar Pet");
            System.out.println("4. Remover Pet");
            System.out.println("5. Listar todos os Pets");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    // Adicionar Pet
                    System.out.println("=== Adicionar Pet ===");
                    Pet novoPet = criarPetComInput(scanner);
                    petDAO.adicionarPet(novoPet);
                    break;
                case 2:
                    // Buscar Pet
                    System.out.println("=== Buscar Pet ===");
                    System.out.print("Digite o nome do pet que deseja buscar: ");
                    String nomeBusca = scanner.nextLine();
                    Pet petEncontrado = petDAO.buscarPetPorNome(nomeBusca);
                    if (petEncontrado != null) {
                        System.out.println("Pet encontrado: " + petEncontrado);
                    }
                    break;
                case 3:
                    // Atualizar Pet
                    System.out.println("=== Atualizar Pet ===");
                    System.out.print("Digite o nome do pet que deseja atualizar: ");
                    String nomeAtualizar = scanner.nextLine();
                    Pet novosDadosPet = criarPetComInput(scanner);
                    petDAO.atualizarPet(nomeAtualizar, novosDadosPet);
                    break;
                case 4:
                    // Remover Pet
                    System.out.println("=== Remover Pet ===");
                    System.out.print("Digite o nome do pet que deseja remover: ");
                    String nomeRemover = scanner.nextLine();
                    petDAO.removerPet(nomeRemover);
                    break;
                case 5:
                    // Listar Pets
                    System.out.println("=== Lista de Pets Cadastrados ===");
                    petDAO.listarPets();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    // Método auxiliar para criar um Pet com input do usuário
    private static Pet criarPetComInput(Scanner scanner) {
        System.out.print("Digite o nome do pet: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a raça do pet: ");
        String raca = scanner.nextLine();

        System.out.print("Digite a idade do pet: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        System.out.print("Digite o porte do pet (Pequeno, Médio, Grande): ");
        String porte = scanner.nextLine();

        System.out.print("Digite o sexo do pet (Macho, Fêmea): ");
        String sexo = scanner.nextLine();

        return PetFactory.criarPet(nome, raca, idade, porte, sexo);
	}

}
