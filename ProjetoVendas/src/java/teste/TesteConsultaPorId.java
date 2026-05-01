package teste;

import dao.VendasDAO;
import modelo.ModeloVendas;

public class TesteConsultaPorId {
    public static void main(String[] args) {

        // =========================
        // INSTÂNCIA DO DAO
        // =========================
        // Objeto responsável por acessar o banco de dados e executar consultas
        VendasDAO vendasDao = new VendasDAO();

        try {

            // =========================
            // CONSULTA POR ID
            // =========================
            // Busca uma venda específica no banco com base no ID informado
            ModeloVendas venda = vendasDao.consultarPorId(1);

            // Exibe o objeto retornado usando o método toString() do modelo
            System.out.println(venda);

        } catch (Exception e) {

            // =========================
            // TRATAMENTO DE ERRO
            // =========================
            // Pode ocorrer quando:
            // - o ID não existe no banco
            // - falha na conexão com o banco
            // - erro na query SQL
            System.out.println("Venda não encontrada com esse ID.");
        }
    }
}