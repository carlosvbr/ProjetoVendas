package teste;

import util.FabricaConexao;
import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {

        try (

            Connection conexao = FabricaConexao.obterConexao()
        ) {

            System.out.println("Conexão estabelecida com sucesso!");

        } catch (Exception e) {

            System.err.println("Erro ao conectar: " + e.getMessage());
        }
    }
}
