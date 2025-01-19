import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cadastro {
    public static final String FILE_NAME = "usuarios.txt";

    public void realizaCadastro(String nome, String cpf, String email, String senha, String tipo) {
        if (emailJaCadastrado(email)) {
            System.out.println("Email já cadastrado.");
            return;
        }

        // Criação do objeto dependendo do tipo
        Usuario usuario;
        if ("Hospede".equals(tipo)) {
            usuario = new Hospede(nome, cpf, email);
        } else {
            usuario = new Usuario(nome, cpf, email);
        }

        // Chamada do método polimórfico para salvar o usuário
        usuario.escreverUsuario(senha);
        
        System.out.println(tipo + " cadastrado com sucesso!");
    }

    private boolean emailJaCadastrado(String email) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados[0].equals(email)) {
                    return true;
                }
            }
        } catch (IOException e) {
            // Arquivo pode não existir ainda
        }
        return false;
    }

    private int getTotalLinhas() {
        int linhas = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            while (reader.readLine() != null) {
                linhas++;
            }
        } catch (IOException e) {
            System.out.println("Erro ao contar linhas no arquivo: " + e.getMessage());
        }
        return linhas;
    }

    public void excluirCadastro(String email) {
        // Criar uma lista temporária para armazenar as linhas que não devem ser excluídas
        List<String> linhas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                // Verifica se o email não corresponde ao email a ser excluído
                if (!dados[0].equals(email)) {
                    linhas.add(linha);  
                }
            }

        
            if (linhas.size() < getTotalLinhas()) {
                try (FileWriter writer = new FileWriter(FILE_NAME)) {
                    for (String l : linhas) {
                        writer.write(l + "\n");
                    }
                    System.out.println("Cadastro excluído com sucesso!");
                }
            } else {
                System.out.println("Email não encontrado para exclusão.");
            }

        } catch (IOException e) {
            System.out.println("Erro ao tentar excluir o cadastro: " + e.getMessage());
        }
    }

    /*public static void main(String[] args) {
        // Criar o objeto Cadastro
        Cadastro cadastro = new Cadastro();

        // Cadastrar alguns usuários
        cadastro.realizaCadastro("João", "12345678901", "joao@example.com", "senha123", "Usuario");
        cadastro.realizaCadastro("Maria", "98765432100", "maria@example.com", "senha456", "Hospede");

        // Tentar excluir um cadastro
        System.out.println("\nExcluindo o cadastro do usuário joao@example.com");
        //cadastro.excluirCadastro("joao@example.com");

        // Tentar excluir um cadastro não existente
        System.out.println("\nTentando excluir o cadastro de um usuário não existente (naoexiste@example.com)");
        cadastro.excluirCadastro("naoexiste@example.com");
    }*/ 
}
