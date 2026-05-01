package teste;

import dao.VendasDAO;
import modelo.ModeloVendas;

import java.time.LocalDate;

public class TesteInsercao {
    public static void main(String[] args) {

        ModeloVendas venda = new ModeloVendas();


        venda.setId(1);
        venda.setDataVenda(LocalDate.now());
        venda.setValorTotal(500.75);
        venda.setFormaPagamento("Cartão de Crédito");
        venda.setDescontoAplicado(20.00);
        venda.setStatusVenda("Concluída");
        venda.setImposto(50.75);
        venda.setEnderecoEntrega("Rua Exemplo, 123");
        venda.setFrete(30.00);
        venda.setItemVendido("Produto Exemplo");

        VendasDAO vendasDao = new VendasDAO();

        try {
            vendasDao.inserir(venda);

            System.out.println("Venda inserida com sucesso!");

        } catch (Exception e) {
            System.err.println("Erro ao inserir venda: " + e.getMessage());

            e.printStackTrace();
        }
    }
}
