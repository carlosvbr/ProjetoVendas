package teste;

import dao.VendasDAO;
import modelo.ModeloVendas;

public class TesteConsultaPorId {
    public static void main(String[] args) {

        VendasDAO vendasDao = new VendasDAO();

        try {

            ModeloVendas venda = vendasDao.consultarPorId(1);

            System.out.println(venda);

        } catch (Exception e) {


            System.out.println("Venda não encontrada com esse ID.");
        }
    }
}
