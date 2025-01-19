import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;

public class TelaHotel extends JFrame {

    private Hotel hotel;
    private JPanel painelHotel;
    private JTextField diasTextField; // Campo para inserir a quantidade de dias

    public TelaHotel() {
        // Inicializando o hotel com dados aleatórios
        hotel = criarHotelAleatorio();

        // Configuração da tela
        setTitle("Tela do Hotel");
        setSize(600, 600); // Aumentando a altura para uma melhor disposição
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal com Layout ajustado
        painelHotel = new JPanel();
        painelHotel.setLayout(new BoxLayout(painelHotel, BoxLayout.Y_AXIS));
        painelHotel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Título do Hotel
        JLabel nomeLabel = new JLabel("<html><b>Hotel: </b>" + hotel.getNome() + "</html>");
        nomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        nomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Endereço do Hotel
        JLabel enderecoLabel = new JLabel("<html><b>Endereço: </b>" + hotel.getEndereco() + "</html>");
        enderecoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        enderecoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Telefone do Hotel
        JLabel telefoneLabel = new JLabel("<html><b>Telefone: </b>" + hotel.getTelefone() + "</html>");
        telefoneLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        telefoneLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Listando os quartos disponíveis
        JLabel quartosLabel = new JLabel("<html><b>Quartos Disponíveis:</b></html>");
        quartosLabel.setFont(new Font("Arial", Font.BOLD, 14));
        quartosLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Criando a tabela para exibir os quartos
        String[] colunas = {"ID", "Tipo", "Preço (R$)", "Capacidade", "Status"};
        Object[][] dados = new Object[hotel.listarQuartosDisponiveis().size()][5];

        int i = 0;
        for (Quarto quarto : hotel.listarQuartosDisponiveis()) {
            dados[i][0] = quarto.getId();
            dados[i][1] = quarto.getTipo();
            dados[i][2] = String.format("%.2f", quarto.getPreco()); // Formatando o preço
            dados[i][3] = quarto.getCapacidade();
            dados[i][4] = quarto.getStatus();
            i++;
        }

        // Criando a tabela
        JTable tabelaQuartos = new JTable(dados, colunas);
        tabelaQuartos.setFont(new Font("Arial", Font.PLAIN, 14));
        tabelaQuartos.setPreferredScrollableViewportSize(new Dimension(550, 150));
        tabelaQuartos.setFillsViewportHeight(true);
        tabelaQuartos.setDefaultEditor(Object.class, null); // Desabilitando a edição

        // Adicionando a tabela a um painel com rolagem
        JScrollPane scrollPane = new JScrollPane(tabelaQuartos);
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Adicionando os componentes ao painel
        painelHotel.add(nomeLabel);
        painelHotel.add(Box.createRigidArea(new Dimension(0, 10)));
        painelHotel.add(enderecoLabel);
        painelHotel.add(Box.createRigidArea(new Dimension(0, 10)));
        painelHotel.add(telefoneLabel);
        painelHotel.add(Box.createRigidArea(new Dimension(0, 10)));
        painelHotel.add(quartosLabel);
        painelHotel.add(Box.createRigidArea(new Dimension(0, 10)));
        painelHotel.add(scrollPane); // Tabela dos quartos

        // Painel de fundo
        JPanel fundoPanel = new JPanel();
        fundoPanel.setLayout(new BorderLayout());
        fundoPanel.setBackground(new Color(245, 245, 245));  // Cor de fundo suave
        fundoPanel.add(painelHotel, BorderLayout.CENTER);

        // Adicionando o painel de fundo ao frame
        add(fundoPanel);
    }

    private Hotel criarHotelAleatorio() {
        // Gerando dados aleatórios para o hotel
        Random rand = new Random();
        String nome = "Hotel " + (rand.nextInt(1000) + 1);
        String endereco = "Rua " + (rand.nextInt(100) + 1) + ", Bairro " + (rand.nextInt(50) + 1);
        String telefone = "(" + (rand.nextInt(10) + 1) + ")" + (rand.nextInt(10000) + 10000);

        Hotel hotel = new Hotel(nome, endereco, telefone);

        // Criando quartos aleatórios
        for (int i = 0; i < 5; i++) { // Adicionando 5 quartos aleatórios
            int id = rand.nextInt(1000) + 1;
            String tipo = "Quarto " + (rand.nextInt(3) + 1);
            double preco = rand.nextDouble() * (500 - 100) + 100; // Preço aleatório entre 100 e 500
            int capacidade = rand.nextInt(3) + 1; // Capacidade aleatória entre 1 e 3
            String status = rand.nextBoolean() ? "Disponível" : "Ocupado"; // Status aleatório
            hotel.adicionarQuarto(new Quarto(id, tipo, preco, capacidade, status));
        }

        return hotel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaHotel().setVisible(true));
    }
}
