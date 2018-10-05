/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elhacker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Nacho
 */
public class ElHacker {
    /*
        [0] ID
        [1] NAME
        [2] MESSAGES
        [3] COLOR
    */
    
    //String id, String name, String messages, String color, String life, String attack, String speed, String shootSpeed, String shootDelay
    
    public static String[] getUser(String id) throws MalformedURLException, IOException {
        String[] userData = new String[9];
        for (int i = 0; i < 9; i++) {
            userData[i] = "";
        }
        userData[0] = id;
        URL ur = new URL("https://foro.elhacker.net/profiles/"+ id +".html");
        HttpURLConnection yc =(HttpURLConnection) ur.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String inputLine = "";
        int next = -1;
        while ((inputLine = in.readLine()) != null) {
            if(next == 1) userData[1] = inputLine.substring(inputLine.lastIndexOf("<td>")+4,inputLine.indexOf("</td>"));
            if(next == 2) userData[2] = inputLine.substring(inputLine.lastIndexOf("<td>")+4,inputLine.indexOf(" "));
            
            
            if(inputLine.contains("<td colspan=\"2\" width=\"100%\" class=\"smalltext\"><div class=\"signature\">")) {
            
            String[] subLines = inputLine.split("<br/>");
                for(String sl : subLines) {
                    if(sl.contains("[color:")) {
                int start = sl.lastIndexOf("[color:")+7;
                int end = sl.lastIndexOf("]");
                if(start<end) userData[3] = sl.substring(start,end);
            }
            
            if(sl.contains("[life:")) {
                int start = sl.lastIndexOf("[life:")+6;
                int end = sl.lastIndexOf("]");
                if(start<end) userData[4] = sl.substring(start,end);
            }
            
            if(sl.contains("[attack:")) {
                int start = sl.lastIndexOf("[attack:")+8;
                int end = sl.lastIndexOf("]");
                if(start<end) userData[5] = sl.substring(start,end);
            }
            
            if(sl.contains("[speed:")) {
                int start = sl.lastIndexOf("[speed:")+7;
                int end = sl.lastIndexOf("]");
                if(start<end) userData[6] = sl.substring(start,end);
            }
            if(sl.contains("[shootSpeed:")) {
                int start = sl.lastIndexOf("[shootSpeed:")+12;
                int end = sl.lastIndexOf("]");
                if(start<end) userData[7] = sl.substring(start,end);
            }
            
            if(sl.contains("[shootDelay:")) {
                int start = sl.lastIndexOf("[shootDelay:")+12;
                int end = sl.lastIndexOf("]");
                if(start<end) userData[8] = sl.substring(start,end);
            }
                }
            
            }
            
            
            
            
            next = -1;
            if(inputLine.equals("<td><b>Nombre: </b></td>")) next = 1;
            if(inputLine.equals("<td><b>Mensajes: </b></td>")) next = 2;
        }
        in.close(); 
        
        System.out.println(userData[0] + " " + userData[1] + " " + userData[2] + " " + userData[3]);
        return userData;
    }
}
