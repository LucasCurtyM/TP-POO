import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TelaReserva extends JFrame {

    private JTextField checkInField;
    private JTextField checkOutField;
    private JComboBox<String> quartoComboBox;
    private JComboBox<Integer> hospedesComboBox; // Seleção da quantidade de hóspedes
    private JButton confirmarButton;
    private JPanel hospedesPanel; // Painel para adicionar campos de hóspedes
    private JScrollPane hospedesScrollPane; // Scroll para os hóspedes
    private Reserva reserva;

    public TelaReserva() {
        // Configuração da tela
        setTitle("Tela de Reserva");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Obter a altura da tela
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

        // Definindo os tamanhos dos campos de data como 8% da altura da tela
        int fieldHeight = (int) (screenHeight * 0.08);  // Menor altura para o campo
        int fieldWidth = 120; // Largura mais compacta

        // Criando os componentes da tela de reserva
        checkInField = new JTextField(8); // Reduzindo o tamanho para 8 caracteres
        checkOutField = new JTextField(8); // Reduzindo o tamanho para 8 caracteres
        quartoComboBox = new JComboBox<>(new String[] {"Quarto 1 - Simples", "Quarto 2 - Duplo", "Quarto 3 - Luxo"});
        hospedesComboBox = new JComboBox<>(new Integer[] {1, 2, 3, 4, 5}); // Quantidade de hóspedes (1 a 5)
        hospedesPanel = new JPanel();
        hospedesPanel.setLayout(new BoxLayout(hospedesPanel, BoxLayout.Y_AXIS)); // Coloca cada hóspede em uma linha
        hospedesScrollPane = new JScrollPane(hospedesPanel); // Adiciona o painel de hóspedes em um scroll
        confirmarButton = new JButton("Confirmar Reserva");

        // Ajustando as larguras e alturas dos campos de texto
        checkInField.setPreferredSize(new Dimension(fieldWidth, fieldHeight));
        checkOutField.setPreferredSize(new Dimension(fieldWidth, fieldHeight));

        // Ação do botão de confirmar reserva
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obtendo as datas de entrada
                    String checkIn = checkInField.getText();
                    String checkOut = checkOutField.getText();

                    // Definindo o formato das datas
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataCheckIn = dateFormat.parse(checkIn);
                    Date dataCheckOut = dateFormat.parse(checkOut);

                    // Verificando se a data de check-out é maior que a de check-in
                    if (dataCheckOut.before(dataCheckIn)) {
                        JOptionPane.showMessageDialog(null, "A data de check-out deve ser maior que a data de check-in.");
                        return; // Impede a criação da reserva se a data estiver incorreta
                    }

                    // Criando a lista de hóspedes com base nos campos preenchidos
                    List<Hospede> hospedes = new ArrayList<>();
                    for (Component component : hospedesPanel.getComponents()) {
                        if (component instanceof JPanel) {
                            JPanel panel = (JPanel) component;
                            // Aqui, pegamos corretamente os campos de texto dos hóspedes
                            JTextField nomeHospedeField = (JTextField) panel.getComponent(1); // Nome
                            JTextField cpfHospedeField = (JTextField) panel.getComponent(3);  // CPF
                            JTextField emailHospedeField = (JTextField) panel.getComponent(5); // Email

                            String nomeHospede = nomeHospedeField.getText();
                            String cpfHospede = cpfHospedeField.getText();
                            String emailHospede = emailHospedeField.getText();

                            if (!nomeHospede.trim().isEmpty() && !cpfHospede.trim().isEmpty() && !emailHospede.trim().isEmpty()) {
                                // Criar o hóspede com nome, CPF e e-mail
                                Hospede hospede = new Hospede(nomeHospede, cpfHospede, emailHospede);
                                hospedes.add(hospede);
                            }
                        }
                    }

                    // Criando o quarto (usando o índice selecionado no comboBox)
                    Quarto quarto = new Quarto(1, quartoComboBox.getSelectedItem().toString(), 150.0, hospedes.size(), "Disponível");

                    // Criando a reserva com a lista de hóspedes
                    reserva = new Reserva(1, dataCheckIn, dataCheckOut, hospedes, quarto);
                    reserva.confirmarReserva();

                    // Redireciona para a tela de pagamento
                    TelaPagamento telaPagamento = new TelaPagamento(reserva);
                    telaPagamento.setVisible(true);
                    setVisible(false); // Fecha a tela de reserva
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao criar a reserva. Verifique as datas e dados dos hóspedes.");
                    ex.printStackTrace(); // Para exibir o erro detalhado no console
                }
            }
        });

        // Ação para alterar o número de hóspedes
        hospedesComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numHospedes = (int) hospedesComboBox.getSelectedItem();
                atualizarCamposHospedes(numHospedes);
            }
        });

        // Layout da tela de reserva
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Borda do painel para espaçamento

        // Estilo para os rótulos
        Font labelFont = new Font("Arial", Font.PLAIN, 14);
        JLabel checkInLabel = new JLabel("Data Check-In (formato: dd/mm/yyyy):");
        checkInLabel.setFont(labelFont);
        JLabel checkOutLabel = new JLabel("Data Check-Out (formato: dd/mm/yyyy):");
        checkOutLabel.setFont(labelFont);
        JLabel quartoLabel = new JLabel("Escolha o Quarto:");
        quartoLabel.setFont(labelFont);
        JLabel hospedesLabel = new JLabel("Número de Hóspedes:");
        hospedesLabel.setFont(labelFont);
        JLabel hospedesSubLabel = new JLabel("Hóspedes:");
        hospedesSubLabel.setFont(labelFont);

        // Criando um painel horizontal para colocar os campos de data lado a lado
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new GridLayout(2, 2, 5, 5)); // Organizando rótulos e campos com GridLayout
        dataPanel.add(checkInLabel);
        dataPanel.add(checkInField);
        dataPanel.add(checkOutLabel);
        dataPanel.add(checkOutField);

        // Adicionando os componentes com espaçamento adequado
        panel.add(dataPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento
        panel.add(quartoLabel);
        panel.add(quartoComboBox);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento
        panel.add(hospedesLabel);
        panel.add(hospedesComboBox);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento
        panel.add(hospedesSubLabel);

        // Adicionando o painel dos hóspedes dentro do JScrollPane
        panel.add(hospedesScrollPane);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento
        panel.add(confirmarButton);

        // Personalizando o botão de confirmação
        confirmarButton.setBackground(new Color(0, 123, 255)); // Cor de fundo do botão
        confirmarButton.setForeground(Color.WHITE); // Cor do texto do botão
        confirmarButton.setPreferredSize(new Dimension(150, 40)); // Ajustando o tamanho do botão
        confirmarButton.setFocusPainted(false); // Remove a borda de foco do botão

        // Adicionando o painel ao frame
        add(panel);

        setLocationRelativeTo(null); // Centraliza a janela na tela
    }

    // Atualiza os campos de hóspede com base no número selecionado
    private void atualizarCamposHospedes(int numHospedes) {
        hospedesPanel.removeAll(); // Limpa os campos antigos

        // Adiciona novos campos de texto para os hóspedes
        for (int i = 0; i < numHospedes; i++) {
            JPanel hospedePanel = new JPanel();
            hospedePanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Disposição em linha

            JTextField nomeHospede = new JTextField(15);
            nomeHospede.setToolTipText("Nome do hóspede " + (i + 1));

            JTextField cpfHospede = new JTextField(15);
            cpfHospede.setToolTipText("CPF do hóspede " + (i + 1));

            JTextField emailHospede = new JTextField(15);
            emailHospede.setToolTipText("E-mail do hóspede " + (i + 1));

            hospedePanel.add(new JLabel("Hóspede " + (i + 1) + ":"));
            hospedePanel.add(nomeHospede);
            hospedePanel.add(new JLabel("CPF:"));
            hospedePanel.add(cpfHospede);
            hospedePanel.add(new JLabel("E-mail:"));
            hospedePanel.add(emailHospede);

            hospedesPanel.add(hospedePanel);
        }

        hospedesPanel.revalidate();
        hospedesPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaReserva().setVisible(true);
        });
    }
}
