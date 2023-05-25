package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.HttpSession;
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
        try (Connection conn = ConnectionFactory.getConnection()) {
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
        } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        return usuario;
    }
    
    public boolean usuarioValido(String login, String senha,HttpSession session) {
    	String sql = "SELECT Id FROM usuarios WHERE login = ? AND senha = ?";
    	try (Connection conn = ConnectionFactory.getConnection()) {
    		try (PreparedStatement statement = connection.prepareStatement(sql)) { 
    			statement.setString(1, login);
                statement.setString(2, senha);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                    	session.setAttribute("usernameId", resultSet.getInt("Id"));
                        return true;
                    } else {
                    	return false;
                    }
                }
    		}
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    }
    
    public void cadastrarUsuario(Usuario user) {
    	String sql = "INSERT INTO usuarios (nome,email,login,senha) values (?,?,?,?);";
    	try (Connection conn = ConnectionFactory.getConnection()) {
    		try (PreparedStatement statement = connection.prepareStatement(sql)) {
    			statement.setString(1, user.getNome());
    			statement.setString(2, user.getEmail());
    			statement.setString(3, user.getLogin());
    			statement.setString(4, user.getSenha());
    			statement.executeUpdate();
    		}
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public Usuario obterUsuarioPorId(int id) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
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
        } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        return usuario;
    }
}
