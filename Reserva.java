import java.util.Date;

public class Reserva {
    private int id;
    private Date dataCheckIn;
    private Date dataCheckOut;
    private String status;
    private Hospede hospede;
    private Quarto quarto;

    public Reserva(int id, Date dataCheckIn, Date dataCheckOut, Hospede hospede, Quarto quarto) {
        this.id = id;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.hospede = hospede;
        this.quarto = quarto;
        this.status = "Pendente";
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public Date getDataCheckIn() {
        return dataCheckIn;
    }

    public Date getDataCheckOut() {
        return dataCheckOut;
    }

    public int calcularDuracao() {
        long duracao = (dataCheckOut.getTime() - dataCheckIn.getTime()) / (1000 * 60 * 60 * 24);
        return (int) duracao;
    }

    public void confirmarReserva() {
        this.status = "Confirmada";
        System.out.println("Reserva confirmada.");
    }

    public void cancelarReserva() {
        this.status = "Cancelada";
        System.out.println("Reserva cancelada.");
    }
}
