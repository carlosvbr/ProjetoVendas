package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

    // URL de conexão com o banco PostgreSQL
    // Formato: jdbc:postgresql://HOST:PORTA/NOME_DO_BANCO
    private static final String URL = "db_url";

    private static final String USER = "db_user";

    private static final String PASSWORD = "db_password";


    public static Connection obterConexao() {
        try {

            Class.forName("org.postgresql.Driver");

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            
            throw new RuntimeException("Driver do PostgreSQL não encontrado", e);

        } catch (SQLException e) {
            
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }
}
