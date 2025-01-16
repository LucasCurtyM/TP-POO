import javax.swing.*;
import java.awt.*;

public class TelaCadastro extends JFrame {
    private JTextField emailField;
    private JPasswordField senhaField;
    private JButton cadastrarButton;
    private Cadastro cadastro; // Instância da classe Cadastro

    public TelaCadastro() {
        // Configuração da tela
        setTitle("Tela de Cadastro");
        setSize(400, 300); // Tamanho ajustado
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a tela na tela do usuário

        // Criando a instância de Cadastro
        cadastro = new Cadastro();

        // Painel principal com BoxLayout para centralizar os componentes
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Alinhamento vertical

        // Definindo o título
        JLabel titleLabel = new JLabel("Cadastro de Usuário", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Alinha o título no centro
        panel.add(titleLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Espaço entre o título e os campos

        // Painel dos campos de entrada, com BoxLayout para os campos
        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.Y_AXIS)); // Alinhamento vertical
        fieldsPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Alinha os campos no centro

        // E-mail
        JLabel emailLabel = new JLabel("E-mail:");
        emailLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Alinha o rótulo ao centro
        emailField = new JTextField(20);
        emailField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        emailField.setMaximumSize(new Dimension(300, 30)); // Define o tamanho máximo do campo de texto

        // Senha
        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Alinha o rótulo ao centro
        senhaField = new JPasswordField(20);
        senhaField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        senhaField.setMaximumSize(new Dimension(300, 30)); // Define o tamanho máximo do campo de senha

        // Adicionando os campos ao painel de campos
        fieldsPanel.add(emailLabel);
        fieldsPanel.add(emailField);
        fieldsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço entre os campos
        fieldsPanel.add(senhaLabel);
        fieldsPanel.add(senhaField);

        // Adiciona o painel de campos ao painel principal
        panel.add(fieldsPanel);

        // Espaço entre os campos e o botão
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Botão de cadastro
        cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBackground(new Color(34, 139, 34)); // Cor verde para o botão
        cadastrarButton.setForeground(Color.WHITE);
        cadastrarButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Alinha o botão no centro
        panel.add(cadastrarButton);

        // Cor de fundo para a tela
        getContentPane().setBackground(new Color(240, 240, 240)); // Cor suave de fundo

        // Adicionando o painel principal à tela
        add(panel);

        // Ação do botão de cadastro
        cadastrarButton.addActionListener(e -> {
            String email = emailField.getText();
            String senha = new String(senhaField.getPassword());

            // Chama o método da classe Cadastro para realizar o cadastro
            cadastro.realizaCadastro(email, senha);

            // Abre a tela de reserva após cadastro
            TelaReserva telaReserva = new TelaReserva();
            telaReserva.setVisible(true);

            // Fecha a tela de cadastro
            setVisible(false);
            dispose();
        });
    }
}
