import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nome;
    private String endereco;
    private String telefone;
    private List<Quarto> quartosDisponiveis;

    public Hotel(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.quartosDisponiveis = new ArrayList<>();
    }

    public void adicionarQuarto(Quarto quarto) {
        quartosDisponiveis.add(quarto);
    }

    public List<Quarto> listarQuartosDisponiveis() {
        return quartosDisponiveis;
    }

    public Quarto buscarQuartoPorId(int id) {
        for (Quarto quarto : quartosDisponiveis) {
            if (quarto.getId() == id) {
                return quarto;
            }
        }
        return null;
    }
}
