public class Pagamento {
    private int id;
    private double valor;
    private String metodo;
    private String status;

    public Pagamento(int id, double valor, String metodo) {
        this.id = id;
        this.valor = valor;
        this.metodo = metodo;
        this.status = "Pendente";
    }

    public void processarPagamento() {
        this.status = "Pago";
        System.out.println("Pagamento processado no valor de: R$" + valor);
    }

    public String verificarStatus() {
        return status;
    }
}
