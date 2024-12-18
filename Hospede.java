public class Hospede {
    private String nome;
    private String cpf;
    private String email;
    private boolean logado;

    public Hospede(String nome, String cpf, String email) {
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

}