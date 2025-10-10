import java.util.List;

public interface IRelatorio {
    String gerar();
    double getCustoProcessamento();
    List<Pedido> getPedidos();
}
