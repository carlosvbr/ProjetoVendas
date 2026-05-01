package teste;

import dao.VendasDAO;
import modelo.ModeloVendas;
import java.util.List;

public class TesteConsultarTodos {
    public static void main(String[] args) {

        VendasDAO vendasDao = new VendasDAO();

        try {

            List<ModeloVendas> vendas = vendasDao.consultarTodos();

            if (vendas.isEmpty()) {
                System.out.println("Nenhuma venda encontrada.");

            } else {

                System.out.println("Vendas cadastradas:");

                for (ModeloVendas venda : vendas) {

                    System.out.println(venda);
                }
            }

        } catch (Exception e) {

            System.err.println("Erro ao consultar vendas: " + e.getMessage());

            e.printStackTrace();
        }
    }
}
