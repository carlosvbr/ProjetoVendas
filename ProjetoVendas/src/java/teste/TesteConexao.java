package teste;

import util.FabricaConexao;
import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {

        try (
            // =========================
            // ABERTURA DE CONEXÃO (TRY-WITH-RESOURCES)
            // =========================
            // Abre a conexão com o banco e garante fechamento automático ao final
            Connection conexao = FabricaConexao.obterConexao()
        ) {

            // Se chegou aqui, significa que a conexão foi estabelecida com sucesso
            System.out.println("Conexão estabelecida com sucesso!");

        } catch (Exception e) {

            // =========================
            // TRATAMENTO DE ERRO DE CONEXÃO
            // =========================
            // Pode ocorrer por:
            // - banco fora do ar
            // - credenciais incorretas
            // - driver JDBC ausente
            // - URL incorreta
            System.err.println("Erro ao conectar: " + e.getMessage());
        }
    }
}