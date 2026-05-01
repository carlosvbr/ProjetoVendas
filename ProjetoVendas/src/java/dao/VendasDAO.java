package dao;

import modelo.ModeloVendas;
import util.FabricaConexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendasDAO {

    // =========================
    // INSERIR VENDA NO BANCO
    // =========================
    // Responsável por gravar um objeto ModeloVendas na tabela vendas
    public void inserir(ModeloVendas venda) throws SQLException {

        // SQL parametrizado evita SQL Injection e melhora segurança
        String sql = "INSERT INTO vendas (id, data_venda, valor_total, forma_pagamento, desconto_aplicado, " +
                     "status_venda, imposto, endereco_entrega, frete, item_vendido) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // try-with-resources garante fechamento automático de conexão e statement
        try (Connection conexao = FabricaConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            // Mapeamento dos atributos do objeto para os parâmetros do SQL
            stmt.setInt(1, venda.getId());

            // Conversão obrigatória: LocalDate -> java.sql.Date (JDBC não aceita LocalDate direto)
            stmt.setDate(2, Date.valueOf(venda.getDataVenda()));

            stmt.setDouble(3, venda.getValorTotal());
            stmt.setString(4, venda.getFormaPagamento());
            stmt.setDouble(5, venda.getDescontoAplicado());
            stmt.setString(6, venda.getStatusVenda());
            stmt.setDouble(7, venda.getImposto());
            stmt.setString(8, venda.getEnderecoEntrega());
            stmt.setDouble(9, venda.getFrete());
            stmt.setString(10, venda.getItemVendido());

            stmt.executeUpdate();

        } catch (SQLException e) {
            // Propaga exceção para camada superior tratar (teste/controller)
            throw e;
        }
    }

    // =========================
    // CONSULTAR VENDA POR ID
    // =========================
    // Retorna um único objeto ModeloVendas baseado no ID informado
    public ModeloVendas consultarPorId(int id) throws SQLException {

        String sql = "SELECT * FROM vendas WHERE id = ?";
        ModeloVendas venda = null;

        try (Connection conexao = FabricaConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            // Se encontrar registro, faz o mapeamento ResultSet -> objeto
            if (rs.next()) {
                venda = new ModeloVendas();

                venda.setId(rs.getInt("id"));
                venda.setDataVenda(rs.getDate("data_venda").toLocalDate());
                venda.setValorTotal(rs.getDouble("valor_total"));
                venda.setFormaPagamento(rs.getString("forma_pagamento"));
                venda.setDescontoAplicado(rs.getDouble("desconto_aplicado"));
                venda.setStatusVenda(rs.getString("status_venda"));
                venda.setImposto(rs.getDouble("imposto"));
                venda.setEnderecoEntrega(rs.getString("endereco_entrega"));
                venda.setFrete(rs.getDouble("frete"));
                venda.setItemVendido(rs.getString("item_vendido"));

            } else {
                // Caso não encontre, lança exceção para controle de fluxo
                throw new SQLException("Venda não encontrada");
            }

        } catch (SQLException e) {
            throw e;
        }

        return venda;
    }

    // =========================
    // CONSULTAR TODAS AS VENDAS
    // =========================
    // Retorna lista completa de vendas do banco
    public List<ModeloVendas> consultarTodos() throws SQLException {

        String sql = "SELECT * FROM vendas";
        List<ModeloVendas> vendas = new ArrayList<>();

        try (Connection conexao = FabricaConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // Percorre todas as linhas do ResultSet
            while (rs.next()) {

                ModeloVendas venda = new ModeloVendas();

                // Mapeamento linha do banco -> objeto Java
                venda.setId(rs.getInt("id"));
                venda.setDataVenda(rs.getDate("data_venda").toLocalDate());
                venda.setValorTotal(rs.getDouble("valor_total"));
                venda.setFormaPagamento(rs.getString("forma_pagamento"));
                venda.setDescontoAplicado(rs.getDouble("desconto_aplicado"));
                venda.setStatusVenda(rs.getString("status_venda"));
                venda.setImposto(rs.getDouble("imposto"));
                venda.setEnderecoEntrega(rs.getString("endereco_entrega"));
                venda.setFrete(rs.getDouble("frete"));
                venda.setItemVendido(rs.getString("item_vendido"));

                vendas.add(venda);
            }

        } catch (SQLException e) {
            throw e;
        }

        return vendas;
    }

    // =========================
    // ATUALIZAR VENDA
    // =========================
    // Atualiza todos os campos de uma venda existente com base no ID
    public void atualizar(ModeloVendas venda) throws SQLException {

        String sql = "UPDATE vendas SET data_venda = ?, valor_total = ?, forma_pagamento = ?, desconto_aplicado = ?, " +
                     "status_venda = ?, imposto = ?, endereco_entrega = ?, frete = ?, item_vendido = ? WHERE id = ?";

        try (Connection conexao = FabricaConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setDate(1, Date.valueOf(venda.getDataVenda()));
            stmt.setDouble(2, venda.getValorTotal());
            stmt.setString(3, venda.getFormaPagamento());
            stmt.setDouble(4, venda.getDescontoAplicado());
            stmt.setString(5, venda.getStatusVenda());
            stmt.setDouble(6, venda.getImposto());
            stmt.setString(7, venda.getEnderecoEntrega());
            stmt.setDouble(8, venda.getFrete());
            stmt.setString(9, venda.getItemVendido());
            stmt.setInt(10, venda.getId());

            int linhasAfetadas = stmt.executeUpdate();

            // Validação: garante que realmente existia registro para atualizar
            if (linhasAfetadas == 0) {
                throw new SQLException("Nenhuma venda encontrada para atualizar");
            }

        } catch (SQLException e) {
            throw e;
        }
    }

    // =========================
    // EXCLUIR VENDA
    // =========================
    // Remove registro do banco baseado no ID
    public void excluir(int id) throws SQLException {

        String sql = "DELETE FROM vendas WHERE id = ?";

        try (Connection conexao = FabricaConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int linhasAfetadas = stmt.executeUpdate();

            // Validação: garante que a venda existia antes de deletar
            if (linhasAfetadas == 0) {
                throw new SQLException("Nenhuma venda encontrada para excluir");
            }

        } catch (SQLException e) {
            throw e;
        }
    }
}