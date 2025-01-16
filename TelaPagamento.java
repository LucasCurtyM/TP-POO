import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.List;

public class TelaPagamento extends JFrame {

    private Reserva reserva;
    private Pagamento pagamento;
    private JButton confirmarPagamentoButton;
    private JLabel statusLabel;
    private JLabel avisoLabel; // Label para o aviso

    public TelaPagamento(Reserva reserva) {
        this.reserva = reserva;

        // Configuração da tela de pagamento
        setTitle("Tela de Pagamento");
        setSize(500, 500); // Aumentando a tela para comportar os elementos com mais espaço
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Adiciona borda para espaçamento

        // Estilo para o título e informações
        JLabel infoLabel = new JLabel("<html><b>Reserva Confirmada!</b><br>Quarto: " + reserva.getQuarto().getTipo() +
                " | Data Check-In: " + reserva.getDataCheckIn() +
                " | Data Check-Out: " + reserva.getDataCheckOut() + "</html>");
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        infoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Inicializando o pagamento
        pagamento = new Pagamento(1, reserva.calcularDuracao() * 150.0, "Cartão de Crédito");

        // Estilo para o valor da reserva
        JLabel valorLabel = new JLabel("<html><b>Valor Total:</b> R$ " + pagamento.getValor() + "</html>");
        valorLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        valorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        valorLabel.setForeground(new Color(34, 139, 34)); // Cor verde para destacar o valor

        // Estilo para os hóspedes
        JPanel hospedesPanel = new JPanel();
        hospedesPanel.setLayout(new BoxLayout(hospedesPanel, BoxLayout.Y_AXIS));
        hospedesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        List<Hospede> hospedes = reserva.getHospedes();
        for (Hospede hospede : hospedes) {
            JLabel hospedeLabel = new JLabel("<html>Hóspede: <b>" + hospede.getNome() + "</b> | CPF: " + hospede.getCpf() + " | Email: " + hospede.getEmail() + "</html>");
            hospedeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            hospedesPanel.add(hospedeLabel);
        }

        // Botão para confirmar o pagamento
        confirmarPagamentoButton = new JButton("Confirmar Pagamento");
        confirmarPagamentoButton.setFont(new Font("Arial", Font.BOLD, 14));
        confirmarPagamentoButton.setBackground(new Color(0, 123, 255)); // Cor azul para o botão
        confirmarPagamentoButton.setForeground(Color.WHITE); // Cor branca para o texto
        confirmarPagamentoButton.setPreferredSize(new Dimension(200, 40)); // Tamanho do botão
        confirmarPagamentoButton.setFocusPainted(false); // Remove a borda de foco do botão
        confirmarPagamentoButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Ação do botão de confirmar pagamento
        confirmarPagamentoButton.addActionListener(e -> {
            pagamento.processarPagamento();
            statusLabel.setText("Status do Pagamento: " + pagamento.verificarStatus());

            // Criando os hóspedes e exibindo o aviso
            criarHospedes();
            avisoLabel.setText("Hóspedes criados com sucesso!"); // Exibindo aviso
        });

        // Status do pagamento
        statusLabel = new JLabel("Status do Pagamento: " + pagamento.verificarStatus());
        statusLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Aviso para hóspedes criados
        avisoLabel = new JLabel("");
        avisoLabel.setFont(new Font("Arial", Font.BOLD, 14));
        avisoLabel.setForeground(Color.GREEN);
        avisoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Adicionando os componentes ao painel
        panel.add(infoLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento
        panel.add(valorLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento
        panel.add(hospedesPanel); // Adiciona o painel com as informações dos hóspedes
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Espaçamento
        panel.add(confirmarPagamentoButton);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Espaçamento
        panel.add(statusLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento
        panel.add(avisoLabel); // Adiciona o aviso de criação de hóspedes

        // Adiciona o painel ao frame
        add(panel);
    }

    private void criarHospedes() {
        // Aqui você pode criar novos hóspedes com as informações fornecidas.
        // No caso, vamos apenas simular a criação deles.
        for (Hospede hospede : reserva.getHospedes()) {
            // Criar os hóspedes. Para efeito de exemplo, apenas imprimimos no console.
            System.out.println("Hóspede Criado: " + hospede.getNome() + " | CPF: " + hospede.getCpf() + " | Email: " + hospede.getEmail());
        }
    }

    public static void main(String[] args) {
        // Criando um exemplo de reserva e chamando a tela de pagamento
        Quarto quarto = new Quarto(1, "Quarto Luxo", 300.0, 2, "Disponível");
        List<Hospede> hospedes = List.of(
                new Hospede("João Silva", "12345678900", "joao@email.com"),
                new Hospede("Maria Oliveira", "98765432100", "maria@email.com")
        );
        Reserva reserva = new Reserva(1, new Date(), new Date(System.currentTimeMillis() + 86400000), hospedes, quarto);
        SwingUtilities.invokeLater(() -> new TelaPagamento(reserva).setVisible(true));
    }
}
