/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import elhacker.ElHacker;
import elhacker.User;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Nacho
 */
public class Program {

    public static User USER;
    
    //public static String[] USER_DATA;
    
    public static void main(String[] args) throws IOException {
        //String id = JOptionPane.showInputDialog(null, "Escribe tu ID: ");
        String id = "";//"nacho-u537557";
        if(id.equals("")) id = JOptionPane.showInputDialog(null, "Escribe tu ID: ");
        String[] data = ElHacker.getUser(id);
        if(data[1] == null || data[1].equals("")) {
            JOptionPane.showMessageDialog(null, "Error");
            System.exit(0);
        } 
        
        //String id, String name, String messages, String color, String life, String attack, String speed, String shootSpeed, String shootDelay
        USER = new User(data[0],data[1],data[2],data[3],data[4],data[5], data[6], data[7], data[8]);
        new Game();
    }
    
}
