public class Login {
    public boolean realizaLogin(String email, String senha) {
        // Implementação fictícia de login, verificando se o email e senha são "admin"
        if (email.equals("admin") && senha.equals("admin")) {
            System.out.println("Login realizado para o email: " + email);
            return true; // Login bem-sucedido
        }
        return false; // Login falhou
    }
}
