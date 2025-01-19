import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelaInicial extends JFrame {

    private JButton loginButton;
    private JButton cadastroButton;
    private JButton hotelButton;  // Novo botão para ir para a TelaHotel

    public TelaInicial() {
        // Configuração da tela
        setTitle("Tela Inicial");
        setSize(400, 400);  // Tamanho da janela ajustado para a imagem ser visível
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Centraliza a janela

        // Criando os botões
        loginButton = new JButton("Login");
        cadastroButton = new JButton("Cadastro");
        hotelButton = new JButton("Ir para o Hotel");  // Novo botão

        // Estilizando os botões
        loginButton.setFont(new Font("Arial", Font.BOLD, 12));  // Tamanho da fonte reduzido
        cadastroButton.setFont(new Font("Arial", Font.BOLD, 12));  // Tamanho da fonte reduzido
        hotelButton.setFont(new Font("Arial", Font.BOLD, 12));  // Tamanho da fonte reduzido
        loginButton.setPreferredSize(new Dimension(80, 30));  // Diminuindo ainda mais o tamanho dos botões
        cadastroButton.setPreferredSize(new Dimension(80, 30));  // Diminuindo ainda mais o tamanho dos botões
        hotelButton.setPreferredSize(new Dimension(120, 30));  // Tamanho adequado para o novo botão

        // Ação do botão de login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaLogin telaLogin = new TelaLogin();
                telaLogin.setVisible(true);
                setVisible(false); // Fecha a tela inicial
            }
        });

        // Ação do botão de cadastro
        cadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastro telaCadastro = new TelaCadastro();
                telaCadastro.setVisible(true);
                setVisible(false); // Fecha a tela inicial
            }
        });

        // Ação do botão de hotel (ir para a tela do hotel)
        hotelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaHotel telaHotel = new TelaHotel();
                telaHotel.setVisible(true);  // Abre a tela do hotel
                setVisible(false); // Fecha a tela inicial
            }
        });

        // Criando um painel personalizado para o fundo
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Carregando a imagem de fundo
                ImageIcon imageIcon = new ImageIcon("images/imagemInicial.jpg"); // Substitua pelo caminho da imagem
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this); // Desenha a imagem no painel
            }
        };

        // Definir o layout como null para controle total da posição dos botões
        panel.setLayout(null);
      

        // Definindo os botões para posição absoluta, para controlar diretamente
        loginButton.setBounds(100, 150, 100, 30);  // Posição e tamanho do botão login
        cadastroButton.setBounds(200, 150, 100, 30);  // Posição e tamanho do botão cadastro
        hotelButton.setBounds(150, 200, 100, 30);  // Posição e tamanho do botão ir para o hotel

        // Adicionando os botões diretamente no painel
        panel.add(loginButton);
        panel.add(cadastroButton);
        panel.add(hotelButton);  // Adiciona o botão de hotel ao painel

        // Adiciona o painel à janela
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaInicial telaInicial = new TelaInicial();
            telaInicial.setVisible(true);
        });
    }
}
