package teste;

import dao.VendasDAO;

public class TesteExclusao {
    public static void main(String[] args) {

        VendasDAO vendasDao = new VendasDAO();

        int idParaExcluir = 1;

        try {

            vendasDao.excluir(idParaExcluir);

            System.out.println("Venda com ID " + idParaExcluir + " excluída com sucesso!");

        } catch (Exception e) {

            System.err.println("Erro ao excluir venda: " + e.getMessage());

            e.printStackTrace();
        }
    }
}
