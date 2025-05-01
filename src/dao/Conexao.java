package dao;

import java.sql.*;

public class Conexao {

    public static Connection conectar(){
        String url = "jdbc:sqlite:banco.db";

        try{
           Connection conexao = DriverManager.getConnection(url);
           System.out.println("Conexão estabelecida com o SQLite.");

           String sql = "CREATE TABLE IF NOT EXISTS Jogo ("+
                        "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                        "nome TEXT NOT NULL,"+
                        "genero TEXT NOT NULL,"+
                        "estudio TEXT NOT NULL,"+
                        "preco INTEGER,"+
                        "duracao INTEGER)";

           Statement stmt = conexao.createStatement();
           stmt.execute(sql);
           return conexao;

        } catch(SQLException e){
            System.err.println("Erro ao conectar: "+e.getMessage());
            return null;
        }
    }

    public static void main(String [] args){
        try (Connection conexao = conectar()){
            if (conexao != null){
                var meta = conexao.getMetaData();
                System.out.println("O nome do driver é "+meta.getDriverName());
                System.out.print("Um novo banco de dados foi criado.");
            }
            }catch (SQLException e){
            System.err.print("Erro ao conectar: "+e.getMessage());
        }
    }
}
