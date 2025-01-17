import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Cadastro {
    private static final String FILE_NAME = "usuarios.txt";

    public void realizaCadastro(String email, String senha) {
        if (emailJaCadastrado(email)) {
            System.out.println("Email já cadastrado.");
            return;
        }
        cadastrarUsuario(email, senha);
        System.out.println("Usuário cadastrado com sucesso!");
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
            // caso não existe arquivo ainda
        }
        return false;
    }

    private void cadastrarUsuario(String email, String senha) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(email + "," + senha + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o usuário: " + e.getMessage());
        }
    }

    // public static void main(String[] args) {
    //     String email = "usuaro@gmail.com";
    //     String senha = "senha123";
    //     Cadastro cadastro = new Cadastro();
    //     cadastro.realizaCadastro(email, senha);

    // }
} 


