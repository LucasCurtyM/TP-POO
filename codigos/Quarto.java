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

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
