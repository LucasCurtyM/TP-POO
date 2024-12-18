import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Hotel Java", "Rua Exemplo, 123", "12345-6789");

        Quarto quarto1 = new Quarto(1, "Simples", 150.0, 2, "Disponível");
        hotel.adicionarQuarto(quarto1);

        Hospede hospede = new Hospede("João Silva", "12345678900", "joao@email.com");

        Cadastro cadastro = new Cadastro();
        cadastro.realizaCadastro(hospede.getEmail(), "senha123");

        Login login = new Login();
        login.realizaLogin(hospede.getEmail(), "senha123");

        // Reserva
        Reserva reserva = new Reserva(1, new Date(), new Date(System.currentTimeMillis() + (3 * 86400000)), hospede, quarto1);
        reserva.confirmarReserva();

        // Pagamento
        Pagamento pagamento = new Pagamento(1, quarto1.calcularPreco(reserva.calcularDuracao()), "Cartão de Crédito");
        pagamento.processarPagamento();
        System.out.println("Status do pagamento: " + pagamento.verificarStatus());
    }
}
