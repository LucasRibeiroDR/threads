/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author a120009
 */

public class Ban {
    
    static Statement stm;
    static PreparedStatement stmt;
    static ResultSet rs;
    String driver = "org.postgresql.Driver";
    String localBanco = "jdbc:postgresql://localhost:5432/serial";
    String user = "postgres";
    String senha = "postgres";
    static Connection con;
    
    public void conexao() {

        try {
            System.setProperty("jdbc.Drivers", driver);
            con = DriverManager.getConnection(localBanco, user, senha);
        } catch (SQLException sqex) {
            System.out.println("ERRO! Conexão não estabelecida." + sqex.getMessage());

        }

    }
        public void depositar(String nome, String valor) throws SQLException {
        String saldo = "";
        String novoSaldo = "";
        String sql = "SELECT saldo FROM contas WHERE nome = '" + nome + "'";
        stm = (Statement) con.createStatement();
        rs = stm.executeQuery(sql);
        while (rs.next()) {
            saldo = rs.getString("saldo");
        }
        novoSaldo = Integer.toString(Integer.parseInt(saldo) + Integer.parseInt(valor));
        atualizarBanco(nome, novoSaldo);
    }

    public void desconectarBanco() {
        try {
            con.close();
        } catch (SQLException esx) {
            System.out.println("ERRO! Banco continua conectado!");

        }

    }


    public void atualizarBanco(String nome, String saldo) throws SQLException {
        String sql = "update contas "
                + "set saldo = ? where  nome = '" + nome + "'";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, saldo);
        stmt.execute();
        stmt.close();

    }

    public String selectSaldo(String nome) throws SQLException {
        String valor = "";
        String sql = "SELECT saldo FROM contas WHERE nome = '" + nome + "'";
        stm = (Statement) con.createStatement();
        rs = stm.executeQuery(sql);
        while (rs.next()) {
            valor = rs.getString("saldo");
        }

        return valor;
    }

    public String selectNome(String nome) throws SQLException {
        String valor = "";
        String sql = "SELECT nome FROM contas WHERE codigo = '" + nome + "'";
        stm = (Statement) con.createStatement();
        rs = stm.executeQuery(sql);
        while (rs.next()) {
            valor = rs.getString("nome");
        }

        return valor;
    }

    public String selectCodigo(String codigo) throws SQLException {
        String valor = "";
        String sql = "SELECT nome FROM contas WHERE codigo = '" + codigo + "'";
        stm = (Statement) con.createStatement();
        rs = stm.executeQuery(sql);
        while (rs.next()) {
            valor = rs.getString("codigo");
        }

        return valor;
    }

}
