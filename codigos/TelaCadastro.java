import java.awt.*;
import javax.swing.*;

public class TelaCadastro extends JFrame {
    private JTextField emailField;
    private JPasswordField senhaField;
    private JButton cadastrarButton;
    private JRadioButton usuarioToggle;
    private JRadioButton hospedeToggle;
    private Cadastro cadastro;

    public TelaCadastro() {
        setTitle("Cadastro de Usuário");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cadastro = new Cadastro();

        // Painel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(240, 240, 255)); // Cor de fundo suave

        // Título
        JLabel titleLabel = new JLabel("Cadastro de Usuario");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(new Color(50, 50, 150)); // Cor do texto
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(titleLabel);

        // Painel de campos
        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.Y_AXIS));
        fieldsPanel.setOpaque(false); // Transparente para fundo principal
        fieldsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        fieldsPanel.setBorder(BorderFactory.createEmptyBorder(20, 120, 20, 20));

        JLabel emailLabel = new JLabel("E-mail:");
        emailField = new JTextField(20);
        emailField.setMaximumSize(new Dimension(400, 30));
        emailField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        emailField.setToolTipText("Digite seu e-mail");

        JLabel senhaLabel = new JLabel("Senha:");
        senhaField = new JPasswordField(20);
        senhaField.setMaximumSize(new Dimension(400, 30));
        senhaField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        senhaField.setToolTipText("Digite sua senha");

        fieldsPanel.add(emailLabel);
        fieldsPanel.add(emailField);
        fieldsPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        fieldsPanel.add(senhaLabel);
        fieldsPanel.add(senhaField);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(fieldsPanel);

        // Painel de alternância
        JLabel toggleLabel = new JLabel("Selecione o tipo:");
        toggleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        toggleLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        usuarioToggle = new JRadioButton("Usuário");
        hospedeToggle = new JRadioButton("Hóspede");

        ButtonGroup group = new ButtonGroup();
        group.add(usuarioToggle);
        group.add(hospedeToggle);

        usuarioToggle.setSelected(true);

        JPanel togglePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        togglePanel.setOpaque(false); // Transparente para fundo principal
        togglePanel.add(usuarioToggle);
        togglePanel.add(hospedeToggle);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        mainPanel.add(toggleLabel);
        mainPanel.add(togglePanel);

        // Botão de cadastro
        cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        cadastrarButton.setBackground(new Color(0, 120, 215)); // Azul moderno
        cadastrarButton.setForeground(Color.WHITE);
        cadastrarButton.setFont(new Font("Arial", Font.BOLD, 14));
        cadastrarButton.setToolTipText("Clique para realizar o cadastro");

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(cadastrarButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Adicionar painel principal à janela
        add(mainPanel);

        // Ação do botão
        cadastrarButton.addActionListener(e -> {
            String email = emailField.getText();
            String senha = new String(senhaField.getPassword());

            if (email.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (usuarioToggle.isSelected()) {
                cadastro.realizaCadastro("nome", "cpf", email, senha, "Usuario");
            } else if (hospedeToggle.isSelected()) {
                cadastro.realizaCadastro("nome", "cpf", email, senha, "Hospede");
            }

            JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
            dispose();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaCadastro telaCadastro = new TelaCadastro();
            telaCadastro.setVisible(true);
        });
    }
}
