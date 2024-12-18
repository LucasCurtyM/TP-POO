public class Quarto {
    private int id;
    private String tipo;
    private double preco;
    private int capacidade;
    private String status;

    public Quarto(int id, String tipo, double preco, int capacidade, String status) {
        this.id = id;
        this.tipo = tipo;
        this.preco = preco;
        this.capacidade = capacidade;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
    }

    public double calcularPreco(int dias) {
        return preco * dias;
    }
}
