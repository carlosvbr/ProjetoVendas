package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

    // URL de conexão com o banco PostgreSQL
    // Formato: jdbc:postgresql://HOST:PORTA/NOME_DO_BANCO
    private static final String URL = "jdbc:postgresql://localhost:5432/vendas_db";

    // Usuário do banco de dados PostgreSQL
    private static final String USER = "postgres";

    // Senha do usuário do banco (em projetos reais, nunca deixar hardcoded)
    private static final String PASSWORD = "1234";

    // =========================
    // MÉTODO: OBTER CONEXÃO
    // =========================
    // Responsável por criar e retornar uma conexão com o banco de dados
    public static Connection obterConexao() {
        try {

            // Carrega o driver JDBC do PostgreSQL na memória
            // Necessário para que o DriverManager consiga reconhecer o banco
            Class.forName("org.postgresql.Driver");

            // Abre e retorna a conexão com o banco de dados
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            // Ocorre quando o driver JDBC não está no classpath do projeto
            throw new RuntimeException("Driver do PostgreSQL não encontrado", e);

        } catch (SQLException e) {
            // Ocorre quando há erro de conexão (credenciais, banco offline, URL errada)
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }
}