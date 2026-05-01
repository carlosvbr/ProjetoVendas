package teste;

import dao.VendasDAO;
import modelo.ModeloVendas;
import java.util.List;

public class TesteConsultarTodos {
    public static void main(String[] args) {

        // =========================
        // INSTÂNCIA DO DAO
        // =========================
        // Responsável por executar consultas no banco de dados
        VendasDAO vendasDao = new VendasDAO();

        try {

            // =========================
            // CONSULTA NO BANCO
            // =========================
            // Recupera todas as vendas cadastradas na tabela
            List<ModeloVendas> vendas = vendasDao.consultarTodos();

            // =========================
            // VERIFICAÇÃO DE RESULTADO
            // =========================
            // Caso a lista esteja vazia, não existem registros no banco
            if (vendas.isEmpty()) {
                System.out.println("Nenhuma venda encontrada.");

            } else {

                System.out.println("Vendas cadastradas:");

                // Percorre toda a lista retornada pelo DAO
                for (ModeloVendas venda : vendas) {

                    // Usa o toString() do modelo para exibir os dados formatados
                    System.out.println(venda);
                }
            }

        } catch (Exception e) {

            // =========================
            // TRATAMENTO DE ERRO
            // =========================
            // Pode ocorrer por:
            // - falha na conexão com banco
            // - erro SQL na consulta
            System.err.println("Erro ao consultar vendas: " + e.getMessage());

            // Mostra stack trace para depuração detalhada
            e.printStackTrace();
        }
    }
}