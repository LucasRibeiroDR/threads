/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a120088
 */
public class Teste {

    public static void main(String[] args) {
        
        ContaA contaA = new ContaA();
        contaA.setSaldo(0);
        
        ContaB contaB = new ContaB();
        contaB.setSaldo(150);
        
        ContaC contaC = new ContaC();
        contaC.setSaldo(0);

        ThreadW threadW = new ThreadW("Transação W");
        try {
            threadW.sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }

        ThreadX threadX = new ThreadX("Transação X");
        try {
            threadX.sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }

        ThreadY threadY = new ThreadY("Transação Y");
        try {
            threadY.sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }

        ThreadZ threadZ = new ThreadZ("Transação Z");
        try {
            threadZ.sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }

        ThreadP threadP = new ThreadP("Transação P");
        try {
            threadP.sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (threadW.isAlive()) {
            try {
                threadX.wait();
                threadY.wait();
                threadZ.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        while (threadX.isAlive()) {
            try {
                threadW.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        while (threadY.isAlive()) {
            try {
                threadW.wait();
                threadZ.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        while (threadZ.isAlive()) {
            try {
                threadW.wait();
                threadY.wait();
                threadP.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        while (threadP.isAlive()) {
            try {
                threadZ.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
    
    
}
