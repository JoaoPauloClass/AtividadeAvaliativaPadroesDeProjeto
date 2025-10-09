import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pedido {
    private int id;
    private String cliente;
    private double valor;
    private LocalDate data;

    public Pedido(int id, String cliente, double valor, LocalDate data) {
        this.id = id;
        this.cliente = cliente;
        this.valor = valor;
        this.data = data;
    }

    public int getId() { return id; }
    public String getCliente() { return cliente; }
    public double getValor() { return valor; }
    public LocalDate getData() { return data; }

    @Override
    public String toString() {
        return String.format("Pedido #%d | Cliente: %-15s | R$ %8.2f | Data: %s",
                           id, cliente, valor, data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

}
