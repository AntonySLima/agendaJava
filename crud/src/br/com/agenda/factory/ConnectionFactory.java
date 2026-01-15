package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";

    public static Connection createConnectionToMySQL() throws Exception {
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

        return connection;
    }

    public static void main(String[] args) {
            try (Connection con = createConnectionToMySQL()) {
                if (con != null) {
                    System.out.println("Conexão obtida com sucesso!");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }
}
