import java.util.ArrayList;
import java.util.List;


public class Hospede {
    private String nome;
    private String cpf;
    private String email;
    private boolean logado;
    private List<Reserva> reservas;

    public Hospede(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.logado = false;
        this.reservas = new ArrayList<>();
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
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada para o hóspede " + nome + ".");
        } else {
            System.out.println("Reservas do hóspede " + nome + ":");
            for (Reserva reserva : reservas) {
                System.out.println("Reserva ID: " + reserva.getId() +
                        ", Status: " + reserva.getStatus() +
                        ", Check-in: " + reserva.getDataCheckIn() +
                        ", Check-out: " + reserva.getDataCheckOut());
            }
        }
    }

}