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
import static pack.Ban.con;
import static pack.Ban.stmt;

/**
 *
 * @author a120088
 */
public class ThreadP extends Thread{
    private String nome;

    public boolean isUtilizandoContaA() {
        return utilizandoContaA;
    }

    public void setUtilizandoContaA(boolean utilizandoContaA) {
        this.utilizandoContaA = utilizandoContaA;
    }

    public boolean isUtilizandoContaB() {
        return utilizandoContaB;
    }

    public void setUtilizandoContaB(boolean utilizandoContaB) {
        this.utilizandoContaB = utilizandoContaB;
    }

    public boolean isUtilizandoContaC() {
        return utilizandoContaC;
    }

    public void setUtilizandoContaC(boolean utilizandoContaC) {
        this.utilizandoContaC = utilizandoContaC;
    }
    private boolean utilizandoContaA;
    private boolean utilizandoContaB;
    private boolean utilizandoContaC;
    
    
    public ThreadP(String nome){
        this.nome = nome;
        start();
    }
    
    public void run(){
        Ban bp = new Ban();
        bp.conexao();
        try {
            bp.depositar("C", "250");
            System.out.println("\n Thread P executando\n");
        } catch (SQLException ex) {
            Logger.getLogger(ThreadP.class.getName()).log(Level.SEVERE, null, ex);
        }
        bp.desconectarBanco();
    }
}
