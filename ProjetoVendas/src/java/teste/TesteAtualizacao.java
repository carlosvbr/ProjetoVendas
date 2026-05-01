package teste;

import dao.VendasDAO;
import modelo.ModeloVendas;
import java.time.LocalDate;
import java.sql.SQLException;

public class TesteAtualizacao {
    public static void main(String[] args) {

        // =========================
        // INSTÂNCIA DO DAO
        // =========================
        // Responsável por executar operações de atualização no banco
        VendasDAO vendasDao = new VendasDAO();

        // =========================
        // CRIAÇÃO DO OBJETO
        // =========================
        // Objeto que representa a venda que será atualizada no banco
        ModeloVendas venda = new ModeloVendas();

        // =========================
        // DEFINIÇÃO DO ID
        // =========================
        // O ID indica qual registro existente será atualizado no banco
        venda.setId(1);

        // =========================
        // ATUALIZAÇÃO DOS DADOS
        // =========================
        // Aqui são definidos os novos valores que substituirão os antigos no banco

        venda.setDataVenda(LocalDate.now());
        venda.setValorTotal(600.00);
        venda.setFormaPagamento("Boleto");
        venda.setDescontoAplicado(50.00);
        venda.setStatusVenda("Pendente");
        venda.setImposto(60.00);
        venda.setEnderecoEntrega("Rua Atualizada, 456");
        venda.setFrete(35.00);

        try {

            // =========================
            // EXECUÇÃO DA ATUALIZAÇÃO
            // =========================
            // Envia o objeto preenchido para o DAO atualizar no banco
            vendasDao.atualizar(venda);

            System.out.println("Venda atualizada com sucesso!");

        } catch (SQLException e) {

            // =========================
            // TRATAMENTO DE ERRO SQL
            // =========================
            // Pode ocorrer quando:
            // - ID não existe no banco
            // - erro de conexão
            // - erro na query UPDATE
            System.out.println("Erro ao atualizar venda: " + e.getMessage());
        }
    }
}