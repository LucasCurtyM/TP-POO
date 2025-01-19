import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin extends JFrame {

    private JTextField emailField;
    private JPasswordField senhaField;
    private JButton loginButton;
    private JLabel mensagemLabel;

    public TelaLogin() {
        // Configuração da tela
        setTitle("Tela de Login");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criando os componentes
        emailField = new JTextField(20);
        senhaField = new JPasswordField(20);
        loginButton = new JButton("Login");
        mensagemLabel = new JLabel("");
        mensagemLabel.setForeground(Color.RED);

        // Ação do botão de login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String senha = new String(senhaField.getPassword());

                // Instanciando a classe Login
                Login login = new Login();
                // Chamando o método realizaLogin
                if (login.realizaLogin(email, senha)) {
                    TelaReserva telaReserva = new TelaReserva();
                    telaReserva.setVisible(true);
                    setVisible(false); // Fecha a tela de login
                } else {
                    mensagemLabel.setText("Usuário não encontrado");
                }
            }
        });

        // Layout da tela de login
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Organizando os componentes verticalmente
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Adicionando borda ao painel

        // Adicionando os componentes ao painel com espaçamento
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento entre os campos
        panel.add(new JLabel("Senha:"));
        panel.add(senhaField);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento entre os campos
        panel.add(loginButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento entre o botão e a mensagem
        panel.add(mensagemLabel);

        // Adicionando o painel ao frame
        add(panel);

        // Configurações adicionais de design
        loginButton.setBackground(new Color(0, 123, 255)); // Cor de fundo do botão
        loginButton.setForeground(Color.WHITE); // Cor do texto do botão
        loginButton.setFocusPainted(false); // Remove a borda de foco do botão
        loginButton.setPreferredSize(new Dimension(100, 35)); // Ajustando o tamanho do botão

        setLocationRelativeTo(null); // Centraliza a janela na tela
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaLogin().setVisible(true);
        });
    }
}
