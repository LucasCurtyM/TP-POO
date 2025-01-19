import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Hospede extends Usuario {
    private List<Reserva> reservas;

    public Hospede(String nome, String cpf, String email) {
        super(nome, cpf, email);
        this.reservas = new ArrayList<>();
    }

    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    @Override
    public void verificarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada para o hóspede " + getNome() + ".");
        } else {
            System.out.println("Reservas do hóspede " + getNome() + ":");
            for (Reserva reserva : reservas) {
                System.out.println("Reserva ID: " + reserva.getId() +
                        ", Status: " + reserva.getStatus() +
                        ", Check-in: " + reserva.getDataCheckIn() +
                        ", Check-out: " + reserva.getDataCheckOut());
            }
        }
    }

    @Override
    public void exibirPerfil() {
        super.exibirPerfil();
        System.out.println("Tipo: Hóspede");
        System.out.println("Reservas associadas: " + reservas.size());
    }

    @Override
    public void login() {
        System.out.println("Bem-vindo, " + getNome() + ". Você está logado como hóspede.");
        setLogado(true);
    }

    @Override
    public void listarAtividades() {
        System.out.println("Hóspede pode acessar as seguintes atividades:");
        System.out.println("- Visualizar reservas");
        System.out.println("- Modificar reservas");
        System.out.println("- Solicitar serviços adicionais");
    }

    // Sobrescreve o método para escrever "Hospede" no arquivo
    @Override
    public void escreverUsuario(String senha) {
        try (FileWriter writer = new FileWriter(Cadastro.FILE_NAME, true)) {
            writer.write(getEmail() + "," + senha + ",Hospede\n");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o hóspede: " + e.getMessage());
        }
    }
}
