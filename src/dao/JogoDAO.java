package dao;

import java.sql.*;
import model.Jogo;

public class JogoDAO {

    public void inserir(Jogo jogo){

        String sql = "INSERT INTO jogo(nome, genero, estudio, preco, duracao) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)){

             stmt.setString (1, jogo.getNome());
             stmt.setString(2, jogo.getGenero());
             stmt.setString(3, jogo.getEstudio());
             stmt.setInt(4, jogo.getPreco());
             stmt.setInt(5, jogo.getDuracao());

             stmt.executeUpdate();

        } catch (SQLException e){
            System.err.println ("Erro ao inserir: "+ e.getMessage());
        }
    }
    public void listar(Jogo jogo){
        String sql = "SELECT * FROM jogo";

        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql);
           var rs = stmt.executeQuery()){

            while(rs.next()){
                System.out.printf("%-5d%-25s%-10s%-15s%-10d%-10d%n",
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("genero"),
                            rs.getString("estudio"),
                            rs.getInt("preco"),
                            rs.getInt("duracao"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar os jogos "+e.getMessage());
        }
    }
    public void atualizar(Jogo jogo){

        String sql = "UPDATE jogo SET nome = ?, "
                    + "genero = ?,"
                    + "estudio = ?,"
                    + "preco = ?,"
                    + "duracao = ? "
                    + "WHERE id = ?";

        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){
        stmt.setString (1, jogo.getNome());
        stmt.setString (2, jogo.getGenero());
        stmt.setString (3,jogo.getEstudio());
        stmt.setInt(4, jogo.getPreco());
        stmt.setInt(5, jogo.getDuracao());
        stmt.setInt(6, jogo.getId());

        stmt.executeUpdate();
            System.out.println("Jogo atualizado com sucesso!");

        } catch (SQLException e){
            System.err.println ("Erro ao atualizar: "+ e.getMessage());
        }
    }
    public void deletar(Jogo jogo){

        String sql = "DELETE FROM jogo WHERE id = ?";

        try (Connection conn = Conexao.conectar();

             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, jogo.getId());
            stmt.executeUpdate();
            System.out.println("Jogo deletado com sucesso!");

        } catch (SQLException e){
            System.err.println ("Erro ao deletar: "+ e.getMessage());
        }
    }
}
