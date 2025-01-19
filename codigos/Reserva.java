import java.util.Date;
import java.util.List;

public class Reserva {
    private int id;
    private Date dataCheckIn;
    private Date dataCheckOut;
    private String status;
    private List<Hospede> hospedes;
    private Quarto quarto;

    public Reserva(int id, Date dataCheckIn, Date dataCheckOut, List<Hospede> hospedes, Quarto quarto) {
        this.id = id;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.hospedes = hospedes;  
        this.quarto = quarto;
        this.status = "Pendente";
    }

    public List<Hospede> getHospedes() {
        return hospedes;
    }

    public void setHospedes(List<Hospede> hospedes) {
        this.hospedes = hospedes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(Date dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public Date getDataCheckOut() {
        return dataCheckOut;
    }

    public void setDataCheckOut(Date dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
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
