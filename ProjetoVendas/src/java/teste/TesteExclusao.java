package teste;

import dao.VendasDAO;

public class TesteExclusao {
    public static void main(String[] args) {

        // =========================
        // INSTÂNCIA DO DAO
        // =========================
        // Objeto responsável por acessar e manipular o banco de dados
        VendasDAO vendasDao = new VendasDAO();

        // ID da venda que será removida do banco
        // Atenção: se não existir no banco, o DAO irá lançar exceção
        int idParaExcluir = 1;

        try {
            // =========================
            // OPERAÇÃO DE EXCLUSÃO
            // =========================
            // Chama o método DAO que remove a venda com base no ID informado
            vendasDao.excluir(idParaExcluir);

            System.out.println("Venda com ID " + idParaExcluir + " excluída com sucesso!");

        } catch (Exception e) {
            // =========================
            // TRATAMENTO DE ERRO
            // =========================
            // Captura erros como:
            // - ID inexistente
            // - falha de conexão
            // - erro SQL
            System.err.println("Erro ao excluir venda: " + e.getMessage());

            // Mostra detalhes completos do erro para debug
            e.printStackTrace();
        }
    }
}