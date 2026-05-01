package teste;

import dao.VendasDAO;
import modelo.ModeloVendas;
import java.time.LocalDate;
import java.sql.SQLException;

public class TesteAtualizacao {
    public static void main(String[] args) {

        VendasDAO vendasDao = new VendasDAO();


        ModeloVendas venda = new ModeloVendas();

        venda.setId(1);

        venda.setDataVenda(LocalDate.now());
        venda.setValorTotal(600.00);
        venda.setFormaPagamento("Boleto");
        venda.setDescontoAplicado(50.00);
        venda.setStatusVenda("Pendente");
        venda.setImposto(60.00);
        venda.setEnderecoEntrega("Rua Atualizada, 456");
        venda.setFrete(35.00);

        try {

            vendasDao.atualizar(venda);

            System.out.println("Venda atualizada com sucesso!");

        } catch (SQLException e) {


            System.out.println("Erro ao atualizar venda: " + e.getMessage());
        }
    }
}
