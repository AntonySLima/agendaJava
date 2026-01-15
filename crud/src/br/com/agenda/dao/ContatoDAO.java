package br.com.agenda.dao;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.models.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {

    public void save(Contato contato) {
        String sql = "INSERT INTO CONTATOS(NOME, IDADE, DATACADASTRO) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, contato.getNome());
            pstm.setInt(2, contato.getIdade());
            pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

            pstm.executeUpdate();

            System.out.println("Contato salvo com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao acessar banco de dados", e);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public List<Contato> getContatos() {

        String sql = "SELECT * FROM contatos";

        List<Contato> contatos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql);

             ResultSet resultSet = pstm.executeQuery()) {

            while (resultSet.next()) {
                Contato contato = new Contato();

                contato.setId(resultSet.getInt("ID"));
                contato.setNome(resultSet.getString("NOME"));
                contato.setIdade(resultSet.getInt("IDADE"));
                contato.setDataCadastro(resultSet.getDate("DATACADASTRO"));

                contatos.add(contato);
            }

            return contatos;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao acessar banco de dados", e);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void update(Contato contato) {
        String sql = "UPDATE contatos SET NOME = ?, IDADE = ?, DATACADASTRO = ? WHERE ID = ?";

        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, contato.getNome());
            pstm.setInt(2, contato.getIdade());
            pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
            pstm.setInt(4, contato.getId());

            pstm.executeUpdate();

            System.out.println("Contato atualizado com sucesso com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao acessar banco de dados", e);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void deleteByID(int id) {
        String sql = "DELETE FROM contatos WHERE ID = ?";

        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, id);

            pstm.executeUpdate();

            System.out.println("Contato deletado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao acessar banco de dados", e);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
