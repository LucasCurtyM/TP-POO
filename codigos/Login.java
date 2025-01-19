import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Login {
    
    private static final String FILE_NAME = "usuarios.txt";

    public boolean realizaLogin(String email, String senha) {
        if (verificarCredenciais(email, senha)) {
            System.out.println("Login realizado com sucesso!");
            return true;
        } else {
            System.out.println("Email ou senha incorretos.");
            return false;
        }
    }

    private boolean verificarCredenciais(String email, String senha) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados[0].equals(email) && dados[1].equals(senha)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao verificar credenciais: " + e.getMessage());
        }
        return false;
    }
    

    // public static void main(String[] args) {
    //     Login login = new Login();
    //     String emailLogin = "usuario@example.com";
    //     String senhaLogin = "senha123";
    //     login.realizaLogin(emailLogin, senhaLogin);
    // }

}
