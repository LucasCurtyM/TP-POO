import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Usuario {
    private String nome;
    private String cpf;
    private String email;
    private boolean logado;

    public Usuario(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.logado = false;
    }

    public void setLogado(boolean status) {
        this.logado = status;
    }

    public boolean isLogado() {
        return logado;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void verificarReservas() {
        System.out.println("Usuários não podem ter reservas.");
    }

    public void exibirPerfil() {
        System.out.println("Perfil do Usuário:");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Email: " + email);
    }

    public void login() {
        System.out.println("Bem-vindo, " + nome + ". Você está logado como usuário comum.");
        logado = true;
    }

    public void listarAtividades() {
        System.out.println("Usuário comum não possui atividades adicionais.");
    }

    // Método polimórfico que será sobrescrito em Hospede
    public void escreverUsuario(String senha) {
        try (FileWriter writer = new FileWriter(Cadastro.FILE_NAME, true)) {
            writer.write(email + "," + senha + ",Usuario\n");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o usuário: " + e.getMessage());
        }
    }
}
