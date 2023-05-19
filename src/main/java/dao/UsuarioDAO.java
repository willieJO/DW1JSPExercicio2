package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import model.Usuario;

public class UsuarioDAO {
    private Connection connection;

    public UsuarioDAO() {
        try {
            connection = ConnectionFactory.getConnection();
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    }

    public Usuario obterUsuarioPorLoginSenha(String login, String senha) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, login);
            statement.setString(2, senha);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    usuario = new Usuario();
                    usuario.setId(resultSet.getInt("id"));
                    usuario.setLogin(resultSet.getString("login"));
                    usuario.setSenha(resultSet.getString("senha"));
                    usuario.setNome(resultSet.getString("nome"));
                    usuario.setEmail(resultSet.getString("email"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving user from the database: " + e.getMessage());
        }

        return usuario;
    }

    public Usuario obterUsuarioPorId(int id) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    usuario = new Usuario();
                    usuario.setId(resultSet.getInt("id"));
                    usuario.setLogin(resultSet.getString("login"));
                    usuario.setSenha(resultSet.getString("senha"));
                    usuario.setNome(resultSet.getString("nome"));
                    usuario.setEmail(resultSet.getString("email"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving user from the database: " + e.getMessage());
        }

        return usuario;
    }
}
