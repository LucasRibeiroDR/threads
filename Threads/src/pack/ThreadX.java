/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a120088
 */
public class ThreadX extends Thread{
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
    
    public ThreadX(String nome){
        this.nome = nome;
        start();
    }
    
    public void run(){
        Ban bx = new Ban();
        bx.conexao();
        try {
            bx.depositar("A", "300");
            System.out.println("\n Thread X executando\n");
        } catch (SQLException ex) {
            Logger.getLogger(ThreadP.class.getName()).log(Level.SEVERE, null, ex);
        }
        bx.desconectarBanco();
    }
}
