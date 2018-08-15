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
        threadW.setUtilizandoContaA(true);
        threadW.setUtilizandoContaB(true);
        threadW.setUtilizandoContaC(false);

        ThreadX threadX = new ThreadX("Transação X");
        threadW.setUtilizandoContaA(true);
        threadW.setUtilizandoContaB(false);
        threadW.setUtilizandoContaC(false);

        ThreadY threadY = new ThreadY("Transação Y");
        threadW.setUtilizandoContaA(false);
        threadW.setUtilizandoContaB(true);
        threadW.setUtilizandoContaC(false);

        ThreadZ threadZ = new ThreadZ("Transação Z");
        threadW.setUtilizandoContaA(false);
        threadW.setUtilizandoContaB(true);
        threadW.setUtilizandoContaC(true);

        ThreadP threadP = new ThreadP("Transação P");
        threadW.setUtilizandoContaA(false);
        threadW.setUtilizandoContaB(false);
        threadW.setUtilizandoContaC(true);

        while (threadW.isAlive()) {
            try {
                threadX.sleep(300);
                threadY.sleep(300);
                threadZ.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        while (threadX.isAlive()) {
            try {
                threadW.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        while (threadY.isAlive()) {
            try {
                threadW.sleep(300);
                threadZ.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        while (threadZ.isAlive()) {
            try {
                threadW.sleep(300);
                threadY.sleep(300);
                threadP.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        while (threadP.isAlive()) {
            try {
                threadZ.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
    
    
}
