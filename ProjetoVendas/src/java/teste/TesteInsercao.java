package teste;

import dao.VendasDAO;
import modelo.ModeloVendas;

import java.time.LocalDate;

public class TesteInsercao {
    public static void main(String[] args) {

        // =========================
        // CRIAÇÃO DO OBJETO DE TESTE
        // =========================
        // Instancia um objeto ModeloVendas para simular uma venda real
        ModeloVendas venda = new ModeloVendas();

        // =========================
        // PREENCHIMENTO DOS DADOS
        // =========================
        // Aqui simulamos dados que normalmente viriam de um formulário (JSP/HTML)

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

        // =========================
        // PERSISTÊNCIA NO BANCO
        // =========================
        // Instancia o DAO responsável pela comunicação com o banco
        VendasDAO vendasDao = new VendasDAO();

        try {
            // Executa o método de inserção no banco de dados
            vendasDao.inserir(venda);

            System.out.println("Venda inserida com sucesso!");

        } catch (Exception e) {
            // Captura qualquer erro (conexão, SQL, constraint, etc.)
            System.err.println("Erro ao inserir venda: " + e.getMessage());

            // Exibe stack trace para debug detalhado
            e.printStackTrace();
        }
    }
}